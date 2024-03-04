package com.example.assigmentsdj.Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ModelManager implements Model {
    private ArrayList<Vinyl> vinyls;
    private final PropertyChangeSupport support;

    public ModelManager(){
        this.vinyls = new ArrayList<>(List.of(new Vinyl("Abbey Road", "The Beatles", 1969, null, null),
            new Vinyl("Thriller", "Michael Jackson", 1982, null, null),
            new Vinyl("The Dark Side of the Moon", "Pink Floyd", 1973, null, null),
            new Vinyl("A Night at the Opera", "Queen", 1975, null, null),
            new Vinyl("Led Zeppelin IV", "Led Zeppelin", 1971, null, null),
            new Vinyl("Nevermind", "Nirvana", 1991, null, null),
            new Vinyl("Highway 61 Revisited", "Bob Dylan", 1965, null, null),
            new Vinyl("Sticky Fingers", "The Rolling Stones", 1971, null, null),
            new Vinyl("The Rise and Fall of Ziggy Stardust and the Spiders from Mars", "David Bowie", 1972, null, null),
            new Vinyl("The Velvet Underground & Nico", "The Velvet Underground", 1967, null, null)));
        this.support = new PropertyChangeSupport(vinyls);
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
    public synchronized void reserve(Vinyl vinyl, Person person) {
        try {
            vinyl.reserve(vinyl, person);
            notifyVinylsChanged();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public synchronized void returnIt(Vinyl vinyl, Person person) {
        try {
            vinyl.returnIt(vinyl, person);
            notifyVinylsChanged();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public synchronized void remove(Vinyl vinyl) {
        try {
            vinyl.remove(vinyl);
            notifyVinylsChanged();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ArrayList<Vinyl> getVinyls() {
        return vinyls;
    }

    public Vinyl getVinyl(int index)
    {
        return vinyls.get(index);
    }

    private void notifyVinylsChanged() {
        support.firePropertyChange("ListOfVinyls", null, vinyls);
    }
}




