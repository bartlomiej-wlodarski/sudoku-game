package com.mycompany.sudokuproject1;

import daopackage.Dao;
import daopackage.FileSudokuBoardDao;
import daopackage.SudokuBoardDaoFactory;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) {//SudokuBoard test = new SudokuBoard();
        //test.fillBoard();
        /*int[][] board = {
            { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
            { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
            { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
            { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
            { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
            { 0, 9, 0, 0, 0, 0, 4, 0, 0 } 
        };
        test.printBoard(board);
        test.solve(board);
        System.out.println();
        test.printBoard(board);*/
        /*SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(solver);
        int[][] values = {
            {8, 1, 2, 7, 5, 3, 6, 4, 9},
            {9, 4, 3, 6, 8, 2, 1, 7, 5},
            {6, 7, 5, 4, 9, 1, 2, 8, 3},
            {1, 5, 4, 2, 3, 7, 8, 9, 6},
            {3, 6, 9, 8, 4, 5, 7, 2, 1},
            {2, 8, 7, 1, 6, 9, 5, 3, 4},
            {5, 2, 1, 9, 7, 4, 3, 6, 8},
            {4, 3, 8, 5, 2, 6, 9, 1, 7},
            {7, 9, 6, 3, 1, 8, 4, 5, 2}
        };
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                board.set(x, y, values[x][y]);
            }
        }
        //System.out.println(board.getColumn(0).verify());
        
        /*SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
        try (Dao dao = factory.getFileDao("file.txt")) {
            dao.write(board);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        SudokuBoard test = new SudokuBoard(solver);
        try (Dao dao = factory.getFileDao("file.txt")) {
            test = (SudokuBoard) dao.read();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(test.toString());*/
            
        /*DAO SudokuBoard test*/
        /*try (FileSudokuBoardDao<SudokuBoard> dao = new FileSudokuBoardDao("file.txt")) {
            dao.write(board);
        } catch (IOException ex) {
            System.out.println("write error");
        }
        try (FileSudokuBoardDao<SudokuBoard> dao = new FileSudokuBoardDao("file.txt")) {
            SudokuBoard str = dao.read();
            System.out.println(str.toString());
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("read error");
        }*/
        
        /*  DAO string test*//*
        String text = "test text";
        try (FileSudokuBoardDao<String> dao = new FileSudokuBoardDao("file.txt")) {
            dao.write(text);
        } catch (IOException ex) {
            System.out.println("write error");
        }
        try (FileSudokuBoardDao<String> dao = new FileSudokuBoardDao("file.txt")) {
            String str = dao.read();
            System.out.println(str);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("read error");
        }*/
    }

}
