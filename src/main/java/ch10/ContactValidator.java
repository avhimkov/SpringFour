package ch10;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;

@Component("contactValidator")
public class ContactValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz){
        return Contact.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors e){
        ValidationUtils.rejectIfEmpty(e, "firstName", "firstName.empty");
    }
}
