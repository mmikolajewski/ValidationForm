package pl.javastart.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = ZipCodeValidator.class)
@Target({ FIELD})
@Retention(RUNTIME)
public @interface ZipCode {
    String message() default "Wpisz poprawny kod pocztowy";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
