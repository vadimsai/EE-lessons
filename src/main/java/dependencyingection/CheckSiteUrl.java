package dependencyingection;


import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

//@Constraint(validatedBy = {UrlValidat.class})
@Retention(RUNTIME)
@Target(value = {ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
public @interface CheckSiteUrl {
    String message() default " Invalid ";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};

    int port() default -1;
    String host() default  "";
    String protocol() default "";

}


