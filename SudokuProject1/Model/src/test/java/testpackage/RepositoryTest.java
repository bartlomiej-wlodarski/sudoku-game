/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

import com.mycompany.sudokuproject1.BacktrackingSudokuSolver;
import com.mycompany.sudokuproject1.Repository;
import com.mycompany.sudokuproject1.SudokuBoard;
import com.mycompany.sudokuproject1.SudokuSolver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Maciej
 */
public class RepositoryTest {
    
    
    public RepositoryTest() {
    }
    
    @Test
    public void CloneAndModifyExpectDeepCopy() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(solver);
        Repository repo = new Repository(sudoku);
        SudokuBoard clone1 = repo.createInstance();
        SudokuBoard clone2 = repo.createInstance();
        assertEquals(sudoku, clone1);
        sudoku.set(5, 3, 7);
        assertNotEquals(sudoku, clone1);
        assertNotEquals(sudoku, clone2);
        assertEquals(clone2, clone1);
        clone1.set(1, 1, 9);
        assertNotEquals(clone2, clone1);
    }
    
    @Test
    public void createDifferentInstanceTest() throws CloneNotSupportedException {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(solver);
        Repository repo = new Repository(sudoku);
        SudokuBoard EasyBoard = repo.createInstance();
        SudokuBoard HardBoard = repo.createInstance();
        assertNotSame(EasyBoard, HardBoard);
    }
    
}
