package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Clientes;
import modelos.Compras;
import modelos.Pacotes;

public class CompraDAO {
	// create
	public void create(Compras compra) {

		String sql = "insert into Compras (Data_compras, Id_pacotes, Id_clientes) values ( ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, compra.getData_compras());
			pstm.setInt(2, compra.getPacoteDeViagem().getId_pacotes());
			pstm.setInt(3, compra.getCliente().getId());


			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// read

	public List<Compras> read() {
		List<Compras> compras = new ArrayList<Compras>();
		String sql = "select * from Compras";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				
				Compras compra = new Compras();
				Pacotes pacote = new Pacotes();
				Clientes cliente = new Clientes();

				compra.setId(rset.getInt("Id_compras"));
				compra.setData_compras(rset.getString("Data_compras"));
				

				pacote.setId_pacotes(rset.getInt("Id_pacotes"));
				pacote.setPeriodo_pacotes(rset.getString("Periodo_pacotes"));
				pacote.setDestino_pacotes(rset.getString("Destino_pacotes"));
				pacote.setPreco_pacotes(rset.getFloat("preco_pacotes"));
				
				cliente.setId(rset.getInt("Id_cliente"));
				cliente.setNome_cliente(rset.getString("Nome_cliente"));
				cliente.setEmail_cliente(rset.getString("Email_cliente"));
				cliente.setCpf_cliente(rset.getString("Cpf_clientes"));
				cliente.setSenha_cliente(rset.getString("Senha_clientes"));
				
				compra.setPacoteDeViagem(pacote);
				compra.setCliente(cliente);
				
				compras.add(compra);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return compras;
	}

	// Update

	public void update(Compras compra) {
		String sql = "UPDATE Compras set Periodo_compra = ?, Destino_compra = ?, Preco_compra = ?, WHERE Id_compras = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, compra.getData_compras());
			pstm.setInt(2, compra.getPacoteDeViagem().getId_pacotes());
			pstm.setInt(3, compra.getCliente().getId());

	
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	//delete
	
	public void delete(int id) {
		String sql = "DELETE FROM Compras WHERE Id_compras = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	//readByid
	
	public Compras readById(int id) {
		Compras compra = new Compras();
		String sql = "select * from Compras WHERE Id_compras = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			pstm.setString(1, compra.getData_compras());
			pstm.setInt(2, compra.getPacoteDeViagem().getId_pacotes());
			pstm.setInt(3, compra.getCliente().getId());


			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return compra;
	}
	

}
