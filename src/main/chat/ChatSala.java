package chat;

import java.util.ArrayList;
import java.util.List;

public class ChatSala implements ChatMediator {

    private List<Usuario> usuarios;

    public ChatSala() {
        this.usuarios = new ArrayList<>();
    }

    @Override
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void enviarMensagem(String mensagem, Usuario remetente) {
        for (Usuario usuario : usuarios) {
            if (usuario != remetente) {
                usuario.receber(mensagem);
            }
        }
    }
}