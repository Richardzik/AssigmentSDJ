package com.example.assigmentsdj.View;
import com.example.assigmentsdj.*;
import com.example.assigmentsdj.ViewModel.ManageVinylsViewModel;
import com.example.assigmentsdj.ViewModel.ViewModelFactory;
import javafx.fxml.FXMLLoader;

import javafx.scene.layout.Region;
import java.io.IOError;
import java.io.IOException;

public class ViewFactory {
    public static final String MANAGE = "manage";
    public static final String START = "start";
    private final ViewHandler viewHandler;
    private final ViewModelFactory viewModelFactory;
    private ManageVinylsViewController manageVinylsViewController;
    private StartViewController startViewController;

    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.manageVinylsViewController = null;
        this.startViewController = null;
    }

    public Region loadStartView(){
        if(startViewController == null){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com.example.assigmentssdj/StartView.fxml"));
            try {
                Region root = loader.load();
                startViewController = loader.getController();
                startViewController.init(viewHandler, viewModelFactory.getStartViewModel(), root);
                return root;
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        return startViewController.getRoot();
    }

    public Region loadVinylView() {
        if (manageVinylsViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com.example.assigmentssdj/VinylListView.fxml"));
            try {
                Region root = loader.load();
                manageVinylsViewController = loader.getController();
                manageVinylsViewController.init(viewHandler, viewModelFactory.getManageVinylsViewModel(), root);
                return root;
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        return manageVinylsViewController.getRoot();
    }


    public Region loadView(String id){
        return switch (id){
            case START -> loadStartView();
            case MANAGE -> loadVinylView();
            default -> throw new IllegalArgumentException("Unknow view: " + id);

        };
    }

}
