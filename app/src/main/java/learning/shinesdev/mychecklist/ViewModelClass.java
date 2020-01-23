package learning.shinesdev.mychecklist;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ViewModelClass extends ViewModel {
    private Repository mRepo;
    private LiveData<List<Checklist>> mList;
    private Application mapp;


    void init(Application app){
        if (mList != null){
            return;
        }
        mapp = app;
        mRepo = Repository.getInstance(mapp);
        mList = mRepo.loadChecklist();
    }


    public LiveData<List<Checklist>> getLisData(){
        return  mList;
    }

}
