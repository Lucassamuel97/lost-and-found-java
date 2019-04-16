package br.edu.utfpr.alunos.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import br.edu.utfpr.alunos.model.Users;

public class UsersDAO extends SqlBase {

	public UsersDAO() {

		open();

		try {
			PreparedStatement stm = (PreparedStatement) conection.prepareStatement(
					"CREATE TABLE IF NOT EXISTS `users`  (\r\n" + 
					"  `id` int(11) NOT NULL AUTO_INCREMENT,\r\n" + 
					"  `login` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,\r\n" + 
					"  `pwd` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,\r\n" + 
					"  `telefone` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,\r\n" + 
					"  `email` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,\r\n" + 
					"  PRIMARY KEY (`id`) USING BTREE\r\n" + 
					")"+ "ENGINE = InnoDB;");
			
			stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public Users create(Users user) {

		open();
		
		Users UserResult = new Users();
		
		try {
			PreparedStatement statement = (PreparedStatement) conection.prepareStatement("INSERT INTO users(login, pwd, telefone, email) VALUES (?, ?, ?,?)", Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, user.getLogin());
				statement.setString(1, user.getPwd());
				statement.setString(1, user.getTelefone());
				statement.setString(1, user.getEmail());
		
				statement.executeUpdate();
				
				ResultSet resultSet = statement.getGeneratedKeys();
				if(resultSet.next()) {
					UserResult = user;
					UserResult.setId(resultSet.getInt(1));
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return UserResult;
	}
	
	public List<Users> findAll(){
		ArrayList<Users> result = new ArrayList<>();
		
		open();
		
		try {
			PreparedStatement stm = (PreparedStatement) conection.prepareStatement("SELECT * FROM users ORDER BY login");
			ResultSet resultSet = stm.executeQuery();
			
			while (resultSet.next()) {
				Users user = new Users(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
				result.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
	
	public void update(Users user) {
		
		open();
		
		try {
			PreparedStatement stm = (PreparedStatement) conection.prepareStatement("UPDATE users SET login = ?, pwd = ?, telefone = ?, email = ? WHERE id = ?");
			stm.setString(1, user.getLogin());
			stm.setString(2, user.getPwd());
			stm.setString(3, user.getTelefone());
			stm.setString(4, user.getEmail());
			stm.setInt(5, user.getId());
			
			stm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			close();
		}
	}
	
	public void delete(Users user) {
		
		open();
		
		try {
			PreparedStatement stm = (PreparedStatement) conection.prepareStatement("DELETE FROM users WHERE id = ?" );
			stm.setInt(1, user.getId());
			stm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			close();
		}
	}
	
	public Users find(int id){
		Users userResult = new Users();
		open();
		
		try {
			PreparedStatement stm = (PreparedStatement) conection.prepareStatement("SELECT * FROM users WHERE id = ?");
			stm.setInt(1, id);
			
			ResultSet resultSet = stm.executeQuery();
			
			if (resultSet.next()) {
				userResult.setId(resultSet.getInt(1));
				userResult.setLogin(resultSet.getString(2));
				userResult.setPwd(resultSet.getString(3));
				userResult.setTelefone(resultSet.getString(4));
				userResult.setEmail(resultSet.getString(5));

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return userResult;
	}
}
