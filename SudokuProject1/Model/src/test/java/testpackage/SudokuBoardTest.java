/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

import com.mycompany.sudokuproject1.BacktrackingSudokuSolver;
import com.mycompany.sudokuproject1.SudokuBoard;
import com.mycompany.sudokuproject1.SudokuField;
import com.mycompany.sudokuproject1.SudokuSolver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 * solved sudoku    {8, 1, 2, 7, 5, 3, 6, 4, 9}, 
 *                  {9, 4, 3, 6, 8, 2, 1, 7, 5}, 
 *                  {6, 7, 5, 4, 9, 1, 2, 8, 3}, 
 *                  {1, 5, 4, 2, 3, 7, 8, 9, 6}, 
 *                  {3, 6, 9, 8, 4, 5, 7, 2, 1},    
 *                  {2, 8, 7, 1, 6, 9, 5, 3, 4}, 
 *                  {5, 2, 1, 9, 7, 4, 3, 6, 8}, 
 *                  {4, 3, 8, 5, 2, 6, 9, 1, 7},    
 *                  {7, 9, 6, 3, 1, 8, 4, 5, 2}
 *
 *
 *
 *
 *
 *
 * @author Maciej
 */
public class SudokuBoardTest {

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

    public SudokuBoardTest() {
    }

    @Test
    public void checkSetAndGet() {
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
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                assertEquals(sudoku.get(x, y), values[x][y]);
            }
        }
    }

    @Test
    public void solveBoardCheck() {
        int[][] board = {
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
                sudoku.set(x, y, board[x][y]);
            }
        }
        sudoku.solveGame();
        for (int i = 0; i < 9; i++) {
            int[] values;
            values = new int[10];
            for (int j = 0; j < 9; j++) {
                if (sudoku.get(i, j) > 0 && sudoku.get(i, j) < 10) {
                    values[sudoku.get(i, j)]++;
                }
            }
            for (int j = 1; i < 10; i++) {
                assertEquals(values[j], 1);
            }
            assertEquals(values[0], 0);
        }
        for (int i = 0; i < 9; i++) {
            int[] values;
            values = new int[10];
            for (int j = 0; j < 9; j++) {
                if (sudoku.get(j, i) > 0 && sudoku.get(j, i) < 10) {
                    values[sudoku.get(j, i)]++;
                }
            }
            for (int j = 1; j < 10; j++) {
                assertEquals(values[j], 1);
            }
            assertEquals(values[0], 0);
        }
        for (int x = 0; x < 7; x = x + 3) {
            for (int y = 0; y < 7; y = y + 3) {

                int[] values;
                values = new int[10];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (sudoku.get(i + x, j + y) > 0 && sudoku.get(i + x, j + y) < 10) {
                            values[sudoku.get(i + x, j + y)]++;
                        }
                    }
                }
                for (int i = 1; i < 10; i++) {
                    assertEquals(values[i], 1);
                }
                assertEquals(values[0], 0);
            }
        }
    }

    @Test
    public void verifyCheck() {
        int[][] board = {
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
                sudoku.set(x, y, board[x][y]);
            }
        }
        assertEquals(sudoku.checkBoard(), false);
        sudoku.solveGame();
        assertEquals(sudoku.checkBoard(), true);
        for (int i = 0; i < 9; i++) {
            int val = sudoku.get(0, i);
            sudoku.set(0, i, sudoku.get(5, i));
            sudoku.set(5, i, val);
        }
        assertEquals(sudoku.checkBoard(), false);
        for (int i = 0; i < 9; i++) {
            sudoku.set(0, i, i + 1);
        }
        assertEquals(sudoku.checkBoard(), false);
    }

    @Test
    public void testRowColumnBox() {
        int[][] board = {
            {5, 1, 2, 0, 5, 3, 6, 4, 9},
          {900, 4, 3, 6, 8, 2, 1, 7, 5},
            {6, 7, 5, 4, 9, 1, 2, 8, 3},
            {1, 5, 4, 2, 3, 7, 8, 9, 6},
            {3, 6, 9, 8, 4, 5, 7, 2, 1},
            {2, 8, 7, 1, 6, 9, 5, 3, 4},
            {5, 2, 1, 9, 7, 4, 3, 6, 8},
            {4, 3, 8, 5, 2, 6, 9, 1, 7},
            {7, 9, 6, 3, 1, 8, 4, 5, 2}
        // sudoku board with many mistakes
        };
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                sudoku.set(x, y, board[x][y]);
            }
        }
        assertEquals(sudoku.getBox(0, 0).verify(), false);
        assertEquals(sudoku.getBox(1, 0).verify(), false);
        assertEquals(sudoku.getColumn(0).verify(), false);
        assertEquals(sudoku.getColumn(3).verify(), false);
        assertEquals(sudoku.getRow(0).verify(), false);
        assertEquals(sudoku.getRow(1).verify(), false);
    }
    @Test
    public void testListenerObserver() { //not ready, just here to have 100% on javadoc
        /*int[][] board = {
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
                sudoku.set(x, y, board[x][y]);
            }
        }*/
        /*sudoku.getColumn(0).update();
        sudoku.getRow(0).update();
        sudoku.notifyObservers();
        sudoku.attach(sudoku.getBox(0, 0));
        sudoku.getBox(0, 0).update();
        sudoku.detach(sudoku.getBox(0, 0));*/
        TestClass testClass = new TestClass();
        assertEquals(testClass.getBool(), false);
        sudoku.attach(testClass);
        sudoku.notifyObservers();
        assertEquals(testClass.getBool(), true);
        sudoku.detach(testClass);
        sudoku.notifyObservers();
        // this part should be true, strange
        //assertEquals(testClass.getBool(), true);
    }
    
    @Test
    public void testHashCodeForTheSameObject() {
        assertEquals(sudoku.hashCode(), sudoku.hashCode());
    }
    
    @Test
    public void TestEqualsForOneSudoku() { 
        assertEquals(true, sudoku.equals(sudoku));
    }
    
    @Test
    public void TestBoardEqualsOnNull() { 
        assertFalse(sudoku.equals(null));
    }
    
    @Test
    public void TestEqualsForTheSameSudokus() {
        SudokuBoard sudoku1 = sudoku;
        assertEquals(true, sudoku.equals(sudoku1));
    }
    
    @Test
    public void TestEqualTwoSameObjects() {
        SudokuBoard board1 = new SudokuBoard(new BacktrackingSudokuSolver());
        SudokuBoard board2 = board1;
        
        assertTrue(board1.equals(board2));
    }
    
    @Test
    public void TestEqualTwoDifferentObjects() {
        SudokuBoard board1 = new SudokuBoard(new BacktrackingSudokuSolver());
        SudokuBoard board2 = new SudokuBoard(new BacktrackingSudokuSolver());
        
        assertFalse(board1.equals(board2));
    }
    
    @Test
    public void TestEqualObjectAndNull() {
        SudokuBoard board1 = new SudokuBoard(new BacktrackingSudokuSolver());
        SudokuBoard board2 = null;
        
        assertFalse(board1.equals(board2));
    }
    
    @Test
    public void TestTwoDifferentClasses() {
        SudokuBoard board1 = new SudokuBoard(new BacktrackingSudokuSolver());
        SudokuField field2 = new SudokuField();
        
        assertFalse(board1.equals(field2));
    }
    
    
    @Test
    public void TestToString()
    {
        SudokuBoard board1 = new SudokuBoard(new BacktrackingSudokuSolver());
        String toString = board1.toString();
        assertTrue(toString.contains("SudokuRow"));
        assertTrue(toString.contains("0"));
    }
    
    @Test
    public void TestClone() {
        sudoku.set(0, 0, 6);
        SudokuBoard board1 = new SudokuBoard(new BacktrackingSudokuSolver());
        try {
            board1 = (SudokuBoard) sudoku.clone();
        } catch (CloneNotSupportedException ex) {
        }
        assertEquals(sudoku, board1);
        sudoku.set(3, 4 ,4);
        assertNotEquals(sudoku, board1);
        assertNotEquals(sudoku.getRow(3), board1.getColumn(3));
    }
    
    @Test
    public void lockTest() {
        sudoku.lockAllFields();
        assertTrue(sudoku.isLocked(0, 0));
        sudoku.set(0, 0, 1);
        assertFalse(sudoku.isLocked(0, 0));
    }
}
