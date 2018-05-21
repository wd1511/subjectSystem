package subjectSystem;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class teaSearchGrade1 {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String t = request.getParameter("teacherID");
		String []a1=t.split(";");
		String teacherID=a1[0];
		String subjectID=a1[2];
		String studentID=a1[1];
		String g1 = request.getParameter("grade");
		connectMysql a=new connectMysql();
		teacher p=a.teacherSear(teacherID);
		student q=a.studentSear(studentID);
		subject r=a.searchSub(subjectID);
		a.setGrade(subjectID, studentID, g1);
		String g=a.getGrade(subjectID, studentID);
		request.setAttribute("nte", p);
		request.setAttribute("nst", q);
		request.setAttribute("nsb", r);
		request.setAttribute("g", g);
		return "success";
	}
}
