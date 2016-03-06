package college.edu.tomer.herokuusage.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NotesResponse {

    @SerializedName("notes")
    @Expose
    private List<Note> notes = new ArrayList<>();

    /**
     * @return The notes
     */
    public List<Note> getNotes() {
        return notes;
    }

    /**
     * @param notes The notes
     */
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
