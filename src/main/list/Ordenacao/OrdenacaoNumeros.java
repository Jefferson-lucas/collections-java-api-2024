package main.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros{
    //atributos
    private List<Integer> integerList;

    public OrdenacaoNumeros() {
        this.integerList = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        this.integerList.add(numero);
    }

    public List<Integer> ordernarAscendente(){
        List<Integer> ordenacaoAscendente = new ArrayList<>(this.integerList);
        if (!this.integerList.isEmpty()){
            Collections.sort(ordenacaoAscendente);
            return ordenacaoAscendente;
        }else {
            throw new RuntimeException("A lista está vazia");
        }
    }

    public List<Integer> ordenarDescendente() {
        List<Integer> ordenacaoDescendente = new ArrayList<>(this.integerList);
        if (!this.integerList.isEmpty()){
            ordenacaoDescendente.sort(Collections.reverseOrder());
            return ordenacaoDescendente;
        }else {
            throw new RuntimeException("A lista está vazia");
        }
    }

    public static void main(String[] args) {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();

        ordenacaoNumeros.adicionarNumero(5);
        ordenacaoNumeros.adicionarNumero(2);
        ordenacaoNumeros.adicionarNumero(3);
        ordenacaoNumeros.adicionarNumero(4);
        ordenacaoNumeros.adicionarNumero(9);
        ordenacaoNumeros.adicionarNumero(0);

        System.out.println(ordenacaoNumeros);
        System.out.println("A ordenação ascentende do conjunto de números é: " + ordenacaoNumeros.ordernarAscendente());
        System.out.println("A ordenação Desccentende do conjunto de números é: " + ordenacaoNumeros.ordenarDescendente());
    }

}