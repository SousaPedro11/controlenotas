package controlenotas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConexaoBase implements Conexao {

    private Connection conexao;

    @Override
    public Connection conectar(final String url, final String usuario, final String senha)
                    throws SQLException, ClassNotFoundException {

        Class.forName(this.getDriverClass());
        this.conexao = DriverManager.getConnection(url, usuario, senha);

        return this.conexao;
    }

    @Override
    public Connection getConexao() {

        return this.conexao;
    }
}