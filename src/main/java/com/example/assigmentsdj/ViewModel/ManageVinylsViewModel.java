package com.example.assigmentsdj.ViewModel;
import com.example.assigmentsdj.Model.Model;
import com.example.assigmentsdj.Model.Person;
import com.example.assigmentsdj.Model.Vinyl;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ManageVinylsViewModel implements PropertyChangeListener {

    private Model model;
    private StringProperty message;
    private final ListProperty<Vinyl> vinyls;


    private ObjectProperty<Vinyl> vinyl;
    private final ObjectProperty<Person> person;


    public ManageVinylsViewModel(Model model) {
        this.model = model;
        this.message = new SimpleStringProperty();
        this.vinyls = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.vinyl = new SimpleObjectProperty<>();
        this.person = new SimpleObjectProperty<>();
        model.addPropertyChangeListener(this);
    }

    public void reserve() {
        try {
            if (vinyl.get() != null && person.get() != null)
                model.reserve(vinyl.get(), person.get());
        } catch (Exception e) {
            message.setValue(e.getMessage());
        }
    }

    public void borrow() {
        try {
            if (vinyl.get() != null && person.get() != null)
                model.borrow(vinyl.get(), person.get());
        } catch (Exception e) {
            message.setValue(e.getMessage());
        }
    }

    public void returnIt() {
        try {
            if (vinyl.get() != null && person.get() != null)
                model.returnIt(vinyl.get(), person.get());
        } catch (Exception e) {
            message.setValue(e.getMessage());
        }
    }

    public void remove() {
        try {
            if (vinyl.get() != null)
                model.remove(vinyl.get());
        } catch (Exception e) {
            message.setValue(e.getMessage());
        }
    }

    public void bindVinyl(ObjectProperty<ObservableList<Vinyl>> property){
        property.bind(vinyls);
    }
    public void bindSelected(ReadOnlyObjectProperty<Vinyl> property){
        vinyl.bind(property);
    }



    ////Probably not functional - IDK HOW TO FIX
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            if (evt.getPropertyName().equals("ListOfVinyls")) {
                ArrayList<Vinyl> temp = (ArrayList<Vinyl>) evt.getNewValue();
                vinyls.clear();
                vinyls.addAll(temp);
                vinyls.set(FXCollections.observableArrayList(temp));
            }
        });
    }

}
