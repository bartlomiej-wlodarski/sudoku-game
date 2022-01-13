package daopackage;

/**
 * Summary of a class in JavaDoc.
 * 
 * @author Maciej
 */
public class SudokuBoardDaoFactory {
    
    public Dao getFileDao(String filename) {
        FileSudokuBoardDao dao = new FileSudokuBoardDao(filename);
        return dao;
    }
}
