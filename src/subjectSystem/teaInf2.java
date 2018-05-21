package subjectSystem;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class teaInf2 {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String id = request.getParameter("teacherID");
		connectMysql a=new connectMysql();
		teacher p=a.teacherSear(id);
		System.out.println(id);
		System.out.println(p.getTeacherID());
		request.setAttribute("newteacher", p);
		return "success";
	}
}
