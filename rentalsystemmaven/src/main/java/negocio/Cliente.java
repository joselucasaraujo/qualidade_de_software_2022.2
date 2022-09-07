package negocio;

import java.util.ArrayList;

public class Cliente {

	protected String nome;
	protected int id;
	protected Situacao situacao;
	protected ArrayList<Filme> filmesFavoritos = new ArrayList<Filme>();;
	
	public Cliente(String nome, int id, Situacao situacao) {
		this.nome = nome;
		this.id = id;
		this.situacao = situacao;
	}
	
	public void setFilmeFavorito(Filme filme) {
		this.filmesFavoritos.add(filme);
	}
}
