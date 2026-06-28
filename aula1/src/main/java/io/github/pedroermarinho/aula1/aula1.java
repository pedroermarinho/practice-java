package io.github.pedroermarinho.aula1;

public class aula1 {

    public static void main(String[] args) {

        /// -------------------------------------------------
        /// String -> Texto
        /// int -> Numero (reais) (-1,-2,-3, 1, 2, 3)
        /// float -> Numero (decimais) (-1.5, -2.5, 3.4, 5.6)
        /// double -> Numero (decimais) (-1.5, -2.5, 3.4, 5.6)
        /// boolean -> Verdadeiro ou Falso
        /// -------------------------------------------------
        /// BigDecimal -> Numero (decimais) com alta precisão

        String nome = "Pedro";
        int idade = 17;
        float altura = 1.75f;
        double peso = 70.5;
        boolean estudante = false;


        System.out.println("ola mundo");
        System.out.println("Nome:"+nome);
        System.out.println("Idade:"+idade);
        System.out.println("Altura:"+altura);
        System.out.println("Peso:"+peso);
        System.out.println("É estudante?:"+estudante);


        /// estruturas condicionais
        /// se idade for maior que 18 escreva você já maior de idade, caso contrario escreva acesso negado
        /// if -> se/caso
        /// else -> caso contrario

        if(idade >= 18){ // se + condição
            System.out.println("Você já é maior de idade");//ação
        } else {// caso contrario
            System.out.println("Acesso negado"); // ação
        }

        /// operadores lógicos
        /// && -> E
        /// || -> OU
        /// ! -> NÃO

        if (idade >= 18 && estudante){
            System.out.println("Você é maior de idade e estudante");
        }

        if (idade >= 18 || estudante){
            System.out.println("Você é maior de idade ou estudante");
        }

        //estudante = true > pass;
        // estudate = false > pass;


        if (!estudante){ // somente passa se valor for verdadeiro
            System.out.println("Você não é estudante");
        }

        if (estudante == false){
            System.out.println("Você não é estudante");
        }


        /// tabela verdade
        ///  verdadeiro + verdadeiro = verdadeiro
        ///  verdadeiro + falso = falso
        ///  falso + verdadeiro = falso
        ///  falso + falso = falso

        /// operadores relacionais
        /// == -> Igual
        /// != -> Diferente
        /// > -> Maior que
        /// < -> Menor que
        /// >= -> Maior ou igual a
        /// <= -> Menor ou igual a


        if (idade == 18){
            System.out.println("Você tem 18 anos");
        }

        if(idade != 18){
            System.out.println("Você não tem 18 anos");
        }

        if (idade > 18){
            System.out.println("Você é maior que 18 anos");
        }

        if (idade < 18){
            System.out.println("Você é menor que 18 anos");
        }

        if (idade >= 18){
            System.out.println("Você é maior ou igual a 18 anos");
        }
        if (idade <= 18){
            System.out.println("Você é menor ou igual a 18 anos");
        }


        /// estrutura de repetição
        /// for -> para
        /// 3 paramentros
        /// 1º -> declaração e inicialização das da variavel acumuladora
        /// 2º -> condição de parada, enquanto for verdadeira o laço continua
        /// 3º -> incremento ou decremento da variavel acumuladora

        // ++ => variavel = variavel + 1

        for (int acumuladora = 0; acumuladora < 10; acumuladora++){
            System.out.println("Contador: "+acumuladora );
        }

        System.out.println("=======================================================");

        for (int acumuladora = 10; acumuladora > 0; acumuladora--){
            System.out.println("Contador: "+acumuladora );
        }


    }
}
