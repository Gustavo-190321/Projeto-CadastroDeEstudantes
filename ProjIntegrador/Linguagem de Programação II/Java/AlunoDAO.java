package escola;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

	private Connection connection;
	private String mensagem;

	// Constantes
	public static final String FALHA_CONEXAO = "Falha na conexão com o banco de dados";
	public static final String FALHA_OPERACAO = "Falha na operação do banco de dados";
	public static final String CADASTRO_SUCESSO = "Cadastro realizado com sucesso";
	public static final String CADASTRO_INSUCESSO = "O cadastro não foi realizado";
	public static final String CONSULTA_VAZIA = "A consulta não retornou resultados";
	public static final String ATUALIZACAO_SUCESSO = "Atualização realizada com sucesso";
	public static final String ATUALIZACAO_INSUCESSO = "A atualização não foi realizada";
	public static final String EXCLUSAO_SUCESSO = "Exclusão realizada com sucesso";
	public static final String EXCLUSAO_INSUCESSO = "A exclusão não foi realizada";

	public String getMensagem() {
		return mensagem;
	}

	public boolean inserir(Aluno aluno) {

		String query = null;
		PreparedStatement ps = null;
		int inserted = 0;
		boolean status = true;

		connection = ConnectionFactory.getConnection();

		if (connection == null) {
			System.out.println("Falha na Conexão");
			mensagem = FALHA_CONEXAO;
			return false;
		}

		query = "INSERT INTO tb_aluno (idAluno, nome, cpf, dataNascimento, nomeTutor, departamento, disciplina)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, aluno.getIdAluno());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getCpf());
			ps.setString(4, aluno.getDataNascimento());
			ps.setString(5, aluno.getTutorNome());
			ps.setString(6, aluno.getDepartamento());
			ps.setString(7, aluno.getDisciplina());

			inserted = ps.executeUpdate();

			if (inserted > 0) {
				System.out.println("Cadastrado com sucesso");
				mensagem = CADASTRO_SUCESSO;
			} else {
				System.out.println("Cadastrado falhou");
				mensagem = CADASTRO_INSUCESSO;
				status = false;
			}
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			System.out.println("Falha na Operação");
			mensagem = FALHA_OPERACAO;
			status = false;
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ex) {
				System.out.println("Falha na Operação");
				System.err.println("SQLException: " + ex.getMessage());
			}
		}

		ConnectionFactory.closeConnection();

		return status;
	}

	public List<Aluno> listar() {

		List<Aluno> lista = null;
		String query = null;
		Statement s = null;
		int count = 0;

		connection = ConnectionFactory.getConnection();

		if (connection == null) {
			System.out.println("Falha de Conexão");
			mensagem = FALHA_CONEXAO;
			return null;
		}

		query = "SELECT * FROM tb_aluno";

		try {
			s = connection.createStatement();
			ResultSet rs = s.executeQuery(query);

			lista = new ArrayList<Aluno>();

			while (rs.next()) {

				Aluno aluno = new Aluno();

				aluno.setIdAluno(rs.getString("idAluno"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setDataNascimento(rs.getString("dataNascimento"));
				aluno.setTutorNome(rs.getString("nomeTutor"));
				aluno.setDepartamento(rs.getString("departamento"));
				aluno.setDisciplina(rs.getString("disciplina"));

				lista.add(aluno);
				count++;
			}

			if (count == 0) {
				System.out.println("Consulta Vazia");
				mensagem = CONSULTA_VAZIA;
			}

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			System.out.println("Falha na Operação");
			mensagem = FALHA_OPERACAO;
			lista = null;
		} finally {
			try {
				if (s != null)
					s.close();
			} catch (Exception ex) {
				System.out.println("Falha na Operação");
				System.err.println("SQLException: " + ex.getMessage());
			}
		}

		ConnectionFactory.closeConnection();

		return lista;
	}

	public List<Aluno> pesquisar(String nome) {

		List<Aluno> lista = null;
		String query = null;
		PreparedStatement ps = null;
		int count = 0;

		connection = ConnectionFactory.getConnection();

		if (connection == null) {
			System.out.println("Falha de Conexão");
			mensagem = FALHA_CONEXAO;
			return null;
		}

		query = "SELECT * FROM tb_aluno WHERE nome = ?";

		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, nome);

			ResultSet rs = ps.executeQuery();

			lista = new ArrayList<Aluno>();

			while (rs.next()) {

				Aluno aluno = new Aluno();

				aluno.setIdAluno(rs.getString("idAluno"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setDataNascimento(rs.getString("dataNascimento"));

				lista.add(aluno);
				count++;
			}

			if (count == 0) {
				System.out.println("Consulta vazia");
				mensagem = CONSULTA_VAZIA;
			}
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			System.out.println("Falha na Operação");
			mensagem = FALHA_OPERACAO;
			lista = null;
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ex) {
				System.out.println("Falha na Operação");
				System.err.println("SQLException: " + ex.getMessage());

			}
		}

		ConnectionFactory.closeConnection();
		
		return lista;
	}

	public boolean atualizar(int id, Aluno aluno) {

		String query = null;
		PreparedStatement ps = null;
		int updated = 0;
		boolean status = true;

		connection = ConnectionFactory.getConnection();

		if (connection == null) {
			System.out.println("Falha de Conexão");
			mensagem = FALHA_CONEXAO;
			return false;
		}

		query = "UPDATE tb_aluno SET nome=?, cpf=?, dataNascimento=?, nomeTutor=?, departamento=?, disciplina=?  WHERE idAluno = ?";

		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getCpf());
			ps.setString(3, aluno.getDataNascimento());
			ps.setString(4, aluno.getTutorNome());
			ps.setString(5, aluno.getDepartamento());
			ps.setString(6, aluno.getDisciplina());

			ps.setInt(7, id);

			updated = ps.executeUpdate();

			if (updated > 0) {
				System.out.println("Atualizado com Sucesso");
				mensagem = ATUALIZACAO_SUCESSO;
			} else {
				System.out.println("Atualização apresentou Falhas");
				mensagem = ATUALIZACAO_INSUCESSO;
				status = false;
			}
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			System.out.println("Falha na Operação");
			mensagem = FALHA_OPERACAO;
			status = false;
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ex) {
				System.out.println("Falha na Operação");
				System.err.println("SQLException: " + ex.getMessage());
			}
		}

		ConnectionFactory.closeConnection();

		return status;
	}

	public boolean remover(int id) {

		String query = null;
		PreparedStatement ps = null;
		int deleted = 0;
		boolean status = true;

		connection = ConnectionFactory.getConnection();

		if (connection == null) {
			System.out.println("Falha de Conexão");
			mensagem = FALHA_CONEXAO;
			return false;
		}

		query = "DELETE FROM tb_aluno WHERE idAluno = ?";

		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);

			deleted = ps.executeUpdate();

			if (deleted > 0) {
				System.out.println("Excluido com sucesso");
				mensagem = EXCLUSAO_SUCESSO;
			} else {
				System.out.println("Exclusão apresentou falhas");
				mensagem = EXCLUSAO_INSUCESSO;
				status = false;
			}
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			System.out.println("Falha na Operação");
			mensagem = FALHA_OPERACAO;
			status = false;
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ex) {
				System.out.println("Falha na Operação");
				System.err.println("SQLException: " + ex.getMessage());
			}
		}

		ConnectionFactory.closeConnection();

		return status;
	}
}
