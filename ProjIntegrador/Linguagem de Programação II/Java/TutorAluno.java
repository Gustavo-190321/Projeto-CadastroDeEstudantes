package escola;

public class TutorAluno {
	private String tutorNome;
	private String departamento;
	private String disciplina;

	public TutorAluno() {

	}

	public String getTutorNome() {
		return tutorNome;
	}

	public void setTutorNome(String tutorNome) {
		if (tutorNome.length() > -1 && 20 >= tutorNome.length())
			this.tutorNome = tutorNome;
		else
			System.out.println("Digite um tutor valido");
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		if (departamento.length() > -1 && 20 >= departamento.length())
			this.departamento = departamento;
		else
			System.out.println("Digite um departamento valido");
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		if (disciplina.length() > -1 && 20 >= disciplina.length())
			this.disciplina = disciplina;
		else
			System.out.println("Digite uma disciplina valida");
	}
}