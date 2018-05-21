package subjectSystem;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class chooseSub2 {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String t = request.getParameter("studentID");
		connectMysql a=new connectMysql();
		student p=a.studentSear(t);
		if(p!=null)
		{
			request.setAttribute("newstudent", p);
			return "success";
		}
		return "error";
	}
}
