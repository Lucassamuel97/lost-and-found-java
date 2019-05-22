package br.edu.utfpr.alunos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import com.mysql.jdbc.PreparedStatement;

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
			PreparedStatement stm = (PreparedStatement) conection.prepareStatement("SELECT * FROM users WHERE id = ?");
			
			stm.setInt(1, id);
			ResultSet resultSet = stm.executeQuery();
			
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
			PreparedStatement stm = (PreparedStatement) conection.prepareStatement("SELECT * FROM users WHERE login = ?");
			
			stm.setString(1, name);
			ResultSet resultSet = stm.executeQuery();
			
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
			PreparedStatement stm = (PreparedStatement) conection.prepareStatement("SELECT * FROM users ORDER BY login");
			ResultSet resultSet = stm.executeQuery();
			
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

	@Deprecated
	public void persist(User user, Role role) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.persist(role);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public User create(User user) {
		open();
		
		try {
			PreparedStatement statement = (PreparedStatement) conection.prepareStatement("INSERT INTO users (login, pwd, telefone, email) VALUES (?,?,?,?)");
				statement.setString(1, user.getLogin());
				statement.setString(2, user.getPwd());
				statement.setString(3, user.getTelefone());
				statement.setString(4, user.getEmail());
		
				statement.executeUpdate();
				
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
			PreparedStatement statement = (PreparedStatement) conection.prepareStatement("UPDATE users SET login = ?, pwd = ?, telefone = ?, email = ? WHERE id = ?");
			statement.setString(1, user.getLogin());
			statement.setString(2, user.getPwd());
			statement.setString(3, user.getTelefone());
			statement.setString(4, user.getEmail());
			statement.setInt(5, user.getId());
			statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			close();
		}
	}
	
	public void delete(User user) {
		
		open();
		
		try {
			PreparedStatement statement = (PreparedStatement) conection.prepareStatement("DELETE FROM users WHERE login = ?" );
			
			statement.setString(1, user.getLogin());
			
			statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			close();
		}
	}

}