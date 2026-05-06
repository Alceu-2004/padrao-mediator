package chat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ChatMediatorTest {

    @Test
    void deveEnviarMensagemParaOutrosUsuarios() {

        ChatMediator chat = new ChatSala();

        Usuario u1 = new UsuarioConcreto(chat, "A");
        Usuario u2 = new UsuarioConcreto(chat, "B");

        chat.adicionarUsuario(u1);
        chat.adicionarUsuario(u2);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        u1.enviar("teste");

        String output = out.toString();

        assertTrue(output.contains("B recebeu: A: teste"));
    }

    @Test
    void usuarioNaoRecebePropriaMensagem() {

        ChatMediator chat = new ChatSala();

        Usuario u1 = new UsuarioConcreto(chat, "A");
        chat.adicionarUsuario(u1);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        u1.enviar("teste");

        String output = out.toString();

        assertFalse(output.contains("A recebeu"));
    }

    @Test
    void deveAdicionarUsuariosCorretamente() {

        ChatSala chat = new ChatSala();

        Usuario u1 = new UsuarioConcreto(chat, "A");
        chat.adicionarUsuario(u1);

        assertNotNull(u1);
    }

    @Test
    void deveEnviarMensagemParaMultiplosUsuarios() {

        ChatMediator chat = new ChatSala();

        Usuario u1 = new UsuarioConcreto(chat, "A");
        Usuario u2 = new UsuarioConcreto(chat, "B");
        Usuario u3 = new UsuarioConcreto(chat, "C");

        chat.adicionarUsuario(u1);
        chat.adicionarUsuario(u2);
        chat.adicionarUsuario(u3);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        u1.enviar("oi");

        String output = out.toString();

        assertTrue(output.contains("B recebeu: A: oi"));
        assertTrue(output.contains("C recebeu: A: oi"));
    }
}