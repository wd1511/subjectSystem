package manager;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import subjectSystem.connectMysql;
import subjectSystem.teacher;

public class addTea1 {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String sex = request.getParameter("sex");
		String school = request.getParameter("school");
		String phoneNum = request.getParameter("phoneNum");
		String password = request.getParameter("password");
		connectMysql a=new connectMysql();
		if(a.teacherSear(id)!=null)
			return "false";
		teacher b = new teacher();
		b.setTeacherID(id);
		b.setTeacherName(name);
		b.setBirthday(birthday);
		b.setSex(sex);
		b.setSchoolID(school);
		b.setPhoneNum(phoneNum);
		b.setPassword(password);
		if(a.addTeacher(b)){
			request.setAttribute("b", b);
			return "success";
		}
		else
			return "false";
	}
}
