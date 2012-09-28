package com.classtransaction.service.impl;

import java.util.List;

import com.classtransaction.dao.CourseDao;
import com.classtransaction.model.Course;
import com.classtransaction.model.Role;
import com.classtransaction.model.User;
import com.classtransaction.service.BusinessException;
import com.classtransaction.service.CourseService;

public class CourseServiceImpl implements CourseService{
	private CourseDao courseDao;
	
	public CourseServiceImpl(CourseDao courseDao){
		this.courseDao = courseDao;
	}
	
	
	@Override
	public void addCourse(Course course) {
		//根据新的用户名去查找, 判断是否存在相同用户名的用户
		Course u = this.courseDao.findCourse(course.getCOURSENAME(),course.getCOURSETIME(),course.getCOURSEPLACE());
		if (u != null) throw new BusinessException("该用课程项已经存在");
		this.courseDao.save(course);		
	}

	@Override
	public void delete(String id) {
		//最后一个用户不能删除
		if (this.courseDao.getCourseCount() <= 1) {
			throw new BusinessException("最后一个课程不能删除");
		}
		this.courseDao.delete(id);
	}

	@Override
	public List<Course> getCourses() {
		List<Course> courses = this.courseDao.findCourses();
		return courses;
	}

	@Override
	public List<Course> query(String realCourse) {
		List<Course> courses = this.courseDao.query(realCourse);
		return courses;
	}

}
