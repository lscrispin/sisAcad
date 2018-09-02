package Dominio;

public class Inscricao {
    private Aluno aluno;
    private float media;
    private boolean passou;
    private String semestre;
    private Turma turma;

    public Inscricao(Aluno _aluno, float _media, String _semestre, Turma _turma){
        this.aluno = _aluno;
        this.media = _media;
        if(media >= 6) this.passou = true;
        else this.passou = false;
        this.semestre = _semestre;
        this.turma = _turma;
        this.aluno.addInsc(this);
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public boolean isPassou() {
        return passou;
    }

    public void setPassou(boolean passou) {
        this.passou = passou;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
