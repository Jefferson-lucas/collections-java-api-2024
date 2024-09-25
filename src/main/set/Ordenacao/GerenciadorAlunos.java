package main.set.Ordenacao;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    //atributos

    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(Long matricula, String nome, double nota){
        this.alunoSet.add(new Aluno(matricula,nome, nota));
    }

    public void removerAluno(Long matricula){
        Aluno alunoRemover = null;

        if(!alunoSet.isEmpty()){
            for (Aluno a : alunoSet){
                if (a.getMatricula().longValue() == matricula.longValue()){
                    alunoRemover = a;
                    break;
                }
            }
            alunoSet.remove(alunoRemover);
        }
    }

    public Set<Aluno> exibirAlunosPorNome(){
        Set<Aluno> alunos = new TreeSet<>(alunoSet);
        return alunos;
    }


    public Set<Aluno> exibirAlunoPorNota(){
        Set<Aluno> alunosPorNota = new TreeSet<>(new ComparePorNota());
        alunosPorNota.addAll(alunoSet);
        return alunosPorNota;
    }

    public void exibirAlunos(){
        System.out.println(alunoSet);
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno(1234L,"Jose",8);
        gerenciadorAlunos.adicionarAluno(1235L,"Mateus",1);
        gerenciadorAlunos.adicionarAluno(1236L,"André",4);

        gerenciadorAlunos.exibirAlunos();

        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());

        gerenciadorAlunos.removerAluno(1234L);
        System.out.println(gerenciadorAlunos.exibirAlunoPorNota());



    }
}
