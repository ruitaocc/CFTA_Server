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
		//�����µ��û���ȥ����, �ж��Ƿ������ͬ�û������û�
		Course u = this.courseDao.findCourse(course.getCOURSENAME(),course.getCOURSETIME(),course.getCOURSEPLACE());
		if (u != null) throw new BusinessException("���ÿγ����Ѿ�����");
		this.courseDao.save(course);		
	}

	@Override
	public void delete(String id) {
		//���һ���û�����ɾ��
		if (this.courseDao.getCourseCount() <= 1) {
			throw new BusinessException("���һ���γ̲���ɾ��");
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
