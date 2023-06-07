package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
// import java.util.Scanner;

import DTOs.BookMaster;

public class BookMasterDAO implements DAO<BookMaster> {

	@Override
	public void insert(BookMaster entity) throws SQLException {
		throw new UnsupportedOperationException("Unimplemented method 'insert'");
	}

	@Override
	public void update(BookMaster entity) throws SQLException {
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

	@Override
	public void delete(BookMaster bookCondition) throws SQLException {
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}

	@Override
	public List<BookMaster> getAll() throws SQLException {
		ConnectionManager connectionManager = new ConnectionManager();
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = null;
            try {
                String sql = "SELECT * FROM book_master ORDER BY id";
                // SQLの作成(準備)
                preparedStatement = connection.prepareStatement(sql);
                // preparedStatement.setInt(1, masterId);
                ResultSet resultSet = preparedStatement.executeQuery();
                List<BookMaster> result = new ArrayList<BookMaster>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    int currentStock = resultSet.getInt("current_stock");
                    int totalStock = resultSet.getInt("total_stock");
                    int publicationYear = resultSet.getInt("publication_year");
                    String category = resultSet.getString("category");
                    String description = resultSet.getString("description");
                    String image = resultSet.getString("image");

                    // Create a new BookMaster object using the retrieved data
                    BookMaster book = new BookMaster(id, title, author, currentStock, totalStock, publicationYear,
                            category, description, image);

                    // Add the BookMaster object to the result list
                    result.add(book);
                }

                for (int i = 0; i < result.size(); i++) {
                    BookMaster book = result.get(i);

                    // Access the properties of the BookMaster object
                    int id = book.getId();
                    String title = book.getTitle();
                    String author = book.getAuthor();
                    int currentStock = book.getCurrentStock();
                    int totalStock = book.getTotalStock();
                    int publicationYear = book.getPublicationYear();
                    String category = book.getCategory();
                    String description = book.getDescription();
                    String image = book.getImage();

                    // Process the retrieved data as needed
                    System.out.println("Book details at index " + i + ":");
                    System.out.println("ID: " + id);
                    System.out.println("Title: " + title);
                    System.out.println("Author: " + author);
                    System.out.println("Current Stock: " + currentStock);
                    System.out.println("Total Stock: " + totalStock);
                    System.out.println("Publication Year: " + publicationYear);
                    System.out.println("Category: " + category);
                    System.out.println("Description: " + description);
                    System.out.println("image: " + image);
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

	@Override
	public List<BookMaster> select(BookMaster searchCondition) throws SQLException {
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			Connection connection = connectionManager.getConnection();
			PreparedStatement preparedStatement = null;
			try {
				String sql = "SELECT * FROM book_master WHERE 1 = 1"; // StringJoinerクラスを使ってみる
				if (searchCondition.getId() != null) {
					sql += " AND id = " + searchCondition.getId();
				}
				if (searchCondition.getTitle() != null) {
					sql += " AND title = '" + searchCondition.getTitle() + "'";
				}
				if (searchCondition.getAuthor() != null) {
					sql += " AND author = '" + searchCondition.getAuthor() + "'";
				}
				if (searchCondition.getCurrentStock() != null) {
					sql += " AND current_stock = " + searchCondition.getCurrentStock();
				}
				if (searchCondition.getTotalStock() != null) {
					sql += " AND total_stock = " + searchCondition.getTotalStock();
				}
				if (searchCondition.getPublicationYear() != null) {
					sql += " AND publication_year = " + searchCondition.getPublicationYear();
				}
				if (searchCondition.getDescription() != null) {
					sql += " AND description = '" + searchCondition.getDescription() + "'";
				}
				if (searchCondition.getCategory() != null) {
					sql += " AND category = '" + searchCondition.getCategory() + "'";
				}
				if (searchCondition.getImage() != null) {
					sql += " AND image = '" + searchCondition.getImage() + "'";
				}

				sql += " ORDER BY id";
				System.out.println(sql);

				// SQLの作成(準備)
				preparedStatement = connection.prepareStatement(sql);
				// preparedStatement.setInt(1, masterId);
				ResultSet resultSet = preparedStatement.executeQuery();
				List<BookMaster> result = new ArrayList<BookMaster>();
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String title = resultSet.getString("title");
					String author = resultSet.getString("author");
					int currentStock = resultSet.getInt("current_stock");
					int totalStock = resultSet.getInt("total_stock");
					int publicationYear = resultSet.getInt("publication_year");
					String category = resultSet.getString("category");
					String description = resultSet.getString("description");
					String image = resultSet.getString("image");

					// Create a new BookMaster object using the retrieved data
					BookMaster book = new BookMaster(id, title, author, currentStock, totalStock,
							publicationYear, category, description, image);

					// Add the BookMaster object to the result list
					result.add(book);
				}

				for (int i = 0; i < result.size(); i++) {
					BookMaster book = result.get(i);
					// Access the properties of the BookMaster object
					int id = book.getId();
					String title = book.getTitle();
					String author = book.getAuthor();
					int currentStock = book.getCurrentStock();
					int totalStock = book.getTotalStock();
					int publicationYear = book.getPublicationYear();
					String category = book.getCategory();
					String description = book.getDescription();
					String image = book.getImage();

					// Process the retrieved data as needed
					System.out.println("Book details at index " + i + ":");
					System.out.println("ID: " + id);
					System.out.println("Title: " + title);
					System.out.println("Author: " + author);
					System.out.println("Current Stock: " + currentStock);
					System.out.println("Total Stock: " + totalStock);
					System.out.println("Publication Year: " + publicationYear);
					System.out.println("Category: " + category);
					System.out.println("Description: " + description);
					System.out.println("image: " + image);
					System.out.println("------------------------");
				}
			} catch (SQLException e) {
				throw new RuntimeException("BookMasterテーブルからの情報取得に失敗しました。", e);
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
			try {
				connectionManager.closeConnection();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		}
		throw new UnsupportedOperationException("Unimplemented method 'getAll'");
	}
}
