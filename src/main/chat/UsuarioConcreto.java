package chat;

public class UsuarioConcreto extends Usuario {

    public UsuarioConcreto(ChatMediator mediator, String nome) {
        super(mediator, nome);
    }

    @Override
    public void enviar(String mensagem) {
        mediator.enviarMensagem(this.nome + ": " + mensagem, this);
    }

    @Override
    public void receber(String mensagem) {
        System.out.println(nome + " recebeu: " + mensagem);
    }
}