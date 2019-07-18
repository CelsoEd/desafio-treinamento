package la.foton.treinamento.desafio.autorizador.common.exception;

public class Erro {

    private String mensagem;

    public Erro(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
