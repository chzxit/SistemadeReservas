package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Quarto {
	private String id;
	private String numero;
	private boolean status;

	public Quarto(String numero, boolean status, String id) {
		this.status = status;
		this.numero = numero;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Quarto " + numero;
	}

	
	public static void verificarReserva(String id) {
		String url = "jdbc:sqlite:resources/bdSistemadeReservas.db";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			conn = DriverManager.getConnection(url);

			
			String sql = "SELECT STATUS FROM QUARTOS WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			
			if (rs.next()) {
				String statusReserva = rs.getString("STATUS");
				if ("reservado".equalsIgnoreCase(statusReserva)) {
					System.out.println("O quarto com ID " + id + " já foi reservado.");
				} else {
					System.out.println("O quarto com ID " + id + " está disponível para reserva.");
					
				}
			} else {
				System.out.println("Quarto com ID " + id + " não encontrado.");
			}

		} catch (SQLException e) {
			System.out.println("Erro ao verificar reserva: " + e.getMessage());
		} finally {
			
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException ex) {
				System.out.println("Erro ao fechar recursos: " + ex.getMessage());
			}
		}
	}
}
