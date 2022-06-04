package service;

import dao.ProfessorDAO;
import entities.Professor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProfessorService {

	private ProfessorDAO professorDAO = new ProfessorDAO();

	public Professor validaProfessor(Professor professor) {
		if (
			professor.getNome() != null
			&& !professor.getNome().isEmpty()
            && !professor.getFormacao().isEmpty()
			&& professor.getNomeMae() != null
			&& !professor.getNomeMae().isEmpty()
			&& professor.getDataNascimento() != null
			&& !professor.getDataNascimento().isEmpty()
		) {
			professor.setDataCadastro(new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
			professorDAO.adicionarBanco(professor);
		} else {
			System.out.println("Verifique os dados cadastrados. O nome do professor, nome da mãe e data de nascimento são obrigatórios!");
		}

		return null;
	}


	public List<Professor> listaProfessores() {
		return professorDAO.selectListaProfessor();
	}

	public List<Professor> listaProfessorPorId(String id) {
		return professorDAO.selectProfessorPorId(id);
	}

	public Professor adicionarProfessorValidacao(Professor professor) {
		if (validaProfessor(professor) != null) {
			professorDAO.adicionarBanco(professor);
		} else {
			System.out.println("Verifique os dados cadastrados. O nome do professor, nome da mãe e data de nascimento são obrigatórios!");
		}
		return null;
	}

	public Professor atualizarProfessorValidacao(Professor professor) {
		if (validaProfessor(professor) != null) {
			professorDAO.atualizarProfessor(professor);
		} else {
			System.out.println("Verifique os dados cadastrados. O nome do professor, nome da mãe e data de nascimento são obrigatórios!");
		}
		return null;
	}

	public void deletarProfessorValidacao(int id) {
		try {
			professorDAO.selectProfessorPorId(Integer.toString(id));
			professorDAO.excluirProfessor(id);
		} catch (Exception e) {
			System.out.println("Id não encontrado");
			e.printStackTrace();
		}
	}


}
