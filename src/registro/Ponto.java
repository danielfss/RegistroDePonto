package registro;

public class Ponto {

	private String matricula;
	private String dataRegistro;
	private String horaEntrada;
	private String horaSaida;
	
	public Ponto(String dataRegistro, String horaEntrada, String horaSaida) {
		this.matricula = matricula;
		this.dataRegistro = dataRegistro;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
	
}
