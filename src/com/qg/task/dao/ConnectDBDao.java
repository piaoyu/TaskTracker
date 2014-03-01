package com.qg.task.dao;

import java.sql.*;
/**
 * 
 * @author piaoyu
 *
 */
public interface ConnectDBDao {	
	/**
	 * ������ݿ�����
	 * @return
	 */
	public Connection getConnection();
	
	/**
	 * �ر�����
	 * @param conn
	 */
	public void closeConnection(Connection conn);
	
	/**
	 * �ر�Statement
	 */
	public void closeStmt(Statement Stmt);
	
	/**
	 * �ر�PreParedStatement
	 * @param preStmt
	 */
	public void closePrepStmt(PreparedStatement preStmt);
	
	/**
	 * �ر�ResultSet
	 * @param rs
	 */
	public void closeResultSet(ResultSet rs);
	
}
