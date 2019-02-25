package com.whgc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperUtil {
	public static String getByNameAndPW(String name,String password) {
    	String sql = "select * from user_ where name=\"demo1\" and  password=\"pw1\"";
    	//查找table表重的 id和name
		String json = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println(DBUtil.resultSetToJson(rs));
			json = DBUtil.resultSetToJson(rs);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		return json;

	}
	public static void main(String[] args) {
		getByNameAndPW("demo1","pw1");
	}

}

