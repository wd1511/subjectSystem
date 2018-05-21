package subjectSystem;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class teaSearchStu2 {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String t = request.getParameter("teacherID");
		connectMysql a=new connectMysql();
		teacher p=a.teacherSear(t);
		if(p!=null)
		{
			LinkedList<subject> b = a.teaSearchSub(p.getTeacherID());
			request.setAttribute("allSub", b);
			request.setAttribute("newteacher", p);
			return "success";
		}
		return "error";
	}
}
