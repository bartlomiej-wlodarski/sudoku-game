package com.mycompany.sudokuproject1;

import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Summary of a class in JavaDoc.
 *
 * @author Maciej
 */
public class SudokuField implements Serializable, Cloneable, Comparable<SudokuField> {

    private int value;
    private boolean locked;

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    
    public int getFieldValue() {
        return value;
    }

    public void setFieldValue(int value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("SudokuField", value)
                .toString();
    }
    
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
         }
         return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int compareTo(SudokuField o) {
        return Integer.compare(this.value, o.value);
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
