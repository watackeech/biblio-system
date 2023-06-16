package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAO{

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
}
