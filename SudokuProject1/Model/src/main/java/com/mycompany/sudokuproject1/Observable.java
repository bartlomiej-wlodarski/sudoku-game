package com.mycompany.sudokuproject1;

/**
 * Summary of a class in JavaDoc.
 *
 * @author Maciej
 */
public interface Observable {

    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers();
}
