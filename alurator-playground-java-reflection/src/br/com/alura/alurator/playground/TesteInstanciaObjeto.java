package br.com.alura.alurator.playground;

import br.com.alura.alurator.playground.controle.Controle;

public class TesteInstanciaObjeto {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<Controle> controleClasse1 = Controle.class;

        Controle controle = new Controle();
        Class<? extends Controle> controleClass2 = controle.getClass();

        Class<?> controleClass3  = Class.forName("br.com.alura.alurator.playground.controle.Controle");

        Controle objectControle1 = controleClasse1.newInstance();

        System.out.println(objectControle1 instanceof Controle);

        Object objectControle3 = controleClass3.newInstance();

        System.out.println(objectControle3 instanceof Controle);
        
    }
}
  