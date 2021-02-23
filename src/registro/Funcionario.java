package registro;

public class Funcionario {

	private String nome;
	private String matricula;
	private String cargo;
	private Ponto ponto;
	
	
	public Funcionario(String nome, String matricula, String cargo) {
        this.nome = nome;
        this.matricula = matricula;
        this.cargo = cargo;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public Ponto getPonto() {
		return ponto;
	}
	
	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}
	
	@Override
	public String toString() {
		return "Funcionario: " + this.nome + "\nMatricula: " + this.matricula + "\nCargo: " + this.cargo;
	}
	
}
