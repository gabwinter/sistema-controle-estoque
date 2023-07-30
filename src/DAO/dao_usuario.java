package DAO;

import model.model_usuario;
import util.ConexaoSQLite;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dao_usuario {

    public boolean salvar_usuarioDAO(model_usuario pModel_usuario) {
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        if (conexaoSQLite.conectar()) {
            String SQL = "INSERT INTO tbl_usuario (user_nome, user_login, user_senha) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = conexaoSQLite.getConexao().prepareStatement(SQL)) {
                preparedStatement.setString(1, pModel_usuario.getNome_usuario());
                preparedStatement.setString(2, pModel_usuario.getLogin_usuario());
                preparedStatement.setString(3, pModel_usuario.getSenha_usuario());
                preparedStatement.executeUpdate();
                System.out.println("Usuário salvo com sucesso.");
                return true;
            } catch (SQLException e) {
                System.err.println("Erro ao executar a inserção: " + e.getMessage());
                return false;
            } finally {
                conexaoSQLite.desconectar();
            }
        } else {
            System.err.println("Não foi possível conectar ao banco de dados.");
            return false;
        }
    }
}
