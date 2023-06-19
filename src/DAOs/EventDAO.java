package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DTOs.Event;

public class EventDAO {
	private Connection con;

	public EventDAO(Connection con) {
		this.con = con;
	}

	public List<Event> getAll() throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			String sql = "SELECT * FROM event ORDER BY id";
			preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Event> result = new ArrayList<>();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int userId = resultSet.getInt("user_id");
				String eventTitle = resultSet.getString("event_title");
				String summary = resultSet.getString("summary");
				int maxCap = resultSet.getInt("max_cap");
				int currentParticipants = resultSet.getInt("current_participants");
				Timestamp startTime = resultSet.getTimestamp("start_time");
				Timestamp endTime = resultSet.getTimestamp("end_time");
				String image = resultSet.getString("image");
				Event event = new Event(id, userId, eventTitle, summary, maxCap, currentParticipants,
						startTime, endTime, image);

				result.add(event);
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

	public void insert(Event entity) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			con.setAutoCommit(false);
			String sql = "INSERT INTO event (user_id, event_title, summary, max_cap, current_participants, start_time, end_time, image) "
					+
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, entity.getUserId());
			preparedStatement.setString(2, entity.getEventTitle());
			preparedStatement.setString(3, entity.getSummary());
			preparedStatement.setInt(4, entity.getMaxCap());
			preparedStatement.setInt(5, entity.getCurrentParticipants());
			preparedStatement.setTimestamp(6, entity.getStartTime());
			preparedStatement.setTimestamp(7, entity.getEndTime());
			preparedStatement.setString(8, entity.getImage());
			preparedStatement.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			con.rollback();
			throw new RuntimeException("データベースエラー", e);
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
	}

	public void update(Event entity) throws SQLException {
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE event SET event_title = ?, summary = ?, max_cap = ?, current_participants = ?, start_time = ?, end_time = ?, image = ? WHERE id = ?";

		try {
			con.setAutoCommit(false); // トランザクションの開始

			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, entity.getEventTitle());
			preparedStatement.setString(2, entity.getSummary());
			preparedStatement.setInt(3, entity.getMaxCap());
			preparedStatement.setInt(4, entity.getCurrentParticipants());
			preparedStatement.setTimestamp(5, entity.getStartTime());
			preparedStatement.setTimestamp(6, entity.getEndTime());
			preparedStatement.setString(7, entity.getImage());
			preparedStatement.setInt(8, entity.getId());

			preparedStatement.executeUpdate();

			con.commit(); // トランザクションのコミット
		} catch (SQLException e) {
			con.rollback(); // トランザクションのロールバック（エラー発生時の処理）
			throw e;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
	}

	public void deleteById(Integer id) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			String sql = "DELETE FROM event WHERE id = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
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

}
