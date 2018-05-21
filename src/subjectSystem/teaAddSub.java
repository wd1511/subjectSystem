package subjectSystem;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class teaAddSub {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String id = request.getParameter("teacherID");
		connectMysql a=new connectMysql();
		teacher p=a.teacherSear(id);
		request.setAttribute("newteacher", p);
		return "success";
	}
}
