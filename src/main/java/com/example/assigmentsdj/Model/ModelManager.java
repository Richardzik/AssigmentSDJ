package com.example.assigmentsdj.Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ModelManager implements Model {   // Library for vinyls
    private ArrayList<Vinyl> vinyls;
    private final PropertyChangeSupport support;

    public ModelManager(){
        this.vinyls = new ArrayList<>();
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
