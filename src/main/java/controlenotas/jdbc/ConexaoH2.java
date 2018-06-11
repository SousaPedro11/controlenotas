package controlenotas.jdbc;

public class ConexaoH2 extends ConexaoBase {

    @Override
    public String getDriverClass() {

        return "org.h2.Driver";
    }
}