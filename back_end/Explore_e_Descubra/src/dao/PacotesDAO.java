package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Pacotes;

public class PacotesDAO {
	// create
	public void create(Pacotes pacote) {

		String sql = "insert into Pacotes (Periodo_pacotes, Destino_pacotes, preco_pacotes) values ( ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pacote.getPeriodo_pacotes());
			pstm.setString(2, pacote.getDestino_pacotes());
			pstm.setFloat(3, pacote.getPreco_pacotes());

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

	public List<Pacotes> read() {
		List<Pacotes> pacotes = new ArrayList<Pacotes>();
		String sql = "select * from Pacotes";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				
				Pacotes pacote = new Pacotes();

				pacote.setId_pacotes(rset.getInt("Id_pacotes"));
				pacote.setPeriodo_pacotes(rset.getString("Periodo_pacotes"));
				pacote.setDestino_pacotes(rset.getString("Destino_pacotes"));
				pacote.setPreco_pacotes(rset.getFloat("Preco_pacotes"));


				pacotes.add(pacote);
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

		return pacotes;
	}

	// Update

	public void update(Pacotes pacote) {
		String sql = "UPDATE Pacotes set Periodo_pacote = ?, Destino_pacote = ?, Preco_pacote = ?, WHERE Id_pacotes = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pacote.getPeriodo_pacotes());
			pstm.setString(2, pacote.getDestino_pacotes());
			pstm.setFloat(3, pacote.getPreco_pacotes());
			pstm.setInt(5, pacote.getId_pacotes());

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
		String sql = "DELETE FROM Pacotes WHERE Id_pacotes = ?";

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
	
	public Pacotes readById(int id) {
		Pacotes pacote = new Pacotes();
		String sql = "select * from Pacotes WHERE Id_pacotes = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			pacote.setId_pacotes(rset.getInt("ID_pacote"));
			pacote.setPeriodo_pacotes(rset.getString("Periodo_pacotes"));
			pacote.setDestino_pacotes(rset.getString("Destino_pacotes"));
			pacote.setPreco_pacotes(rset.getFloat("Preco_pacotes"));

			

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
		return pacote;
	}
	
	
}
