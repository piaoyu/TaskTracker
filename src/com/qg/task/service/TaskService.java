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
	 * 获得所有任务
	 * @return
	 */
	public ArrayList<Task> getAllTask();
	/**
	 * 删除任务
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 完成任务
	 * @param id
	 */
	public void complete(int id);
	/**
	 * 恢复任务
	 * @param id
	 */
	public void recover(int id);
	/**
	 * 增加任务
	 * @param time
	 * @param content
	 */
	public void add(String time ,String content);
	/**
	 * 修改任务
	 * @param id
	 * @param contnet
	 */
	public void modify(int id,String contnet);
	
}

