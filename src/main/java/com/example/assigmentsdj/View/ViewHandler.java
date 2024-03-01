package com.example.assigmentsdj.View;

import com.example.assigmentsdj.ViewModel.ViewModelFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Region; // Import the correct Region class
import javafx.stage.Stage;

public class ViewHandler {
    private final Scene currentScene;
    private Stage primaryStage;
    private final ViewFactory viewFactory;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewFactory = new ViewFactory(this, viewModelFactory);
        this.currentScene = new Scene(new Region());
    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        openView(ViewFactory.MANAGE);
    }

    public void openView(String id) {
        Region root = viewFactory.loadView(id);
        if (root == null) {
            return; // Handle the case where the view is not loaded properly
        }
        currentScene.setRoot(root);
        Object userData = root.getUserData();
        primaryStage.setTitle(userData != null ? userData.toString() : "");
        primaryStage.setScene(currentScene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public void closeView() {
        primaryStage.close();
    }
}
