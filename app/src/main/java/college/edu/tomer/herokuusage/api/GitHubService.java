package college.edu.tomer.herokuusage.api;

import college.edu.tomer.herokuusage.models.NotesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;


interface NotesApiService {
    @GET("api/notes")
    Call<NotesResponse> getAllNotes();

    @POST("api/addNote")
    Call<String> addNote();
}