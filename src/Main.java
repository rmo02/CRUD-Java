
import service.AlunoService;
import service.ProfessorService;
import service.TurmaService;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


import entities.Aluno;
import entities.Professor;
import entities.Turma;

public class Main {

	// scanner para entrada de dados
	private static Scanner entrada = new Scanner(System.in);

	// classe responsavel por manipular alunos, professor
	private static AlunoService alunoService = new AlunoService();
	private static ProfessorService professorService = new ProfessorService();
	private static TurmaService turmaService = new TurmaService();

	public static void main(String[] args) throws SQLException {

		// flag que controla execucao do programa
		boolean continuar = true;

		while (continuar) {
			exibeMenu();

			switch (entrada.nextLine()) {
			case "1":
				limpaTela();
				adicionarAluno();
				pressioneQualquerTecla();
				break;
			case "2":
				limpaTela();
				listarAlunos();
				pressioneQualquerTecla();
				break;
			case "3":
				limpaTela();
				buscarPorId();
				pressioneQualquerTecla();
				break;
			 case "4":
			 	limpaTela();
			 	atualizarAluno();
			 	pressioneQualquerTecla();
			 	break;
			case "5":
			 	limpaTela();
			 	deletarAluno();
			 	pressioneQualquerTecla();
			 	break;
			case "6":
			 	limpaTela();
			 	adicionarProfessor();
			 	pressioneQualquerTecla();
			 	break;
			case "7":
			 	limpaTela();
			 	listarProfessores();
			 	pressioneQualquerTecla();
			 	break;
			case "8":
			 	limpaTela();
			 	buscarPorIdd();
			 	pressioneQualquerTecla();
			 	break;
			case "9":
			 	limpaTela();
			 	atualizarProfessor();
			 	pressioneQualquerTecla();
			 	break;
			case "10":
			 	limpaTela();
			 	deletarProfessor();
			 	pressioneQualquerTecla();
			 	break;
			case "11":
			 	limpaTela();
			 	adicionarTurma();
			 	pressioneQualquerTecla();
			 	break;
			case "12":
			 	limpaTela();
			 	listarTurmas();
			 	pressioneQualquerTecla();
			 	break;
			case "13":
			 	limpaTela();
			 	buscarPorIddd();
			 	pressioneQualquerTecla();
			 	break;
			case "14":
			 	limpaTela();
			 	atualizarTurma();
			 	pressioneQualquerTecla();
			 	break;
			case "15":
			 	limpaTela();
			 	deletarTurma();
			 	pressioneQualquerTecla();
			 	break;
			case "16":
				limpaTela();
				System.out.println("Tchau... :)");
				pressioneQualquerTecla();
				continuar = false;
				break;
			default:
				limpaTela();
				System.out.println("Por favor, selecione uma opção válida.");
				pressioneQualquerTecla();
				break;
			}
			
			limpaTela();
		}

		entrada.close();
	}

	private static void exibeMenu() {
		System.out.println("Bem vindo, por favor digite uma opção válida: ");
		System.out.println("1 - Cadastrar aluno");
		System.out.println("2 - Listar alunos");
		System.out.println("3 - Buscar aluno por id");
		System.out.println("4 - Atualizar aluno por id");
		System.out.println("5 - Deletar aluno");
		System.out.println("6 - Cadastrar Professor");
		System.out.println("7 - Listar professores");
		System.out.println("8 - Buscar professor por id");
		System.out.println("9 - Atualizar professor por id");
		System.out.println("10 - Deletar professor");
		System.out.println("11 - Cadastrar Turma");
		System.out.println("12 - Listar turmas");
		System.out.println("13 - Buscar turma por id");
		System.out.println("14 - Atualizar turma por id");
		System.out.println("15 - Deletar tuma");
		System.out.println("16 - Sair");
	}

	

	private static void adicionarAluno() {
		Aluno aluno = new Aluno();

		System.out.println("Informe o nome do aluno:");
		String resposta = entrada.nextLine();
		aluno.setNome(resposta);

		System.out.println("Informe o nome da Mae do Aluno:");
		resposta = entrada.nextLine();
		aluno.setNomeMae(resposta);

		System.out.println("Informe o nome do Pai do Aluno:");
		resposta = entrada.nextLine();
		aluno.setNomePai(resposta);

		System.out.println("Informe a data de nascimento do aluno (Ex.: 22/02/2000):");
		resposta = entrada.nextLine();
		aluno.setDataNascimento(resposta);

		alunoService.validaAluno(aluno);
	}

	private static void atualizarAluno() {
		Aluno aluno = new Aluno();

		System.out.println("Informe o id do aluno que deseja atualizar:");
		int respostaId = Integer.parseInt(entrada.nextLine());
		aluno.setId(respostaId);

		System.out.println("Informe o novo nome do aluno:");
		String resposta = entrada.nextLine();
		aluno.setNome(resposta);

		System.out.println("Informe o novo nome da Mae do Aluno:");
		resposta = entrada.nextLine();
		aluno.setNomeMae(resposta);

		System.out.println("Informe o novo nome do Pai do Aluno:");
		resposta = entrada.nextLine();
		aluno.setNomePai(resposta);

		System.out.println("Informe a nova data de nascimento do aluno (Ex.: 22/02/2000):");
		resposta = entrada.nextLine();
		aluno.setDataNascimento(resposta);

		alunoService.atualizarAlunoValidacao(aluno);
	}

	private static void listarAlunos() {
		List<Aluno> listaAlunos = alunoService.listaAlunos();
		printaAlunos(listaAlunos);
	}

	private static void buscarPorIdd() {
		System.out.print("Informe o id do aluno: ");
		String idBusca = entrada.nextLine();
		List<Aluno> listaAlunos = alunoService.listaAlunoPorId(idBusca);
		printaAlunos(listaAlunos);
	}
	
	private static void deletarAluno() {
		System.out.println("Informe o id do aluno que deseja deletar:");
		int respostaId = Integer.parseInt(entrada.nextLine());

		alunoService.deletarAlunoValidacao(respostaId);
	}

	private static void printaAlunos(List<Aluno> listaAlunos) {
		Iterator<Aluno> it = listaAlunos.iterator();

		while(it.hasNext()) {
			Aluno aluno = it.next();

			System.out.printf("%-4s\t", aluno.getId());
			System.out.printf("%-20s\t", aluno.getNome());
			System.out.printf("%-10s\t", aluno.getDataNascimento());
			System.out.println();
		}
	}

	
	//professor
	private static void adicionarProfessor() {
		Professor professor = new Professor();

		System.out.println("Informe o nome do professor:");
		String resposta = entrada.nextLine();
		professor.setNome(resposta);

		System.out.println("Informe a formação:");
		resposta = entrada.nextLine();
		professor.setFormacao(resposta);

		System.out.println("Informe o nome da Mae do Professor:");
		resposta = entrada.nextLine();
		professor.setNomeMae(resposta);

		System.out.println("Informe o nome do Pai do Professor:");
		resposta = entrada.nextLine();
		professor.setNomePai(resposta);

		System.out.println("Informe a data de nascimento do professor (Ex.: 22/02/2000):");
		resposta = entrada.nextLine();
		professor.setDataNascimento(resposta);

		professorService.validaProfessor(professor);
	}

	private static void atualizarProfessor() {
		Professor professor = new Professor();

		System.out.println("Informe o id do professor que deseja atualizar:");
		int respostaId = Integer.parseInt(entrada.nextLine());
		professor.setId(respostaId);

		System.out.println("Informe o novo nome do professor:");
		String resposta = entrada.nextLine();
		professor.setNome(resposta);
		
		System.out.println("Informe a formação:");
		resposta = entrada.nextLine();
		professor.setFormacao(resposta);

		System.out.println("Informe o novo nome da Mae do professor:");
		resposta = entrada.nextLine();
		professor.setNomeMae(resposta);

		System.out.println("Informe o novo nome do Pai do professor:");
		resposta = entrada.nextLine();
		professor.setNomePai(resposta);

		System.out.println("Informe a nova data de nascimento do professor (Ex.: 22/02/2000):");
		resposta = entrada.nextLine();
		professor.setDataNascimento(resposta);

		professorService.atualizarProfessorValidacao(professor);
	}

	private static void listarProfessores() {
		List<Professor> listaProfessores = professorService.listaProfessores();
		printaProfessores(listaProfessores);
	}

	private static void buscarPorId() {
		System.out.print("Informe o id do professor: ");
		String idBusca = entrada.nextLine();
		List<Professor> listaProfessores = professorService.listaProfessorPorId(idBusca);
		printaProfessores(listaProfessores);
	}
	
	private static void deletarProfessor() {
		System.out.println("Informe o id do professor que deseja deletar:");
		int respostaId = Integer.parseInt(entrada.nextLine());

		professorService.deletarProfessorValidacao(respostaId);
	}

	private static void printaProfessores(List<Professor> listaProfessores) {
		Iterator<Professor> it = listaProfessores.iterator();

		while(it.hasNext()) {
			Professor professor = it.next();

			System.out.printf("%-4s\t", professor.getId());
			System.out.printf("%-20s\t", professor.getNome());
			System.out.printf("%-10s\t", professor.getDataNascimento());
			System.out.println();
		}
	}

	//Turma

	private static void adicionarTurma() {
		Turma turma = new Turma();

		System.out.println("Informe o nome da Turma:");
		String resposta = entrada.nextLine();
		turma.setNome(resposta);

		System.out.println("Informe a curso:");
		resposta = entrada.nextLine();
		turma.setCurso(resposta);

		System.out.println("Informe o andar:");
		resposta = entrada.nextLine();
		turma.setAndar(resposta);

		turmaService.validaTurma(turma);
	}

	private static void atualizarTurma() {
		Turma turma = new Turma();

		System.out.println("Informe o id da turma que deseja atualizar:");
		int respostaId = Integer.parseInt(entrada.nextLine());
		turma.setId(respostaId);

		System.out.println("Informe o novo nome da turma:");
		String resposta = entrada.nextLine();
		turma.setNome(resposta);
		
		System.out.println("Informe o curso:");
		resposta = entrada.nextLine();
		turma.setCurso(resposta);

		System.out.println("Informe o andar:");
		resposta = entrada.nextLine();
		turma.setAndar(resposta);

		turmaService.atualizarTurmaValidacao(turma);
	}

	private static void listarTurmas() {
		List<Turma> listaTurmas = turmaService.listaTurmas();
		printaTurmas(listaTurmas);
	}

	private static void buscarPorIddd() {
		System.out.print("Informe o id da turma: ");
		String idBusca = entrada.nextLine();
		List<Turma> listaTurmas = turmaService.listaTurmaPorId(idBusca);
		printaTurmas(listaTurmas);
	}
	
	private static void deletarTurma() {
		System.out.println("Informe o id da turma que deseja deletar:");
		int respostaId = Integer.parseInt(entrada.nextLine());

		turmaService.deletarTurmaValidacao(respostaId);
	}

	private static void printaTurmas(List<Turma> listaTurmas) {
		Iterator<Turma> it = listaTurmas.iterator();

		while(it.hasNext()) {
			Turma turma = it.next();

			System.out.printf("%-4s\t", turma.getId());
			System.out.printf("%-20s\t", turma.getNome());
			System.out.println();
		}
	}

	
	private static void limpaTela() {
		for (int i = 0; i < 100; i++) {
			System.out.println("\r\n");
		}
	}
	
	private static void pressioneQualquerTecla() {
		System.out.println("\n\nPressione qualquer tecla para continuar...");
		entrada.nextLine();
	}
}
