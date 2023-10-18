package crud;

import java.util.Scanner;

import dao.ClienteDAO;

import modelos.Clientes;

public class ClientesCRUD {

	public static void main(String[] args) {
	

		ClienteDAO clienteDAO = new ClienteDAO();
		Scanner s = new Scanner(System.in);

		int opcao = 0, id = 0;

		String nome, email, cpf, senha;

		do {

			System.out.println("\n============================== CLIENTES =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:

				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o CPF:");
				cpf = s.nextLine();
				System.out.println("Digite o email:");
				email = s.nextLine();
				System.out.println("Digite a senha:");
				senha = s.nextLine();

				Clientes cliente1 = new Clientes(nome, cpf, email, senha);
				clienteDAO.create(cliente1);

				break;

			case 2:

				for (Clientes c : clienteDAO.read())
					System.out.println(c.toString());

				break;

			case 3:

				System.out.println("Digite o ID");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o CPF:");
				cpf = s.nextLine();
				System.out.println("Digite o email:");
				email = s.nextLine();
				System.out.println("Digite a senha:");
				senha = s.nextLine();

				Clientes cliente2 = new Clientes(id, nome, cpf, email, senha);
				clienteDAO.update(cliente2);

				break;

			case 4:
				System.out.println("Digite um id para deletar");
				id = s.nextInt();
				s.nextLine();
				
				clienteDAO.delete(id);
				break;
				
			case 5:
				System.out.println("Digite um id para consulta");
				id = s.nextInt();
				s.nextLine();
				
				Clientes cliente3 = clienteDAO.readById(id);

				System.out.println(cliente3.toString());
			default:
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();

	}
}
