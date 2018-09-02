package App;

import Dominio.*;

import java.util.ArrayList;
import java.util.Scanner;

public class SisAcad {

    private ArrayList<Unidade> unidades;

    public SisAcad(){
        this.unidades = new ArrayList<Unidade>();
    }

    public Curso addCurso(Curso novo, Unidade u){
        if(this.unidades.contains(u)){
            u.addCurso(novo);
            return novo;
        }else return null;
    }

    public void addUnidade(Unidade nova){
        this.unidades.add(nova);
    }

    public Professor addProfessor(Professor novo, Unidade u){
        if(this.unidades.contains(u)){
            u.addProfessor(novo);
            return novo;
        }else return null;
    } 

    public ArrayList<Curso> getCursos(Unidade u){
        if(unidades.contains(u)) return u.getCursos();
        else return null;
    }

    public ArrayList<Unidade> getUnidades(){
        return this.unidades;
    }



    private static Curso getCursos(ArrayList<Curso> cursos, Scanner tec){
        System.out.println("Digite o numero do seu curso:");
        for(Curso c: cursos){
            System.out.printf("%d - %s\n", cursos.indexOf(c), c.getNome());
        }
        return cursos.get(tec.nextInt());
    }

    private static Unidade getUnidade(ArrayList<Unidade> unidades, Scanner tec){
        System.out.println("Digite o numero da unidade:");
        for(Unidade c: unidades){
            System.out.printf("%d - %s\n", unidades.indexOf(c), c.getNome());
        }
        return unidades.get(tec.nextInt());
    }

    private static Professor getProfessor(ArrayList<Professor> profs, Scanner tec){
        ArrayList<Professor> professores = profs;
        System.out.println("Digite o numero do professor:");
        for(Professor p: professores){
            System.out.printf("%d - %s\n", professores.indexOf(p), p.getNome());
        }
        return professores.get(tec.nextInt());
    }

    private static Aluno getAlunoCurso(Curso curso, Scanner tec){
        ArrayList<Aluno> alunos = curso.getAlunos();
        for(Aluno a: alunos){
            System.out.printf("%d - %s\n", alunos.indexOf(a), a.getNome());
        }
        return alunos.get(tec.nextInt());
    }

    private static Disciplina getMateriaCurso(Curso curso, Scanner tec){
        ArrayList<Disciplina> disciplinas = curso.getDisciplinas();
        System.out.println("Digite o numero da disciplina:");
        for(Disciplina a: disciplinas){
            System.out.printf("%d - %s\n", disciplinas.indexOf(a), a.getNome());
        }
        return disciplinas.get(tec.nextInt());
    }

    private static Turma getTurmaMateria(Disciplina dis, Scanner tec){
        ArrayList<Turma> turmas = dis.getTurmas();
        System.out.println("Digite o numero da turma:");
        for(Turma a: turmas){
            System.out.printf("%d - Turma: %s - Professor: %s\n", turmas.indexOf(a), a.getCodigo(), a.getProfessor().getNome());
        }
        return turmas.get(tec.nextInt());
    }

    private static void printInsc(Aluno aluno){
        ArrayList<Inscricao> inscricoes = aluno.getInscricoes();
        for(Inscricao a: inscricoes){
            System.out.printf("%s\nPeriodo: %s\nNota: %.2f\n\n", ((a.getTurma()).getDisciplina()).getNome(), a.getSemestre(), a.getMedia());
        }

    }

    private static Coordenador getCoord(ArrayList<Professor> profs, Scanner tec){
        ArrayList<Professor> professores = profs;
        System.out.println("Digite o numero do coordenador:");
        for(Professor p: professores){
            System.out.printf("%d - %s\n", professores.indexOf(p), p.getNome());
        }
        return (Coordenador)professores.get(tec.nextInt());
    }

    public static void interfaceSis(){
        int sel = 1;
        int selAux = 0;
        int ch, matricula;
        String nome, codigo, semestre;
        float nota;
        Aluno aluno;
        Coordenador coord;
        Professor prof;
        Curso curso;
        ArrayList<Unidade> unidades = new ArrayList<Unidade>();
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        ArrayList<Professor> professores = new ArrayList<Professor>();

        Scanner teclado = new Scanner(System.in);

        while(sel != 0){
            System.out.println("Digite 0 para sair\n" +
                               "Digite 1 para alunos\n" +
                               "Digite 2 para coordenadores\n" +
                               "Digite 3 para professores");

            sel = teclado.nextInt();

            switch (sel){
                case 1:
                    System.out.println("Digite 1 para inscrever materias\n" +
                                       "Digite 2 para ver historico\n" +
                                       "Digite 3 para novo aluno");
                    selAux = teclado.nextInt();
                    switch (selAux){
                        case 1:
                            aluno = getAlunoCurso(getCursos(cursos, teclado), teclado);
                            System.out.printf("Bem vindo %s!\n\n", aluno.getNome());
                            System.out.println("Digite a media da materia:");
                            nota = teclado.nextFloat();
                            System.out.println("Digite o semestre:");
                            semestre = teclado.next();
                            new Inscricao(aluno, nota, semestre, getTurmaMateria(getMateriaCurso(aluno.getCurso(), teclado), teclado));
                            break;
                        case 2:
                            aluno = getAlunoCurso(getCursos(cursos, teclado), teclado);
                            System.out.printf("Bem vindo %s!\nSeu cr: %.2f\n\n", aluno.getNome(), aluno.getCr());
                            printInsc(aluno);
                            break;
                        case 3:
                            teclado.reset();
                            System.out.println("Digite o nome do aluno:");
                            nome = teclado.next();
                            teclado.reset();
                            System.out.println("Digite a matricula do aluno:");
                            matricula = teclado.nextInt();
                            curso =  getCursos(cursos, teclado);
                            new Aluno(nome, matricula, curso);
                            break;
                    }
                    break;
                case 2 :
                    System.out.println("Digite 1 para criar materias\n" +
                            "Digite 2 para criar cursos\n" +
                            "Digite 3 para novo coordenador\n" +
                            "Digite 4 para nova unidade");
                    selAux = teclado.nextInt();
                    switch (selAux) {
                        case 1:
                            teclado.reset();
                            System.out.println("Digite o nome da disciplina:");
                            nome = teclado.next();
                            teclado.reset();
                            System.out.println("Digite a carga horaria da disciplina:");
                            ch = teclado.nextInt();
                            curso = getCursos(cursos, teclado);
                            new Disciplina(nome, ch, curso);
                            break;
                        case 2:
                            coord = getCoord(professores, teclado);
                            teclado.reset();
                            System.out.println("Digite o nome do curso:");
                            nome = teclado.next();
                            teclado.reset();
                            System.out.println("Digite o codigo do curso:");
                            codigo = teclado.next();
                            System.out.println("Digite a carga horaria do curso:");
                            ch = teclado.nextInt();
                            cursos.add(new Curso(nome, codigo, ch, getUnidade(unidades, teclado), coord));
                            break;
                        case 3:
                            teclado.reset();
                            System.out.println("Digite o nome do coordenador:");
                            nome = teclado.next();
                            teclado.reset();
                            System.out.println("Digite a matricula do coordenador:");
                            matricula = teclado.nextInt();
                            professores.add(new Coordenador(nome, matricula));
                            break;
                        case 4:
                            teclado.reset();
                            System.out.println("Digite o nome da unidade:");
                            nome = teclado.next();
                            unidades.add(new Unidade(nome));
                            teclado.reset();
                            break;
                    }
                    break;

                case 3:
                    System.out.println("Digite 1 para criar turmas\n" +
                                       "Digite 2 para novo professor\n");
                    selAux = teclado.nextInt();
                    switch(selAux) {
                        case 1:
                            prof = getProfessor(professores, teclado);
                            System.out.println("Digite o codigo da turma:");
                            codigo = teclado.next();
                            new Turma(codigo, prof, getMateriaCurso(getCursos(cursos, teclado), teclado));
                            break;
                        case 2:
                            System.out.println("Digite o nome do professor");
                            nome = teclado.next();
                            System.out.println("Digite a matricula do professor");
                            matricula = teclado.nextInt();
                            professores.add(new Professor(nome, matricula));
                    }
            }
        }
    }

}
