package dependencyingection;


import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

//@Constraint(validatedBy = {ChronpValid.class})
@Retention(RUNTIME)
@Target(TYPE)
public @interface ChronoDates {
    String message() default " date invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
