package negocio;

import java.util.ArrayList;

public class Transacao {

	protected  ArrayList<Locacao> alugueis;
	
	public Transacao() {
		
		alugueis = new ArrayList<Locacao>();
	}
	
	public double valorLocacaoTotal() {
	    double valor = 0;
		for (Locacao locacao : alugueis) {
			valor += locacao.filme.valorCompra;
		}
		return valor;
	}
	
	public Cliente buscaCliente(int id) {
		for (Locacao locacao : alugueis) {
			if(locacao.cliente.id == id) {
				return locacao.cliente;
			}
			
		}
		
		return null;
	}
	
	public double calculoLucro(int filmeId) {
		double valor = 0;
		Filme aux = null;
		for (Locacao locacao : alugueis) {
			if(locacao.filme.id == filmeId) {
				valor += locacao.valorAluguel;
				aux = locacao.filme;
			}
			
		}
		return (valor * 100) / aux.valorCompra;
	}
	
	public Genero getGenerosMaisAlugados(ArrayList<Locacao> alugueis) {
		System.out.println("teste " + alugueis.size());
		Genero retorno = null;
		int countR = 0, countD = 0, countC = 0;
		for (Locacao loc : alugueis) {
			switch (loc.filme.genero) {
			case COMEDIA:
				countC++;
				break;
			case DRAMA:
				countD++;
				break;
			case ROMANCE:
				countR++;
				break;
			default:
				break;			
			}
		}
		int maisAlugado;
		maisAlugado = Math.max(countD,Math.max(countC,countR));
		if (countR == maisAlugado) retorno = Genero.ROMANCE;
        if (countC == maisAlugado) retorno = Genero.COMEDIA;
        if (countD == maisAlugado) retorno = Genero.DRAMA;
        
		return retorno;
	}
	
	public ArrayList<Locacao> aplicarDesconto(ArrayList<Locacao> alugueis, Genero genero, float percentualDesconto) {
		
		for (Locacao loc : alugueis) {
			if (loc.filme.genero == genero) {
				loc.valorAluguel -= ((percentualDesconto/100) * loc.valorAluguel);
			}
		}
		return alugueis;
	}
	
}
