package learning.shinesdev.mychecklist;

public class Checklist {
    String item;
    String resources;
    boolean checked;
    String notes;

    public Checklist(String item, String resources) {
        this.item = item;
        this.resources = resources;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
