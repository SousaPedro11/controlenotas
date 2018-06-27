package controlenotas.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotação criada para atribuir campos no ToString().
 *
 * @author Pedro Sousa
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AtribuirToString {

    String prefixo() default "";

    String sufixo() default "";
}
