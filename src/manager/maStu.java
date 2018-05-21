package manager;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import subjectSystem.connectMysql;

public class maStu {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		//String id = request.getParameter("id");
		connectMysql a=new connectMysql();
		LinkedList<String> b=a.getAllStudentID();
		LinkedList<String> c=new LinkedList<String>();//×¨ÒµÃû³Æ
		for(String b1:b){
			String c1=a.studentSear(b1).getStudentName();
			c.add(c1);
		}
		request.setAttribute("stuID", b);
		request.setAttribute("stuName", c);
		return "success";
	}
}
