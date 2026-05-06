package chat;

public abstract class Usuario {

    protected ChatMediator mediator;
    protected String nome;

    public Usuario(ChatMediator mediator, String nome) {
        this.mediator = mediator;
        this.nome = nome;
    }

    public abstract void enviar(String mensagem);
    public abstract void receber(String mensagem);
}