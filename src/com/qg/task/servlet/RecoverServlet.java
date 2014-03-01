package com.qg.task.servlet;
import com.qg.task.bean.Task;
import com.qg.task.service.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author piaoyu
 *
 */
public class RecoverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		      //获得参数id 
	          int id=Integer.parseInt(request.getParameter("id"));
	          //执行恢复操作
	          TaskService taskService = new TaskServiceImpl();
	          taskService.recover(id);
	          
	          //增加新任务时刷新newtask区
			  PrintWriter out = response.getWriter();
			  Task task=null;
			  ArrayList<Task> tasks = taskService.getAllTask();
			  task = tasks.get(id);  
			  out.print("<p>");
			  out.print(task.getTime()+" "); 
			  out.print(task.getContent());
			  out.print("<input type='button' value='恢复' onclick='complete("+task.getId()+")'/>");
			  out.print("<input type='button' value='修改' onclick='modify("+task.getId()+")'/>");  
			  out.print("<input type='button' value='删除' onclick='delete_("+task.getId()+")'/>");  
			  out.flush();
			  out.close();
	        }
}
