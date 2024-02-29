package com.example.assigmentsdj.Model;
import java.beans.PropertyChangeListener;

public interface Model {
    void addPropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);
    void removeVinyl(Vinyl vinyl);
    void borrow(Vinyl vinyl);  // borrow,reserve,returnIt nie mam pojęcia czy powinny tu być
    void reserve(Vinyl vinyl);
    void returnIt(Vinyl vinyl);
}
