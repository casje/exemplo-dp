package br.com.casje.state;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orcamento {
	
	protected double valor;
	private List<Item> itens;
	
	protected EstadoDeUmOrcamento estadoAtual;
	
	/*
	 * refatorando para o padrão State
	 * 
	private int estadoAtual;
	
	public static final int EM_APROVACAO = 1;
	public static final int APROVADO = 1;
	public static final int REPROVADO = 1;
	public static final int FINALIZADO = 1;
	*/
	
	public Orcamento(double valor){
		this.valor = valor;
		itens = new ArrayList<Item>();
		
		estadoAtual = new EmAprovacao();
		
	}
	
	public double getValor() {
		return valor;
	}
	
	public void adicionaItem(Item item){
		this.itens.add(item);
	}

	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}
	
	public void aplicaDescontoExtra(){
		
		estadoAtual.aplicaDescontoExtra(this);
		
		
		/*
		 *refatorando para o padrão state 
		 *
		if(estadoAtual == EM_APROVACAO) {
			valor = valor - (valor * 0.05);
		}
		else if (estadoAtual == APROVADO) {
			valor = valor - (valor * 0.02);
		}
		else {
			throw new RuntimeException("Somente orçamento em aprovação ou aprovados recebem descontos extra!");
		}
		*/
	}
	
	public String getEstado() {
		return estadoAtual.getEstado();
	}
	
	public void aprova(){
		estadoAtual.aprova(this);
	}
	
	public void reprova(){
		estadoAtual.reprova(this);		
	}
	
	public void finaliza(){
		estadoAtual.finaliza(this);		
	}
	
}
