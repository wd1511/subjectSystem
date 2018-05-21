package subjectSystem;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class chooseSub1 {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String t = request.getParameter("studentID");
		String []a1=t.split(";");
		String studentID=a1[0];
		String subjectID=a1[1];
		//String subjectID = request.getParameter("subjectID");
		//System.out.println(subjectID);
		connectMysql a=new connectMysql();
		student p=a.studentSear(studentID);
		boolean c=a.chooseSubject(p, subjectID);
		request.setAttribute("newstudent", p);
		System.out.println("11");
		String c1=a.mesSub(subjectID);
		System.out.println("22");
		subject b=a.searchSub(subjectID);
		System.out.println("33");
		request.setAttribute("mes", c1);
		request.setAttribute("sub", b);
		if(!c){
			System.out.println(1);
			return "false";
		}
		return "success";
	}
}
