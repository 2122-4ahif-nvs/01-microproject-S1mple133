package at.htl.mymusic.control.validator;

import at.htl.mymusic.control.ArtistRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistingAuthorValidator implements ConstraintValidator<ExistingAuthor, Integer> {
    @Inject
    ArtistRepository repository;

    @Override
    public void initialize(ExistingAuthor constraintAnnotation) {
        System.out.println(1);
    }

    @Override
    public boolean isValid(Integer i, ConstraintValidatorContext constraintValidatorContext) {
        return repository.findById((long) i).await().indefinitely() != null;
    }
}
