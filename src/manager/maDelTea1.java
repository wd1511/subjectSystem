package manager;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import subjectSystem.connectMysql;
import subjectSystem.teacher;

public class maDelTea1 {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String id = request.getParameter("teacherID");
		connectMysql a=new connectMysql();
		teacher b=a.teacherSear(id);
		if(b==null){
			return "false";
		}else{				
			request.setAttribute("ID",b.getTeacherID());
			request.setAttribute("Name",b.getTeacherName());
			boolean c=a.delTeacher(b);
			if(c)
				return "success";
			else
				return "false";
		}
	}
}
