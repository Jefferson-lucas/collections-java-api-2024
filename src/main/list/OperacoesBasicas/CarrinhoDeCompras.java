package main.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> listaDeItens;

    public CarrinhoDeCompras() {
        this.listaDeItens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        listaDeItens.add(new Item(nome,preco,quantidade));
    }

    public void removerItem(String nome){
        List<Item> itensRemover = new ArrayList<>();

        for(Item item : listaDeItens){
            if(item.getNome().equalsIgnoreCase(nome)){
                itensRemover.add(item);
            }
        }
        listaDeItens.removeAll(itensRemover);
    }

    public void calcularValorTotal(){
        double valorTotal = 0.0;
        int quantidadeItensNoCarrinho = 0;

        for(Item item : listaDeItens){
            valorTotal += (item.getPreco() * item.getQuantidade());
            quantidadeItensNoCarrinho +=item.getQuantidade();
        }
        System.out.println("A quantidade de Itens no carrinho é: " + quantidadeItensNoCarrinho + " e valor total de itens é: " + valorTotal);
    }

    public void exibirItens(){
        System.out.println(listaDeItens);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Arroz",7.95,2);
        carrinhoDeCompras.adicionarItem("Feijão",5.5,1);
        carrinhoDeCompras.adicionarItem("Macarrão",2,1);

        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.removerItem("Macarrão");

        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.calcularValorTotal();
    }
}
