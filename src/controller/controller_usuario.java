package controller;
import DAO.dao_usuario;
import model.model_usuario;

public class controller_usuario {
    dao_usuario dUsuario = new dao_usuario();

    public boolean salvarUsuarioController(model_usuario modelUsuario) {
        return this.dUsuario.salvar_usuarioDAO(modelUsuario);
    }
}
