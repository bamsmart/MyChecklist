package learning.shinesdev.mychecklist;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class Repository {

    public static Repository instance;
    private static JsonHelper helper;
    private List<Checklist> checklist;


    public static Repository getInstance(Application app) {
        if (instance == null) {
            instance = new Repository();
            helper = new JsonHelper(app);
        }
        return instance;
    }

    public MutableLiveData<List<Checklist>> loadChecklist() {
        MutableLiveData<List<Checklist>> data = new MutableLiveData<>();
        data.setValue(helper.loadChecklist());
        return data;
    }


}
