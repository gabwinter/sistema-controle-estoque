package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQLite {

    private Connection conexao;
    
    /**
     * Conecta a um banco de dados (cria o banco se ele não existir)
     */
    public boolean conectar() {
        try {
            String url = "jdbc:sqlite:G:/Meu Drive/BACKUP/Sistema_estoque/db/db_estoque";
            this.conexao = DriverManager.getConnection(url);
            System.out.println("Conectado");
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    public boolean desconectar() {
        try {
            if (this.conexao != null && !this.conexao.isClosed()) {
                this.conexao.close();
                System.out.println("Desconectado");
            }
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    public Connection getConexao() {
        return this.conexao;
    }
}
