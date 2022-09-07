package negocio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Locacao {

	protected Cliente cliente;
	protected Filme filme;
	protected double valorAluguel;
	protected LocalDateTime dataHora;
	
	public void alugar(Cliente c, Filme f) {
		if (c.situacao == Situacao.INATIVO) {
			return;
		}
		this.dataHora = LocalDateTime.now();
		this.cliente = c;
		this.filme = f;
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    String dataFormatada = this.dataHora.format(formato);
		
	}
	
	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
}
