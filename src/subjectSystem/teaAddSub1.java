package subjectSystem;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class teaAddSub1 {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String n=request.getParameter("n");
		//System.out.println(n);
		String subjectID = request.getParameter("subID");
		String name = request.getParameter("name");
		String capacity = request.getParameter("capacity");
		String tPW = request.getParameter("pw");
		//int i=atoi(capacity);
		int capa=Integer.parseInt(capacity);
		connectMysql a=new connectMysql();
		teacher newteacher=new teacher();
		System.out.println(capa);
		newteacher.setTeacherID(n);
		newteacher.setPassword(tPW);
		newteacher=a.TeacherLogin(newteacher);
		if(newteacher==null){
			newteacher=a.teacherSear(n);
			request.setAttribute("newteacher", newteacher);
			return "false2";
		}
		boolean tt=a.addSub(newteacher, subjectID, name, capa);
		request.setAttribute("newteacher", newteacher);
		if(tt){
			subject l=a.searchSub(subjectID);
			request.setAttribute("newSub", l);
			return "success";
		}
		else{
			return "false1";
		}
	}
}
