package com.example.assigmentsdj.Model;
import java.beans.PropertyChangeListener;

public interface Model {
    void addPropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);
    void removeVinyl(Vinyl vinyl);
    void borrow(Vinyl vinyl, Person person);  // borrow,reserve,returnIt nie mam pojęcia czy powinny tu być
    void reserve(Vinyl vinyl, Person person);
    void returnIt(Vinyl vinyl, Person person);
}
