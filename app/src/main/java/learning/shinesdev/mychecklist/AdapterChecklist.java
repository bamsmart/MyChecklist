package learning.shinesdev.mychecklist;



/*private static final int TYPE_ITEM = 0;
private static final int TYPE_SEPARATOR = 1;
private LayoutInflater inflater;
private List<ItemChecklist> itemList;
private TreeSet<Integer> sectionHeader = new TreeSet<Integer>();
private Context context;

public AdapterCreateChecklist(Context context, int resource) {
        super(context, resource);
        this.context = context;
        itemList = new ArrayList<ItemChecklist>();
        inflater = LayoutInflater.from(context);
        }

@Override
public ItemChecklist getItem(int position) {
        return itemList.get(position);
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        ItemChecklist checklist = this.getItem(position);
        TextView id_checklist;
        TextView id_parent;
        TextView item_checklist;
        CheckBox checkbox;
        TextView section;
        ChecklistViewHolder holder;

        int rowType = getItemViewType(position);

        switch (rowType) {
        case TYPE_ITEM:
        if (convertView == null) {
        convertView = inflater.inflate(R.layout.list_item_checklist, null);
        id_checklist = (TextView) convertView.findViewById(R.id.id_checklist);
        id_parent = (TextView) convertView.findViewById(R.id.id_parent);
        item_checklist = (TextView) convertView.findViewById(R.id.item_checklist);
        checkbox = (CheckBox) convertView.findViewById(R.id.checkbox);
        } else {
        holder = (ChecklistViewHolder) convertView.getTag();
        id_checklist = holder.getIdCheklist();
        id_parent = holder.getIdParent();
        item_checklist = holder.getItemCheckList();
        checkbox = holder.getCheckBox();
        }
        convertView.setTag(new ChecklistViewHolder(id_checklist, id_parent, item_checklist, checkbox));
        checkbox.setTag(checklist);
        checkbox.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
        CheckBox cb = (CheckBox) v;
        ItemChecklist checklist = (ItemChecklist) cb.getTag();
        checklist.setChecked(cb.isChecked());
        }
        });

        id_checklist.setText("" + checklist.getIdChecklist());
        id_parent.setText("" + checklist.getIdParent());
        item_checklist.setText(checklist.getItemCheckList());
        checkbox.setChecked(checklist.isChecked());

        break;
        case TYPE_SEPARATOR:
        convertView = inflater.inflate(R.layout.snippet_item2, null);
        section = (TextView) convertView.findViewById(R.id.textSeparator);
        convertView.setTag(new ChecklistViewHolder(section));
        section.setText(checklist.getGroup());
        break;
        }
        return convertView;
        }

public void addItem(String group, String name) {
        itemList.add(new ItemChecklist(group, name));
        notifyDataSetChanged();
        }

public void addItems(int id_checklist, int id_parent, String name) {
        itemList.add(new ItemChecklist(id_checklist, id_parent, name));
        notifyDataSetChanged();
        }

public void addSectionHeaderItem(final String item) {
        itemList.add(new ItemChecklist(item));
        sectionHeader.add(itemList.size() - 1);
        notifyDataSetChanged();
        }

@Override
public int getItemViewType(int position) {
        return sectionHeader.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
        }

@Override
public int getViewTypeCount() {
        return 2;
        }

@Override
public int getCount() {
        return itemList.size();
        }

public List<ItemChecklist> getData() {
        // you'll use this method to get all of the row's data items. Then
        // using the checkedPosition fields from RowData you can see which
        // of the RadioButton from that rows RadioGroup is checked.
        return itemList;
        }

*/

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds child views for one row.
 *//*
private static class ChecklistViewHolder {
    private TextView section;
    private TextView id_checklist;
    private TextView id_parent;
    private TextView item_checklist;
    private CheckBox checkbox;

    public ChecklistViewHolder() {
    }

    public ChecklistViewHolder(TextView section) {
        this.section = section;
    }

    public ChecklistViewHolder(TextView id_checklist, TextView id_parent, TextView item_checklist, CheckBox checkbox) {
        this.id_checklist = id_checklist;
        this.id_parent = id_parent;
        this.item_checklist = item_checklist;
        this.checkbox = checkbox;
    }

    public CheckBox getCheckBox() {
        return checkbox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkbox = checkBox;
    }

    public TextView getItemCheckList() {
        return item_checklist;
    }

    public void setItemCheckList(TextView item_checklist) {
        this.item_checklist = item_checklist;
    }

    public TextView getIdCheklist() {
        return id_checklist;
    }

    public void setIdCheklist(TextView id_checklist) {
        this.id_checklist = id_checklist;
    }

    public TextView getIdParent() {
        return id_parent;
    }

    public void setIdParent(TextView id_parent) {
        this.id_parent = id_parent;
    }

    public TextView getSection() {
        return section;
    }

    public void setSection(TextView section) {
        this.section = section;
    }
}*/


public class AdapterChecklist extends RecyclerView.Adapter<AdapterChecklist.ChecklistViewHolder>{
    private final Activity activity;
    private List<Checklist> mChecklist = new ArrayList<>();

    AdapterChecklist(Activity activity) {
        this.activity = activity;
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
    public void onBindViewHolder(@NonNull final AdapterChecklist.ChecklistViewHolder holder, int position) {

        holder.item.setText(getListData().get(position).getItem());
        holder.notes.setText(getListData().get(position).getNotes());

        final boolean checked = getListData().get(position).getChecked();
        //Checked
        Log.d("Is Checked : ",""+checked);
        holder.checked.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Is Checked : ",""+checked);

                if(!checked){
                    holder.checked.setChecked(true);
                }else{
                   holder.checked.setChecked(false);
                }
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
