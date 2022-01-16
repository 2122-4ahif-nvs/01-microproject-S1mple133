package at.htl.mymusic.control.validator;

import at.htl.mymusic.control.ArtistRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@ApplicationScoped
public class ExistingAuthorValidator implements ConstraintValidator<ExistingAuthor, Long> {
    @Inject
    ArtistRepository repository;

    @Override
    public void initialize(ExistingAuthor constraintAnnotation) {
        System.out.println(1);
    }

    @Override
    public boolean isValid(Long i, ConstraintValidatorContext constraintValidatorContext) {
        return repository.findById( i).await().indefinitely() != null;
    }
}
