package com.qg.task.dao;
import java.sql.*;
import java.util.ArrayList;
import com.qg.task.bean.Task;
/**
 * 
 * @author piaoyu
 *
 */
public class TaskDaoImpl implements TaskDao{
	private ConnectDBDao connectDBDao = new ConnectDBDaoImpl();
	
	public ArrayList<Task> getAllTask() {
		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		ArrayList<Task> tasks = new ArrayList<Task>();
		Task task = null;
		try {
			conn = connectDBDao.getConnection(); // 运行时是ConnectDBDaoImpl这种类型
			String sql = "select * from task";
			prepStmt = conn.prepareStatement(sql);
			rs = prepStmt.executeQuery();
			while(rs.next()) {
				task = new Task();
				task.setTime(rs.getString("time"));
				task.setId(rs.getInt("id"));
				task.setContent(rs.getString("content"));
				task.setState(rs.getInt("state"));
				tasks.add(task);
			} // end while
			return tasks;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connectDBDao.closeResultSet(rs);
			connectDBDao.closePrepStmt(prepStmt);
			connectDBDao.closeConnection(conn);
		}
		return null;
	}
	public void add( String time,String content) {//增加任务
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prepStmt = null;
		try{
			conn = connectDBDao.getConnection();
			String sql = "insert into task values (?,null,?,0)";
			prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, time);
			prepStmt.setString(2, content);
			prepStmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			connectDBDao.closePrepStmt(prepStmt);
			connectDBDao.closeConnection(conn);
		}
	}
	
	public void complete(int id) {//完成任务
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prepStmt = null;
		try{
			conn = connectDBDao.getConnection();
			String sql = "update from task set state = 1 where id = ?";
			prepStmt = conn.prepareStatement(sql);
			prepStmt.setInt(1, id);
			prepStmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			connectDBDao.closePrepStmt(prepStmt);
			connectDBDao.closeConnection(conn);
		}
	}
	  
	public void recover(int id) {//恢复任务
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prepStmt = null;
		try{
			conn = connectDBDao.getConnection();
			String sql = "update from task set state = 0 where id = ?";
			prepStmt = conn.prepareStatement(sql);
			prepStmt.setInt(1, id);
			prepStmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			connectDBDao.closePrepStmt(prepStmt);
			connectDBDao.closeConnection(conn);
		}
	}
	
	public void delete(int id) {//删除任务
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prepStmt = null;
		try{
			conn = connectDBDao.getConnection();
			String sql = "delete from task set state = 0 where id = ?";
			prepStmt = conn.prepareStatement(sql);
			prepStmt.setInt(1, id);
			prepStmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			connectDBDao.closePrepStmt(prepStmt);
			connectDBDao.closeConnection(conn);
		}
	}
	
	public void modify(int id,String content) {//更改任务
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement prepStmt = null;
		try{
			conn = connectDBDao.getConnection();
			String sql = "update task set content=?where id=?";
			prepStmt = conn.prepareStatement(sql);
			prepStmt.setInt(2, id);
			prepStmt.setString(1, content);
			prepStmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			connectDBDao.closePrepStmt(prepStmt);
			connectDBDao.closeConnection(conn);
		}
	}   
}
