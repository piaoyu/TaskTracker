package com.qg.task.dao;

import java.sql.*;
/**
 * 
 * @author piaoyu
 *
 */
public interface ConnectDBDao {	
	/**
	 * 获得数据库连接
	 * @return
	 */
	public Connection getConnection();
	
	/**
	 * 关闭连接
	 * @param conn
	 */
	public void closeConnection(Connection conn);
	
	/**
	 * 关闭Statement
	 */
	public void closeStmt(Statement Stmt);
	
	/**
	 * 关闭PreParedStatement
	 * @param preStmt
	 */
	public void closePrepStmt(PreparedStatement preStmt);
	
	/**
	 * 关闭ResultSet
	 * @param rs
	 */
	public void closeResultSet(ResultSet rs);
	
}
