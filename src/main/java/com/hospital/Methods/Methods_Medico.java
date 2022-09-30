package com.hospital.Methods;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hospital.DB;
import com.hospital.Models.Medico;

public class Methods_Medico {
    Connection dbConect;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Medico> arrayMedicos = new ArrayList<Medico>();

    public void criarMed(Medico medico) throws SQLException {
        String sql = "INSERT INTO Medicos (nome, crm, especialidade) values(?,?,?)";

        dbConect = new DB().banco();
        try {
            pstm = dbConect.prepareStatement(sql);
            pstm.setString(1, medico.getNome());
            pstm.setString(2, medico.getCRM());
            pstm.setString(3, medico.getEspecialidade());

            pstm.execute();
            pstm.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Medico> listarMedicos() throws SQLException {
        String sql = "select * from Medicos";

        dbConect = new DB().banco();
        try {
            pstm = dbConect.prepareStatement(sql);
            rs = pstm.executeQuery();

            while(rs.next()) {
                Medico medico = new Medico(rs.getString("nome"), rs.getString("crm"), rs.getString("especialidade"));

                medico.setIdMedico(rs.getInt("IdPaciente"));

                arrayMedicos.add(medico);
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return arrayMedicos;
    }

    public void editarMedico(Medico medico) throws SQLException {
        dbConect = new DB().banco();
        String sql = "update Medicos set nome = ?, crm = ?, especialidade = ? where IdMedico = ?";

        try {
            pstm = dbConect.prepareStatement(sql);
            pstm.setString(1, medico.getNome());
            pstm.setString(2, medico.getCRM());
            pstm.setString(3, medico.getEspecialidade());
            pstm.setInt(4, medico.getIdMedico());

            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirMedico(int id) throws SQLException {
        dbConect = new DB().banco();
        String sql = "delete from Medicos where IdMedico = ?";

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
