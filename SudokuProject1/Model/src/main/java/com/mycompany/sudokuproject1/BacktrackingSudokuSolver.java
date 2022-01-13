package com.mycompany.sudokuproject1;

import java.io.Serializable;
import java.util.stream.IntStream;

/**
 * Summary of a class in JavaDoc.
 *
 * @author Maciej
 */
public class BacktrackingSudokuSolver implements SudokuSolver, Serializable {

    @Override
    public void solve(SudokuBoard board) {
        solver(board);
    }

    // ======= Functions needed for solve to work ==========
    public boolean solver(SudokuBoard board) {
        for (int row = ZERO_CONST; row < BOARD_SIZE; row++) {
            for (int column = ZERO_CONST; column < BOARD_SIZE; column++) {
                if (board.get(row, column) == ZERO_CONST) {
                    for (int k = 1; k <= BOARD_SIZE; k++) {
                        board.set(row, column, k);
                        if (isValid(board, row, column) && solver(board)) {
                            return true;
                        }
                        board.set(row, column, ZERO_CONST);
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private static final int ZERO_CONST = 0;
    private static final int BOARD_SIZE = 9;

    boolean checkConstraint(
            SudokuBoard board,
            int row,
            boolean[] constraint,
            int column) {
        if (board.get(row, column) != ZERO_CONST) {
            if (!constraint[board.get(row, column) - 1]) {
                constraint[board.get(row, column) - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean subsectionConstraint(SudokuBoard board, int row, int column) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        int subsectionRowStart = (row / ELEMENT_SIZE) * ELEMENT_SIZE;
        int subsectionRowEnd = subsectionRowStart + ELEMENT_SIZE;

        int subsectionColumnStart = (column / ELEMENT_SIZE) * ELEMENT_SIZE;
        int subsectionColumnEnd = subsectionColumnStart + ELEMENT_SIZE;

        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if (!checkConstraint(board, r, constraint, c)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static final int ELEMENT_SIZE = 3;

    private boolean columnConstraint(SudokuBoard board, int column) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        return IntStream.range(ZERO_CONST, BOARD_SIZE)
                .allMatch(row -> checkConstraint(board, row, constraint, column));
    }

    private boolean rowConstraint(SudokuBoard board, int row) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        return IntStream.range(ZERO_CONST, BOARD_SIZE)
                .allMatch(column -> checkConstraint(board, row, constraint, column));
    }

    private boolean isValid(SudokuBoard board, int row, int column) {
        return (rowConstraint(board, row)
                && columnConstraint(board, column)
                && subsectionConstraint(board, row, column));
    }
}
