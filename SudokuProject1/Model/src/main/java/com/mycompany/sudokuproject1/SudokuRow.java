package com.mycompany.sudokuproject1;

import java.io.Serializable;

/**
 * Summary of a class in JavaDoc.
 *
 * @author bawlo
 */
public class SudokuRow extends SudokuElement implements Observer, Serializable, Cloneable {

    public Object cloneRow() throws CloneNotSupportedException {
        return this.clone();
    }

    @Override
    public void update() {
        this.verify();
    }

    public String rowToString() {
        return this.toString();
    }

    public int rowHashCode() {
        return this.hashCode();
    }

    public boolean rowEquals(Object obj) {
        return this.equals(obj);
    }
}
