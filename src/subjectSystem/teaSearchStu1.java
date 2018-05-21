package subjectSystem;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class teaSearchStu1 {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String t = request.getParameter("studentID");
		String []a1=t.split(";");
		String teacherID=a1[0];
		String subjectID=a1[1];
		String studentID=a1[2];
		connectMysql a=new connectMysql();
		teacher p=a.teacherSear(teacherID);
		boolean c=a.delSubject(studentID, subjectID);
		student p1=a.studentSear(studentID);
		subject p2=a.searchSub(subjectID);
		request.setAttribute("newteacher", p);
		request.setAttribute("newstudent", p1);
		request.setAttribute("newsubject", p2);
		if(c){
			return "success";
		}
		else{
			return "false";
		}
			
	}
}
