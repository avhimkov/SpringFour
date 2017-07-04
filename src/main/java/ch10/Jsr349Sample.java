package ch10;

import java.util.HashSet;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Jsr349Sample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/jsr349-app-context.xml");
        ctx.refresh();

        MyBeanValidationService myBeanValidationService = ctx.getBean("myBeanValidationService", MyBeanValidationService.class);

        Customer customer = new Customer();
        Customer.setFirstName("C");
        Customer.setLastName("Schaefer");
        Customer.setCustomerType(null);
        Customer.setGender(null);

        validateCustomer(customer, myBeanValidationService);
    }

    private static void validateCustomer (Customer customer, MyBeanValidationService myBeanValidationService) {
        Set<ConstraintViolation<Customer>> violations = new HashSet<ConstraintViolation<Customer>>();
        violations = myBeanValidationService.validateCustomer(customer);
        listViolation(violations);
    }

    private static void listViolation(Set<ConstraintViolation<Customer>>violations){
        System.out.println("No. of violations: " + violations.size());
        for (ConstraintViolation<Customer> violation: violations){
            System.out.println("Validation error for property: " + violation.getPropertyPath()
                    + "with value:" + violation.getInvalidValue() + "with error message: "
                    + violation.getMessage());
        }
    }
}
