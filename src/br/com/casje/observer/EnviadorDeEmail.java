package br.com.casje.observer;

public class EnviadorDeEmail implements AcaoAposGerarNota {
	
	@Override
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("envia por e-mail");
	}

}
