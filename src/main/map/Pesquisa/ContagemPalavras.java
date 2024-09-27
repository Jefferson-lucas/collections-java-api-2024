package main.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    //atributos
    private Map<String,Integer> palavrasMap;

    public ContagemPalavras() {
        this.palavrasMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem){
        this.palavrasMap.put(palavra,contagem);
    }

    public void removerPalavra(String palavra){
        if (!this.palavrasMap.isEmpty()){
            this.palavrasMap.remove(palavra);
        }
    }
    public Map exibirContagemPalavras(){
        return this.palavrasMap;
    }

    public String encontrarPalavraMaisFrequente(){
        int ocorrencias = 0;
        String chave = null;
        //Map <String,Integer> palavraMaisFrequente;

        if (!this.palavrasMap.isEmpty()){
            for (Map.Entry<String, Integer> i : palavrasMap.entrySet()){
                if (i.getValue() > ocorrencias){
                    ocorrencias = i.getValue();
                    chave = i.getKey();
                }
            }
        }
        return "A palavra mais frequente é: " + chave + " com " + ocorrencias + " ocorrencias";
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();

        //adicionar palavras
        contagemPalavras.adicionarPalavra("Teste", 5);
        contagemPalavras.adicionarPalavra("Maria", 7);
        contagemPalavras.adicionarPalavra("José", 2);
        contagemPalavras.adicionarPalavra("Final", 3);

        //exibir palavras
        System.out.println(contagemPalavras.exibirContagemPalavras());

        //remover palavra
        contagemPalavras.removerPalavra("Teste");
        System.out.println(contagemPalavras.exibirContagemPalavras());

        //buscar por palavra mais usada com base na quantidade informada
        System.out.println(contagemPalavras.encontrarPalavraMaisFrequente());
    }

}
