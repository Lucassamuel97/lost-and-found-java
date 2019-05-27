package br.edu.utfpr.alunos.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class SqlBase {

	private String user = "root";
	private String password = "";
	protected Connection conection = null;

	public Connection open() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/lost_and_found?useSSL=false&allowMultiQueries=true", user, password);
			if(conection != null)
				return conection;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException eOne) {
			eOne.printStackTrace();
		}
		
		return null;
	}

	public void close() {

			try { 
				if (conection != null) 
					conection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
