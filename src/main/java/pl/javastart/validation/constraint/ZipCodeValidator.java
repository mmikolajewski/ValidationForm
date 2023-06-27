package pl.javastart.validation.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {


    @Override
    public void initialize(ZipCode zipCode) {
        ConstraintValidator.super.initialize(zipCode);

    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile("^[0-9]{2}-[0-9]{3}$");
        return pattern.matcher(value).matches();
    }
}
