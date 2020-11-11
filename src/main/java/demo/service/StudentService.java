package demo.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.hibernate.Session;

import demo.model.Student;
import demo.utils.HibernateUtils;

@Named
@RequestScoped
public class StudentService implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Student> students;

	@PostConstruct
	public void init() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		students = session.createNativeQuery("select * from student", Student.class).list();
		session.getTransaction().commit();
	}

	public List<Student> getStudents() {
		return students;
	}

//	public void addStudent(Student student) {
//		Session session = HibernateUtils.getSessionFactory().openSession();
//		session.beginTransaction();
//		session.save(student);
//		session.getTransaction().commit();
//	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
