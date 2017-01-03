package br.com.casje.strategy;

public class CalculadorDeImpostos {
	
	public double realizaCalculo(Orcamento orcamento, Imposto impostoQualquer){
		
		return impostoQualquer.calcula(orcamento);		
		
		// Primeira Versão
		/*
		if(imposto .equals("ICMS")){
			double icms = orcamento.getValor() * 0.1;
			System.out.println(icms);
		}
		else if(imposto.equals("ISS")) {
			double iss = orcamento.getValor() * 0.06;
			System.out.println(iss);
		}
		*/
	}

}
