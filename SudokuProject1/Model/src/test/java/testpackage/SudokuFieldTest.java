/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

import com.mycompany.sudokuproject1.BacktrackingSudokuSolver;
import com.mycompany.sudokuproject1.SudokuBoard;
import com.mycompany.sudokuproject1.SudokuField;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bawlo
 */
public class SudokuFieldTest {

    public SudokuFieldTest() {
    }
    
    @Test
    public void TestHashCodeTwoObjectsTwoDifferentHashcodes() {
        SudokuField field1 = new SudokuField();
        SudokuField field2 = new SudokuField();
        
        field1.setFieldValue(20);
        field2.setFieldValue(30);
        
        assertNotEquals(field1.hashCode(), field2.hashCode());
    }
    @Test
    public void TestToString()
    {
        SudokuField field = new SudokuField();
        field.setFieldValue(20);
        
        String temp = field.toString();
        
        assertTrue(temp.contains("SudokuField"));
        assertTrue(temp.contains("20"));
    }
    
   
    @Test
    public void TestEqualTwoSameObjects() {
        SudokuField field1 = new SudokuField();
        SudokuField field2 = field1;
        
        assertTrue(field1.equals(field2));
    }
    
    @Test
    public void TestFieldObjectEqualsOnNull() {
        SudokuField field1 = new SudokuField();
        SudokuField field2 = null;
        
        assertFalse(field1.equals(field2));
    }
    
    @Test
    public void TestEqualTwoDifferentObjects() {
        SudokuField field1 = new SudokuField();
        SudokuField field2 = new SudokuField();
        
        field1.setFieldValue(20);
        field2.setFieldValue(30);
        
        assertFalse(field1.equals(field2));
    }
    
    @Test
    public void TestTwoDifferentClasses() {
        
        SudokuField field1 = new SudokuField();
        SudokuBoard board2 = new SudokuBoard(new BacktrackingSudokuSolver());
        
        assertFalse(field1.equals(board2));
    }
    
    @Test
    public void TestComprator() {
        SudokuField field1 = new SudokuField();
        SudokuField field2 = new SudokuField();
        
        assertEquals(field1.compareTo(field2), 0);
        
        field1.setFieldValue(1);
        field2.setFieldValue(2);
        
        assertTrue(field1.compareTo(field2) < 0);
        assertTrue(field2.compareTo(field1) > 0);
    }
    
    @Test
    public void TestNullComparator() {
        boolean thrown = false;
        SudokuField field = new SudokuField();
        try {
            field.compareTo(null);
        } catch(NullPointerException ex) {
            thrown = true;
        }
        assertTrue(thrown);
    }
    
    @Test
    public void TestClone() {
        SudokuField field1 = new SudokuField();
        SudokuField field2 = new SudokuField();
        field1.setFieldValue(4);
        try {
            field2 = (SudokuField) field1.clone();
        } catch (CloneNotSupportedException ex) {
        }
        assertEquals(field1, field2);
        field1.setFieldValue(2);
        assertNotEquals(field1, field2);
    }
    
}
