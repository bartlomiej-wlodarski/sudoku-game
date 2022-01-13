/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

import com.mycompany.sudokuproject1.SudokuBoard;
import com.mycompany.sudokuproject1.SudokuPuzzleGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bawlo
 */
public class SudokuPuzzleGeneratorTest {
    
    private final SudokuPuzzleGenerator generator;
    
    public SudokuPuzzleGeneratorTest() {
        generator = new SudokuPuzzleGenerator();
    }
    
    @Test
    public void generateEasyTest() {
        SudokuBoard board = generator.generate(SudokuPuzzleGenerator.Level.EASY);
        int zeros = 0;
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (board.get(x, y) == 0) zeros++;
            }
        }
        if (zeros > 30) fail();
    }
    
    @Test
    public void generateMediumTest() {
        SudokuBoard board = generator.generate(SudokuPuzzleGenerator.Level.MEDIUM);
        int zeros = 0;
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (board.get(x, y) == 0) zeros++;
            }
        }
        if (zeros > 45) fail();
    }
    
    @Test
    public void generateHardTest() {
        SudokuBoard board = generator.generate(SudokuPuzzleGenerator.Level.HARD);
        int zeros = 0;
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (board.get(x, y) == 0) zeros++;
            }
        }
        if (zeros > 60) fail();
    }
    
    @Test
    public void generateEmptyTest() {
        SudokuBoard board = generator.returnEmpty();
        int zeros = 0;
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (board.get(x, y) == 0) zeros++;
            }
        }
        if (zeros != 81) fail();
    }
    
    @Test
    public void generateInvalid() {
        //SudokuBoard board = generator.generate();
        // Some kind of fake Level enum is needed
    }
}
