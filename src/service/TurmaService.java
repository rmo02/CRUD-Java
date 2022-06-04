package service;

import dao.TurmaDAO;
import entities.Turma;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TurmaService {

	private TurmaDAO turmaDAO = new TurmaDAO();

	public Turma validaTurma(Turma turma) {
		if (
			turma.getNome() != null
			&& !turma.getNome().isEmpty()
            && !turma.getCurso().isEmpty()
			&& turma.getAndar() != null
		) {
			turma.setDataCadastro(new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
			turmaDAO.adicionarBanco(turma);
		} else {
			System.out.println("Verifique os dados cadastrados. O nome do turma é obrigatório!");
		}

		return null;
	}


	public List<Turma> listaTurmas() {
		return turmaDAO.selectListaTurma();
	}

	public List<Turma> listaTurmaPorId(String id) {
		return turmaDAO.selectTurmaPorId(id);
	}

	public Turma adicionarTurmaValidacao(Turma turma) {
		if (validaTurma(turma) != null) {
			turmaDAO.adicionarBanco(turma);
		} else {
			System.out.println("Verifique os dados cadastrados. O nome da turma é obrigatório!");
		}
		return null;
	}

	public Turma atualizarTurmaValidacao(Turma Turma) {
		if (validaTurma(Turma) != null) {
			turmaDAO.atualizarTurma(Turma);
		} else {
			System.out.println("Verifique os dados cadastrados. O nome da turma é obrigatório!");
		}
		return null;
	}

	public void deletarTurmaValidacao(int id) {
		try {
			turmaDAO.selectTurmaPorId(Integer.toString(id));
			turmaDAO.excluirTurma(id);
		} catch (Exception e) {
			System.out.println("Id não encontrado");
			e.printStackTrace();
		}
	}


}
