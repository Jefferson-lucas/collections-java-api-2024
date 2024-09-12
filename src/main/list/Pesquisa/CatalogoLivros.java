package main.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    //atributo

    private List<Livro> livroList;

    public CatalogoLivros() {
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
        livroList.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor){

        List<Livro> livrosPorAutor = new ArrayList<>();
        if(!livroList.isEmpty()){
            for(Livro l : livroList){
                if(l.getAutor().equalsIgnoreCase(autor)){
                    livrosPorAutor.add(l);
                }
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisaPorIntervaloDeAnos(int anoInicial, int anoFinal){
        List<Livro> livroPorIntervaloDeAnos = new ArrayList<>();

        if(!livroList.isEmpty()){
            for(Livro l : livroList){
                if(l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal) {
                    livroPorIntervaloDeAnos.add(l);
                }
            }
        }
        return livroPorIntervaloDeAnos;
    }

    public Livro pesquisarPorTitulo (String titulo) throws ExceptioListaVazia{
        Livro livroPorTitulo = null;

        if(!livroList.isEmpty()){
            for(Livro l : livroList){
                if(l.getTitulo().equalsIgnoreCase(titulo)){
                    livroPorTitulo = l;
                    break;
                }
            }
        }

        if(livroPorTitulo == null){
            throw new ExceptioListaVazia();
        }
        else {
            return livroPorTitulo;
        }
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 2020);
        catalogoLivros.adicionarLivro("Livro 1", "Autor 2", 2021);
        catalogoLivros.adicionarLivro("Livro 2", "Autor 2", 2022);
        catalogoLivros.adicionarLivro("Livro 3", "Autor 3", 2023);
        catalogoLivros.adicionarLivro("Livro 4", "Autor 4", 1994);

        //Pesquisar por autor
        System.out.println(catalogoLivros.pesquisarPorAutor("Autor 2"));

        //Pesquisar por intervalo de anos
        System.out.println(catalogoLivros.pesquisaPorIntervaloDeAnos(2020,2022));

        //Pesquisar por titulo do livro - IMplementando tratamento de exceção
        try{
            System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 4"));
        }catch (ExceptioListaVazia e){
            System.out.println("Não foram encontrados Livros com este título");
        }

    }
}
