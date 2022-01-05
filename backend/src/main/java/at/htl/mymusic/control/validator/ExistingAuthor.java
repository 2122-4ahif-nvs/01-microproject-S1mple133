package at.htl.mymusic.control.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static javax.validation.constraintvalidation.ValidationTarget.ANNOTATED_ELEMENT;

@Documented
@Constraint(validatedBy = ExistingAuthorValidator.class)
@Target({
        METHOD,
        FIELD,
        ANNOTATION_TYPE,
        CONSTRUCTOR,
        PARAMETER,
        TYPE_USE })
@Retention(RUNTIME)
@SupportedValidationTarget(ANNOTATED_ELEMENT)
@ReportAsSingleViolation
public @interface ExistingAuthor {
    String message() default "Artist with the given id does not exist!";

    Class<? extends Payload>[] payload() default {};

    Class<?>[] groups() default {};
}
