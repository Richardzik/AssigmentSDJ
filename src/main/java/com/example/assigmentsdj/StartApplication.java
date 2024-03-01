package com.example.assigmentsdj;

import com.example.assigmentsdj.*;
import com.example.assigmentsdj.Model.Model;
import com.example.assigmentsdj.Model.ModelManager;
import com.example.assigmentsdj.View.ViewHandler;
import com.example.assigmentsdj.ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Model model = new ModelManager();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(stage);
    }
    public static void main(String[] args){
        launch();
    }
}
