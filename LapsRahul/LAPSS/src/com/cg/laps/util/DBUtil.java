package com.cg.laps.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {	
		static Connection conn;		
		static{
			
			try {
				InitialContext context = new InitialContext();
				DataSource source = (DataSource) context.lookup("java:/OracleDS");
				conn = source.getConnection();
			} catch (Exception e) {
				try {
					throw new SQLException(e.getMessage());
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		}
		
		public static Connection getConnection(){			
			return conn;
		}
}
