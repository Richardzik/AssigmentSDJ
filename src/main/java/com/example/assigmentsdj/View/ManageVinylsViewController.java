package com.example.assigmentsdj.View;

import com.example.assigmentsdj.Model.*;
import com.example.assigmentsdj.ViewModel.ManageVinylsViewModel;
import com.example.assigmentsdj.ViewModel.ViewModelFactory;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;

public class ManageVinylsViewController {
    @FXML private TableView<Vinyl> VinylTableView;
    @FXML private TableColumn<Vinyl, String> VinylTitle;
    @FXML private TableColumn<Vinyl, String> VinylArtist;
    @FXML private TableColumn<Vinyl, Integer> VinylYear;
    @FXML private TableColumn<Vinyl, State> VinylState;
    @FXML private TableColumn<Vinyl, Person> VinylBorrower;
    @FXML private TableColumn<Vinyl, Person> VinylReservist;
    @FXML private Button BorrowButton;
    @FXML private Button ReserveButton;
    @FXML private Button ReturnButton;
    @FXML private Button RemoveButton;
    private Region root;
    private ViewHandler viewHandler;
    private ReadOnlyObjectProperty<Vinyl> selectedVinyl;
    private ManageVinylsViewModel manageVinylsViewModel;

    public void init(ViewHandler viewHandler, ManageVinylsViewModel manageVinylsViewModel, Region root){
        this.root = root;
        this.viewHandler = viewHandler;
        this.manageVinylsViewModel = manageVinylsViewModel;

        manageVinylsViewModel.bindVinyl(VinylTableView.itemsProperty());
        this.VinylTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        this.VinylArtist.setCellValueFactory(new PropertyValueFactory<>("artist"));
        this.VinylYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        this.VinylState.setCellValueFactory(new PropertyValueFactory<>("lendingState"));
        this.VinylBorrower.setCellValueFactory(new PropertyValueFactory<>("borrower"));
        this.VinylReservist.setCellValueFactory(new PropertyValueFactory<>("reservist"));
        this.selectedVinyl = VinylTableView.getSelectionModel().selectedItemProperty();


        this.selectedVinyl = VinylTableView.getSelectionModel().selectedItemProperty();
        this.manageVinylsViewModel.bindSelected(selectedVinyl);
        populateTable();
    }
    @FXML public void onReserve(){
        manageVinylsViewModel.reserve();
    }
    @FXML public void onBorrow(){
        manageVinylsViewModel.borrow();
    }
    @FXML public void onReturn(){
        manageVinylsViewModel.returnIt();
    }
    @FXML public void onRemove(){
        manageVinylsViewModel.remove();
    }
    @FXML public void onBack(){
        viewHandler.closeView();
    }
    @FXML public void onSelect(){
        if(selectedVinyl.get().getLendingState() instanceof Removed){
            BorrowButton.setDisable(true);
            ReserveButton.setDisable(true);
            ReturnButton.setDisable(true);
            RemoveButton.setDisable(true);
        }
        if(selectedVinyl.get().getLendingState() instanceof Reserved){
            BorrowButton.setDisable(false);
            ReserveButton.setDisable(true);
            ReturnButton.setDisable(true);
            RemoveButton.setDisable(false);
        }
        if(selectedVinyl.get().getLendingState() instanceof Borrowed){
            BorrowButton.setDisable(true);
            ReserveButton.setDisable(false);
            ReturnButton.setDisable(false);
            RemoveButton.setDisable(false);
        }
        if(selectedVinyl.get().getLendingState() instanceof Borrowed_Reserved){
            BorrowButton.setDisable(true);
            ReserveButton.setDisable(true);
            ReturnButton.setDisable(false);
            RemoveButton.setDisable(false);
        }
        if(selectedVinyl.get().getLendingState() instanceof Available){
            BorrowButton.setDisable(true);
            ReserveButton.setDisable(false);
            ReturnButton.setDisable(true);
            RemoveButton.setDisable(false);
        }
    }

    public Region getRoot(){
        return root;
    }
    public void populateTable() {
        // Clear existing items
        VinylTableView.getItems().clear();

        // Create a new ObservableList of Vinyl objects
        ObservableList<Vinyl> vinyls = FXCollections.observableArrayList(
                new Vinyl("Abbey Road", "The Beatles", 1969, null, null),
                new Vinyl("Thriller", "Michael Jackson", 1982, null, null),
                new Vinyl("The Dark Side of the Moon", "Pink Floyd", 1973, null, null),
                new Vinyl("A Night at the Opera", "Queen", 1975, null, null),
                new Vinyl("Led Zeppelin IV", "Led Zeppelin", 1971, null, null),
                new Vinyl("Nevermind", "Nirvana", 1991, null, null),
                new Vinyl("Highway 61 Revisited", "Bob Dylan", 1965, null, null),
                new Vinyl("Sticky Fingers", "The Rolling Stones", 1971, null, null),
                new Vinyl("The Rise and Fall of Ziggy Stardust and the Spiders from Mars", "David Bowie", 1972, null, null),
                new Vinyl("The Velvet Underground & Nico", "The Velvet Underground", 1967, null, null)
        );

        // Add all vinyls to the TableView
        VinylTableView.getItems().addAll(vinyls);
    }
}
