package controlenotas.annotations;

import java.io.Serializable;

public interface IEntidade<K extends Serializable> {

    K getChavePrimaria();
}