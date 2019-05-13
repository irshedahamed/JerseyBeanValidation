/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

/**
 *
 * @author irshed-pt2884
 */
@Retention(RetentionPolicy.RUNTIME)

@Constraint(validatedBy = PatchValidate.PatchValidator.class)
public @interface PatchValidate {

    String message() default "Invalid Status of Patch";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class PatchValidator implements ConstraintValidator<PatchValidate, Patch> {

        @Override
        public void initialize(PatchValidate a) {
        }

        @Override
        public boolean isValid(Patch obj, ConstraintValidatorContext cvc) {
            
            System.out.println("Inside Validate");
            String status = obj.getStatus();
            if(status.equalsIgnoreCase("approved") || status.equalsIgnoreCase("notapproved") || status.equalsIgnoreCase("not approved")){
                return true;
            }
            return false;
        }

    }

}
