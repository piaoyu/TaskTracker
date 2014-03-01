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
 *@author  piaoyu
 */
public class CompleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public class CompleteService extends HttpServlet {
		
		private static final long serialVersionUID = 1L;
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			//��ò���id    
			int id=Integer.parseInt(request.getParameter("id"));
			//ִ����ɲ���
			TaskService MyOperation=new TaskServiceImpl();
			MyOperation.complete(id);
			
			//���������ʱˢ��finishtask��
			PrintWriter out = response.getWriter();
			Task task=null;
			TaskService taskService = new TaskServiceImpl();
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

}
