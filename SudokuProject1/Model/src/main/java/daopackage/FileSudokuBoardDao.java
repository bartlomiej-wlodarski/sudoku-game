package daopackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Summary of a class in JavaDoc.
 *
 * @author Maciej
 * @param <T> type of object
 */
public class FileSudokuBoardDao<T> implements Dao<T>, AutoCloseable {

    private final String filename;
    private ObjectOutputStream writer;
    private ObjectInputStream reader;

    public FileSudokuBoardDao(String filename) {
        this.filename = filename;
    }

    @Override
    public void write(T obj) throws DaoException {
        try {
            writer = new ObjectOutputStream(new FileOutputStream(filename));
            writer.writeObject(obj);
        } catch (IOException ex) {
            throw new DaoException(DaoException.NULL_NAME);
            //Logger.getLogger(FileSudokuBoardDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void close() throws DaoException {
        try {
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                reader.close();
            }
        } catch (IOException ex) {
            throw new DaoException(DaoException.NULL_NAME);
        }
    }

    @Override
    public T read() throws DaoException {
        try {
            reader = new ObjectInputStream(new FileInputStream(filename));
            T obj = (T) reader.readObject();
            return obj;
        } catch (IOException | ClassNotFoundException ex) {
            throw new DaoException(DaoException.NULL_NAME);
        }
    }
}
