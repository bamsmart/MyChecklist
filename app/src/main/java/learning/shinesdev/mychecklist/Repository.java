package learning.shinesdev.mychecklist;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class Repository {

    private static JsonHelper helper;
    public static Repository instance;
    private List<Checklist> checklist;


    public static Repository getInstance(Application app) {
        if(instance == null){
            instance = new Repository();
            helper = new JsonHelper(app);
        }
        return instance;
    }

    public MutableLiveData<List<Checklist>> loadChecklist(){
        MutableLiveData<List<Checklist>> data = new MutableLiveData<>();
        data.setValue(helper.loadChecklist());
        return data;
    }


}
