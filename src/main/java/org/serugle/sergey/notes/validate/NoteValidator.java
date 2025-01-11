package org.serugle.sergey.notes.validate;

import org.serugle.sergey.notes.annotation.Validator;

@Validator(MIN_LENGTH = 30, MAX_LENGTH = 1000)
public class NoteValidator {
    private int minLength;
    private int maxLength;

    public NoteValidator() {
        Validator validator = this.getClass().getAnnotation(Validator.class);
        this.minLength = validator.MIN_LENGTH();
        this.maxLength = validator.MAX_LENGTH();
    }

    public boolean validate(String note) {
        return this.minLength <= note.length() && note.length() <= this.maxLength;
    }
}
