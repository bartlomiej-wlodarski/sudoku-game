package daopackage;

/**
 * Summary of a class in JavaDoc.
 * 
 * @author Maciej
 * 
 * @param <T> type of object
 */
public interface Dao<T> extends AutoCloseable {
    public T read() throws DaoException;
    
    public void write(T obj) throws DaoException;
    
    @Override
    public void close() throws DaoException;
}
