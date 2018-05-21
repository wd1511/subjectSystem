package manager;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import subjectSystem.connectMysql;
import subjectSystem.student;

public class maDelStu {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String id = request.getParameter("studentID");
		connectMysql a=new connectMysql();
		student b=a.studentSear(id);
		if(b==null){
			return "error";
		}else{				
			request.setAttribute("newStu", b);
			return "success";
		}
	}
}
