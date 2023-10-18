package crud;

import java.util.Scanner;

import dao.PacotesDAO;
import modelos.Pacotes;

public class PacotesCRUD {

	public static void main(String[] args) {
		

		PacotesDAO pacotesDAO = new PacotesDAO();
		Scanner s = new Scanner(System.in);

		int opcao = 0, id = 0;

		String periodo = "", destino = "";
		Float preco = (float) 0 ;
		

		do {

			System.out.println("\n============================== PACOTES =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:

				System.out.println("Digite o Periodo da viagem xx/xx/xx :");
				periodo = s.nextLine();
				System.out.println("Digite o Destino da viagem:");
				destino = s.nextLine();
				System.out.println("Digite o preco");
				preco = s.nextFloat();

				Pacotes pacote1 = new Pacotes(periodo, destino, preco);
				pacotesDAO.create(pacote1);

				break;

			case 2:

				for (Pacotes c : pacotesDAO.read())
					System.out.println(c.toString());

				break;

			case 3:

				System.out.println("Digite o ID");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o Periodo da viagem xx/xx/xx :");
				periodo = s.nextLine();
				System.out.println("Digite o Destino da viagem:");
				destino = s.nextLine();
				System.out.println("Digite o preco");
				preco = s.nextFloat();

				Pacotes pacote2 = new Pacotes(id, periodo, destino, preco);
				pacotesDAO.update(pacote2);

				break;

			case 4:
				System.out.println("Digite um id para deletar");
				id = s.nextInt();
				s.nextLine();
				
				pacotesDAO.delete(id);
				break;
				
			case 5:
				System.out.println("Digite um id para consulta");
				id = s.nextInt();
				s.nextLine();
				
				Pacotes pacote3 = pacotesDAO.readById(id);

				System.out.println(pacote3.toString());
			default:
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();

	}

}
