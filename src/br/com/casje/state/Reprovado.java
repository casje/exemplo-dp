package br.com.casje.state;

public class Reprovado implements EstadoDeUmOrcamento {
	
	@Override
	public void aplicaDescontoExtra(Orcamento orcamento){
		throw new RuntimeException("N�o � poss�vel receber desconto para um pedido reprovado");
	}
	
	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Or�amento reprovado n�o pode ser aprovado");
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Or�amento j� est� aprovado");
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		orcamento.estadoAtual = new Finalizado();
	}

	@Override
	public String getEstado(){
		return "Reprovado";
	}
}
