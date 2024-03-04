package com.example.assigmentsdj.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ModelManager implements Model {
    private ObservableList<Vinyl> vinyls;
    private final PropertyChangeSupport support;

    public ModelManager(){
         vinyls = FXCollections.observableArrayList();
        this.support = new PropertyChangeSupport(vinyls);
        Vinyl vinyl1 = new Vinyl("Abbey Road", "The Beatles", 1969, null, null);
        Vinyl vinyl2 = new Vinyl("Thriller", "Michael Jackson", 1982, null, null);
        Vinyl vinyl3 = new Vinyl("The Dark Side of the Moon", "Pink Floyd", 1973, null, null);
        Vinyl vinyl4 = new Vinyl("A Night at the Opera", "Queen", 1975, null, null);
        Vinyl vinyl5 = new Vinyl("Led Zeppelin IV", "Led Zeppelin", 1971, null, null);
        Vinyl vinyl6 = new Vinyl("Nevermind", "Nirvana", 1991, null, null);
        Vinyl vinyl7 = new Vinyl("Highway 61 Revisited", "Bob Dylan", 1965, null, null);
        Vinyl vinyl8 = new Vinyl("Sticky Fingers", "The Rolling Stones", 1971, null, null);
        Vinyl vinyl9 = new Vinyl("The Rise and Fall of Ziggy Stardust and the Spiders from Mars", "David Bowie", 1972, null, null);
        Vinyl vinyl10 = new Vinyl("The Velvet Underground & Nico", "The Velvet Underground", 1967, null, null);

        vinyls.add(vinyl1);
        vinyls.add(vinyl2);
        vinyls.add(vinyl3);
        vinyls.add(vinyl4);
        vinyls.add(vinyl5);
        vinyls.add(vinyl6);
        vinyls.add(vinyl7);
        vinyls.add(vinyl8);
        vinyls.add(vinyl9);
        vinyls.add(vinyl10);
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

    @Override public ObservableList<Vinyl> getVinyls()
    {
        return vinyls;
    }

    private void notifyVinylsChanged() {
        support.firePropertyChange("ListOfVinyls", null, vinyls);
    }
}




