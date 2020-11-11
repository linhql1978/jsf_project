package demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import demo.model.Student;
import demo.utils.HibernateUtils;

public class Test {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		List<Student> students = session.createNativeQuery("select * from student", Student.class).list();
		session.getTransaction().commit();
		System.out.println(students);
	}
}
