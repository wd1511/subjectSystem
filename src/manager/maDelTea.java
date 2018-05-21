package manager;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import subjectSystem.connectMysql;
import subjectSystem.teacher;

public class maDelTea {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String id = request.getParameter("teacherID");
		connectMysql a=new connectMysql();
		teacher b=a.teacherSear(id);
		if(b==null){
			return "error";
		}else{				
			request.setAttribute("newTea", b);
			return "success";
		}
	}
}
