package br.edu.utfpr.alunos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.edu.utfpr.alunos.model.Role;
import br.edu.utfpr.alunos.model.User;

public class RoleDAO extends SqlBase{

	public RoleDAO() {

		open();

		try {
			PreparedStatement stm = (PreparedStatement) conection.prepareStatement("CREATE TABLE IF NOT EXISTS  roles (" + 
					"	login varchar(20) NOT NULL," + 
					"    role varchar(20) NOT NULL," + 
					"	primary key(login, role)" + 
					")ENGINE = InnoDB;");
			stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public Role create(User user, Role role) {

		open();

		try {
			PreparedStatement statement = (PreparedStatement) conection.prepareStatement("INSERT INTO roles (login, role) VALUES (?,?);");
			statement.setString(1, user.getLogin());
			statement.setString(2, role.getRole());
	
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return role;
	}

	public List<Role> findAll() {
		ArrayList<Role> result = new ArrayList<>();
		open();

		try {
			PreparedStatement stm = (PreparedStatement) conection
					.prepareStatement("SELECT * FROM roles ORDER BY roles ASC;");
			ResultSet resultSet = stm.executeQuery();

			while (resultSet.next()) {
				Role roleBean = new Role(resultSet.getString(1), resultSet.getString(2));
				result.add(roleBean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

	public void update(Role role) {

		open();

		try {
			PreparedStatement stm = (PreparedStatement) conection.prepareStatement("UPDATE roles SET login = ?, role = ? WHERE login = ? AND role = ?;");

			stm.setString(1, role.getName());
			stm.setString(2, role.getRole());

			stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close();
		}
	}

	public void delete(Role role) {

		open();

		try {
			PreparedStatement stm = (PreparedStatement) conection.prepareStatement("DELETE FROM roles WHERE role = ? and login = ?;");

			stm.setString(1, role.getRole());
			stm.setString(2, role.getName());

			stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public Role find(String primaryKey) {
		Role result = null;
		open();

		try {
			PreparedStatement stm = (PreparedStatement) conection.prepareStatement("SELECT * FROM roles WHERE login = ?;");

			stm.setString(1, primaryKey);

			ResultSet resultSet = stm.executeQuery();

			if (resultSet.next()) {
				Role roleBean = new Role(resultSet.getString(1), resultSet.getString(2));
				result = roleBean;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}
}
