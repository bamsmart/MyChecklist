package learning.shinesdev.mychecklist;


import android.app.Application;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {
    private final String TAG = JsonHelper.class.getSimpleName();
    private Application application;

    public JsonHelper(Application application) {
        this.application = application;
    }

    private String parsingFileToString(String fileName) {
        try {
            InputStream in = application.getAssets().open(fileName);
            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            in.close();

            return new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public List<Checklist> loadChecklist() {
        ArrayList<Checklist> list = new ArrayList<>();

        try {
            JSONObject responseObject = new JSONObject(parsingFileToString("checklist_template_2.json"));
            JSONArray listArray = responseObject.getJSONArray("data");

            for (int i = 0; i < listArray.length(); i++) {
                JSONObject res = listArray.getJSONObject(i);

                String item = res.getString("item");
                String img = "ikan";//res.getJSONObject("resources").toString();

                Checklist movieResponse = new Checklist(item, img);
                list.add(movieResponse);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }
}
