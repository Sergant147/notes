package org.serugle.sergey.notes.repository;

import org.serugle.sergey.notes.model.Note;

import java.util.ArrayList;


public class NoteRepository implements INoteRepository {
    private ArrayList<Note> notes;

    public NoteRepository() {
        this.notes = new ArrayList<Note>();
    }

    public ArrayList<String> getNotesByUsername(String username) {
        ArrayList<String> out = new ArrayList<String>();
        for (Note note : this.notes) {
            if (note.owner.equals(username)) {
                out.add(note.note);
            }
        }
        return out;
    }

    public ArrayList<Note> fetchAll() {
        return this.notes;
    }

    public String getOwnerOf(String note) {
        return this.notes.stream().filter(noteFound -> noteFound.note.equals(note)).findFirst().orElseThrow().owner;
    }

    public void clear() {
        this.notes = new ArrayList<Note>();
    }

    public void addNote(String username, String note) {
        this.notes.add(new Note(username, note));
    }

    public void deleteUser(String username) {
        int notesLengthOld = this.notes.size();
        this.notes.removeIf(note -> note.owner.equals(username));
        int notesLengthNew = this.notes.size();
        if (notesLengthOld == notesLengthNew) {
            throw new RuntimeException("No such user found!");
        }
    }
}