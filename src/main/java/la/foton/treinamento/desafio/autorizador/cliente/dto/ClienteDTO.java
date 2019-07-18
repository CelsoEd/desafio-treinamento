package la.foton.treinamento.desafio.autorizador.cliente.dto;

import la.foton.treinamento.desafio.autorizador.cliente.entity.Cliente;

public class ClienteDTO {

    private String cpf;
    private String nome;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente paraCliente() {
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setNome(nome);
        return cliente;
    }
}
