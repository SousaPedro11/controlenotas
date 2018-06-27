package controlenotas.util;

import java.io.Serializable;

/**
 * Interface que auxilia na obtencao da pk(cod) por reflexao
 * 
 * @author pedrosousa
 *
 * @param <K>
 */
public interface IEntidade<K extends Serializable> {

    K getChavePrimaria();
}