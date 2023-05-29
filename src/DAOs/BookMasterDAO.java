// package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookMasterDAO implements DAO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "SHIFT-JIS");
        System.out.println("書籍のマスターIDを入力してください");
        int masterId = scanner.nextInt();
        System.out.println("やりたい操作を教えてください");
        System.out.println("SHOW:1 INSERT:2 UPDATE:3 DELETE:4");
        int mode = scanner.nextInt();

        // try {
        // Class.forName("org.postgresql.Driver");
        // System.out.println("ドライバーのロードに成功しました");
        // } catch (ClassNotFoundException e) {
        // throw new RuntimeException("ドライバーのロードに失敗しました", e);
        // }

        ConnectionManager connectionManager = new ConnectionManager();

        try {
            Connection connection = connectionManager.getConnection();
            // ステートメントの定義
            PreparedStatement preparedStatement = null;
            try {
                String sql;
                if (mode == 1) { // TODO SELECT用の分岐
                    sql = "SELECT id, title, author, publication_year FROM book_master WHERE id = ?";
                    // SQLの作成(準備)
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setInt(1, masterId);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    System.out.println(resultSet);
                    while (resultSet.next()) {
                        System.out.println("id:" + resultSet.getInt("id"));
                        System.out.println("title:" + resultSet.getString("title"));
                        System.out.println("author:" + resultSet.getString("author"));
                        System.out.println("publication_year:" + resultSet.getInt("publication_year"));
                    }
                } else { // TODO INSERT UPDATE DELETE用の分岐
                    if (mode == 4) {
                        sql = "DELETE FROM book_master WHERE id = ?";
                        // SQLの作成(準備)
                        preparedStatement = connection.prepareStatement(sql);
                        // SQLバインド変数への値設定
                        preparedStatement.setInt(1, masterId);
                    }
                    System.out.println("タイトルを入力してください");
                    String title = scanner.next();
                    System.out.println("著者を入力してください");
                    String author = scanner.next();
                    System.out.println("出版年を入力してください");
                    int publication_year = scanner.nextInt();
                    switch (mode) {
                        case 2:
                            sql = "INSERT INTO book_master ( id, title, author, publication_year ) VALUES (?,?,?,?)";
                            // SQLの作成(準備)
                            preparedStatement = connection.prepareStatement(sql);
                            // SQLバインド変数への値設定
                            preparedStatement.setInt(1, masterId);
                            preparedStatement.setString(2, title);
                            preparedStatement.setString(3, author);
                            preparedStatement.setInt(4, publication_year);
                            break;
                        case 3:
                            sql = "UPDATE book_master SET title = ?, author = ?, publication_year =? WHERE id = ?";
                            // SQLの作成(準備)
                            preparedStatement = connection.prepareStatement(sql);
                            // SQLバインド変数への値設定
                            preparedStatement.setString(1, title);
                            preparedStatement.setString(2, author);
                            preparedStatement.setInt(3, publication_year);
                            preparedStatement.setInt(4, masterId);
                            break;
                        default:
                            System.out.println("モード選択ができていませんでした");
                    }
                    int result = preparedStatement.executeUpdate();
                    System.out.println("登録結果:" + result);
                }
            } catch (SQLException e) {
                throw new RuntimeException("EMPLOYEEテーブルのINSERTに失敗しました", e);
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

    // @Override
    // public List<BookMaster> select(BookMaster bookMaster) {
    // List<BookMaster> result;
    // return result;
    // throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    // }

    @Override
    public void insert(Object entity) throws SQLException {
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Object entity) throws SQLException {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Object entity) throws SQLException {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List select(Object entity) throws SQLException {

        List<BookMaster> result = null;
        return result;
        // throw new UnsupportedOperationException("Unimplemented method 'select'");
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
                // System.out.println(resultSet);
                // while (resultSet.next()) {
                // System.out.println("id:" + resultSet.getInt("id"));
                // System.out.println("title:" + resultSet.getString("title"));
                // System.out.println("author:" + resultSet.getString("author"));
                // System.out.println("publication_year:" +
                // resultSet.getInt("publication_year"));
                // }

            } catch (SQLException e) {
                throw new RuntimeException("EMPLOYEEテーブルのINSERTに失敗しました", e);
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
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
}
