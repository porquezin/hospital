package com.hospital.Methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hospital.DB;
import com.hospital.Models.Paciente;

public class Methods_Paciente {
    Connection dbConect;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Paciente> arrayPacientes = new ArrayList<Paciente>();

    public void criarPac(Paciente paciente) throws SQLException {
        String sql = "INSERT INTO Pacientes (nome, email, cpf) values(?,?,?)";

        dbConect = new DB().banco();
        try {
            pstm = dbConect.prepareStatement(sql);
            pstm.setString(1, paciente.getNome());
            pstm.setString(2, paciente.getEmail());
            pstm.setString(3, paciente.getCpf());

            pstm.execute();
            pstm.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Paciente> listarPacientes() throws SQLException {
        String sql = "select * from Pacientes";

        dbConect = new DB().banco();
        try {
            pstm = dbConect.prepareStatement(sql);
            rs = pstm.executeQuery();

            while(rs.next()) {
                Paciente paciente = new Paciente(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"));
                paciente.setIdPaciente(rs.getInt("IdPaciente"));

                arrayPacientes.add(paciente);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return arrayPacientes;
    }

    public void editarPaciente(Paciente paciente) throws SQLException {
        dbConect = new DB().banco();
        String sql = "update Pacientes set nome = ?, email = ?, cpf = ? where IdPaciente = ?";

        try {
            pstm = dbConect.prepareStatement(sql);
            pstm.setString(1, paciente.getNome());
            pstm.setString(2, paciente.getEmail());
            pstm.setString(3, paciente.getCpf());
            pstm.setInt(4, paciente.getIdPaciente());

            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirPaciente(int id) throws SQLException {
        dbConect = new DB().banco();
        String sql = "delete from Pacientes where idPaciente = ?";

        try {
            pstm = dbConect.prepareStatement(sql);
            pstm.setInt(1, id);

            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
