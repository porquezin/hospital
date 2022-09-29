package com.hospital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.hospital.Methods.Methods_Paciente;
import com.hospital.Models.Paciente;

public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        Methods_Paciente MP = new Methods_Paciente();
        
        ArrayList<Paciente> lista = MP.listarPacientes();

        for (Paciente item : lista) {
            System.out.println(item.getIdPaciente());
            System.out.println(item.getNome());
        }

    }
}
