package manager;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import subjectSystem.connectMysql;
import subjectSystem.student;

public class maDelStu1 {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String id = request.getParameter("studentID");
		connectMysql a=new connectMysql();
		student b=a.studentSear(id);
		if(b==null){
			return "false";
		}else{				
			request.setAttribute("ID",b.getStudentID());
			request.setAttribute("Name",b.getStudentName());
			boolean c=a.delStudent(b);
			if(c)
				return "success";
			else
				return "false";
		}
	}
}
