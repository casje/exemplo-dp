package br.com.casje.observer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotaFiscalBuilder {
	
	private String razaoSocial;
	private String cnpj;
	private List<ItemDaNota> todosItens = new ArrayList<ItemDaNota>();
	private double impostos;
	private double valorBruto;
	private String observacoes;
	private Calendar dataEmissao;
	
	private List<AcaoAposGerarNota> todasAcoesASeremExecutadas;
	
	public NotaFiscalBuilder(){
		todasAcoesASeremExecutadas = new ArrayList<AcaoAposGerarNota>();
	}
	
	public void adicionaAcao(AcaoAposGerarNota acao){
		this.todasAcoesASeremExecutadas.add(acao);
	}
	
	public NotaFiscalBuilder paraEmpresa(String razaoSocial){
		this.razaoSocial = razaoSocial;
		
		return this;
	}
	
	public NotaFiscalBuilder comCNPJ(String cnpj){
		this.cnpj = cnpj;
		
		return this;
	}
	
	public NotaFiscalBuilder comItem(ItemDaNota item){
		todosItens.add(item);
		
		this.valorBruto += item.getValor();
		this.impostos += item.getValor() * 0.05;
		
		return this;
	}
	
	public NotaFiscalBuilder comObservacao(String observacoes){
		this.observacoes = observacoes;
		return this;
	}
	
	public NotaFiscalBuilder naDataAtual(){
		this.dataEmissao = Calendar.getInstance();
		return this;
	}
	
	public NotaFiscal constroi(){
		NotaFiscal notaFiscal = new NotaFiscal(razaoSocial, cnpj, dataEmissao, valorBruto, impostos, todosItens, observacoes);
		
		for(AcaoAposGerarNota acao : todasAcoesASeremExecutadas){
			acao.executa(notaFiscal);
		}
		
		return notaFiscal;
	}

	

	

}
