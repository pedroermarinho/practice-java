/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedroermarinho
 */
public class AlunoController {
    
    List<Aluno> alunos = new ArrayList<>();
    
    List<Aluno> listar(){
        return alunos;
    }
                
    void inserir(Aluno aluno){
        this.alunos.add(aluno);
    } 
}
