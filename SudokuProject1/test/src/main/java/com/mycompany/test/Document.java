package com.mycompany.test;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Maciej
 */
public class Document {
    private final int id;
    private final LocalDate time;
    private String content;

    public Document(int id, LocalDate time) {
        this.id = id;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public LocalDate getTime() {
        return time;
    }
    
    
}
