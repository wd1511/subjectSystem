package subjectSystem;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class teaSearchGrade {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String t = request.getParameter("studentID");
		String []a1=t.split(";");
		String teacherID=a1[0];
		String subjectID=a1[1];
		String studentID=a1[2];
		connectMysql a=new connectMysql();
		teacher p=a.teacherSear(teacherID);
		student q=a.studentSear(studentID);
		subject r=a.searchSub(subjectID);
		String g=a.getGrade(subjectID, studentID);
		request.setAttribute("nte", p);
		request.setAttribute("nst", q);
		request.setAttribute("nsb", r);
		request.setAttribute("g", g);
		return "success";
	}
}
