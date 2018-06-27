package controlenotas.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Auxilia na identificação de chave estrangeira da tabela.
 *
 * @author Pedro Sousa
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Fk {

    String tabelareferencia();

    String chavereferencia() default "COD";
}
