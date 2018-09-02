package App;

import Dominio.*;

import java.util.ArrayList;
import java.util.Scanner;

public class SisAcad {

    private ArrayList<Unidade> unidades;
    private ArrayList<Curso> cursos;

    public SisAcad(){
        this.unidades = new ArrayList<Unidade>();
        this.cursos = new ArrayList<Curso>();
    }

    public void addCurso(Curso novo){
        this.cursos.add(novo);
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

    public ArrayList<Unidade> getUnidades(){ return this.unidades; }

    public ArrayList<Curso> getCursos(){return this.cursos;}

}
