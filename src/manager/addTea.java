package manager;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import subjectSystem.connectMysql;

public class addTea {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		//String id = request.getParameter("id");
		connectMysql a=new connectMysql();
		LinkedList<String> b=a.getAllSchoolID();//学院编号
		LinkedList<String> c=new LinkedList<String>();//学院名称
		for(String b1:b){
			String c1=a.getSchool(b1);
			c.add(c1);
		}
		request.setAttribute("sid", b);
		request.setAttribute("sname", c);
		//System.out.println(id);
		return "success";
	}
}
