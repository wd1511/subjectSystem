package subjectSystem;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class teaSearchStu {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String t = request.getParameter("studentID");
		String []a1=t.split(";");
		String teacherID=a1[0];
		String subjectID=a1[1];
		connectMysql a=new connectMysql();
		teacher p=a.teacherSear(teacherID);
		LinkedList<String> b=a.searchSubStu(subjectID);
		LinkedList<student> s= new LinkedList<student>();
		for(String b1:b){
			student s1=a.studentSear(b1);
			s.add(s1);
		}
		subject c=a.searchSub(subjectID);
		request.setAttribute("newteacher", p);
		request.setAttribute("allStu", s);
		request.setAttribute("mes",c);
		return "success";
	}
}
