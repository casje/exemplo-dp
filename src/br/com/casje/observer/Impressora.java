package br.com.casje.observer;

public class Impressora implements AcaoAposGerarNota {
	
	@Override
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("imprime");		
	}

}
