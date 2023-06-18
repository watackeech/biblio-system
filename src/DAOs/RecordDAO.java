package DAOs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DTOs.Record;

public class RecordDAO {
	private Connection con;

	public RecordDAO(Connection con) {
		this.con = con;
	}

	public void addRecord(Record record) throws SQLException {
		PreparedStatement preparedStatement = null;

	    try {
	    	con.setAutoCommit(false);
	        String sql = "INSERT INTO record (user_id, barcode_id, start_date) VALUES (?, ?, ?)";
	        preparedStatement = con.prepareStatement(sql);
	        preparedStatement.setInt(1, record.getUserId());
	        preparedStatement.setString(2, record.getBarcodeId());
	        preparedStatement.setDate(3, new Date(record.getStartDate().getTime())); //java.util.Dateをjava.sql.Dateに変換
//	        preparedStatement.setDate(4, new Date(record.getEndDate().getTime()));
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

	public void closeRecord(Record record) throws SQLException {
		PreparedStatement preparedStatement = null;

	    try {
	    	con.setAutoCommit(false);
	        String sql = "UPDATE record SET  end_date=? WHERE id = (SELECT id FROM record WHERE barcode_id = ? AND end_date IS NULL ORDER BY id DESC LIMIT 1)"; //idが最大のもの（最新のものだけ取得)
	        preparedStatement = con.prepareStatement(sql);
	        preparedStatement.setDate(1, new Date(record.getEndDate().getTime()));//java.util.Dateをjava.sql.Dateに変換
	        preparedStatement.setString(2, record.getBarcodeId());
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
}
