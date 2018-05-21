package subjectSystem;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


public class searchChooseSub {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String id = request.getParameter("studentID");
		connectMysql a=new connectMysql();
		student p=a.studentSear(id);
		LinkedList<subject> b=a.stuSearchChoose(id);
		LinkedList<String> c=new LinkedList<String>();
		for(subject b1:b)
		{
			String c1=a.mesSub(b1.getSubjectID());
			//System.out.println(c1);
			c.add(c1);
		}
		request.setAttribute("newstudent", p);
		request.setAttribute("allSub", b);
		request.setAttribute("mes",c);
		return "success";
	}
}
