package demo.service;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class NavigationController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private int pageId;

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public String showPage() {
		if (pageId == 1)
			return "home";
		else if (pageId == 2)
			return "add_student";
		return "home_page";
	}
}
