package main.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    //atributos
    private Map<String, String> dicionarioPalavras;

    public Dicionario() {
        this.dicionarioPalavras = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao){
        this.dicionarioPalavras.put(palavra,definicao);
    }

    public void removerPalavra(String palavra){
        if (!this.dicionarioPalavras.isEmpty()){
            this.dicionarioPalavras.remove(palavra);
        }
    }

    public void exibirPalavras(){
        System.out.println(this.dicionarioPalavras);
    }

    public String pesquisarPalavra(String palavra){
        String definicao = null;

        if (!this.dicionarioPalavras.isEmpty()){
            definicao = dicionarioPalavras.get(palavra);
        }
        return definicao;
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        //adicionar palavras
        dicionario.adicionarPalavra("Jefferson","Nome proprio");
        dicionario.adicionarPalavra("Batata","Tuberculo");
        dicionario.adicionarPalavra("Cadeira","Movel");

        //exibir palavras
        dicionario.exibirPalavras();

        //remover palavra
        dicionario.removerPalavra("Batata");
        dicionario.exibirPalavras();

        System.out.println("A definição da palavra pesquisada é: " + dicionario.pesquisarPalavra("Jefferson"));

    }

}
