package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {

	private Connection con;

	public BookDAO(Connection con) {
		this.con = con;
	}

	public void lendByBarcodeId(String barcodeId) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			String updateBooksQuery = "UPDATE books SET status = 'borrowed' WHERE barcode_id = ?";
			preparedStatement = con.prepareStatement(updateBooksQuery);
			preparedStatement.setString(1, barcodeId);
			preparedStatement.executeUpdate();

			String updateBookMasterQuery = "UPDATE book_master SET current_stock = current_stock - 1 WHERE id = (SELECT master_id FROM books WHERE barcode_id = ?)";
			preparedStatement = con.prepareStatement(updateBookMasterQuery);
			preparedStatement.setString(1, barcodeId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("データベースエラー", e);
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
	}

	public void returnByBarcodeId(String barcodeId) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			String updateBooksQuery = "UPDATE books SET status = 'in_stock' WHERE barcode_id = ?";
			preparedStatement = con.prepareStatement(updateBooksQuery);
			preparedStatement.setString(1, barcodeId);
			preparedStatement.executeUpdate();

			String updateBookMasterQuery = "UPDATE book_master SET current_stock = current_stock + 1 WHERE id = (SELECT master_id FROM books WHERE barcode_id = ?)";
			preparedStatement = con.prepareStatement(updateBookMasterQuery);
			preparedStatement.setString(1, barcodeId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("データベースエラー", e);
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
	}

	public Boolean checkBorrowedByBarcodeId(String barcodeId) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Boolean judge = null;

		try {
			String selectBooksQuery = "SELECT status FROM books WHERE barcode_id = ?";
			preparedStatement = con.prepareStatement(selectBooksQuery);
			preparedStatement.setString(1, barcodeId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String status = resultSet.getString("status");
				if (status.equals("borrowed")) {
					judge = true;

				} else {
					judge = false;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("データベースエラー", e);
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
		return judge;
	}

	public Boolean checkStockByBarcodeId(String barcodeId) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Boolean judge = null;

		try {
			String checkStockQuery = "SELECT current_stock FROM book_master WHERE id = (SELECT master_id FROM books WHERE barcode_id = ?)";
	        preparedStatement = con.prepareStatement(checkStockQuery);
	        preparedStatement.setString(1, barcodeId);
	        resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	            int currentStock = resultSet.getInt("current_stock");
	            if (currentStock > 0) {
	            	judge = true;
	            }
	            } else {
	                judge = false;
	            }
		} catch (SQLException e) {
			throw new RuntimeException("データベースエラー", e);
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
		return judge;
	}

}
