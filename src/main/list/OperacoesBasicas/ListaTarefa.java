package main.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ListaTarefa {
    private List<Tarefa> tarefaList;

    public ListaTarefa() {
        this.tarefaList = new ArrayList<>();
    }

    public void adiccionarTarefa(String descricao) {
        tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        List<Tarefa> tarefasParaRemover = new ArrayList<>();

        for (Tarefa t : tarefaList) {
            if (t.getDescicao().equalsIgnoreCase(descricao)) {
                tarefasParaRemover.add(t);
            }
        }
        tarefaList.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotalTarefas() {
        return tarefaList.size();
    }

    public void obterDescricoesTarefas() {
        System.out.println(tarefaList);
    }

    public void pesquisarTarefa(String tarefaPesquisada) {

        Predicate<Tarefa> tarefaEncontrada = t -> t.getDescicao().equalsIgnoreCase(tarefaPesquisada);

        List<Tarefa> resultado = this.tarefaList.stream()
                .filter(tarefaEncontrada)
                .toList();

        resultado.stream().forEach(System.out::println);

    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();
        //System.out.println("O numero total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.adiccionarTarefa("Tarefa 1");
        listaTarefa.adiccionarTarefa("Tarefa 1");
        listaTarefa.adiccionarTarefa("Tarefa 2");
        //System.out.println("O numero total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());

        //listaTarefa.removerTarefa("Tarefa 2");
        //System.out.println("O numero total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());

        //listaTarefa.obterDescricoesTarefas();

        //Pesquisar tarefa utilizando um lambda
        listaTarefa.pesquisarTarefa("Tarefa 1");
    }

}
