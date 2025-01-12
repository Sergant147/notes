package org.serugle.sergey.notes.repository;

import org.serugle.sergey.notes.model.Note;

import java.util.ArrayList;


public interface INoteRepository {
    public ArrayList<String> getNotesByUsername(String username);

    public ArrayList<Note> fetchAll();

    public String getOwnerOf(String note);

    public void clear();

    public void addNote(String username, String note);

    public void deleteUser(String username);
}
