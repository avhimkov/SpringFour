package ch10;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = IndividualCustomerValidator.class)
@Documented
public @interface CheckindividualCustomer {
    String message() default "Individual customer should have gender and last" +
            "name defined";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
