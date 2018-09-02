package Dominio;

import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private int ch;
    private ArrayList<Turma> turmas;
    private Curso curso;

    public Disciplina(String _nome, int _ch, Curso _curso){
        this.nome = _nome;
        this.ch = _ch;
        this.curso = _curso;
        this.curso.addDisciplina(this);
        this.turmas = new ArrayList<Turma>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCh() {
        return ch;
    }

    public void setCh(int ch) {
        this.ch = ch;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void addTurma(Turma _turma){
        this.turmas.add(_turma);
    }

    public ArrayList<Turma> getTurmas(){
        return this.turmas;
    }
}
