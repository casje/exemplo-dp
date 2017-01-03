package br.com.casje.observer;

public class EnviadorDeSMS implements AcaoAposGerarNota {
	
	@Override
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("envia por SMS");
	}

}
