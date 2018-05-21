package subjectSystem;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class teaInf {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String id = request.getParameter("teacherID");
		connectMysql a=new connectMysql();
		teacher p=a.teacherSear(id);
		String c=a.getSchool(p.getSchoolID());
		request.setAttribute("newteacher", p);
		request.setAttribute("c", c);
		return "success";
	}
}
