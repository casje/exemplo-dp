package br.com.casje.state;

public class Aprovado implements EstadoDeUmOrcamento {

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		orcamento.valor -= orcamento.valor * 0.02;
	}
	
	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Or�amento j� est� aprovado");
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Or�amento aprovado n�o pode ser finalizado");
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		orcamento.estadoAtual = new Finalizado();
	}
	
	@Override
	public String getEstado(){
		return "Aprovado";
	}
}
