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
    @FXML private Button SimulateButton;
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
    @FXML public void onSimulate(){
        Simulation simulation = new Simulation(manageVinylsViewModel.getModel());
        Thread thread = new Thread(simulation);
        thread.start();
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
        if(selectedVinyl.get().isToBeRemoved())
        {
            RemoveButton.setDisable(true);
        }
    }

    public Region getRoot(){
        return root;
    }
}
