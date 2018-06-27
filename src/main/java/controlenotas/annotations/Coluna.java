package controlenotas.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotação criada para marcar colunas e auxiliar na criação de DDL.
 *
 * @author Pedro Sousa
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Coluna {

    String nome();

    String tipo() default "VARCHAR";

    int tamanho() default 255;

    boolean nulo() default false;

    boolean auto() default false;
}