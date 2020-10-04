package io.github.pedroermarinho.cursomc.domain.enums;

public enum TipoCliente {
	PESSOAFISICA(1,"Pessoa Física"),
	PESSOAJURIDICA(1,"Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod,String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return this.cod;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(TipoCliente x: TipoCliente.values()) {
			if(cod.equals(x.cod)) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id invalido: "+cod);
	}
}
