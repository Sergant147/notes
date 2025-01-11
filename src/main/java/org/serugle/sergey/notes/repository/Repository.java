package org.serugle.sergey.notes.repository;

import org.serugle.sergey.notes.expection.NoSuchUserExpection;
import org.serugle.sergey.notes.model.Note;

import java.util.ArrayList;

public class Repository /*implements RepositoryInterface*/ {
    private ArrayList<Note> notes;

    public Repository() {
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

    public void fetchAll() {
        for (Note note : this.notes) {
            System.out.print("Owner: " + note.owner);
            System.out.println();
            System.out.print("Note: " + note.note);
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    public String getOwnerOf(String note) {
        for (Note noteFound : this.notes) {
            if (noteFound.note.equals(note)) {
                return noteFound.owner;
            }
        }
        throw new NoSuchUserExpection("No user found for the note!");
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
            throw new NoSuchUserExpection("No such user found!");
        }
    }
}
