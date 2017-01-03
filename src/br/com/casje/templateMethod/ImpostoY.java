package br.com.casje.templateMethod;

import br.com.casje.chainOfResponsibility.Orcamento;

public class ImpostoY extends TemplateDeImpostoCondicional{

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.02;
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.08;
	}

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 800.0;
	}	
}
