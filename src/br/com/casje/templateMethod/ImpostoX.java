package br.com.casje.templateMethod;

import br.com.casje.chainOfResponsibility.Orcamento;

public class ImpostoX extends TemplateDeImpostoCondicional {

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.03;
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.10;
	}

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 200.0 && temItemMaiorQue100Reais(orcamento); 
	}
	
	private boolean temItemMaiorQue100Reais(Orcamento orcamento){
		for (br.com.casje.chainOfResponsibility.Item item : orcamento.getItens()) {
			if(item.getValor() > 100.0){
				return true;
			}
		}
		return false;
	}

}
