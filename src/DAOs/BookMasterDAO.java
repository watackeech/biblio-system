// package DAOs;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookMasterDAO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "SHIFT-JIS");
        System.out.println("書籍のマスターIDを入力してください");
        int masterId = scanner.nextInt();
        System.out.println("やりたい操作を教えてください");
        System.out.println("SHOW:1 INSERT:2 UPDATE:3 DELETE:4");
        int mode = scanner.nextInt();

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("ドライバーのロードに成功しました");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("ドライバーのロードに失敗しました", e);
        }

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
}
