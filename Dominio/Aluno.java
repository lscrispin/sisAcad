package Dominio;

import java.util.ArrayList;

public class Aluno {
    private String nome;
    private int matricula;
    private float cr;
    private ArrayList<Inscricao> inscricoes;
    private Curso curso;

    public Aluno(){

    }

    public Aluno(String _nome, int _matricula, Curso _curso){
        this.nome = _nome;
        this.matricula = _matricula;
        this.cr = 0;
        this.inscricoes = new ArrayList<Inscricao>();
        this.curso = _curso;
        this.curso.addAluno(this);
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

    public float getCr() {
        return cr;
    }

    public void setCr(float cr) {
        this.cr = cr;
    }

    public ArrayList<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(ArrayList<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void addInsc(Inscricao i){
        this.inscricoes.add(i);
        float soma = 0f;
        int qtd = 0;
        for(Inscricao ins: this.inscricoes){
            qtd ++;
            soma += ins.getMedia();
        }
        this.setCr(soma/(float)qtd);
    }
}
