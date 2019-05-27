package br.edu.utfpr.alunos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.edu.utfpr.alunos.model.Role;
import br.edu.utfpr.alunos.model.User;

public class UserDAO extends SqlBase {

	protected EntityManager entityManager;

	public UserDAO() {
		open();
		
		try {
			PreparedStatement stm = (PreparedStatement) conection.prepareStatement(
					          "CREATE TABLE IF NOT EXISTS users (" + 
							  "login varchar(20) NOT NULL PRIMARY KEY,"+ 
							  "pwd VARCHAR(64) NOT NULL)");
			
			stm.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}

	public User getById(final int id) {
		
		User result = new User();
		open();
		
		try {
			String query = "SELECT * FROM users WHERE id =" + id + ";";	
	
			Statement statement = (Statement) conection.createStatement();
	
			ResultSet resultSet = statement.executeQuery(query);
			
			if (resultSet.next()) {
				
				result.setLogin(resultSet.getString(1));
				result.setPwd(resultSet.getString(2));
				result.setTelefone(resultSet.getString(3));
				result.setEmail(resultSet.getString(4));

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
	
	
	public User getByName(String name){		
		User result = new User();
		open();
		
		try {
			String query = "SELECT * FROM users WHERE login ='" + name + "';";	
			
			Statement statement = (Statement) conection.createStatement();
	
			ResultSet resultSet = statement.executeQuery(query);
			
			if (resultSet.next()) {
				
				result.setLogin(resultSet.getString(1));
				result.setPwd(resultSet.getString(2));
				result.setTelefone(resultSet.getString(3));
				result.setEmail(resultSet.getString(4));

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

	public List<User> findAll(){
		ArrayList<User> result = new ArrayList<>();
		
		open();
		
		try {
			String query = "SELECT * FROM users ORDER BY login";	
			
			Statement statement = (Statement) conection.createStatement();
	
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				User userBean = new User(resultSet.getString(1), resultSet.getString(2),resultSet.getString(3), resultSet.getString(4));
				result.add(userBean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

	public User create(User user) {
		open();
		
		try {
			
			String query = "INSERT INTO users SET login='" +user.getLogin()+"', pwd = '"+user.getPwd()+"', telefone='"+user.getTelefone()+"', email='"+user.getEmail()+"';";
			System.out.println(query);
			Statement statement = (Statement) conection.createStatement();
	
			statement.execute(query);
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return user;
	}

	public void update(User user, int id) {
		
		open();
		
		try {
			
			String query = "update users set login='" + user.getLogin() + "', pwd='" + user.getPwd() + "', telefone = '" + user.getTelefone() + "', email='" + user.getEmail() + "' where id=" + id + ";";	
			
			Statement statement = (Statement) conection.createStatement();
	
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			close();
		}
	}
	
	public void delete(User user) {
		
		open();
		
		try {
			String query = "DELETE FROM users WHERE login =" + user.getLogin() + "";	
			
			Statement statement = (Statement) conection.createStatement();
			
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			close();
		}
	}

}