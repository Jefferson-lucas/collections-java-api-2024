package main.set.OperacoesBasicas;

import com.sun.source.doctree.ThrowsTree;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ConjuntoPalavras {
    //atributos
    private Set<String> palavrasSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConjuntoPalavras that = (ConjuntoPalavras) o;
        return Objects.equals(palavrasSet, that.palavrasSet);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(palavrasSet);
    }

    //construtor
    public ConjuntoPalavras() {
        this.palavrasSet = new HashSet<>();
    }

    public void adicionarPalavra(String palavra){
        this.palavrasSet.add(palavra);
    }

    public void removerPalavra(String palavra){
        Set<String> palavrasRemover = new HashSet<>();
        if (!this.palavrasSet.isEmpty()){
            for(String ps : this.palavrasSet ){
                if(ps.equalsIgnoreCase(palavra)){
                    palavrasRemover.add(ps);
                }
            }
            this.palavrasSet.removeAll(palavrasRemover);
        }else {
            throw new RuntimeException("A lista de palavras está vazia");
        }
    }

    public String verificarPalavra(String palavra){
        String palavraProcurada = null;
        if(!this.palavrasSet.isEmpty()){
            for(String p : this.palavrasSet){
                if(p.equalsIgnoreCase(palavra)){
                    palavraProcurada = palavra;
                    break;
                }
            }
        }else{
            throw new RuntimeException("A lista de palavras está vazia");
        }
        if (palavraProcurada != null && !"".equalsIgnoreCase(palavraProcurada)){
            return "A palavra " + palavraProcurada + " foi encontrada na lista de palavras";
        }else {
            return "Palavra " + palavra + " não foi encontrada na lista de palavras";
        }

    }

    public Set<String> exibirPalavrasUnicas(){
        Set<String> setPalavrasUnicas = new HashSet<>();
        setPalavrasUnicas = this.palavrasSet;

        return setPalavrasUnicas;
    }

    public static void main(String[] args) {
        ConjuntoPalavras conjuntoPalavras = new ConjuntoPalavras();

        //adicionar palavras
        conjuntoPalavras.adicionarPalavra("Jefferson");
        conjuntoPalavras.adicionarPalavra("Jefferson");
        conjuntoPalavras.adicionarPalavra("Sabrina");
        conjuntoPalavras.adicionarPalavra("Teste");
        conjuntoPalavras.adicionarPalavra("Luna");
        conjuntoPalavras.adicionarPalavra("Bartô");

        //exibir palavras
        System.out.println(conjuntoPalavras.exibirPalavrasUnicas());

        //Remover palavra
        conjuntoPalavras.removerPalavra("Teste");
        System.out.println(conjuntoPalavras.exibirPalavrasUnicas());

        //verifica palavra
        System.out.println(conjuntoPalavras.verificarPalavra("bartô"));

    }

}
