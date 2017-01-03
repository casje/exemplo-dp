package br.com.casje.chainOfResponsibility;

public class CalculadoraDeDescontos {
	
	public double calcula(Orcamento orcamento){
		
		Desconto descontoPorItens = new DescontoPorCincoItens();
		Desconto descontoPorValor = new DescontoPorMaisDeQuinhentosReais();
		Desconto semDesconto = new SemDesconto();
		
		descontoPorItens.setProximo(descontoPorValor);
		descontoPorValor.setProximo(semDesconto);
		
		return descontoPorItens.desconta(orcamento);
		
		/*
		 * Codigo sem padrão, com varios IFs
		// mais de 5 itensm desconto de 10%
		if(orcamento.getItens().size() > 5) {
			return orcamento.getValor() * 0.1;
		}
		*/
		
		// caso contrario, retorna ZERO
		//return 0;
	}

}
