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

	private Connection con;

	public BookMasterDAO(Connection con) {
		this.con = con;
	}

	@Override
	public void insert(BookMaster entity) throws SQLException {
		PreparedStatement preparedStatement = null;

	    try {
	    	con.setAutoCommit(false);
	        String sql = "INSERT INTO book_master (id, title, author, publication_year, description, image, current_stock, total_stock) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        preparedStatement = con.prepareStatement(sql);
	        preparedStatement.setString(1, entity.getId());
	        preparedStatement.setString(2, entity.getTitle());
	        preparedStatement.setString(3, entity.getAuthor());
	        preparedStatement.setInt(4, entity.getPublicationYear());
	        preparedStatement.setString(5, entity.getDescription());
	        preparedStatement.setString(6, entity.getImage());
	        preparedStatement.setInt(7, 1); // 新規追加された本は、stockが1つ
	        preparedStatement.setInt(8, 1);
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

	public void addAnotherBook(BookMaster entity) throws SQLException {
	    PreparedStatement preparedStatement = null;
	    String sql = "UPDATE book_master SET total_stock = total_stock + 1, current_stock = current_stock + 1 WHERE id = ?";

	    try {
	        System.out.println("try add another book");
	        con.setAutoCommit(false); // トランザクションの開始

	        preparedStatement = con.prepareStatement(sql);
	        preparedStatement.setString(1, entity.getId());
	        preparedStatement.executeUpdate();

	        con.commit(); // トランザクションのコミット
	        System.out.println("added another book!");
	    } catch (SQLException e) {
	        con.rollback(); // トランザクションのロールバック（エラー発生時の処理）
	        throw e;
	    } finally {
	        if (preparedStatement != null) {
	            preparedStatement.close();
	        }
//	        con.setAutoCommit(true); // トランザクションモードをデフォルトに戻す
	    }
	}

	@Override
	public void update(BookMaster entity) throws SQLException {
		PreparedStatement preparedStatement = null;
	    String sql = "UPDATE book_master SET title = ?, author = ?, publication_year = ?, description = ?, image = ?, total_stock = ?, current_stock = ? WHERE id = ?";

	    try {
	        System.out.println("try update");
	        con.setAutoCommit(false); // トランザクションの開始

	        preparedStatement = con.prepareStatement(sql);
	        preparedStatement.setString(1, entity.getTitle());
	        preparedStatement.setString(2, entity.getAuthor());
	        preparedStatement.setInt(3, entity.getPublicationYear());
	        preparedStatement.setString(4, entity.getDescription());
	        preparedStatement.setString(5, entity.getImage());
	        preparedStatement.setInt(6, entity.getTotalStock()); // 新規追加された本は、stockが1つ
	        preparedStatement.setInt(7, entity.getCurrentStock());
	        preparedStatement.setString(8, entity.getId());

	        preparedStatement.executeUpdate();

	        con.commit(); // トランザクションのコミット
	        System.out.println("added another book!");
	    } catch (SQLException e) {
	        con.rollback(); // トランザクションのロールバック（エラー発生時の処理）
	        throw e;
	    } finally {
	        if (preparedStatement != null) {
	            preparedStatement.close();
	        }
//	        con.setAutoCommit(true); // トランザクションモードをデフォルトに戻す
	    }
	}

	@Override
	public void deleteById(Integer i) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			BookMaster bookMaster = null; //合致するものがなかった場合、nullを返したい
			String sql = "DELETE FROM book_master WHERE id= '" + i + "'";
			preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

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
	public void deleteByISBN(String id) throws SQLException {
	    PreparedStatement preparedStatement = null;
	    try {
	        BookMaster bookMaster = null; //合致するものがなかった場合、nullを返したい
	        String sql = "DELETE FROM book_master WHERE id= ?";
	        preparedStatement = con.prepareStatement(sql);
	        preparedStatement.setString(1, id);
	        int rowsDeleted = preparedStatement.executeUpdate();
	        System.out.println("削除された行数: " + rowsDeleted);

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

	/**
	 * @param ISBN
	 * @return
	 * @throws SQLException
	 */
	public BookMaster selectByISBN(String ISBN) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			BookMaster bookMaster = null; //合致するものがなかった場合、nullを返したい
			String sql = "SELECT * FROM book_master WHERE id= '" + ISBN + "'";
			preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				bookMaster = new BookMaster(); //一行取得できた場合のみnullでなくなる
				String id =  resultSet.getString("id");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				Integer publicationYear = Integer.parseInt(resultSet.getString("publication_year"));
				String description = resultSet.getString("description");
				String image = resultSet.getString("image");
				Integer currentStock = Integer.parseInt(resultSet.getString("current_stock"));
				Integer totalStock = Integer.parseInt(resultSet.getString("total_stock"));
				bookMaster.setId(id);
				bookMaster.setTitle(title);
				bookMaster.setAuthor(author);
				bookMaster.setPublicationYear(publicationYear);
				bookMaster.setDescription(description);
				bookMaster.setImage(image);
				bookMaster.setCurrentStock(currentStock);
				bookMaster.setTotalStock(totalStock);
			};

			return bookMaster;

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
	public List<BookMaster> getAll() throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			String sql = "SELECT * FROM book_master ORDER BY id";
			// SQLの作成(準備)
			preparedStatement = con.prepareStatement(sql);
			// preparedStatement.setInt(1, masterId);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<BookMaster> result = new ArrayList<BookMaster>();
			while (resultSet.next()) {
				String id = resultSet.getString("id");
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
				String id = book.getId();
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
	}



	@Override
	public List<BookMaster> select(BookMaster searchCondition) throws SQLException {
//		ConnectionManager connectionManager = new ConnectionManager();
//		try {
//			Connection connection = connectionManager.getConnection();
			PreparedStatement preparedStatement = null;
			try {
				String sql = "SELECT * FROM book_master WHERE 1 = 1";
				// StringJoinerクラスを使ってみる
				//if (whereConditionList.size() > 0) {
				//	  query += " WHERE " + String.join(" AND ", whereConditionList);
				//}



				if (searchCondition.getId() != null) {
					sql += " AND id LIKE " + searchCondition.getId();
				}
				if (searchCondition.getTitle() != null) {
					sql += " AND title LIKE '%" + searchCondition.getTitle() + "%'";
				}
				if (searchCondition.getAuthor() != null) {
					sql += " AND author LIKE '%" + searchCondition.getAuthor() + "%'";
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
				System.out.println("SQL文は" + sql);

				// SQLの作成(準備)
				preparedStatement = con.prepareStatement(sql);
				// preparedStatement.setInt(1, masterId);
				ResultSet resultSet = preparedStatement.executeQuery();
				List<BookMaster> result = new ArrayList<BookMaster>();
				while (resultSet.next()) {
					String id = resultSet.getString("id");
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

//				for (int i = 0; i < result.size(); i++) {
//					BookMaster book = result.get(i);
//					// Access the properties of the BookMaster object
//					String id = book.getId();
//					String title = book.getTitle();
//					String author = book.getAuthor();
//					int currentStock = book.getCurrentStock();
//					int totalStock = book.getTotalStock();
//					int publicationYear = book.getPublicationYear();
//					String category = book.getCategory();
//					String description = book.getDescription();
//					String image = book.getImage();
//
//					// Process the retrieved data as needed
//					System.out.println("Book details at index " + i + ":");
//					System.out.println("ID: " + id);
//					System.out.println("Title: " + title);
//					System.out.println("Author: " + author);
//					System.out.println("Current Stock: " + currentStock);
//					System.out.println("Total Stock: " + totalStock);
//					System.out.println("Publication Year: " + publicationYear);
//					System.out.println("Category: " + category);
//					System.out.println("Description: " + description);
//					System.out.println("image: " + image);
//					System.out.println("------------------------");
//				}

				return result;
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
//		} finally {
//			try {
//				connectionManager.closeConnection();
//			} catch (Exception e) {
//				throw new RuntimeException(e);
//			}
//
//		}

	}
}
