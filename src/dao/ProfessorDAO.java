package dao;

import config.DataBase;
import entities.Professor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

	private Connection connection;

	public  ProfessorDAO() {
		this.connection = new DataBase().conect();
	}

	public void adicionarBanco(Professor professor) {
		String sql = "INSERT INTO professor(nome, formacao, nome_mae, nome_pai, dt_nasc, dt_cadastro) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getFormacao());
			stmt.setString(3, professor.getNomeMae());
			stmt.setString(4, professor.getNomePai());
			stmt.setString(5, professor.getDataNascimento());
			stmt.setString(6, professor.getDataCadastro());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void atualizarProfessor(Professor professor) {
		String sql = "UPDATE professor SET nome = ?, formacao = ?, nome_mae = ?, nome_pai = ?, dt_nasc = ?, dt_cadastro = ? "+
				"WHERE id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getFormacao());
			stmt.setString(3, professor.getNomeMae());
			stmt.setString(4, professor.getNomePai());
			stmt.setString(5, professor.getDataNascimento());
			stmt.setString(6, professor.getDataCadastro());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Problemas ao atualizar professor, linha de erro: " + e.getMessage());
		}
	}

	public void excluirProfessor(int id) {
		String sql = "DELETE FROM professor WHERE id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Problemas ao deletar professor, linha de erro: " + e.getMessage());
		}
	}
	

	public List<Professor> selectListaProfessor() {
		String sql = "SELECT * FROM professor";
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return recuperaProfessores(stmt, rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Professor> selectProfessorPorId(String idProfessor) {
		String sql = "SELECT * FROM professor WHERE id = " + idProfessor;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return recuperaProfessores(stmt, rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private static List<Professor> recuperaProfessores(Statement stmt, ResultSet rs) throws SQLException {
		List<Professor> lista = new ArrayList<Professor>();

		while (rs.next()) {
			Professor professor = new Professor();

			professor.setId(rs.getInt("id"));
			professor.setNome(rs.getString("nome"));
            professor.setFormacao(rs.getString("formacao"));
			professor.setNomeMae(rs.getString("nome_mae"));
			professor.setNomePai(rs.getString("nome_pai"));
			professor.setDataNascimento(rs.getString("dt_nasc"));
			professor.setDataCadastro(rs.getString("dt_cadastro"));

			lista.add(professor);
		}

		stmt.close();

		return lista;
	}
}
