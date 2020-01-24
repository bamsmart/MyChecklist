package learning.shinesdev.mychecklist;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterChecklist extends RecyclerView.Adapter<AdapterChecklist.ChecklistViewHolder>{
    private final Activity mactivity;
    private List<Checklist> mChecklist = new ArrayList<>();

    AdapterChecklist(Activity activity) {
        this.mactivity = activity;
    }

    public List<Checklist> getListData() {
        return mChecklist;
    }

    void initData(List<Checklist> data) {
        if (data == null) return;
        this.mChecklist.clear();
        this.mChecklist.addAll(data);
    }

    @NonNull
    @Override
    public AdapterChecklist.ChecklistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_checklist, parent, false);

        return new ChecklistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterChecklist.ChecklistViewHolder holder, final int position) {
        Checklist checklist = mChecklist.get(position);

        // inisialisasi data pertama kali di load
        holder.item.setText(checklist.getItem());
        holder.notes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                // isikan datanya
                mChecklist.get(holder.getAdapterPosition()).setNotes(s.toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        holder.notes.setText(checklist.getNotes());

        holder.checked.setChecked(checklist.getChecked());
        holder.checked.setTag(checklist);
        holder.checked.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // tampilan checkbox isChecked?
                CheckBox cb = (CheckBox) v;
                Checklist checklist = (Checklist) cb.getTag();
                checklist.setChecked(cb.isChecked());

                // isikan checkboxnya datanya
                getListData().get(holder.getAdapterPosition()).setChecked(cb.isChecked());
            }
        });
    }

    class ChecklistViewHolder extends  RecyclerView.ViewHolder{
            TextView item;
            EditText notes;
            CheckBox checked;

        ChecklistViewHolder(View itemView){
            super(itemView);
            item = itemView.findViewById(R.id.item);
            notes = itemView.findViewById(R.id.notes);
            checked = itemView.findViewById(R.id.checkbox);
        }
    }

    @Override
    public int getItemCount() {
        return mChecklist.size();
    }
}
