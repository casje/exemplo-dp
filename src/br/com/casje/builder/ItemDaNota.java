package br.com.casje.builder;

public class ItemDaNota {
	
	public ItemDaNota(String nome, double valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}
	
	private String nome;
	private double valor;
	
	public String getNome() {
		return nome;
	}
	
	public double getValor() {
		return valor;
	}

}
