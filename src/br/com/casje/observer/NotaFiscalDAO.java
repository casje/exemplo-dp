package br.com.casje.observer;

public class NotaFiscalDAO implements AcaoAposGerarNota {
	
	@Override
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("salva no BD");
	}

}
