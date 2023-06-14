package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTOs.User;

public class UsersDAO implements DAO<User> {
	private Connection con;
	public UsersDAO(Connection con) {
		this.con = con;
	}

	@Override
	public void insert(User entity) throws SQLException {
		PreparedStatement preparedStatement = null;
	    try {
	        String sql = "INSERT INTO users (name, student_id, password) VALUES (?, ?, ?)";
	        preparedStatement = con.prepareStatement(sql);
	        preparedStatement.setString(1, entity.getName());
	        preparedStatement.setInt(2, entity.getStudentId());
	        preparedStatement.setString(3, entity.getPassword());
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        throw new RuntimeException("データベースエラー", e);
	    } finally {
	        if (preparedStatement != null) {
	            preparedStatement.close();
	        }
	    }
	}

	@Override
	public void update(User entity) throws SQLException {
		PreparedStatement preparedStatement = null;
	    try {
	        String sql = "UPDATE users SET name = ?, password = ? WHERE studentId = ?";
	        preparedStatement = con.prepareStatement(sql);
	        preparedStatement.setString(1, entity.getName());
	        preparedStatement.setString(2, entity.getPassword());
	        preparedStatement.setInt(3, entity.getStudentId());
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        throw new RuntimeException("データベースエラー", e);
	    } finally {
	        if (preparedStatement != null) {
	            preparedStatement.close();
	        }
	    }
	}

	@Override
	public void delete(User condition) throws SQLException {
		PreparedStatement preparedStatement = null;
	    try {
	        String sql = "DELETE FROM users WHERE student_id = ?";
	        preparedStatement = con.prepareStatement(sql);
	        preparedStatement.setInt(1, condition.getStudentId());
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        throw new RuntimeException("データベースエラー", e);
	    } finally {
	        if (preparedStatement != null) {
	            preparedStatement.close();
	        }
	    }
	}

	@Override
	public List<User> getAll() throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			String sql = "SELECT * FROM users";
			preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<User> result = new ArrayList<>();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int studentId = Integer.parseInt(resultSet.getString("student_id"));
				String password = resultSet.getString("password");
				String status = resultSet.getString("status");

				User user = new User(studentId, name, password, status);
				result.add(user);
			}

			for (int i = 0; i < result.size(); i++) {
				User user = result.get(i);
				String name = user.getName();
				Integer studentId = user.getStudentId();
				String password = user.getPassword();

				System.out.println("User details at index " + i + ":");
				System.out.println("Student ID: " + studentId);
				System.out.println("Name: " + name);
				System.out.println("Password: " + password);
				System.out.println("------------------------");
			}

			return result;
		} catch (SQLException e) {
			throw new RuntimeException("データベースエラー", e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
					System.out.println("ステートメントの解放に成功しました");
				}
			} catch (SQLException e) {
				throw new RuntimeException("ステートメントの解放に失敗しました", e);
			}
		}
	}


	public User checkById(Integer id) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			User user = new User();
			String sql = "SELECT * FROM Users Where student_id=" + id;
			preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				int studentId = Integer.parseInt(resultSet.getString("student_id"));
				String password = resultSet.getString("password");
				String status = resultSet.getString("status");
				user.setName(name);
				user.setStudentId(studentId);
				user.setPassword(password);
				user.setStatus(status);
			};

			return user;

		} catch (SQLException e) {
			throw new RuntimeException("データベースエラー", e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
					System.out.println("ステートメントの解放に成功しました");
				}
			} catch (SQLException e) {
				throw new RuntimeException("ステートメントの解放に失敗しました", e);
			}
		}
	}

	@Override
	public List<User> select(User searchCondition) throws SQLException {
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			Connection connection = connectionManager.getConnection();
			PreparedStatement preparedStatement = null;
			try {
				StringBuilder sql = new StringBuilder("SELECT * FROM users WHERE 1 = 1");


				if (searchCondition.getName() != null) {
					sql.append(" AND name = '").append(searchCondition.getName()).append("'");
				}
				if (searchCondition.getStudentId() != null) {
					sql.append(" AND student_id = '").append(searchCondition.getStudentId()).append("'");
				}
				if (searchCondition.getPassword() != null) {
					sql.append(" AND password = '").append(searchCondition.getPassword()).append("'");
				}

				sql.append(" ORDER BY id");
				System.out.println(sql.toString());

				preparedStatement = connection.prepareStatement(sql.toString());
				ResultSet resultSet = preparedStatement.executeQuery();
				List<User> result = new ArrayList<>();

				while (resultSet.next()) {
					String name = resultSet.getString("name");
					int studentId = Integer.parseInt(resultSet.getString("student_id"));
					String password = resultSet.getString("password");
					String status = resultSet.getString("status");

					User user = new User(studentId, name, password, status);
					result.add(user);
				}

				for (int i = 0; i < result.size(); i++) {
					User user = result.get(i);
					String name = user.getName();
					int studentId = user.getStudentId();
					String password = user.getPassword();

					System.out.println("User details at index " + i + ":");
					System.out.println("Name: " + name);
					System.out.println("Student ID: " + studentId);
					System.out.println("Password: " + password);
					System.out.println("------------------------");
				}

				return result;
			} catch (SQLException e) {
				throw new RuntimeException("データベースエラー", e);
			} finally {
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
						System.out.println("ステートメントの解放に成功しました");
					}
				} catch (SQLException e) {
					throw new RuntimeException("ステートメントの解放に失敗しました", e);
				}
			}
		} finally {
			connectionManager.closeConnection();
		}
	}
}
