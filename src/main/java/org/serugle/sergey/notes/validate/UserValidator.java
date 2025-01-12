package org.serugle.sergey.notes.validate;

import org.serugle.sergey.notes.annotation.Validator;

@Validator(MIN_LENGTH = 3, MAX_LENGTH = 16)
public class UserValidator {
    private int minLength;
    private int maxLength;

    public UserValidator() {
        Validator validator = this.getClass().getAnnotation(Validator.class);
        this.minLength = validator.MIN_LENGTH();
        this.maxLength = validator.MAX_LENGTH();
    }

    public boolean validate(String user) {
        if (user.isEmpty()) {
            return false;
        }
        return this.minLength <= user.length() && user.length() <= this.maxLength;
    }
}
