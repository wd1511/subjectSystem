package subjectSystem;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class upload {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String select = request.getParameter("tors");
		connectMysql a=new connectMysql();
		//System.out.println(select);
		if(select.equals("2")){
			//学生登录
			//System.out.println(select);
			student newstudent=new student();
			newstudent.setStudentID(id);
			newstudent.setPassword(password);
			newstudent=a.studentLogin(newstudent);
			if(newstudent!=null)
			{
				request.setAttribute("newstudent", newstudent);
				return "success1";
			}
		}
		else if(select.equals("1")){
			//老师登录
			teacher newteacher=new teacher();
			newteacher.setTeacherID(id);
			newteacher.setPassword(password);
			newteacher=a.TeacherLogin(newteacher);
			if(newteacher!=null)
			{
				LinkedList<subject> b = a.teaSearchSub(newteacher.getTeacherID());
				request.setAttribute("newteacher", newteacher);
				request.setAttribute("allSub", b);
				return "success2";
			}
		}
		else{
			//管理员登录
			if(id.equals("123456")&&password.equals("123456"))
				return "success3";
		}
		return "error";
	}
}
