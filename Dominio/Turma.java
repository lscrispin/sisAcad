package Dominio;

import java.util.ArrayList;

public class Turma {
    private String codigo;
    private Professor professor;
    private Disciplina disciplina;
    private ArrayList<Inscricao> inscricoes;

    public Turma(String _cod, Professor _prof, Disciplina _disciplina){
        this.codigo = _cod;
        this.professor = _prof;
        this.professor.addTurma(this);
        this.disciplina = _disciplina;
        this.disciplina.addTurma(this);
        this.inscricoes = new ArrayList<Inscricao>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public ArrayList<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(ArrayList<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }
}
