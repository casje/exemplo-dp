package br.com.casje.decorator;

public abstract class ImpostoDecorador {

	private final ImpostoDecorador outroImposto;
	
	public ImpostoDecorador(ImpostoDecorador outroImposto){
		this.outroImposto = outroImposto;
	}
	
	public ImpostoDecorador(){
		this.outroImposto = null;
	}
	
	protected double calculoDoOutroImposto(br.com.casje.chainOfResponsibility.Orcamento orcamento){
		if(outroImposto == null) { return 0;}
		return outroImposto.calcula(orcamento);
	}
	
	public abstract double calcula(br.com.casje.chainOfResponsibility.Orcamento orcamento);
}
