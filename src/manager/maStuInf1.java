package manager;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import subjectSystem.connectMysql;
import subjectSystem.student;

public class maStuInf1 {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String id = request.getParameter("studentID");
		String newP=request.getParameter("newPhone");
		String name=request.getParameter("name");
		String birthday=request.getParameter("birthday");
		String sex=request.getParameter("sex");
		String field=request.getParameter("field");
		String password=request.getParameter("password");
		connectMysql a=new connectMysql();
		student p=a.studentSear(id);
		a.stuChangeInf(p, name, birthday, sex, newP,field, password);
		p=a.studentSear(id);
		LinkedList<String> b=a.getField(p.getFieldID());
		String c=a.getSchool(b.get(0));
		LinkedList<String> bb=a.getAllFieldID();//专业编号
		LinkedList<String> cc=new LinkedList<String>();//专业名称
		LinkedList<String> d=new LinkedList<String>();//学院编号
		LinkedList<String> e=new LinkedList<String>();//学院名称
		for(String b1:bb){
			LinkedList<String> c1=a.getField(b1);
			String c2=c1.get(1);
			cc.add(c2);
			String d1=c1.get(0);
			d.add(d1);
			String e1=a.getSchool(d1);
			e.add(e1);
		}
		request.setAttribute("fid", bb);
		request.setAttribute("fname", cc);
		request.setAttribute("sid", d);
		request.setAttribute("sname", e);
		request.setAttribute("newstudent", p);
		request.setAttribute("newstudent", p);
		request.setAttribute("b", b);
		request.setAttribute("c", c);
		return "success";
	}
}
