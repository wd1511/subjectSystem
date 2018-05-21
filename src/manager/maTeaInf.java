package manager;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import subjectSystem.connectMysql;
import subjectSystem.teacher;

public class maTeaInf {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String id = request.getParameter("teacherID");
		connectMysql a=new connectMysql();
		teacher p=a.teacherSear(id);
		String c=a.getSchool(p.getSchoolID());
		LinkedList<String> b=a.getAllSchoolID();//学院编号
		LinkedList<String> cc=new LinkedList<String>();//学院名称
		for(String b1:b){
			String c1=a.getSchool(b1);
			cc.add(c1);
		}
		request.setAttribute("sid", b);
		request.setAttribute("sname", cc);
		request.setAttribute("newteacher", p);
		request.setAttribute("c", c);
		return "success";
	}
}
