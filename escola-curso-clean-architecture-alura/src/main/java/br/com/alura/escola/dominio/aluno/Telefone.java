package br.com.alura.escola.dominio.aluno;

public class Telefone {
    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {

        if(ddd==null|| numero ==null){
            throw new IllegalArgumentException("DDD e Numero são obrigatorios");
        }

        if(!ddd.matches("\\d{2}")){
            throw new IllegalArgumentException("DDD invalido");
        }
        if (!numero.matches("\\d{8}|\\d{9}")){
            throw new IllegalArgumentException("Numero invalido");
        }

        this.ddd = ddd;
        this.numero = numero;
    }
}
