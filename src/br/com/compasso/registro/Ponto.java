package br.com.compasso.registro;

public class Ponto {

	private String matricula;
	private String dataRegistro;
	private String horaEntrada;
	private String horaSaida;
	
	public Ponto(String matricula, String dataRegistro) {
		this.matricula = matricula;
		this.dataRegistro = dataRegistro;
		this.horaEntrada = "";
		this.horaSaida = "";
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public String getDataRegistro() {
		return dataRegistro;
	}
	
	public void setDataRegistro(String dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	public String getHoraEntrada() {
		return horaEntrada;
	}
	
	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	
	public String getHoraSaida() {
		return horaSaida;
	}
	
	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}
	
	@Override
	public String toString() {
		return "\nMatricula: " + this.matricula + "\nEntrada: " + this.horaEntrada + "\nSaida: " + this.horaSaida + "\n";
	}
	
}
