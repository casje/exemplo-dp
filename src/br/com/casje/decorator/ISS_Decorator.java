package br.com.casje.decorator;

import br.com.casje.chainOfResponsibility.Orcamento;

public class ISS_Decorator extends ImpostoDecorador {

	public ISS_Decorator(ImpostoDecorador outroImposto) {
		super(outroImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.06 + calculoDoOutroImposto(orcamento);
	}

}
