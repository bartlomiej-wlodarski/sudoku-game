package com.mycompany.sudokuproject1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Summary of a class in JavaDoc.
 * 
 * @author Maciej
 */
public class Repository {
    
    private final Logger logger = LoggerFactory.getLogger(Repository.class);
    private static SudokuBoard cloneTemplate;

    public Repository(SudokuBoard cloneTemplate) {
        Repository.cloneTemplate = cloneTemplate;
    }
    
    public SudokuBoard createInstance() {
        try {
            SudokuBoard clone = (SudokuBoard) cloneTemplate.clone();
            return clone;
        } catch (CloneNotSupportedException ex) {
            logger.info("cloning error");
            return null;
        }
    }
}
