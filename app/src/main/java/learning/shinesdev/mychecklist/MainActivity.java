package learning.shinesdev.mychecklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.database.Observable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewModelClass viewmodel;
    private AdapterChecklist adapter;
    private RecyclerView rvChecklist;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvChecklist = findViewById(R.id.rvChecklist);
        btnSubmit = findViewById(R.id.btnSubmit);

        adapter = new AdapterChecklist(this);

        viewmodel = ViewModelProviders.of(this).get(ViewModelClass.class);
        viewmodel.init(getApplication());
        viewmodel.getLisData().observe(this, new Observer<List<Checklist>>() {
            @Override
            public void onChanged(List<Checklist> checklists) {
                adapter.initData(checklists);
                adapter.notifyDataSetChanged();

            }
        });

        rvChecklist.setLayoutManager(new LinearLayoutManager(this));
        rvChecklist.setHasFixedSize(true);
        rvChecklist.setAdapter(adapter);


    }

}
