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
		
		      //��ò���id 
	          int id=Integer.parseInt(request.getParameter("id"));
	          //ִ�лָ�����
	          TaskService taskService = new TaskServiceImpl();
	          taskService.recover(id);
	          
	          //����������ʱˢ��newtask��
			  PrintWriter out = response.getWriter();
			  Task task=null;
			  ArrayList<Task> tasks = taskService.getAllTask();
			  task = tasks.get(id);  
			  out.print("<p>");
			  out.print(task.getTime()+" "); 
			  out.print(task.getContent());
			  out.print("<input type='button' value='�ָ�' onclick='complete("+task.getId()+")'/>");
			  out.print("<input type='button' value='�޸�' onclick='modify("+task.getId()+")'/>");  
			  out.print("<input type='button' value='ɾ��' onclick='delete_("+task.getId()+")'/>");  
			  out.flush();
			  out.close();
	        }
}
