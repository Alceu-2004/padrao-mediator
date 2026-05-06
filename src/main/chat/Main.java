package chat;

public class Main {

    public static void main(String[] args) {

        ChatMediator chat = new ChatSala();

        Usuario user1 = new UsuarioConcreto(chat, "Alceu");
        Usuario user2 = new UsuarioConcreto(chat, "Maria");
        Usuario user3 = new UsuarioConcreto(chat, "João");

        chat.adicionarUsuario(user1);
        chat.adicionarUsuario(user2);
        chat.adicionarUsuario(user3);

        user1.enviar("Olá pessoal!");
        user2.enviar("Oi Alceu!");
    }
}