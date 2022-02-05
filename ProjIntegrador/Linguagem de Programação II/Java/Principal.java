package escola;

import java.util.Scanner;

public class Principal {

	public static void cadastrarAluno(Scanner teclado, Escola escola) {

		Aluno aluno = new Aluno();

		System.out.println("\nInserir um Aluno");
		System.out.println("Id: ");
		aluno.setIdAluno(teclado.nextLine());

		System.out.println("Nome: ");
		aluno.setNome(teclado.nextLine());

		System.out.println("CPF: ");
		aluno.setCpf(teclado.nextLine());

		System.out.println("Data de Nascimento: ");
		aluno.setDataNascimento(teclado.nextLine());

		System.out.println("Nome do Tutor: ");
		aluno.setTutorNome(teclado.nextLine());

		System.out.println("Departamento: ");
		aluno.setDepartamento(teclado.nextLine());

		System.out.println("Disciplina: ");
		aluno.setDisciplina(teclado.nextLine());

		escola.cadastrarAluno(aluno);
	}

	public static void atualizarAluno(Scanner teclado, Escola escola) {

		Aluno aluno = new Aluno();

		System.out.println("Nome: ");
		aluno.setNome(teclado.nextLine());

		System.out.println("CPF: ");
		aluno.setCpf(teclado.nextLine());

		System.out.println("Data de Nascimento: ");
		aluno.setDataNascimento(teclado.nextLine());

		System.out.println("Nome do Tutor: ");
		aluno.setTutorNome(teclado.nextLine());

		System.out.println("Departamento: ");
		aluno.setDepartamento(teclado.nextLine());

		System.out.println("Disciplina: ");
		aluno.setDisciplina(teclado.nextLine());

		escola.atualizarAluno(aluno);
	}

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		Escola escola = new Escola();
		int opc = 0;

		do {
			@SuppressWarnings("resource")
			Scanner menu = new Scanner(System.in);
			System.out.print("\n");
			System.out.println("Cadastro de Estudantes");
			System.out.println("1 Ц Cadastrar");
			System.out.println("2 Ц Listar");
			System.out.println("3 Ц Pesquisar");
			System.out.println("4 Ц Atualizar");
			System.out.println("5 Ц Remover");
			System.out.println("6 Ц Sair");
			opc = menu.nextInt();

			switch (opc) {
			case 1: {
				// Cadastrar 1 (um) funcionario
				cadastrarAluno(teclado, escola);
				break;
			}

			case 2: {
				// Listar todos os funcionarios
				escola.listarAlunos();
				break;
			}

			case 3: {
				// Pesquisar aluno
				escola.PesquisarAluno();
				break;
			}
			case 4: {
				// Atualiza aluno
				atualizarAluno(teclado, escola);
				break;
			}
			case 5: {
				// Remove aluno
				escola.removeAluno();
				break;
			}
			case 6:{
				System.out.println();
				break;
			}
			default: {
				System.out.println("Digite uma opзгo valida");
				break;
			}
			}
		} while (opc != 6);

		System.out.print("Voce Saiu");
		// Fechando o teclado
		teclado.close();
	}
}
