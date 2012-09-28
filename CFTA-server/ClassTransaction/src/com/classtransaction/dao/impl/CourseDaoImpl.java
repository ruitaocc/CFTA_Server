package com.classtransaction.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.classtransaction.dao.CourseDao;
import com.classtransaction.dao.RoleDao;
import com.classtransaction.model.Course;
import com.classtransaction.model.User;

public class CourseDaoImpl extends BaseDaoImpl implements CourseDao{

	@Override
	public void delete(String id) {
		StringBuffer sql = new StringBuffer("update T_COURSE u");
		sql.append(" set u.ISDELETE = '1'")
		.append(" where u.ID = '" + id + "'");
		getJDBCExecutor().executeUpdate(sql.toString());
	}

	public Course find(String courseId) {
		String sql = "select * from T_COURSE u where u.ID = '" + courseId + "'";
		List<Course> courses = (List<Course>)getDatas(sql, new ArrayList(), Course.class);
		return courses.size() == 1 ? courses.get(0) : null;
	}

	@Override
	public Course findCourse(String courseName) {
		String sql = "select * from T_COURSE u where u.COURSENAME = '" 
			+ courseName +"' and u.ISDELETE = '0'";
		List<Course> courses = (List<Course>)getDatas(sql, new ArrayList(), Course.class);
		return courses.size() == 1 ? courses.get(0) : null;
	}

	@Override
	public List<Course> findCourses() {
		String sql = "select * from T_COURSE u where u.ISDELETE = '0'";
		List<Course> courses = (List<Course>)getDatas(sql, new ArrayList(), Course.class);
		return courses;
	}

	public int getCourseCount() {
		String sql = "SELECT COUNT(DISTINCT COURSENAME) FROM `classtransaction`.`t_course` U WHERE U.ISDELETE = '0'";
		return getJDBCExecutor().count(sql);
	}

	public List<Course> query(String realCourse) {
		String sql = "select * from T_COURSE u where u.COURSENAME like '%" 
			+ realCourse + "%' and u.ISDELETE = '0'";
		List<Course> Courses = (List<Course>)getDatas(sql, new ArrayList(), Course.class);
		return Courses;
	}

	@Override
	public void save(Course course) {
		StringBuffer sql = new StringBuffer("insert into T_COURSE VALUES (");
		sql.append("'"+course.getID()+"','");
		sql.append(course.getCOURSENAME() + "', '")
		.append(course.getCOURSETIME() + "', '")
		.append(course.getCOURSEPLACE() + "', '")
		
		.append(course.getCOURSEMASTERID() + "', '")
		.append(course.getCOURSECREDIT() + "', '")
		.append(course.getCOURSETYPE() + "', '")
		.append(course.getCOURSEREMARK() + "', '")
		
		.append("0')");
		getJDBCExecutor().executeUpdate(sql.toString());
		
	}

	@Override
	public Course findCourse(String courseName, String courseTime,
			String coursePlace) {
		String sql = "select * from T_COURSE u where u.COURSENAME = '" 
			+ courseName +"' and u.COURSETIME = '"+courseTime+"' and u.COURSEPLACE = '"+coursePlace+"' and u.ISDELETE = '0'";
		List<Course> courses = (List<Course>)getDatas(sql, new ArrayList(), Course.class);
		return courses.size() == 1 ? courses.get(0) : null;
		
	}

	

}
