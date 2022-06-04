package dao;

import config.DataBase;
import entities.Turma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {

	private Connection connection;

	public  TurmaDAO() {
		this.connection = new DataBase().conect();
	}

	public void adicionarBanco(Turma turma) {
		String sql = "INSERT INTO turma(nome, andar, curso, dt_cadastro) VALUES(?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, turma.getNome());
            stmt.setString(2, turma.getAndar());
			stmt.setString(3, turma.getCurso());
			stmt.setString(4, turma.getDataCadastro());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void atualizarTurma(Turma turma) {
		String sql = "UPDATE turma SET nome = ?, andar = ?, curso = ?, dt_cadastro = ? "+
				"WHERE id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, turma.getNome());
            stmt.setString(2, turma.getAndar());
			stmt.setString(3, turma.getCurso());
			stmt.setString(4, turma.getDataCadastro());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Problemas ao atualizar turma, linha de erro: " + e.getMessage());
		}
	}

	public void excluirTurma(int id) {
		String sql = "DELETE FROM professor WHERE id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Problemas ao deletar turma, linha de erro: " + e.getMessage());
		}
	}
	

	public List<Turma> selectListaTurma() {
		String sql = "SELECT * FROM turma";
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return recuperaProfessores(stmt, rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private List<Turma> recuperaProfessores(Statement stmt, ResultSet rs) {
		return null;
	}

	public List<Turma> selectTurmaPorId(String idTurma) {
		String sql = "SELECT * FROM turma WHERE id = " + idTurma;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return recuperaTurmas(stmt, rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private static List<Turma> recuperaTurmas(Statement stmt, ResultSet rs) throws SQLException {
		List<Turma> lista = new ArrayList<Turma>();

		while (rs.next()) {
			Turma turma = new Turma();

			turma.setId(rs.getInt("id"));
			turma.setNome(rs.getString("nome"));
            turma.setCurso(rs.getString("curso"));
			turma.setAndar(rs.getString("andar"));
			turma.setDataCadastro(rs.getString("dt_cadastro"));

			lista.add(turma);
		}

		stmt.close();

		return lista;
	}
}
