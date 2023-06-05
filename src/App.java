import DAOs.BookMasterDAO;
import DTOs.BookMaster;

public class App {
    public static void main(String[] args) throws Exception {
        // Scanner scanner = new Scanner(System.in, "SHIFT-JIS");
        // System.out.println("書籍のマスターIDを入力してください");
        // int masterId = scanner.nextInt();
        // System.out.println("やりたい操作を教えてください");
        // System.out.println("SHOW:1 INSERT:2 UPDATE:3 DELETE:4");
        // int mode = scanner.nextInt();
        BookMasterDAO bookMasterDAO = new BookMasterDAO();
        // bookMasterDAO.getAll();
        BookMaster bookCondition = new BookMaster();
        bookCondition.setId(3);
        bookCondition.setAuthor("夏目漱石");
        // bookCondition.setPublicationYear(1999);
        bookMasterDAO.select(bookCondition);
    }
}