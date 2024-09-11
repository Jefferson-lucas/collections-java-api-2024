package main.list.OperacoesBasicas;

public class Tarefa {
    //atributo

    private String descicao;

    public Tarefa(String descicao) {
        this.descicao = descicao;
    }

    public String getDescicao() {
        return descicao;
    }

    @Override
    public String toString() {
        return descicao;
    }
}
