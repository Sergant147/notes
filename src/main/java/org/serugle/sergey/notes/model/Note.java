package org.serugle.sergey.notes.model;

import org.serugle.sergey.notes.expection.InvalidInputExpection;
import org.serugle.sergey.notes.validate.NoteValidator;
import org.serugle.sergey.notes.validate.UserValidator;

public class Note {
    public String owner;
    public String note;

    public Note(String owner, String note) {
        this.owner = owner;
        this.note = note;
        this.validate();
    }

    private void validate() {
        NoteValidator noteValidator = new NoteValidator();
        UserValidator userValidator = new UserValidator();
        if (noteValidator.validate(this.note)){
            throw new InvalidInputExpection("Not valid note!");
        }
        if (userValidator.validate(this.owner)){
            throw new InvalidInputExpection("Not valid username!");
        }
    }
}
