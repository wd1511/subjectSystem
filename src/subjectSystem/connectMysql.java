package subjectSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.LinkedList;
import java.sql.ResultSet;

//老师学生登录
//均可查询所有课程和按照课程编号查询课程
//学生可以选课和取消选课
//老师可以取消学生的选课
//老师可以查看谁选了自己的课，自己有什么课，
//用学号查询学生
//用编号查询老师

//增删查改学生
//增删查改老师
//增删查改课程

public class connectMysql {
	private Connection conn;
	private Statement stmt;
	
	public connectMysql(){
		//String dbUrl = String.format("jdbc:mysql://%s:%s/%s", System.getenv("MYSQL_HOST"), System.getenv("MYSQL_PORT"), System.getenv("MYSQL_DB"));
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//System.out.println("f*ck");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/subjectsystem?useSSL=false&characterEncoding=UTF-8", "root", "");
			//conn = DriverManager.getConnection("jdbc:mysql:// w.rdc.sae.sina.com.cn:3307/app_hitwd", "1jny5oxj0n", "zlxiwi24kk5m5zkjzh23l2h25zhxxihhw40l2k00");
			//conn = DriverManager.getConnection(dbUrl, username, password);
			System.out.println("Mysql succeed!");
			//System.out.println("f*ck");
			stmt = conn.createStatement();
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
		}
	}
	
	//查询所有课程
	public LinkedList<subject> searchSub(){
		String sql = "select * from subject";
	    LinkedList<subject> list = new LinkedList<subject>();
	    try{
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				subject newSub = new subject();
				if(null != rs.getString(1))
					newSub.setSubjectID(new String(rs.getString(1).trim()));
				if(null != rs.getString(2))
					newSub.setSubjectName(new String(rs.getString(2).trim()));
				if(null != rs.getString(3))
					newSub.setTeacherID(new String(rs.getString(3).trim()));
				if(null != rs.getString(4))
					newSub.setCapacity(Integer.parseInt(new String(rs.getString(4).trim())));
				if(null != rs.getString(5))
					newSub.setMaxCapacity(Integer.parseInt(new String(rs.getString(5).trim())));
				list.add(newSub);
			}
			return list;
	    }
	    catch(Exception ex){
	    	System.out.println(ex);
	    	System.exit(0);
	    }
	    return null;
	}
	
	//查询某个科目
	public subject searchSub(String subjectID){
		String sql = "select * from subject where subjectID='" + subjectID + "'";
		subject newSub = new subject();
	    try{
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				
				if(null != rs.getString(1))
					newSub.setSubjectID(new String(rs.getString(1).trim()));
				if(null != rs.getString(2))
					newSub.setSubjectName(new String(rs.getString(2).trim()));
				if(null != rs.getString(3))
					newSub.setTeacherID(new String(rs.getString(3).trim()));
				if(null != rs.getString(4))
					newSub.setCapacity(Integer.parseInt(new String(rs.getString(4).trim())));
				if(null != rs.getString(5))
					newSub.setMaxCapacity(Integer.parseInt(new String(rs.getString(5).trim())));
			}
			return newSub;
	    }
	    catch(Exception ex){
	    	System.out.println(ex);
	    	System.exit(0);
	    }
	    return null;
	}
	
	//学生登录
	public student studentLogin(student newStudent)
	{
		if(newStudent.getStudentID() == "") return null;
		String sql = "select * from student where studentID='" + newStudent.getStudentID() + "'";
		try{
			ResultSet rs = stmt.executeQuery(sql);//find if the book exits in the database
			if(rs.next()) 
			{
				if(newStudent.getPassword().equals(rs.getString(7)))
				{
					student a=new student();	
					if(null != rs.getString(1))
						a.setStudentID(new String(rs.getString(1).trim()));
					if(null != rs.getString(2))
						a.setStudentName(new String(rs.getString(2).trim()));
					if(null != rs.getString(3))
						a.setBirthday(new String(rs.getString(3).trim()));
					if(null != rs.getString(4))
						a.setSex(new String(rs.getString(4).trim()));
					if(null != rs.getString(5))
						a.setPhoneNum(new String(rs.getString(5).trim()));
					if(null != rs.getString(6))
						a.setFieldID(new String(rs.getString(6).trim()));
					if(null != rs.getString(7))
						a.setPassword(new String(rs.getString(7).trim()));
					return a;
				}
			}
			return null;
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
		}
		return null;
	}
	
	//老师登录
	public teacher TeacherLogin(teacher newTeacher)
	{
		if(newTeacher.getTeacherID() == "") return null;
		String sql = "select * from teacher where teacherID='" + newTeacher.getTeacherID() + "'";
		try{
			ResultSet rs = stmt.executeQuery(sql);//find if the book exits in the database
			if(rs.next()) 
			{
				if(newTeacher.getPassword().equals(rs.getString(7)))
				{
					teacher a=new teacher();	
					if(null != rs.getString(1))
						a.setTeacherID(new String(rs.getString(1).trim()));
					if(null != rs.getString(2))
						a.setTeacherName(new String(rs.getString(2).trim()));
					if(null != rs.getString(3))
						a.setBirthday(new String(rs.getString(3).trim()));
					if(null != rs.getString(4))
						a.setSex(new String(rs.getString(4).trim()));
					if(null != rs.getString(5))
						a.setPhoneNum(new String(rs.getString(5).trim()));
					if(null != rs.getString(6))
						a.setSchoolID(new String(rs.getString(6).trim()));
					if(null != rs.getString(7))
						a.setPassword(new String(rs.getString(7).trim()));
					return a;
				}
			}
			return null;
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
		}
		return null;
	}
	
	//选课
	public boolean chooseSubject(student newStudent,String subjectID) {
		subject newSubject=searchSub(subjectID);
		if(newSubject.getCapacity()==0 || newSubject==null)
			return false;
		LinkedList<subject> ppp= stuSearchChoose(newStudent.getStudentID());
		for(subject pppp:ppp){
			if(pppp.getSubjectID().equals(subjectID)){
				return false;
			}
		}
		String sql = "insert into choose (subjectID, studentID,grade)"
				+ "values ('" + subjectID + "','" + newStudent.getStudentID() + 
				"','" + "0" +  "')";
		try{
			stmt.executeUpdate(sql);//insert the book into database
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
			return false;
		}
		int c=newSubject.getCapacity()-1;
		sql = "update subject set capacity = "+c+" where subjectID ='"+subjectID+"'" ;
		try{
			stmt.executeUpdate(sql);//insert the book into database
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
			return false;
		}
		return true;
	}
	
	//取消选课
	public boolean delSubject(String studentID,String subjectID) {
		String sql = "select * from choose where subjectID='" + subjectID + "' and studentID='"+studentID+"'" ;
		//subject newSub = new subject();
	    try{
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				return delChoose(studentID,subjectID);
			}
	    }
	    catch(Exception ex){
	    	System.out.println("sdasda");
	    	System.out.println(ex);
	    	System.exit(0);
	    }
		return false;
	}
	
	//删除选课的某项记录并把课程容量+1
	public boolean delChoose(String studentID,String subjectID) {
		String sql = "delete from choose where subjectID='" + subjectID + "' and studentID='"+studentID+"'";
		try{
			stmt.executeUpdate(sql);
			//System.out.println("2");
			subject a = searchSub(subjectID);
			int c=a.getCapacity()+1;
			sql = "update subject set capacity = "+c+" where subjectID ='"+subjectID+"'" ;
			try{
				//System.out.println("3");
				stmt.executeUpdate(sql);//insert the book into database
			}
			catch(Exception ex){
				System.out.println(ex);
				System.exit(0);
				return false;
			}
			return true;
		}
		catch(Exception ex){
			//System.out.println("sdasda");
	    	System.out.println(ex);
	    	System.exit(0);
	    }
		return false;
	}
	
	//学生查询选课
	public LinkedList<subject> stuSearchChoose(String studentID)
	{
		String sql = "select * from choose where studentID='" + studentID + "'";
		LinkedList<String> a=new LinkedList<String>();
	    try{
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				if(null != rs.getString(1))
					a.add(new String(rs.getString(1).trim()));
			}
	    }
	    catch(Exception ex){
	    	System.out.println(ex);
	    	System.exit(0);
	    	return null;
	    }
	    LinkedList<subject> b = new LinkedList<subject>();
	    subject b1;
	    for(String a1 : a)
	   	{
	    	b1=searchSub(a1);
	    	b.add(b1);
	   	}
	    return b;
	}
	
	//老师查看自己要教授什么课
	public LinkedList<subject> teaSearchSub(String teacherID){
		String sql = "select * from subject where teacherID='" + teacherID + "'";
		LinkedList<subject> list = new LinkedList<subject>();
	    try{
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				subject newSub = new subject();
				if(null != rs.getString(1))
					newSub.setSubjectID(new String(rs.getString(1).trim()));
				if(null != rs.getString(2))
					newSub.setSubjectName(new String(rs.getString(2).trim()));
				if(null != rs.getString(3))
					newSub.setTeacherID(new String(rs.getString(3).trim()));
				if(null != rs.getString(4))
					newSub.setCapacity(Integer.parseInt(new String(rs.getString(4).trim())));
				if(null != rs.getString(5))
					newSub.setMaxCapacity(Integer.parseInt(new String(rs.getString(5).trim())));
				list.add(newSub);
			}
			return list;
	    }
	    catch(Exception ex){
	    	System.out.println(ex);
	    	System.exit(0);
	    }
	    return null;
	}

	//老师看哪些学生选了自己的课，返回四元组，stuId，stuNa，subId，subNa
	public LinkedList<String> teaSearchStudents(String teacherID)
	{
		LinkedList<String> d = new LinkedList<String>();
		LinkedList<subject> a =teaSearchSub(teacherID);
		for(subject b : a)
		{
			LinkedList<String> c = searchSubStu(b.getSubjectID());
			for(String e : c)
			{
				student newstu = studentSear(e);
				String mess = newstu.getStudentID()+";"+newstu.getStudentName()+
						";"+b.getSubjectID()+";"+b.getSubjectName();
				d.add(mess);
			}
		}
		return d;
	}
	
	//查询某个课谁选了，返回id
	public LinkedList<String> searchSubStu(String subjectID)
	{
		String sql = "select * from choose where subjectID ='" + subjectID + "'";
		LinkedList<String> a=new LinkedList<String>();
	    try{
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				if(null != rs.getString(2))
					a.add(new String(rs.getString(2).trim()));
			}
			return a;
	    }
	    catch(Exception ex){
	    	System.out.println(ex);
	    	System.exit(0);
	    	return null;
	    }
	}
	
	//用学号查询学生
	public student studentSear(String studentID)
	{
		if(studentID == "") return null;
		String sql = "select * from student where studentID='" + studentID + "'";
		try{
			ResultSet rs = stmt.executeQuery(sql);//find if the book exits in the database
			if(rs.next()) 
			{
				student a=new student();	
				if(null != rs.getString(1))
					a.setStudentID(new String(rs.getString(1).trim()));
				if(null != rs.getString(2))
					a.setStudentName(new String(rs.getString(2).trim()));
				if(null != rs.getString(3))
					a.setBirthday(new String(rs.getString(3).trim()));
				if(null != rs.getString(4))
					a.setSex(new String(rs.getString(4).trim()));
				if(null != rs.getString(5))
					a.setPhoneNum(new String(rs.getString(5).trim()));
				if(null != rs.getString(6))
					a.setFieldID(new String(rs.getString(6).trim()));
				if(null != rs.getString(7))
					a.setPassword(new String(rs.getString(7).trim()));
				return a;
			}
			return null;
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
		}
		return null;
	}
	
	//用职工号查询老师
	public teacher teacherSear(String teacherID)
		{
			if(teacherID == "") return null;
			String sql = "select * from teacher where teacherID='" + teacherID + "'";
			try{
				ResultSet rs = stmt.executeQuery(sql);//find if the book exits in the database
				if(rs.next()) 
				{
					teacher a=new teacher();	
					if(null != rs.getString(1))
						a.setTeacherID(new String(rs.getString(1).trim()));
					if(null != rs.getString(2))
						a.setTeacherName(new String(rs.getString(2).trim()));
					if(null != rs.getString(3))
						a.setBirthday(new String(rs.getString(3).trim()));
					if(null != rs.getString(4))
						a.setSex(new String(rs.getString(4).trim()));
					if(null != rs.getString(5))
						a.setPhoneNum(new String(rs.getString(5).trim()));
					if(null != rs.getString(6))
						a.setSchoolID(new String(rs.getString(6).trim()));
					if(null != rs.getString(7))
						a.setPassword(new String(rs.getString(7).trim()));
					return a;
				}
				return null;
			}
			catch(Exception ex){
				System.out.println(ex);
				System.exit(0);
			}
			return null;
		}
	
	//添加学生
	public boolean addStudent(student a)
	{
		student p=studentSear(a.getStudentID());
		if(p!=null)
			return false;
		System.out.println(1);
		String sql = "insert into student (studentID, studentName,birthday,sex,phoneNum,"
				+ "fieldID,password) values ('" + a.getStudentID() + "','" 
				+ a.getStudentName() + "','" +	a.getBirthday() + "','" 
				+ a.getSex() + "','" + a.getPhoneNum() + "','"
				+ a.getFieldID() + "','" + a.getPassword() + "')";
		try{
			stmt.executeUpdate(sql);
			System.out.println(2);
			return true;
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
			return false;
		}
	}

	//添加老师
	public boolean addTeacher(teacher a)
	{
		teacher p=teacherSear(a.getTeacherID());
		if(p!=null)
			return false;
		String sql = "insert into teacher (teacherID, teacherName,birthday,sex,phoneNum,"
				+ "schoolID,password) values ('" + a.getTeacherID() + "','" 
				+ a.getTeacherName() + "','" +	a.getBirthday() + "','" 
				+ a.getSex() + "','" + a.getPhoneNum() + "','"
				+ a.getSchoolID() + "','" + a.getPassword() + "')";
		try{
			stmt.executeUpdate(sql);
			//System.out.println(1);
			return true;
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
			return false;
		}
	}
	
	//删除学生
	public boolean delStudent(student a)
	{
		String sql = "delete from student where studentID='" + a.getStudentID() +"'";
		try{
			stmt.executeUpdate(sql);
			//System.out.println("2");
			return true;
		}
		catch(Exception ex){
			//System.out.println("sdasda");
	    	System.out.println(ex);
	    	System.exit(0);
	    	return false;
	    }
	}

	//删除老师
	public boolean delTeacher(teacher a)
	{
		String sql = "delete from teacher where teacherID='" + a.getTeacherID() +"'";
		try{
			stmt.executeUpdate(sql);
			//System.out.println("2");
			return true;
		}
		catch(Exception ex){
			//System.out.println("sdasda");
	    	System.out.println(ex);
	    	System.exit(0);
	    	return false;
	    }
	}
	
	//添加课程
	public boolean addSub(teacher a,String subjectID,String subjectName,int capacity)
	{
		subject c=searchSub(subjectID);
		if(c==null)
			return false;
		String sql = "insert into subject (subjectID, subjectName,teacherID,capacity,maxCapacity"
				+ ") values ('" + subjectID + "','" + subjectName + "','" +	a.getTeacherID() + "','" 
				+ capacity + "','" + capacity + "')";
		try{
			stmt.executeUpdate(sql);
			//System.out.println(1);
			return true;
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
			return false;
		}
	}
	
	//删除课程
	public boolean delSub(teacher a,String subjectID)
	{
		subject b = searchSub(subjectID);
		if(b.getTeacherID().equals(a.getTeacherID())) {
			//System.out.println(1);
			String sql = "delete from subject where subjectID='" + b.getSubjectID() +"'";
			try{
				stmt.executeUpdate(sql);
				//System.out.println("2");
				return true;
			}
			catch(Exception ex){
				//System.out.println("sdasda");
		    	System.out.println(ex);
		    	System.exit(0);
		    }
		}
		return false;
	}
	
	public String mesSub(String subjectID){
		subject a=searchSub(subjectID);
		if(a==null) return null;
		teacher b= teacherSear(a.getTeacherID());
		String c;
		c=a.getSubjectName()+";"+a.getTeacherID()+";"+b.getTeacherName()+";"+a.getCapacity()+"/"+a.getMaxCapacity();
		return c;
	}
	
	public String getGrade(String subjectID,String studentID)
	{
		String a="";
		String sql = "select * from choose where subjectID = '"+subjectID+"' and studentID = '"+studentID+"'"; 
		try{
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				a= rs.getString(3);
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		   	System.exit(0);
		}
		return a;
	}
	
	//修改成绩
	public boolean setGrade(String subjectID,String studentID,String Grade)
	{
		String sql = "update choose set grade = '"+Grade+
				"' where subjectID = '"+subjectID+"' and studentID = '"+studentID+"'" ;
		try{
			//System.out.println("3");
			stmt.executeUpdate(sql);//insert the book into database
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
			return false;
		}
		return true;
	}

	//查询所有专业编号
	public LinkedList<String> getAllFieldID()
	{
		LinkedList<String> a=new LinkedList<String>();
		String sql = "select * from field "; 
		 try{
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					String a1= rs.getString(1);
					a.add(a1);
				}
				return a;
		    }
		    catch(Exception ex){
		    	System.out.println(ex);
		    	System.exit(0);
		    }
		    return null;
	}
	
	public LinkedList<String> getAllStudentID()
	{
		LinkedList<String> a=new LinkedList<String>();
		String sql = "select * from student "; 
		 try{
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					String a1= rs.getString(1);
					a.add(a1);
				}
				return a;
		    }
		    catch(Exception ex){
		    	System.out.println(ex);
		    	System.exit(0);
		    }
		    return null;
	}
	
	public LinkedList<String> getAllTeacherID()
	{
		LinkedList<String> a=new LinkedList<String>();
		String sql = "select * from teacher "; 
		 try{
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					String a1= rs.getString(1);
					a.add(a1);
				}
				return a;
		    }
		    catch(Exception ex){
		    	System.out.println(ex);
		    	System.exit(0);
		    }
		    return null;
	}
	
	//查询所有学院编号
	public LinkedList<String> getAllSchoolID()
	{
		LinkedList<String> a=new LinkedList<String>();
		String sql = "select * from school "; 
		 try{
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					String a1= rs.getString(1);
					a.add(a1);
				}
				return a;
		    }
		    catch(Exception ex){
		    	System.out.println(ex);
		    	System.exit(0);
		    }
		    return null;
	}
	
	//查询某个专业名称
	public LinkedList<String> getField(String c)
	{
		LinkedList<String> a= new LinkedList<String>();
		String sql = "select * from field where fieldID = '"+c+"'"; 
		 try{
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					String a1= rs.getString(2);
					String a2= rs.getString(3);
					a.add(a1);
					a.add(a2);
				}
				return a;
		    }
		    catch(Exception ex){
		    	System.out.println(ex);
		    	System.exit(0);
		    }
		    return null;
	}

	//查询学院名称
	public String getSchool(String c)
	{
		String a;
		String sql = "select * from school where schoolID = '"+c+"'"; 
		try{
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				a= rs.getString(2);
				return a;
			}
	    }
		catch(Exception ex){
		   	System.out.println(ex);
		   	System.exit(0);
		}
		return null;
	}
	
	//学生修改个人信息
	public boolean stuChangeInf(student a,String name,String phoneNum,String password) {
		if(!name.equals(""))
			a.setStudentName(name);
		if(!phoneNum.equals(""))
			a.setPhoneNum(phoneNum);
		if(!password.equals(""))
			a.setPassword(password);
		String sql = "update student set studentName = '"+a.getStudentName()+
				"' , phoneNum = '"+a.getPhoneNum() + "' , password = '" + 
				a.getPassword() + "' where studentID ='"+a.getStudentID()+"'" ;
		try{
			//System.out.println("3");
			stmt.executeUpdate(sql);//insert the book into database
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
			return false;
		}
		return true;
	}
	
	//管理员修改学生
	public boolean stuChangeInf(student a,String name,String birthday,String sex,String phoneNum,String fieldID,String password) {
		if(!name.equals(""))
			a.setStudentName(name);
		if(!birthday.equals(""))
			a.setBirthday(birthday);
		if(!sex.equals(""))
			a.setSex(sex);
		if(!phoneNum.equals(""))
			a.setPhoneNum(phoneNum);
		if(!password.equals(""))
			a.setPassword(password);
		System.out.println(a.getFieldID());
		LinkedList<String> fieldIDAll=getAllFieldID();
		if(!fieldID.equals(null) && !fieldID.equals("") &&fieldIDAll.contains(fieldID))
			a.setFieldID(fieldID);
		System.out.println(a.getFieldID());
		String sql = "update student set studentName = '"+a.getStudentName()+
				"' , phoneNum = '"+a.getPhoneNum() + "' , password = '" + 
				a.getPassword() +"' , sex = '"+a.getSex() + "' , fieldID = '"+a.getFieldID() +
				"' , birthday = '"+a.getBirthday() +	"' where studentID ='"+a.getStudentID()+"'" ;
		try{
			System.out.println(sql);
			stmt.executeUpdate(sql);//insert the book into database
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
			return false;
		}
		return true;
	}

	//老师修改个人信息
	public boolean teaChangeInf(teacher a,String name,String phoneNum,String password) {
		if(!name.equals(""))
			a.setTeacherName(name);
		if(!phoneNum.equals(""))
			a.setPhoneNum(phoneNum);
		if(!password.equals(""))
			a.setPassword(password);
		String sql = "update teacher set teacherName = '"+a.getTeacherName()+
				"' , phoneNum = '"+a.getPhoneNum() + "' , password = '" + 
				a.getPassword() + "' where teacherID ='"+a.getTeacherID()+"'" ;
		try{
			//System.out.println("3");
			stmt.executeUpdate(sql);//insert the book into database
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
			return false;
		}
		return true;
	}
	
	//管理员修改老师
	public boolean teaChangeInf(teacher a,String name,String birthday,String sex,String phoneNum,String schoolID,String password) {
		if(!name.equals(""))
			a.setTeacherName(name);
		if(!birthday.equals(""))
			a.setBirthday(birthday);
		if(!sex.equals(""))
			a.setSex(sex);
		if(!phoneNum.equals(""))
			a.setPhoneNum(phoneNum);
		if(!password.equals(""))
			a.setPassword(password);
		System.out.println(a.getSchoolID());
		LinkedList<String> schoolIDAll=getAllSchoolID();
		if(!schoolID.equals(null) && !schoolID.equals("") &&schoolIDAll.contains(schoolID))
			a.setSchoolID(schoolID);
		System.out.println(a.getSchoolID());
		String sql = "update teacher set teacherName = '"+a.getTeacherName()+
				"' , phoneNum = '"+a.getPhoneNum() + "' , password = '" + 
				a.getPassword() +"' , sex = '"+a.getSex() + "' , schoolID = '"+a.getSchoolID() +
				"' , birthday = '"+a.getBirthday() +	"' where teacherID ='"+a.getTeacherID()+"'" ;
		try{
			System.out.println(sql);
			stmt.executeUpdate(sql);//insert the book into database
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
			return false;
		}
		return true;
	}
}

