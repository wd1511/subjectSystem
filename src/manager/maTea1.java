package manager;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import subjectSystem.connectMysql;

public class maTea1 {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		//String id = request.getParameter("id");
		connectMysql a=new connectMysql();
		LinkedList<String> b=a.getAllTeacherID();
		LinkedList<String> c=new LinkedList<String>();//×¨ÒµÃû³Æ
		for(String b1:b){
			String c1=a.teacherSear(b1).getTeacherName();
			c.add(c1);
		}
		request.setAttribute("teaID", b);
		request.setAttribute("teaName", c);
		return "success";
	}
}
