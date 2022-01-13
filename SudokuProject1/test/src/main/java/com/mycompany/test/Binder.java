package com.mycompany.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Maciej
 */
public class Binder implements Container {

    private final List<Object> documents;
    private final int size;

    public Binder(int size) {
        this.size = size;
        List<Object> temp = Arrays.asList(new Object[size]);
        documents = Collections.unmodifiableList(temp);
    }
    
    
    
    @Override
    public boolean put(Object obj) {
        return documents.add(obj);
    }

    @Override
    public boolean remove(Object obj) {
        return documents.remove(obj);
    }

    @Override
    public List getAll() {
        return documents;
    }
    
    public int getFreeSpace() {
        return size - documents.size();
    }
    
    public int getDocumentsCount() {
        return documents.size();
    }
    
}
