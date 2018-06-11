package controlenotas.jdbc;

public class ConexaoPostgreSQL extends ConexaoBase {

    @Override
    public String getDriverClass() {

        return "org.postgresql.Driver";
    }
}