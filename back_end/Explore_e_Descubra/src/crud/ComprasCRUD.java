package crud;

import java.util.Scanner;

import dao.CompraDAO;
import modelos.Compras;

public class ComprasCRUD {

	public static void main(String[] args) {

		CompraDAO compraDAO = new CompraDAO();
		Scanner s = new Scanner(System.in);

		int opcao = 0, id = 0;

		String periodo = "", destino = "";
		Float preco = (float) 0 ;
		

		do {

			System.out.println("\n==============================  COMPRA =================================\n");
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

				Compras compra1 = new Compras();
				compraDAO.create(compra1);

				break;

			case 2:

				for (Compras c : compraDAO.read())
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

				Compras compra2 = new Compras();
				compraDAO.update(compra2);

				break;

			case 4:
				System.out.println("Digite um id para deletar");
				id = s.nextInt();
				s.nextLine();
				
				compraDAO.delete(id);
				break;
				
			case 5:
				System.out.println("Digite um id para consulta");
				id = s.nextInt();
				s.nextLine();
				
				Compras compra3 = compraDAO.readById(id);

				System.out.println(compra3.toString());
			default:
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();

	}

}
