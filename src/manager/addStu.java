package manager;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import subjectSystem.connectMysql;
import subjectSystem.student;

public class addStu {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		//String id = request.getParameter("id");
		connectMysql a=new connectMysql();
		LinkedList<String> b=a.getAllFieldID();//רҵ���
		LinkedList<String> c=new LinkedList<String>();//רҵ����
		LinkedList<String> d=new LinkedList<String>();//ѧԺ���
		LinkedList<String> e=new LinkedList<String>();//ѧԺ����
		for(String b1:b){
			LinkedList<String> c1=a.getField(b1);
			String c2=c1.get(1);
			c.add(c2);
			String d1=c1.get(0);
			d.add(d1);
			String e1=a.getSchool(d1);
			e.add(e1);
		}
		request.setAttribute("fid", b);
		request.setAttribute("fname", c);
		request.setAttribute("sid", d);
		request.setAttribute("sname", e);
		//System.out.println(id);
		return "success";
	}
}
