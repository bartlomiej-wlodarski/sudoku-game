package testpackage;

import com.mycompany.sudokuproject1.BacktrackingSudokuSolver;
import com.mycompany.sudokuproject1.SudokuBoard;
import com.mycompany.sudokuproject1.SudokuSolver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import daopackage.Dao;
import daopackage.SudokuBoardDaoFactory;
import daopackage.FileSudokuBoardDao;
import java.io.IOException;


/**
 *
 * @author bawlo
 */
public class DaoTest {
    
    private SudokuBoard sudoku;
   
    @BeforeEach
    public void beforeEach() {
        sudoku = prepareBoard();
    }

    private SudokuBoard prepareBoard() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(solver);
        return board;
    }
    public DaoTest() {
    }
    
    @Test
    public void WriteAndReadString() {
    String text = "test text";
        try (FileSudokuBoardDao<String> dao = new FileSudokuBoardDao("file.txt")) {
            dao.write(text);
        } catch (Exception ex) {
            fail("write error");
        }
        try (FileSudokuBoardDao<String> dao = new FileSudokuBoardDao("file.txt")) {
            String str = dao.read();
            assertEquals(str, text);
        } catch (Exception ex) {
            fail("read error");
        }
    }
    
    @Test
    public void WriteAndReadSudokuBoard() {
        int[][] values = {
            {8, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 6, 0, 0, 0, 0, 0},
            {0, 7, 0, 0, 9, 0, 2, 0, 0},
            {0, 5, 0, 0, 0, 7, 0, 0, 0},
            {0, 0, 0, 0, 4, 5, 7, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 3, 0},
            {0, 0, 1, 0, 0, 0, 0, 6, 8},
            {0, 0, 8, 5, 0, 0, 0, 1, 0},
            {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                sudoku.set(x, y, values[x][y]);
            }
        }
        try (FileSudokuBoardDao<SudokuBoard> dao = new FileSudokuBoardDao("file.txt")) {
            dao.write(sudoku);
        } catch (Exception ex) {
            fail("write error");
        }
        try (FileSudokuBoardDao<SudokuBoard> dao = new FileSudokuBoardDao("file.txt")) {
            assertEquals(sudoku.get(0, 0), dao.read().get(0, 0));
        } catch (Exception ex) {
            fail("read error");
        }
    }
    
    @Test
    public void TestFactory() throws Exception {
        String text = "testing factory";
        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
        try (Dao dao = factory.getFileDao("file.txt")) {
            dao.write(text);
        } catch (Exception ex) {
            fail("write error");
        }
        try (Dao dao = factory.getFileDao("file.txt")) {
            String test;
            test = (String) dao.read();
            assertEquals(test, text);
        } catch (Exception ex) {
            fail("read error");
        }
    }
}
