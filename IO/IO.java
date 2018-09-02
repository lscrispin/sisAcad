package IO;

import App.SisAcad;
import Dominio.*;

import java.util.ArrayList;
import java.util.Scanner;

public class IO {

    private static Scanner tec = new Scanner(System.in);

    private static SisAcad sis = new SisAcad();

    private static void addUnidade(){
        System.out.println("Digite o nome da unidade:");
        tec.nextLine();
        String nome = tec.nextLine();
        Unidade nova = new Unidade(nome);
        sis.addUnidade(nova);
    }

    private static void addProfessor(){
        System.out.println("Digite o nome do professor:");
        tec.nextLine();
        String nome = tec.nextLine();
        System.out.println("Digite a matricula do professor:");
        int mat = tec.nextInt();
        ArrayList<Unidade> unidades = sis.getUnidades();
        for(Unidade u: unidades){
            System.out.printf("%d - %s", unidades.indexOf(u), u.getNome());
        }
        System.out.println("Digite o numero da unidade:");
        int sel = tec.nextInt();
        Unidade uni = unidades.get(sel);
        new Professor(nome, mat, uni);
    }

    private static void addCoordenador(){
        System.out.println("Digite o nome do coordenador:");
        tec.nextLine();
        String nome = tec.nextLine();
        System.out.println("Digite a matricula do coordenador:");
        int mat = tec.nextInt();
        ArrayList<Unidade> unidades = sis.getUnidades();
        for(Unidade u: unidades){
            System.out.printf("%d - %s\n", unidades.indexOf(u), u.getNome());
        }
        System.out.println("Digite o numero da unidade:");
        int sel = tec.nextInt();
        Unidade uni = unidades.get(sel);
        new Coordenador(nome, mat, uni);//TODO TIRAR DUVIDA SOBRE CONSTRUTORES
    }

    private static void addCurso(){
        ArrayList<Unidade> unidades = sis.getUnidades();
        for(Unidade u: unidades){
            System.out.printf("%d - %s\n", unidades.indexOf(u), u.getNome());
        }
        System.out.println("Digite o numero da unidade do curso:");
        int sel = tec.nextInt();
        Unidade uni = unidades.get(sel);
        tec.reset();
        System.out.println("Digite o nome do curso:");
        tec.nextLine();
        String nome = tec.nextLine();
        ArrayList<Professor> professores = uni.getProfessores();
        for(Professor p: professores){
            System.out.printf("%d - %s\n", professores.indexOf(p), p.getNome());
        }
        System.out.println("Digite o numero do coordenador do curso:");
        sel = tec.nextInt();
        Coordenador coord = (Coordenador)professores.get(sel);
        System.out.println("Digite o codigo do curso:");
        String codigo = tec.next();
        System.out.println("Digite a carga horaria do curso:");
        int ch = tec.nextInt();
        sis.addCurso(new Curso(nome, codigo, ch, uni, coord));
    }

    private static void addAluno(){
        System.out.println("Digite o nome do aluno:");
        tec.nextLine();
        String nome = tec.nextLine();
        int mat = tec.nextInt();
        ArrayList<Curso> cursos = sis.getCursos();
        for(Curso c: cursos){
            System.out.printf("%d - Curso:%s - Unidade:%s\n", cursos.indexOf(c), c.getNome(), (c.getUnidade()).getNome());
        }
        System.out.println("Digite o numero do curso");
        int sel = tec.nextInt();
        Curso curso = cursos.get(sel);
        new Aluno(nome, mat, curso);
    }

    private static void addDisciplina(){
        System.out.println("Digite o nome da disciplina:");
        tec.nextLine();
        String nome = tec.nextLine();
        System.out.println("Digite a carga horaria:");
        int ch = tec.nextInt();
        ArrayList<Curso> cursos = sis.getCursos();
        for(Curso c: cursos){
            System.out.printf("%d - %s\n", cursos.indexOf(c), c.getNome());
        }
        int sel = tec.nextInt();
        Curso curso = cursos.get(sel);
        new Disciplina(nome, ch, curso);
    }

    private static void addTurma(){
        ArrayList<Curso> cursos = sis.getCursos();
        for(Curso c: cursos){
            System.out.printf("%d - %s\n",cursos.indexOf(c), c.getNome());
        }
        System.out.println("Digite o numero do curso");
        int sel = tec.nextInt();
        Curso curso = cursos.get(sel);
        ArrayList<Disciplina> disciplinas = curso.getDisciplinas();
        for(Disciplina d: disciplinas){
            System.out.printf("%d - %s\n", disciplinas.indexOf(d), d.getNome());
        }
        System.out.println("Digite o numero da disciplina:");
        sel = tec.nextInt();
        Disciplina disc = disciplinas.get(sel);
        ArrayList<Professor> professores = (curso.getUnidade()).getProfessores();
        for(Professor p: professores){
            System.out.printf("%d - %s\n", professores.indexOf(p), p.getNome());
        }
        System.out.println("Digite o numero do professor:");
        sel = tec.nextInt();
        Professor prof = professores.get(sel);
        System.out.println("Digite o codigo da turma:");
        String cod = tec.next();
        new Turma(cod, prof, disc);
    }

    private static void addInscricao(){
        ArrayList<Curso> cursos = sis.getCursos();
        for(Curso c: cursos){
            System.out.printf("%d - %s\n", cursos.indexOf(c), c.getNome());
        }
        System.out.println("Digite o numero do curso:");
        int sel = tec.nextInt();
        ArrayList<Aluno> alunos = (cursos.get(sel)).getAlunos();
        for(Aluno a: alunos){
            System.out.printf("%d - %s\n", alunos.indexOf(a), a.getNome());
        }
        System.out.println("Digite o numero do aluno:");
        sel = tec.nextInt();
        Aluno aluno = alunos.get(sel);
        ArrayList<Disciplina> disciplinas = (aluno.getCurso()).getDisciplinas();
        for(Disciplina d: disciplinas){
            System.out.printf("%d - %s\n", disciplinas.indexOf(d), d.getNome());
        }
        System.out.println("Digite o numero da disciplina:");
        sel = tec.nextInt();
        Disciplina disc = disciplinas.get(sel);
        ArrayList<Turma> turmas = disc.getTurmas();
        for(Turma t: turmas){
            System.out.printf("%d - %s - Professor: %s\n", turmas.indexOf(t), t.getCodigo(), (t.getProfessor()).getNome());
        }
        System.out.println("Digite o numero da turma:");
        sel = tec.nextInt();
        Turma turma = turmas.get(sel);
        System.out.println("Digite a media obtida na materia:");
        float nota = tec.nextFloat();
        System.out.println("Digite o periodo (AA.1 ou 2)");
        String sem = tec.next();
        new Inscricao(aluno, nota, sem, turma);
    }

    public static void menu(){
        int sel = 1;
        while(sel != 0){
            System.out.println("Digite 1 para adicionar alunos\n" +
                    "Digite 2 para adicionar professores\n" +
                    "Digite 3 para inscrever alunos em turmas\n" +
                    "Digite 4 para adicionar coordenador\n" +
                    "Digite 5 para adicionar disciplinas\n" +
                    "Digite 6 para adicionar turmas\n" +
                    "Digite 7 para adicionar curso\n" +
                    "Digite 8 para adicionar unidade\n" +
                    "Digite 0 para sair");
            sel = tec.nextInt();
            switch(sel){
                case 1:
                    addAluno();
                    break;
                case 2:
                    addProfessor();
                    break;
                case 3:
                    addInscricao();
                    break;
                case 4:
                    addCoordenador();
                    break;
                case 5:
                    addDisciplina();
                    break;
                case 6:
                    addTurma();
                    break;
                case 7:
                    addCurso();
                    break;
                case 8:
                    addUnidade();
            }
        }
    }
}
