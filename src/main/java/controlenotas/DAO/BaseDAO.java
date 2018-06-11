package controlenotas.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import controlenotas.jdbc.SingletonConexao;
import controlenotas.jdbc.SingletonProperties;
import controlenotas.jdbc.TipoConexao;

public abstract class BaseDAO<T, K> {

    public Connection getConexao() {

        Connection conexao = null;

        try {
            final SingletonProperties properties = SingletonProperties.getInstancia("configuracao.properties");
            final TipoConexao tipo = TipoConexao.valueOf(properties.getPropriedade("jdbc.tipo"));
            final String url = properties.getPropriedade("jdbc.url");
            final String usuario = properties.getPropriedade("jdbc.usuario");
            final String senha = properties.getPropriedade("jdbc.senha");

            conexao = SingletonConexao.conectar(tipo, url, usuario, senha);

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
            System.exit(1);
        }

        return conexao;
    }

    public abstract void criarDDL();

    public abstract void inserir(T objeto);

    public abstract void alterar(T objeto, K chaveprimaria);

    public abstract void excluir(K chavePrimaria);

    public abstract List<T> buscarTodos();

    public abstract Optional<T> buscarPor(K chavePrimaria);

    public abstract T converter(ResultSet rs) throws SQLException;
}
