package com.qg.task.service;

import java.util.ArrayList;

import com.qg.task.bean.Task;
/**
 * 
 * @author piaoyu
 *
 */
public interface TaskService {
	/**
	 * �����������
	 * @return
	 */
	public ArrayList<Task> getAllTask();
	/**
	 * ɾ������
	 * @param id
	 */
	public void delete(int id);
	/**
	 * �������
	 * @param id
	 */
	public void complete(int id);
	/**
	 * �ָ�����
	 * @param id
	 */
	public void recover(int id);
	/**
	 * ��������
	 * @param time
	 * @param content
	 */
	public void add(String time ,String content);
	/**
	 * �޸�����
	 * @param id
	 * @param contnet
	 */
	public void modify(int id,String contnet);
	
}

