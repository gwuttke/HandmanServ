package de.gtwsp21.handmanserv.validator;

import javax.validation.Payload;

public @interface EmailValid {

    String message() default "Invalid Email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}