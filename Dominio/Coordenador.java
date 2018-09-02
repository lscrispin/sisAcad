package Dominio;

import java.util.ArrayList;

public class Coordenador extends Professor{
    private Curso curso;

    public Coordenador(String _nome, int _matricula, Unidade u){
        this.setNome(_nome);
        this.setMatricula(_matricula);
        this.setTurmas(new ArrayList<Turma>());
        this.setUnidade(u);
        u.addProfessor(this);
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
