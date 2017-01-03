package br.com.casje.principal;

public class PrincipalMain {

	public static void main(String[] args) {

		/*
		 * Método MAIN de teste dos design patterns 
		 */
		System.out.println("---------------------- STRATEGY ----------------------");
		br.com.casje.strategy.ICMS icms = new br.com.casje.strategy.ICMS();
		br.com.casje.strategy.ISS iss = new br.com.casje.strategy.ISS();

		br.com.casje.strategy.Orcamento orcamento1 = new br.com.casje.strategy.Orcamento(500.0);
		br.com.casje.strategy.CalculadorDeImpostos calculadora = new br.com.casje.strategy.CalculadorDeImpostos();
		double vlrICMS = calculadora.realizaCalculo(orcamento1, icms);
		double vlrISS = calculadora.realizaCalculo(orcamento1, iss);

		System.out.printf("Valor do orçamento: %s \n", orcamento1.getValor());
		System.out.printf("Valor de ICMS: %s \n", vlrICMS);
		System.out.printf("valor de ISS:  %s \n", vlrISS);

		// ---------------------------------------------------------------------------------------
		System.out.println("---------------------- CHAIN OF RESPONSIBILITY ----------------------");

		br.com.casje.chainOfResponsibility.CalculadoraDeDescontos descontos = 
				new br.com.casje.chainOfResponsibility.CalculadoraDeDescontos();

		br.com.casje.chainOfResponsibility.Orcamento orcamento2 = 
				new br.com.casje.chainOfResponsibility.Orcamento(700.0);
		orcamento2.adicionaItem(new br.com.casje.chainOfResponsibility.Item("CANETA", 250.0));
		orcamento2.adicionaItem(new br.com.casje.chainOfResponsibility.Item("LAPIS", 250.0));
		orcamento2.adicionaItem(new br.com.casje.chainOfResponsibility.Item("APONTADOR", 200.0));

		double descontoFinal = descontos.calcula(orcamento2);

		System.out.printf("Valor do orçamento: %s \n", orcamento2.getValor());
		System.out.printf("Valor do desconto final: %s \n", descontoFinal);

		// ---------------------------------------------------------------------------------------
		System.out.println("---------------------- TEMPLATE METHOD ----------------------");
		br.com.casje.templateMethod.ImpostoX impostoX = new br.com.casje.templateMethod.ImpostoX();
		br.com.casje.templateMethod.ImpostoY impostoY = new br.com.casje.templateMethod.ImpostoY();

		br.com.casje.chainOfResponsibility.Orcamento orcamento3 = 
				new br.com.casje.chainOfResponsibility.Orcamento(700.0);
		orcamento3.adicionaItem(new br.com.casje.chainOfResponsibility.Item("CANETA", 250.0));
		orcamento3.adicionaItem(new br.com.casje.chainOfResponsibility.Item("LAPIS", 250.0));
		orcamento3.adicionaItem(new br.com.casje.chainOfResponsibility.Item("APONTADOR", 200.0));

		double vlrImpostoX = impostoX.calcula(orcamento3);
		double vlrImpostoY = impostoY.calcula(orcamento3);

		System.out.printf("Valor do Orçamento: %s \n", orcamento3.getValor());
		System.out.printf("Valor do Imposto X:  %s \n", vlrImpostoX);
		System.out.printf("Valor do Imposto Y:  %s \n", vlrImpostoY);
		
		// ---------------------------------------------------------------------------------------
		System.out.println("---------------------- DECORATOR ----------------------");

		br.com.casje.chainOfResponsibility.Orcamento orcamento_decorator = 
				new br.com.casje.chainOfResponsibility.Orcamento(100.0);
		br.com.casje.decorator.ICMS_Decorator icms_decorator = new br.com.casje.decorator.ICMS_Decorator();
		br.com.casje.decorator.ISS_Decorator iss_decorator = new br.com.casje.decorator.ISS_Decorator(icms_decorator);
		
		System.out.printf("Orçamento para o Decorator %s \n", orcamento_decorator.getValor());
		System.out.printf("Valor do imposto com ISS + ICMS: %s \n", iss_decorator.calcula(orcamento_decorator));

		
		// ---------------------------------------------------------------------------------------
		System.out.println("---------------------- STATE ----------------------");
		
		br.com.casje.state.Orcamento orcamento_state = 
				new br.com.casje.state.Orcamento(500.0);
		System.out.printf("Valor do orçamento State: %s \n", orcamento_state.getValor());
		System.out.printf("Estado do orçamento: %s \n", orcamento_state.getEstado());
		
		orcamento_state.aprova();
		orcamento_state.aplicaDescontoExtra();
		
		System.out.printf("Estado do orçamento: %s \n", orcamento_state.getEstado());
		System.out.printf("%s \n", orcamento_state.getValor());		
		
		orcamento_state.finaliza();
		System.out.printf("Estado do orçamento: %s \n", orcamento_state.getEstado());
		
		// ---------------------------------------------------------------------------------------
		System.out.println("---------------------- BUILDER ----------------------");
		br.com.casje.builder.NotaFiscalBuilder criador = 
				new br.com.casje.builder.NotaFiscalBuilder()
				.paraEmpresa("Caelum Ensino e Inovação")
				.comCNPJ("12.345.678/0001-12")
				.comItem(new br.com.casje.builder.ItemDaNota("item 1", 200.0))
				.comItem(new br.com.casje.builder.ItemDaNota("item 2", 300.0))
				.comItem(new br.com.casje.builder.ItemDaNota("item 3", 400.0))
				.comObservacao("Observações da nota fiscal")
				.naDataAtual();
		
		br.com.casje.builder.NotaFiscal notaFiscal = criador.constroi();
		
		System.out.printf("Valor bruto R$: %s \n", notaFiscal.getValorBruto());
		System.out.printf("Impostos    R$:  %s \n", notaFiscal.getImpostos());
		
		// ---------------------------------------------------------------------------------------
		System.out.println("---------------------- OBSERVER ----------------------");
		br.com.casje.observer.NotaFiscalBuilder criadorNF = 
				new br.com.casje.observer.NotaFiscalBuilder();
		
		criadorNF.adicionaAcao(new br.com.casje.observer.EnviadorDeEmail());
		criadorNF.adicionaAcao(new br.com.casje.observer.NotaFiscalDAO());
		criadorNF.adicionaAcao(new br.com.casje.observer.EnviadorDeSMS());
		criadorNF.adicionaAcao(new br.com.casje.observer.Impressora());
		
		br.com.casje.observer.NotaFiscal notaFiscalObserver =
			criadorNF.paraEmpresa("Caelum Ensino e Inovação")
					.comCNPJ("12.345.678/0001-12")
					.comItem(new br.com.casje.observer.ItemDaNota("item 1", 200.0))
					.comItem(new br.com.casje.observer.ItemDaNota("item 2", 300.0))
					.comItem(new br.com.casje.observer.ItemDaNota("item 3", 400.0))
					.comObservacao("Observações da nota fiscal")
					.naDataAtual()
					.constroi();
		
		System.out.printf("Valor bruto R$: %s \n",  notaFiscalObserver.getValorBruto());
		System.out.printf("Impostos    R$:  %s \n", notaFiscalObserver.getImpostos());
	}

}
