package com.qg.task.bean;
/**
 * 
 * @author piaoyu
 *
 */
public class Task {
    //任务的id
	private int id;
	
	//任务内容
	private String content;
	
	//任务的状态
	private int state;
	
	//任务的时间
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
