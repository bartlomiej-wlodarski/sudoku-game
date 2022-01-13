package com.mycompany.sudokuproject1;

import java.io.Serializable;


/**
 * Summary of a class in JavaDoc.
 *
 * @author bawlo
 *
 */
public class SudokuColumn extends SudokuElement implements Observer, Serializable, Cloneable {
    
    public Object cloneColumn() throws CloneNotSupportedException {
        return this.clone();
    }
    
    @Override
    public void update() {
        this.verify();
    }
    
    public String columnToString() {
        return this.toString();
    }
    
    public int columnHashCode() {
        return this.hashCode();
    }
    
    public boolean columnEquals(Object obj) {
        return this.equals(obj);
    }
}
