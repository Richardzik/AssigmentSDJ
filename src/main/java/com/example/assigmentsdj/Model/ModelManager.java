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

    @Override
    public synchronized void borrow(Vinyl vinyl, Person person) {
        try {
            vinyl.borrow(vinyl, person);
            notifyVinylsChanged();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void reserve(Vinyl vinyl, Person person) {
        try {
            vinyl.reserve(vinyl, person);
            notifyVinylsChanged();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void returnIt(Vinyl vinyl, Person person) {
        try {
            vinyl.returnIt(vinyl, person);
            notifyVinylsChanged();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void remove(Vinyl vinyl) {
        try {
            vinyl.remove(vinyl);
            notifyVinylsChanged();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void notifyVinylsChanged() {
        support.firePropertyChange("ListOfVinyls", null, vinyls);
    }
}




