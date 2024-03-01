package com.example.assigmentsdj.ViewModel;
import com.example.assigmentsdj.*;
import com.example.assigmentsdj.Model.Model;

public class ViewModelFactory {
    private ManageVinylsViewModel manageVinylsViewModel;

    public ViewModelFactory(Model model) {
        this.manageVinylsViewModel = new ManageVinylsViewModel(model);
    }
    public ManageVinylsViewModel getManageVinylsViewModel() {
        return manageVinylsViewModel;
    }
}
