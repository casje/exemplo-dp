package br.com.casje.state;

public class Finalizado implements EstadoDeUmOrcamento {
	
	@Override
	public void aplicaDescontoExtra(Orcamento orcamento){
		throw new RuntimeException("N�o � poss�vel receber desconto para um pedido finalizado");
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Or�amento j� foi finalizado, e n�o pode mais mudar.");
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Or�amento j� foi finalizado, e n�o pode mais mudar.");
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("Or�amento j� foi finalizado, e n�o pode mais mudar.");
	}
	
	@Override
	public String getEstado(){
		return "Finalizado";
	}
}
