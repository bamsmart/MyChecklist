package learning.shinesdev.mychecklist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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

        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSubmit:
                List<Checklist> checklistData = adapter.getListData();
                int len = adapter.getItemCount();
                for (int i = 0 ; i < len; i++){
                    System.out.println("item ke "+i + ": "+checklistData.get(i).getItem());
                    System.out.println("isChecked ke "+i + ": "+checklistData.get(i).getChecked());
                    System.out.println("notes ke "+i + ": "+checklistData.get(i).getNotes());

                    System.out.println("============================================================ ");
                }

                break;
        }
    }
}
