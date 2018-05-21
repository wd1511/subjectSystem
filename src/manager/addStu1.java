package manager;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import subjectSystem.connectMysql;
import subjectSystem.student;

public class addStu1 {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String sex = request.getParameter("sex");
		String field = request.getParameter("field");
		String phoneNum = request.getParameter("phoneNum");
		String password = request.getParameter("password");
		connectMysql a=new connectMysql();
		if(a.studentSear(id)!=null)
			return "false";
		student b = new student();
		b.setStudentID(id);
		b.setStudentName(name);
		b.setBirthday(birthday);
		b.setSex(sex);
		b.setFieldID(field);
		b.setPhoneNum(phoneNum);
		b.setPassword(password);
		if(a.addStudent(b)){
			request.setAttribute("b", b);
			return "success";
		}
		else
			return "false";
	}
}
