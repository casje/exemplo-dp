package br.com.casje.state;

public class Reprovado implements EstadoDeUmOrcamento {
	
	@Override
	public void aplicaDescontoExtra(Orcamento orcamento){
		throw new RuntimeException("Não é possível receber desconto para um pedido reprovado");
	}
	
	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Orçamento reprovado não pode ser aprovado");
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Orçamento já está aprovado");
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
