package subjectSystem;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class teaInf3 {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String id = request.getParameter("teacherID");
		String oP= request.getParameter("oldPa");
		String nP= request.getParameter("newPa");
		String nP1= request.getParameter("newPa1");
		connectMysql a=new connectMysql();
		teacher p=a.teacherSear(id);
		if(oP.equals(p.getPassword()) && nP.equals(nP1)){
			a.teaChangeInf(p, "", "", nP);
			p=a.teacherSear(id);
			request.setAttribute("newteacher", p);
			return "success";
		}
		else{
			request.setAttribute("newteacher", p);
			return "false";
		}
		
	}
}
