package br.com.casje.builder;

public class TesteDaNotaFiscal {

	public static void main(String[] args) {
		
		NotaFiscalBuilder criador = new NotaFiscalBuilder()
		.paraEmpresa("Caelum Ensino e Inovação")
		.comCNPJ("12.345.678/0001-12")
		.comItem(new ItemDaNota("item 1", 200.0))
		.comItem(new ItemDaNota("item 2", 300.0))
		.comItem(new ItemDaNota("item 3", 400.0))
		.comObservacao("Observações da nota fiscal")
		.naDataAtual();
		
		NotaFiscal notaFiscal = criador.constroi();
		
		System.out.println("------------------  BUILDER ------------------");
		System.out.printf("Valor bruto R$: %s \n", notaFiscal.getValorBruto());
		System.out.printf("Impostos    R$:  %s \n", notaFiscal.getImpostos());
		
		/*
		 * Padrão BUILDER
		 * 
		List<ItemDaNota> itens = Arrays.asList(new ItemDaNota("Item 1", 200.0), new ItemDaNota("Item 2", 400.0));
		
		double valorTotal = 0;
		for(ItemDaNota item : itens){
			valorTotal += item.getValor();
		}
		
		double impostos = valorTotal * 0.05;
		
		NotaFiscal notaFiscal = new NotaFiscal("razão social", "cnpj", Calendar.getInstance(), valorTotal, impostos, itens, "observacoes");
		*/
	}

}
