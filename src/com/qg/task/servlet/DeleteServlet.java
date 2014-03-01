package com.qg.task.servlet;
import com.qg.task.bean.*;
import com.qg.task.service.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author piaoyu
 */
public class DeleteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		   //获得参数id
		   int id=Integer.parseInt(request.getParameter("id"));
		   TaskService taskService = new TaskServiceImpl();
		   //执行删除操作
		   taskService.delete(id);
		   
		   PrintWriter out = response.getWriter();
	       out.flush();
		   out.close();;
	   }
}