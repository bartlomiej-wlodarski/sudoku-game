package com.mycompany.test;

import java.util.List;

/**
 *
 * @author Maciej
 * 
 * @param <T>
 */
public interface Container<T> {
    public boolean put(T obj);
    
    public boolean remove(T obj);
    
    public List<T> getAll();
}
