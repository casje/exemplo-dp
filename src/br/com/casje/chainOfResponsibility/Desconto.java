package br.com.casje.chainOfResponsibility;

public interface Desconto {
	
	double desconta(Orcamento orcamento);
	void setProximo(Desconto proximo);

}
