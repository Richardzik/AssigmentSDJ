package com.example.assigmentsdj;

import com.example.assigmentsdj.*;
import com.example.assigmentsdj.Model.Model;
import com.example.assigmentsdj.Model.ModelManager;
import com.example.assigmentsdj.Model.Simulation;
import com.example.assigmentsdj.View.ManageVinylsViewController;
import com.example.assigmentsdj.View.ViewHandler;
import com.example.assigmentsdj.ViewModel.ManageVinylsViewModel;
import com.example.assigmentsdj.ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class StartApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Simulation.class.getResource("VinylListView.fxml"));
        Model model = new ModelManager();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(stage);

    }
    public static void main(String[] args){
        launch();
    }
}
