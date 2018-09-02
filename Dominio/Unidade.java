package Dominio;

import java.util.ArrayList;

public class Unidade {
    private String nome;
    private ArrayList<Professor> professores;
    private ArrayList<Curso> cursos;

    public Unidade(String _nome){
        this.nome = _nome;
        this.professores = new ArrayList<Professor>();
        this.cursos = new ArrayList<Curso>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Curso> getCursos(){
        return this.cursos;
    }

    public ArrayList<Professor> getProfessores(){return this.professores;}

    public void addCurso(Curso _curso){
        this.cursos.add(_curso);
    }

    public void addProfessor(Professor novo) {this.professores.add(novo);}


}
