package com.qg.task.bean;
/**
 * 
 * @author piaoyu
 *
 */
public class Task {
        //������id
	private int id;
	
	//��������
	private String content;
	
	//������״̬
	private int state;
	
	//������ʱ��
	private String time;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time= time;
	}
}
