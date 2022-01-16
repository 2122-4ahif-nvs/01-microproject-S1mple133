package at.htl.mymusic.control.validator;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@ApplicationScoped
public class BadWordValidator implements ConstraintValidator<NoBadWord, String> {
    @Override
    public void initialize(NoBadWord constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !(s.contains("shit") || s.contains("lame"));
    }
}
