package com.example.sql_first_try.persistence;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.sql_first_try.async.DeleteAsyncTask;
import com.example.sql_first_try.async.InsertAsyncTask;
import com.example.sql_first_try.async.UpdateAsyncTask;
import com.example.sql_first_try.models.Note;

import java.util.List;

public class NoteRepository {

    private NoteDatabase mNoteDatabase;

    public NoteRepository(Context context) {
        mNoteDatabase = NoteDatabase.getInstance(context);
    }

    public void insertNoteTask(Note note){
        new InsertAsyncTask(mNoteDatabase.getNoteDao()).execute(note);

    }

    public void updateNote(Note note){
        new UpdateAsyncTask(mNoteDatabase.getNoteDao()).execute(note);

    }

    public LiveData<List<Note>> retrieveNoteTask(){
        return mNoteDatabase.getNoteDao().getNotes();
    }

    public void deleteNote(Note note){
        new DeleteAsyncTask(mNoteDatabase.getNoteDao()).execute(note);

    }
}
