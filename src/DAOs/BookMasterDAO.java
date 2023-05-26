package DAOs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BookMasterDAO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("書籍のマスターIDを入力してください");
        int masterId = scanner.nextInt();
        System.out.println("やりたい操作を教えてください");
        System.out.println("INSERT:1 UPDATE:2 DELETE:3");
        int mode = scanner.nextInt();
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("ドライバーのロードに成功しました");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("ドライバーのロードに失敗しました", e);
        }
        Connection connection = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/library";
            String user = "postgres";
            String password = "41572020";

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("データベースの接続に成功しました");

            // ステートメントの定義
            PreparedStatement preparedStatement = null;
            try {
                String sql;
                if (mode == 3) {
                    sql = "DELETE FROM book_master WHERE id = ?";
                    // SQLの作成(準備)
                    preparedStatement = connection.prepareStatement(sql);
                    // SQLバインド変数への値設定
                    preparedStatement.setInt(1, masterId);
                } else {
                    System.out.println("タイトルを入力してください");
                    String title = scanner.next();
                    System.out.println("著者を入力してください");
                    String author = scanner.next();
                    System.out.println("出版年を入力してください");
                    int publication_year = scanner.nextInt();
                    switch (mode) {
                        case 1:
                            sql = "INSERT INTO book_master ( id, title, author, publication_year ) VALUES (?,?,?,?)";
                            // SQLの作成(準備)
                            preparedStatement = connection.prepareStatement(sql);
                            // SQLバインド変数への値設定
                            preparedStatement.setInt(1, masterId);
                            preparedStatement.setString(2, title);
                            preparedStatement.setString(3, author);
                            preparedStatement.setInt(4, publication_year);
                            break;
                        case 2:
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
                }
                int result = preparedStatement.executeUpdate();
                System.out.println("登録結果:" + result);
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
        } catch (SQLException e) {
            throw new RuntimeException("データベースの接続に失敗しました", e);
        } finally {

            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("データベースの切断に成功しました");
                }
            } catch (SQLException e) {
                throw new RuntimeException("データベースの切断に失敗しました", e);
            }
        }
    }

}
