package com.classtransaction.service;

import java.util.List;

import com.classtransaction.model.Course;
import com.classtransaction.model.User;

public interface CourseService {
	
	/**
	 * 返回全部的课程
	 * @return
	 */
	List<Course> getCourses();
	
	/**
	 * 添加一个course
	 * @param course
	 */
	void addCourse(Course course);
	
	/**
	 * 删除course
	 * @param id
	 */
	void delete(String id);
	
	/**
	 * 查询课程
	 * @param realCourse
	 * @return
	 */
	List<Course> query(String realCourse);
}
