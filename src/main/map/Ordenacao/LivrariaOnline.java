package main.map.Ordenacao;

import java.util.*;

public class LivrariaOnline {
    //atributos
    private Map<String, Livro> livroMap;

    public LivrariaOnline() {
        this.livroMap = new HashMap<>();
    }

    @Override
    public String toString() {
        return "LivrariaOnline{" +
                "livroMap = " + livroMap +
                '}';
    }

    public void adicionarLivro(String link, Livro livro) {
        this.livroMap.put(link, livro);
    }

    public void removerLivro(String titulo) {
        List<String> livrosRemover = new ArrayList<>();
        if (!livroMap.isEmpty()) {
            for (Map.Entry<String, Livro> livro : livroMap.entrySet()) {
                if (livro.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                    livrosRemover.add(livro.getKey());

                }
            }
            for (String chave : livrosRemover){
                livroMap.remove(chave);
            }
        }
    }

    public Map exibirLivrosPorPreco() {
        List<Map.Entry<String, Livro>> livrosOrdenadosPreco = new ArrayList<>(livroMap.entrySet());
        Collections.sort(livrosOrdenadosPreco, new OrdernarPorPreco());

        Map<String, Livro> livrosOrdenados = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> entry : livrosOrdenadosPreco) {
            livrosOrdenados.put(entry.getKey(), entry.getValue());
        }
        return livrosOrdenados;
    }

    public Map<String, Livro> pesquisaLivrosPorAutor(String autor) {
        Map<String, Livro> resultado = new HashMap<>();


        if (!livroMap.isEmpty()) {
            for (Map.Entry<String, Livro> livros : livroMap.entrySet()) {
                if (livros.getValue().getAutor().equalsIgnoreCase(autor)){
                    resultado.put(livros.getKey(),livros.getValue());
                }
            }
        }
        return resultado;
    }

    public String obterLivroMaisCaro(){
        double valorLivroMaisCaro = Double.MIN_VALUE;
        String nomeLivro = null;
        String autor = null;


        if (!livroMap.isEmpty()){
            for (Map.Entry<String, Livro> livros : livroMap.entrySet()){
                if (livros.getValue().getPreco() > valorLivroMaisCaro){
                    valorLivroMaisCaro = livros.getValue().getPreco();
                    nomeLivro = livros.getValue().getTitulo();
                    autor = livros.getValue().getAutor();
                }
            }
        }

        return "O livro mais caro é: " + nomeLivro + " do autor " + autor + " com valor de: " + valorLivroMaisCaro;
    }

    public String obterLivroMaisBarato(){
        double valorLivroMaisBarato = Double.MAX_VALUE;
        String nomeLivro = null;
        String autor = null;

        if (!livroMap.isEmpty()){
            for (Map.Entry<String,Livro> livros : livroMap.entrySet()){
                if (livros.getValue().getPreco() < valorLivroMaisBarato ){
                    valorLivroMaisBarato = livros.getValue().getPreco();
                    nomeLivro = livros.getValue().getTitulo();
                    autor = livros.getValue().getAutor();

                }
            }

        }
        return "O livro mais barato é: " + nomeLivro + " do autor " + autor + " com valor de: " + valorLivroMaisBarato;
    }


    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adicionarLivro("Link 1", new Livro("Livro 9", "autor 9", 2.65d) );
        livrariaOnline.adicionarLivro("Link 2", new Livro("Livro 2", "autor 2", 15.00d));
        livrariaOnline.adicionarLivro("Link 3", new Livro("Livro 1", "autor 1", 50.00d));
        livrariaOnline.adicionarLivro("Link 4", new Livro("Livro 5", "autor 5", 25.00d));

        System.out.println(livrariaOnline);
        //ordernar livros por preco
        //System.out.println(livrariaOnline.exibirLivrosPorPreco());

        //remover livro
        //livrariaOnline.removerLivro("Livro 5");
        //System.out.println(livrariaOnline);

        //Pesquisar livro por autor
        //System.out.println(livrariaOnline.pesquisaLivrosPorAutor("Autor 1"));

        //obter livro mais caro da livraria
        System.out.println(livrariaOnline.obterLivroMaisCaro());
        System.out.println(livrariaOnline.obterLivroMaisBarato());


    }
}

