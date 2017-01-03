package br.com.casje.decorator;

import br.com.casje.chainOfResponsibility.Orcamento;

public class ICMS_Decorator extends ImpostoDecorador {

	public ICMS_Decorator(){}
	
	public ICMS_Decorator(ImpostoDecorador outroImposto){
		super(outroImposto);
	}
	
	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.1 + calculoDoOutroImposto(orcamento);
	}

}
