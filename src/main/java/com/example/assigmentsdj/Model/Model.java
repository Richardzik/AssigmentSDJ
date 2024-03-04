package com.example.assigmentsdj.Model;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public interface Model {
    void addPropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);
    void borrow(Vinyl vinyl, Person person);
    void reserve(Vinyl vinyl, Person person);
    void returnIt(Vinyl vinyl, Person person);
    void remove(Vinyl vinyl);
    ObservableList<Vinyl> getVinyls();
}
