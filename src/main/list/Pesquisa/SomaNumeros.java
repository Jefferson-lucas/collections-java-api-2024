package main.list.Pesquisa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SomaNumeros {
    //atributos
    List<Integer> integerList = new ArrayList<>();

    @Override
    public String toString() {
        return "SomaNumeros{" +
                "integerList=" + integerList +
                '}';
    }

    public void adicionarNumero(int numero){
        integerList.add(numero);
    }


    public int calculaSoma(){
        int totalSoma = 0;
        if(!integerList.isEmpty()) {
            for (Integer i : integerList) {
                totalSoma += i;
            }
        }
        return totalSoma;
    }

    public int encontrarMaiorNumero(){
        int maiorNumero = 0;
        maiorNumero = Integer.MIN_VALUE;
        if(!integerList.isEmpty()){
            for(Integer i : integerList){
                if(i>maiorNumero){
                    maiorNumero = i;
                }
            }
        }
       return maiorNumero;
    }

    public int encontrarMenorNumero(){
        int menorNumero = 0;
        menorNumero = Integer.MAX_VALUE;
        if (!integerList.isEmpty()){
            for (Integer i : integerList){
                if (i < menorNumero){
                    menorNumero = i;
                }
            }
        }
        return menorNumero;
    }

    public void exibirNumeros(){
        System.out.println("A lista de números adicionados é: " + integerList);
    }


    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        //adicionando números a lista
        somaNumeros.adicionarNumero(35);
        somaNumeros.adicionarNumero(2);
        somaNumeros.adicionarNumero(3);
        somaNumeros.adicionarNumero(4);
        somaNumeros.adicionarNumero(20);


        //calcular a soma dos números
        System.out.println("O somatório dos números é: " + somaNumeros.calculaSoma());

        //retorna maior número
        System.out.println("O maior número é: " + somaNumeros.encontrarMaiorNumero());

        //retorna menor número
        System.out.println("O maior número é: " + somaNumeros.encontrarMenorNumero());

        //exibir Lista de Números
        somaNumeros.exibirNumeros();
    }

}
