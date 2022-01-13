package com.mycompany.sudokuproject1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Summary of a class in JavaDoc.
 *
 * @author Maciej
 */
public abstract class SudokuElement implements Serializable, Cloneable {

    private List<SudokuField> fieldValue;

    public SudokuElement() {
        fieldValue = Arrays.asList(new SudokuField[9]);
    }

    public void set(SudokuField value, int pos) {
        fieldValue.set(pos, value);
    }

    public boolean verify() {
        int[] values;
        values = new int[10];
        for (int i = 0; i < 9; i++) {
            int current = fieldValue.get(i).getFieldValue();
            if (current > 0 && current < 10) {
                values[current]++;
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (values[i] != 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(fieldValue.get(0).getFieldValue())
                .append(fieldValue.get(1).getFieldValue())
                .append(fieldValue.get(2).getFieldValue())
                .append(fieldValue.get(3).getFieldValue())
                .append(fieldValue.get(4).getFieldValue())
                .append(fieldValue.get(5).getFieldValue())
                .append(fieldValue.get(6).getFieldValue())
                .append(fieldValue.get(7).getFieldValue())
                .append(fieldValue.get(8).getFieldValue())
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
    public Object clone() throws CloneNotSupportedException {
        SudokuElement clone = (SudokuElement) super.clone();
        clone.fieldValue = new ArrayList<>(fieldValue);
        return clone;
    }
}
