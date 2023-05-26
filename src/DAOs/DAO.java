import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    List<T> getAll() throws SQLException;

    List<T> select(T entity) throws SQLException;

    void insert(T entity) throws SQLException;

    void update(T entity) throws SQLException;

    void delete(T entity) throws SQLException;
}