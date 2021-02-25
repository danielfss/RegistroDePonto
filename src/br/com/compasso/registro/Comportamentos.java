package br.com.compasso.registro;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Comportamentos {

	Scanner entrada = new Scanner(System.in);
//	Funcionario funcionario = new Funcionario("", "", "");
//	Ponto ponto = new Ponto("", "");
	List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	List<Ponto> listaPontos = new ArrayList<Ponto>();

	public void menuInicial() {

		String opcao;

		System.out.println("a) Cadastrar um funcion�rio\n" + "b) Registrar ponto\n" + "c) Consultar ponto\n"
				+ "Digite a letra correspondente ao que deseja fazer ou digite qualquer outro caractere para sair: ");

		opcao = entrada.next();

		do {
			if (opcao.equalsIgnoreCase("a")) {
				cadastra();
			} else if (opcao.equalsIgnoreCase("b")) {
				registraPonto();
			} else if (opcao.equalsIgnoreCase("c")) {
				consultaPonto();
				System.out.println("Consultar o ponto");
			} else {
				System.out.println("Op��o inv�lida, execute novamente.");
			}
		} while (opcao == "a" || opcao == "b" || opcao == "c");
	}

	public void cadastra() {
		// VARI�VEIS TEMPOR�RIAS / LOCAIS
		String nome, matricula, cargo;

		System.out.println("Digite o nome do funcion�rio: ");
		nome = entrada.next();
		System.out.println("Digite a matr�cula do funcion�rio: ");
		matricula = entrada.next();
		System.out.println("Digite o cargo do funcion�rio: ");
		cargo = entrada.next();

		// SALVA OS DADOS DIGITADOS NO ARRAYLIST
		listaFuncionarios.add(new Funcionario(nome, matricula, cargo));
		System.out.println(listaFuncionarios);

		System.out.println("Cadastro concluido");
		menuInicial();
	}

	public void registraPonto() {
		System.out.println("-----------------------------------");
		System.out.println("LISTA DE FUNCION�RIOS CADASTRADOS");
		System.out.println(listaFuncionarios);
		System.out.println("-----------------------------------");

		// VARI�VEIS TEMPOR�RIAS / LOCAIS
		String matricula;
		LocalDate hoje;
		LocalDateTime agora;

		System.out.println("Digite o n�mero de matr�cula: ");
		matricula = entrada.next();
		System.out.println("Matr�cula digitada pelo usu�rio: " + matricula);

		int pos = -1;

		for (int i = 0; i < listaFuncionarios.size(); i++) {
			if (matricula.equalsIgnoreCase(listaFuncionarios.get(i).getMatricula())) {
				System.out.println("Funcion�rio existe.");
				pos = i;
				System.out.println(listaFuncionarios.get(i).getNome());
			}
		}

		if(pos >= 0) {
			
			// PEGANDO O DIA
			hoje = LocalDate.now();
			DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			// PEGANDO O DIA E HORA
			agora = LocalDateTime.now();
			DateTimeFormatter formatadorDataEHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

			String data = hoje.format(formatadorData);
			String horaEntrada = agora.format(formatadorDataEHora);
			;
			String horaSaida = agora.format(formatadorDataEHora);

			if (listaPontos.size() > 0) {
				for (int i = 0; i < listaPontos.size(); i++) {
					if (matricula.equalsIgnoreCase(listaPontos.get(i).getMatricula())
							&& listaPontos.get(i).getDataRegistro().equals(data)) {
						if (listaPontos.get(i).getHoraEntrada().equals("")) {
							listaPontos.get(i).setHoraEntrada(horaEntrada);
							System.out.println("Ponto de entrada registrado no dia " + data);
							System.out.println("Ponto de entrada registrado �s: " + horaEntrada);
							System.out.println("lista de pontos: " + listaPontos.size());
						} else if (listaPontos.get(i).getHoraSaida().equals("")) { // Registra o ponto de sa�da
							listaPontos.get(i).setHoraSaida(horaSaida);
							System.out.println("Ponto de sa�da registrado no dia " + data);
							System.out.println("Ponto de sa�da registrado �s: " + horaSaida);
							System.out.println("lista de pontos: " + listaPontos.size());
						} else {
							System.out.println("Voc� j� registrou o ponto de entrada e sa�da de hoje.");
						}
						break;
					} else {
						// CASO A LISTA J� TENHA REGISTROS
						Ponto novoPonto = new Ponto(
								listaFuncionarios.get(pos).getMatricula(), data);
								novoPonto.setHoraEntrada(horaEntrada);
								listaPontos.add(novoPonto);
					}
				break;
				} // Fim do for
			} else {
				// PRIMEIRO REGISTRO DE PONTO COM A LISTA ESTANDO VAZIA
				Ponto novoPonto = new Ponto(
						listaFuncionarios.get(pos).getMatricula(), data);
						novoPonto.setHoraEntrada(horaEntrada);
						listaPontos.add(novoPonto);
			}
			
			System.out.println("Ponto do(a) funcion�rio(a) " + listaFuncionarios.get(pos).getNome() + ".\nRegistrado na data: " + data
					+ ". Hor�rio: " + horaEntrada);
			System.out.println("--------------------------------------");
			// FIM DO IF POS >= 0
			} else {
				System.out.println("N�o existe nenhum funcion�rio com esta matr�cula.");
			}
			menuInicial();
		}
		

	public void consultaPonto() {
		System.out.println("-----------------------------------");
		System.out.println("LISTA DE FUNCION�RIOS CADASTRADOS");
		System.out.println(listaFuncionarios);
		System.out.println("-----------------------------------");
		System.out.println("LISTA DE PONTOS REGISTRADOS");
		System.out.println(listaPontos);
		System.out.println("-----------------------------------");
		
		String matricula;
		System.out.println("Digite o n�mero de matr�cula: ");
		matricula = entrada.next();
		System.out.println("Matr�cula digitada pelo usu�rio: " + matricula);
		
		if (listaPontos.size() > 0) {
			for (int i = 0; i < listaPontos.size(); i++) {
				if (matricula.equals(listaPontos.get(i).getMatricula())) {
					System.out.println("...................................");
					System.out.println(listaPontos.get(i).getDataRegistro() + "\nMatricula: "
							+ listaPontos.get(i).getMatricula() + "\nEntrada: " + listaPontos.get(i).getHoraEntrada()
							+ "\nSa�da: " + listaPontos.get(i).getHoraSaida());
					break;
				} else {
					System.out.println("...................................");
					System.out.println("Este funcion�rio ainda n�o registrou o ponto!");
					System.out.println("...................................");
				}
			}
		} else {
			System.out.println("--------------------------------");
			System.out.println("N�o existe nenhum ponto na lista.");
			System.out.println("--------------------------------");
		}
		menuInicial();

	}
}
