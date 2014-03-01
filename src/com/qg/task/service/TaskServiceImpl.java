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
		//Cache.add(tasks); // �ѻ�õ����ݼ��뵽����
		return tasks;
	}

	public void add(String time, String content) {
		// TODO Auto-generated method stub
		taskDao.add(time, content);//��������
	}

	public void complete(int id) {
		// TODO Auto-generated method stub
		taskDao.complete(id);//�������
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		taskDao.delete(id);//ɾ������
	}

	public void modify(int id, String contnet) {
		// TODO Auto-generated method stub
		taskDao.modify(id, contnet);//�޸�����
	}

	public void recover(int id) {
		// TODO Auto-generated method stub
		taskDao.recover(id);//�ָ�����
	}
	
}
