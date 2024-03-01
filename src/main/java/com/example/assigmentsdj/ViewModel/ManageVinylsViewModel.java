package com.example.assigmentsdj.ViewModel;
import com.example.assigmentsdj.*;
import com.example.assigmentsdj.Model.Model;
import com.example.assigmentsdj.Model.Person;
import com.example.assigmentsdj.Model.Vinyl;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ManageVinylsViewModel implements PropertyChangeListener {

    private Model model;
    private StringProperty message;
    private final ListProperty<Vinyl> vinyls;
    private final ListProperty<Person> persons;

    private ObjectProperty<Vinyl> vinyl;
    

    public ManageVinylsViewModel(Model model) {
        this.model = model;
        this.vinyls = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.persons = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.vinyl = new SimpleObjectProperty<>();
        model.addPropertyChangeListener(this);
    }

    public void bindVinyl(ObjectProperty<ObservableList<Vinyl>> property){
        property.bind(vinyls);
    }
    public void bindPersons(ObjectProperty<ObservableList<Person>> property){
        property.bind(persons);
    }
    public void bindSelected(ReadOnlyObjectProperty<Vinyl> property){
        vinyl.bind(property);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            if (evt.getPropertyName().equals("ListOfVinyls")) {
                ArrayList<Vinyl> temp = (ArrayList<Vinyl>) evt.getNewValue();
                vinyls.clear();
                temp.forEach(vinyls::add);
            }
        });
    }

}
