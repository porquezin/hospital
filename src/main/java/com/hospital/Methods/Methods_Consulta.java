package com.hospital.Methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.hospital.App;
import com.hospital.DB;
import com.hospital.Models.Consulta;

public class Methods_Consulta {
    Connection dbConect;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Consulta> arrayConsultas = new ArrayList<Consulta>();

    public void criarCons(Consulta consulta) throws SQLException {
        String sql = "INSERT INTO Consultas (IdMedico, IdPaciente, Descrição) values(?,?,?)";

        dbConect = new DB().banco();
        try {
            pstm = dbConect.prepareStatement(sql);
            pstm.setInt(1, consulta.getIdMedico());
            pstm.setInt(2, consulta.getIdPaciente());
            pstm.setString(3, consulta.getDescricao());

            pstm.execute();
            pstm.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Reiniciando sistema!");
            App.main(null);
        }
    }

    public ArrayList<Consulta> listarConsultas() throws SQLException {
        String sql = "select * from Consultas";

        dbConect = new DB().banco();
        try {
            pstm = dbConect.prepareStatement(sql);
            rs = pstm.executeQuery();

            while(rs.next()) {
                Consulta consulta = new Consulta(rs.getInt("IdMedico"), rs.getInt("IdPaciente"), rs.getString("Descrição"));

                consulta.setIdConsulta(rs.getInt("IdConsulta"));

                arrayConsultas.add(consulta);
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Reiniciando sistema!");
            App.main(null);
        }
        return arrayConsultas;
    }

    public void editarConsulta(Consulta consulta) throws SQLException {
        dbConect = new DB().banco();
        String sql = "update Consulta set IdMedico = ?, IdPaciente = ?, Descrição = ? where IdConsulta = ?";

        try {
            pstm = dbConect.prepareStatement(sql);
            pstm.setInt(1, consulta.getIdMedico());
            pstm.setInt(2, consulta.getIdPaciente());
            pstm.setString(3, consulta.getDescricao());
            pstm.setInt(4, consulta.getIdConsulta());

            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Reiniciando sistema!");
            App.main(null);
        }
    }

    public void excluirConsulta(int id) throws SQLException {
        dbConect = new DB().banco();
        String sql = "delete from Consultas where IdConsulta = ?";

        try {
            pstm = dbConect.prepareStatement(sql);
            pstm.setInt(1, id);

            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Reiniciando sistema!");
            App.main(null);
        }
    }
}
