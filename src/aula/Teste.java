/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula;

/**
 *
 * @author pedroermarinho
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlunoController controller = new AlunoController();
        
        controller.inserir(new Aluno(
        123,"fulano0","234234-3","234.234.234-34","01/20/2000"
        ));
        controller.inserir(new Aluno(
        344,"fulano1","234234-3","234.234.234-34","01/20/2000"
        ));
        controller.inserir(new Aluno(
        345,"fulano2","234234-3","234.234.234-34","01/20/2000"
        ));
        controller.inserir(new Aluno(
        574,"fulano3","234234-3","234.234.234-34","01/20/2000"
        ));
        
        for (Aluno aluno : controller.listar()) {
            System.out.println("Nome->"+aluno.getNome());
            System.out.println("Matricula->"+aluno.getMatricula());
            System.out.println("rg->"+aluno.getRg());
        }
        
    }
    
}
