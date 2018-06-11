package controlenotas.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public interface Conexao {

    Connection conectar(String url, String usuario, String senha) throws SQLException, ClassNotFoundException;

    String getDriverClass();

    Connection getConexao();
}