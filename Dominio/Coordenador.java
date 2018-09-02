package Dominio;

public class Coordenador extends Professor{
    private Curso curso;

    public Coordenador(String nome, int matricula){
        this.setNome(nome);
        this.setMatricula(matricula);
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
