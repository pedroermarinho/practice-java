/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula;

import java.util.*;

/**
 *
 * @author pedroermarinho
 */
public class AlunoController {
    
    private List<Aluno> alunos = new ArrayList();
    private Scanner scanner = new Scanner(System.in);
    
    List<Aluno> listar(){
       return this.alunos;
    } 
    
    void inserir(Aluno aluno){
        this.alunos.add(aluno);
    }
    
    void cadastrar(){
        System.out.println("----------------------------------------------");
        Aluno aluno = new Aluno();
        System.out.print("Nome:");
        aluno.setNome(scanner.next());
        System.out.print("Matricula:");
        aluno.setMatricula(scanner.nextInt());
        System.out.print("nota1:");
        aluno.setNota1(scanner.nextInt());
        System.out.print("nota2:");
        aluno.setNota2(scanner.nextInt());
        System.out.print("nota3:");
        aluno.setNota3(scanner.nextInt());
        aluno.setMedia((aluno.getNota1()+aluno.getNota2()+aluno.getNota3())/3);
        inserir(aluno);
    }
    
    void mostrar(){
        for (Aluno aluno: listar()) {
            System.out.println("----------------------------------------------");
            System.out.println("Matricula->"+aluno.getMatricula());
            System.out.println("Nome->"+aluno.getNome());
            System.out.println("nota1->"+aluno.getNota1());
            System.out.println("nota2->"+aluno.getNota2());
            System.out.println("nota3->"+aluno.getNota3());
            System.out.println("media->"+aluno.getMedia());
        }
    }
    
}
