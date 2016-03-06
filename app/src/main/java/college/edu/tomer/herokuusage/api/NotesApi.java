package college.edu.tomer.herokuusage.api;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import college.edu.tomer.herokuusage.models.Note;
import college.edu.tomer.herokuusage.models.NotesResponse;

/**
 * Created by master on 06/03/16.
 */
public class NotesApi {

    public interface OnNotesRecieved {
        void onNotesRecieved(List<Note> notes);
    }

    public static void getAllNotes(final OnNotesRecieved listener) {
        //Uses permission: Internet
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://collegeserve.herokuapp.com/api/notes");
                    URLConnection con = url.openConnection();
                    InputStream in = con.getInputStream();
                    InputStreamReader streamReader = new InputStreamReader(in);

                    Gson gson = new Gson();
                    NotesResponse notesResponse = gson.fromJson(streamReader, NotesResponse.class);
                    List<Note> notes = notesResponse.getNotes();
                    listener.onNotesRecieved(notes);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
