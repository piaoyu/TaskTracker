package com.qg.task.service;
import java.util.ArrayList;
import com.qg.task.bean.Task;
import com.qg.task.dao.TaskDao;
import com.qg.task.dao.TaskDaoImpl;

/**
 * 
 * @author piaoyu
 *
 */
public class TaskServiceImpl implements TaskService{
	
	TaskDao taskDao = new TaskDaoImpl();
	
	public ArrayList<Task> getAllTask() {
		ArrayList<Task> tasks = taskDao.getAllTask();
		//Cache.add(tasks); // 把获得的数据加入到缓存
		return tasks;
	}

	public void add(String time, String content) {
		// TODO Auto-generated method stub
		taskDao.add(time, content);//增加任务
	}

	public void complete(int id) {
		// TODO Auto-generated method stub
		taskDao.complete(id);//完成任务
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		taskDao.delete(id);//删除任务
	}

	public void modify(int id, String contnet) {
		// TODO Auto-generated method stub
		taskDao.modify(id, contnet);//修改任务
	}

	public void recover(int id) {
		// TODO Auto-generated method stub
		taskDao.recover(id);//恢复任务
	}
	
}
