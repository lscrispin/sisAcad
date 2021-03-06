package Dominio;

import java.util.ArrayList;

public class Professor {
    private String nome;
    private int matricula;
    private Unidade unidade;
    private ArrayList<Turma> turmas;

    public Professor(){

    }

    public Professor(String _nome, int _matricula, Unidade u){
        this.nome = _nome;
        this.matricula = _matricula;
        this.turmas = new ArrayList<Turma>();
        this.unidade = u;
        u.addProfessor(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Turma[] getTurma(){
        return (Turma[])this.turmas.toArray();
    }

    public void addTurma(Turma turma){
        this.turmas.add(turma);
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }
}
