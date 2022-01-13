package com.mycompany.sudokuproject1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Summary of a class in JavaDoc.
 *
 * @author Maciej
 */
public class SudokuPuzzleGenerator {

    private final Repository repo;

    public enum Level {
        EASY,
        MEDIUM,
        HARD
    }

    public SudokuPuzzleGenerator() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard tempBoard = new SudokuBoard(solver);
        repo = new Repository(tempBoard);
    }

    public SudokuBoard generate(Level difficulty) {
        SudokuBoard board = repo.createInstance();
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = Arrays.asList(array);
        Collections.shuffle(list);
        for (int i = 0; i < 9; i++) {
            board.set(i, i, list.get(i));
        }
        board.solveGame();
        board.lockAllFields();
        switch (difficulty) {
            case EASY -> {
                for (int i = 0; i < 30; i++) {
                    board.set((int) (Math.random() * 9), (int) (Math.random() * 9), 0);
                }
            }
            case MEDIUM -> {
                for (int i = 0; i < 45; i++) {
                    board.set((int) (Math.random() * 9), (int) (Math.random() * 9), 0);
                }
            }
            case HARD -> {
                for (int i = 0; i < 60; i++) {
                    board.set((int) (Math.random() * 9), (int) (Math.random() * 9), 0);
                }
            }
        }
        return board;
    }

    public SudokuBoard returnEmpty() {
        return repo.createInstance();
    }

}
