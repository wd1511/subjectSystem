package subjectSystem;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class stuInf1 {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String id = request.getParameter("studentID");
		String newP=request.getParameter("newPhone");
		connectMysql a=new connectMysql();
		student p=a.studentSear(id);
		a.stuChangeInf(p, "", newP, "");
		p=a.studentSear(id);
		LinkedList<String> b=a.getField(p.getFieldID());
		String c=a.getSchool(b.get(0));
		request.setAttribute("newstudent", p);
		request.setAttribute("b", b);
		request.setAttribute("c", c);
		return "success";
	}
}
