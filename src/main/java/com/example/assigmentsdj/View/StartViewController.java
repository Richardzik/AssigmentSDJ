package com.example.assigmentsdj.View;

import com.example.assigmentsdj.ViewModel.StartViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;

public class StartViewController {
    @FXML public Button startButton;
    private Region root;
    private StartViewModel startViewModel;
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler, StartViewModel startViewModel, Region root) {
        this.root = root;
        this.viewHandler = viewHandler;
        this.startViewModel = startViewModel;
    }

    @FXML public void onStart(){
        viewHandler.openView(ViewFactory.MANAGE);
    }
    public Region getRoot(){
        return root;
    }

}
