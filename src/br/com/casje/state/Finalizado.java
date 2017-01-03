package br.com.casje.state;

public class Finalizado implements EstadoDeUmOrcamento {
	
	@Override
	public void aplicaDescontoExtra(Orcamento orcamento){
		throw new RuntimeException("Não é possível receber desconto para um pedido finalizado");
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Orçamento já foi finalizado, e não pode mais mudar.");
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Orçamento já foi finalizado, e não pode mais mudar.");
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("Orçamento já foi finalizado, e não pode mais mudar.");
	}
	
	@Override
	public String getEstado(){
		return "Finalizado";
	}
}
