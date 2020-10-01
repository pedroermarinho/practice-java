package aplicacao;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pessoa p1 = new Pessoa(1,"fulano","fulano@gmail.com");
		Pessoa p2 = new Pessoa(2,"ciclano","ciclano@gmail.com");
		Pessoa p3 = new Pessoa(3,"tobias","tobias@gmail.com");
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());

	}

}
