package subjectSystem;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class stuInf2 {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String id = request.getParameter("studentID");
		connectMysql a=new connectMysql();
		student p=a.studentSear(id);
		request.setAttribute("newstudent", p);
		return "success";
	}
}
