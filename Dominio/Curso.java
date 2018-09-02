package Dominio;

import java.util.ArrayList;

public class Curso {
    private String nome;
    private String codigo;
    private int ch;
    private ArrayList<Aluno> alunos;
    private ArrayList<Disciplina> disciplinas;
    private Unidade unidade;
    private Coordenador coordenador;

    public Curso(String _nome, String _codigo, int _ch, Unidade _unidade, Coordenador _coordenador){
        this.nome = _nome;
        this.codigo = _codigo;
        this.ch = _ch;
        this.unidade = _unidade;
        this.unidade.addCurso(this);
        this.alunos = new ArrayList<Aluno>();
        this.disciplinas = new ArrayList<Disciplina>();
        this.coordenador = _coordenador;
        this.coordenador.setCurso(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCh() {
        return ch;
    }

    public void setCh(int ch) {
        this.ch = ch;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Coordenador getCoordenador() {
        return this.coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

    public ArrayList<Aluno> getAlunos(){
        return this.alunos;
    }

    public ArrayList<Disciplina> getDisciplinas(){
        return this.disciplinas;
    }

    public void addAluno(Aluno _aluno){
        this.alunos.add(_aluno);
    }

    public void addDisciplina(Disciplina _disciplina){
        this.disciplinas.add(_disciplina);
    }
}
