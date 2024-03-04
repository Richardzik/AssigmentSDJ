package com.example.assigmentsdj.ViewModel;
import com.example.assigmentsdj.*;
import com.example.assigmentsdj.Model.Model;

public class ViewModelFactory {
    private ManageVinylsViewModel manageVinylsViewModel;
    private StartViewModel startViewModel;

    public ViewModelFactory(Model model) {
        this.manageVinylsViewModel = new ManageVinylsViewModel(model);
        this.startViewModel = new StartViewModel(model);
    }
    public ManageVinylsViewModel getManageVinylsViewModel() {
        return manageVinylsViewModel;
    }
    public StartViewModel getStartViewModel() {
        return startViewModel;
    }

}
