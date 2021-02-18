package registro;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Comportamentos {
	
	Scanner entrada = new Scanner(System.in);
	Funcionario funcionario = new Funcionario("", "", "");
	List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	
	public void menuInicial() {
		
		
		String opcao;


		System.out.println("a) Cadastrar um funcionario\n"
						+ "b) Registrar ponto\n"
						+ "c) Consultar ponto\n"
						+ "Digite a letra correspondente ao que deseja fazer ou digite qualquer outro caractere para sair: ");
		
		opcao = entrada.next();
		
		do {
			if (opcao.equalsIgnoreCase("a")) {
				cadastra();
			} else if (opcao.equalsIgnoreCase("b")) {
				registraPonto();
			} else if (opcao.equalsIgnoreCase("c")) {
				// consultaPonto();
				System.out.println("Consultar o ponto");
			} else {
				System.out.println("Op��o inv�lida, execute novamente.");
			}
		} while (opcao == "a" || opcao == "b" || opcao == "c");
	}
	
	
	public void cadastra() {
		String nome, matricula, cargo;
		
		System.out.println("Digite o nome do funcion�rio: ");
		nome = entrada.next();
		System.out.println("Digite a matr�cula do funcion�rio: ");
		matricula = entrada.next();
		System.out.println("Digite o cargo do funcion�rio: ");
		cargo = entrada.next();

		listaFuncionarios.add(new Funcionario(nome, matricula, cargo));
		System.out.println(listaFuncionarios);
		
		funcionario.setNome(nome);
		System.out.println(funcionario.getNome());
		
		funcionario.setMatricula(matricula);
		System.out.println(funcionario.getMatricula());
		
		funcionario.setCargo(cargo);
		System.out.println(funcionario.getCargo());
		

		
		System.out.println("Cadastro concluido");
		menuInicial();
	}
	
	
	public void registraPonto() {
		System.out.println(listaFuncionarios);
		
		String matricula;
		LocalDate hoje;
		LocalDateTime agora;
		
		System.out.println("Digite o n�mero de matr�cula: ");
		matricula = entrada.next();
		System.out.println(matricula);
		System.out.println(funcionario.getMatricula());
		
		if(matricula.equalsIgnoreCase(funcionario.getMatricula())) {
			System.out.println("Funcion�rio existe");
			// PEGANDO O DIA
			hoje = LocalDate.now();
			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			System.out.println("Ponto registrado no dia " + hoje.format(formatador));
			
			// PEGANDO O DIA E HORA
			agora = LocalDateTime.now();
			DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
			System.out.println("Ponto de entrada registrado �s: " + agora.format(formatadorHora));
		} else {
			System.out.println("N�o existe nenhum funcion�rio com este n�mero de matr�cula.");
		}
		
		menuInicial();
	}
	
	public consultaPonto() {
		
	}
}
