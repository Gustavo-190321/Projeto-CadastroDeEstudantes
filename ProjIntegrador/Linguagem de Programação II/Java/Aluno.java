package escola;

public class Aluno extends TutorAluno {

	private String idAluno;
	private String nome;
	private String cpf;
	private String dataNascimento;

	public Aluno() {

	}

	public String getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(String idAluno) {
		if (idAluno.length() > 0 && 10 >= idAluno.length())
		this.idAluno = idAluno;
		else
			System.out.println("Digite um ID valido");
			return;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.length() > 0 && 20 >= nome.length())
			this.nome = nome;
		else
			System.out.println("Digite um nome valido");
			return;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (cpf.length() == 11)
			this.cpf = cpf;
		else
			System.out.println("Digite um CPF valido");
			return;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		if (dataNascimento.length() > 6 && 10 >= dataNascimento.length())
			this.dataNascimento = dataNascimento;
		else
			System.out.println("Digite uma Data de nascimento valida");
	}

}
