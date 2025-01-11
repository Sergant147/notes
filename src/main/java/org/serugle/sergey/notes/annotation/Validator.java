package org.serugle.sergey.notes.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Validator {
    int MAX_LENGTH();

    int MIN_LENGTH();
}
