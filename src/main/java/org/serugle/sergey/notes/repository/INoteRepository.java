package org.serugle.sergey.notes.repository;

import java.util.ArrayList;


public interface INoteRepository {
    public ArrayList<String> getNotesByUsername(String username);

    public void fetchAll();

    public String getOwnerOf(String note);

    public void clear();

    public void addNote(String username, String note);

    public void deleteUser(String username);
}
