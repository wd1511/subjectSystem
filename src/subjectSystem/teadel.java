package subjectSystem;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class teadel {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String t = request.getParameter("studentID");
		String []a1=t.split(";");
		String teacherID=a1[0];
		String subjectID=a1[1];
		connectMysql a=new connectMysql();
		teacher p=a.teacherSear(teacherID);
		boolean tt=a.delSub(p, subjectID);
		LinkedList<subject> b = a.teaSearchSub(p.getTeacherID());
		if(tt){
			request.setAttribute("newteacher", p);
			request.setAttribute("allSub", b);
			return "success";
		}
		else
			return "error";
	}
}
