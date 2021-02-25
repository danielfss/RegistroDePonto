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
		System.out.println("-----------------");
		System.out.println(listaFuncionarios);

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

						} else if (listaPontos.get(i).getHoraSaida().equals("")) { // Registra o ponto de sa�da
							listaPontos.get(i).setHoraSaida(horaSaida);

						} else {
							System.out.println("Voc� j� registrou o ponto de entrada e sa�da de hoje.");
						}
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
		String matricula;
		System.out.println("Digite o n�mero de matr�cula: ");
		matricula = entrada.next();

		System.out.println("Matr�cula digitada pelo usu�rio: " + matricula);
		if (listaPontos.size() > 0) {
			for (int i = 0; i < listaPontos.size(); i++) {
				if (matricula.equals(listaPontos.get(i).getMatricula())) {
					System.out.println("...................................");
					System.out.println(listaPontos.get(i).getDataRegistro() + "\nNome: "
							+ listaPontos.get(i).getMatricula() + "\nEntrada: " + listaPontos.get(i).getHoraEntrada()
							+ "\nSa�da: " + listaPontos.get(i).getHoraSaida());
				} else {
					System.out.println("...................................");
					System.out.println("Este funcion�rio ainda n�o registrou o ponto.!");
				}
			}
		} else {
			System.out.println("--------------------------------");
			System.out.println("Funcion�rio n�o encontrado!");
			System.out.println("--------------------------------");
		}
		menuInicial();

	}
}
