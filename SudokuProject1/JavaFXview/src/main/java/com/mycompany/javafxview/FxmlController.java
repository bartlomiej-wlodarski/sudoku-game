package com.mycompany.javafxview;

import com.mycompany.sudokuproject1.SudokuBoard;
import com.mycompany.sudokuproject1.SudokuPuzzleGenerator;
import daopackage.Dao;
import daopackage.SudokuBoardDaoFactory;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Button;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Locale;

/**
 * Summary of a class in JavaDoc.
 *
 * @author Maciej
 */
public class FxmlController implements Initializable {

    @FXML
    private GridPane boardGrid;
    
    private final  Logger logger = LoggerFactory.getLogger(FxmlController.class);
    private final List<TextField> fields;
    private SudokuBoard board;
    private final SudokuPuzzleGenerator generator;
    private final SudokuBoardDaoFactory factory;
    private ResourceBundle resourceBundle;

    @FXML private Button buttonEasy;
    @FXML private Button buttonMedium;
    @FXML private Button buttonHard;
    @FXML private Button buttonEN;
    @FXML private Button buttonPL;
    @FXML private Button buttonSave;
    @FXML private Button buttonLoad;
    @FXML private Button buttonSolve;
    
    public FxmlController() {
        fields = new ArrayList();
        for (int i = 0; i < 81; i++) {
            TextField field = new TextField();
            field.setPrefHeight(50);
            field.setAlignment(Pos.CENTER);
            field.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
            field.setText("0");
            fields.add(i, field);
        }
        generator = new SudokuPuzzleGenerator();
        factory = new SudokuBoardDaoFactory();
        board = generator.returnEmpty();
    }

    @FXML
    protected void loadAction() {
        try (Dao dao = factory.getFileDao("save.txt")) {
            board = (SudokuBoard) dao.read();
        } catch (Exception ex) {
            //logger.info("load error");
            logger.error("load error", new MyException());
        }
        displaySudoku();
    }

    @FXML
    protected void saveAction() {
        try (Dao dao = factory.getFileDao("save.txt")) {
            dao.write(board);
        } catch (Exception ex) {
            logger.info("save error");
        }
    }

    @FXML
    protected void easyAction() {
        board = generator.generate(SudokuPuzzleGenerator.Level.EASY);
        displaySudoku();
    }

    @FXML
    protected void mediumAction() {
        board = generator.generate(SudokuPuzzleGenerator.Level.MEDIUM);
        displaySudoku();
    }

    @FXML
    protected void hardAction() {
        board = generator.generate(SudokuPuzzleGenerator.Level.HARD);
        displaySudoku();
    }

    @FXML
    protected void solve() {
        if (true) {
            board.solveGame();
            displaySudoku();
        }
    }

    @FXML
    protected void changeLanguageEN() {
        I18N.setLocale(new Locale("en", "UK"));
        logger.info("now language should be changed");
    }
    
    @FXML
    protected void changeLanguagePL() {
        I18N.setLocale(new Locale("pl", "PL"));
        logger.info("now language should be changed");
    }

    private void displaySudoku() {
        //paint all field red
        for (int i = 0; i < 81; i++) {
            fields.get(i).setStyle("-fx-control-inner-background: #FF0000");
        }
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                //refresh values
                fields.get(y * 9 + x).setText(String.valueOf(board.get(x, y)));

                //locker
                if (board.isLocked(x, y)) {
                    fields.get(y * 9 + x).setDisable(true);
                } else {
                    fields.get(y * 9 + x).setDisable(false);
                }

                //validator
                if (board.getRow(x).verify()) {
                    for (int i = 0; i < 9; i++) {
                        fields.get(i * 9 + x).setStyle("-fx-control-inner-background: #FFFFFF");
                    }
                }

                if (board.getColumn(y).verify()) {
                    for (int i = 0; i < 9; i++) {
                        fields.get(y * 9 + i).setStyle("-fx-control-inner-background: #FFFFFF");
                    }
                }

                if (board.getBox(x / 3, y / 3).verify()) {
                    for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
                        for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
                            fields.get(i * 9 + j).setStyle("-fx-control-inner-background: #FFFFFF");
                        }
                    }
                }
            }
        }
    }

    private void updateSudoku(int x, int y) {
        int value = tryParse(fields.get(y * 9 + x).getText());
        if (value >= 0 && value <= 9) {
            board.set(x, y, value);
            displaySudoku();
        }
    }

    private static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resourceBundle = rb;
        buttonEasy.textProperty().bind(I18N.createStringBinding("butt.easy"));
        buttonMedium.textProperty().bind(I18N.createStringBinding("butt.medium"));
        buttonHard.textProperty().bind(I18N.createStringBinding("butt.hard"));
        buttonEN.textProperty().bind(I18N.createStringBinding("lang.en"));
        buttonPL.textProperty().bind(I18N.createStringBinding("lang.pl"));
        buttonSave.textProperty().bind(I18N.createStringBinding("butt.save"));
        buttonLoad.textProperty().bind(I18N.createStringBinding("butt.load"));
        buttonSolve.textProperty().bind(I18N.createStringBinding("butt.solve"));
        
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                int pos = y * 9 + x;
                int _x = x;
                int _y = y;
                boardGrid.add(fields.get(pos), y, x);
                fields.get(pos).focusedProperty().addListener((ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) -> {
                    if (newPropertyValue) {
                        updateSudoku(_x, _y);
                    } else {
                        updateSudoku(_x, _y);
                    }
                });
            }
        }
    }

}
