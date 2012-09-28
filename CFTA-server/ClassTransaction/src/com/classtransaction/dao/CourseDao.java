package com.classtransaction.dao;

import java.util.List;

import com.classtransaction.model.Course;
import com.classtransaction.model.User;

public interface CourseDao {
	/**
	 * ���ݿγ����Ʋ��ҿγ�
	
	 * @return
	 */
	Course findCourse(String courseName);
	
	/**
	 * ���ݿγ�����ʱ�䣬�ص�Ʋ��ҿγ�
	
	 * @return
	 */
	Course findCourse(String courseName,String courseTime,String coursePlace);
	
	
	/**
	 * ����ȫ���Ŀγ�
	 * @return
	 */
	List<Course> findCourses();
	
	/**
	 * �����¿γ�
	 * @param course
	 */
	void save(Course course);
	
	
	
	/**
	 * �޸Ŀγ�
	 * @param user
	 */
	void delete(String id);
	
	/**
	 * �����û���
	 * @return
	 */
	int getCourseCount();
	
	/**
	 * ���ݿγ���ģ�������û�  ������ʽ
	 * @param userName
	 * @return
	 */
	List<Course> query(String realCourse);
	
	/**
	 * ����ID�����û�
	 * @param id
	 * @return
	 */
	Course find(String courseId);
}
