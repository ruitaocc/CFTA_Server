package com.classtransaction.service;

import java.util.List;

import com.classtransaction.model.Course;
import com.classtransaction.model.User;

public interface CourseService {
	
	/**
	 * ����ȫ���Ŀγ�
	 * @return
	 */
	List<Course> getCourses();
	
	/**
	 * ���һ��course
	 * @param course
	 */
	void addCourse(Course course);
	
	/**
	 * ɾ��course
	 * @param id
	 */
	void delete(String id);
	
	/**
	 * ��ѯ�γ�
	 * @param realCourse
	 * @return
	 */
	List<Course> query(String realCourse);
}
