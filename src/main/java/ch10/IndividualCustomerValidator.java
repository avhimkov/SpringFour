package ch10;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IndividualCustomerValidator implements ConstraintValidator<CheckindividualCustomer, Customer> {
    @Override
    public void initialize(CheckindividualCustomer constraintAnnotation) {

    }

    @Override
    public boolean isValid(Customer customer, ConstraintValidatorContext context) {
        boolean result = true;
        if (customer.getCustomerType() != null && (customer.isIndividualCustomer() && (customer.getLastName())== null
        || customer.getGender() == null)){
            return false;
        }
        return result;
    }
}
