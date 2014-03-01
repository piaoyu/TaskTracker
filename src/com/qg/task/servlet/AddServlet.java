package com.qg.task.servlet;
import com.qg.task.service.*;
import com.qg.task.bean.*;
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
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		 response.setContentType("text/html;   charset=utf-8"); 
	      //��ò���ʱ��
	      String time=request.getParameter("time");
	      //��ò�������
	      String content=request.getParameter("content");
	      byte b[]=content.getBytes("ISO-8859-1");
	      content=new String(b); 
	      //ִ���������������
	      TaskService taskService = new TaskServiceImpl();
		  taskService.add(time, content);
		  
		  //����������ʱˢ��newtask��
		  PrintWriter out = response.getWriter();
		  Task task=null;
		  ArrayList<Task> tasks = taskService.getAllTask();
		  for (int i = 0; i < tasks.size(); i++) {
		  task = tasks.get(i);  
		     if (task.getState()==0){
			    out.print("<p>");
				out.print(task.getTime()+" "); 
				out.print(task.getContent());
				out.print("<input type='button' value='���' onclick='complete("+task.getId()+")'/>");
				out.print("<input type='button' value='�޸�' onclick='modify("+task.getId()+")'/>");  
				out.print("<input type='button' value='ɾ��' onclick='delete_("+task.getId()+")'/>"); 
		     }//end if 
		  }//end for
		 out.flush();
		 out.close();
	  }
	
}
