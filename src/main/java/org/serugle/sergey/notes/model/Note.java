package org.serugle.sergey.notes.model;

import org.serugle.sergey.notes.expection.InvalidInputException;
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
        UserValidator userValidator = new UserValidator();
        NoteValidator noteValidator = new NoteValidator();
        if (noteValidator.validate(this.note)){
            throw new InvalidInputException("Not valid note!");
        }
        if (userValidator.validate(this.owner)){
            throw new InvalidInputException("Not valid username!");
        }
    }
}
