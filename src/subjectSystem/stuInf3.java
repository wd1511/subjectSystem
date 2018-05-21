package subjectSystem;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class stuInf3 {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String id = request.getParameter("studentID");
		String oP= request.getParameter("oldPa");
		String nP= request.getParameter("newPa");
		String nP1= request.getParameter("newPa1");
		connectMysql a=new connectMysql();
		student p=a.studentSear(id);
		if(oP.equals(p.getPassword()) && nP.equals(nP1)){
			a.stuChangeInf(p, "", "", nP);
			p=a.studentSear(id);
			request.setAttribute("newstudent", p);
			return "success";
		}
		else{
			request.setAttribute("newstudent", p);
			return "false";
		}
		
	}
}
