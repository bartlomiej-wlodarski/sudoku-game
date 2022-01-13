package com.mycompany.sudokuproject1;

import java.io.Serializable;


/**
 * Summary of a class in JavaDoc.
 *
 * @author bawlo
 */
public class SudokuBox extends SudokuElement implements Observer, Serializable, Cloneable {
    
    public Object cloneBox() throws CloneNotSupportedException {
        return this.clone();
    }
    
    @Override
    public void update() {
        this.verify();
    }
    
    public String boxToString() {
        return this.toString();
    }
    
    public int boxHashCode() {
        return this.hashCode();
    }
    
    public boolean boxEquals(Object obj) {
        return this.equals(obj);
    }
}
