package com.hospital;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hospital.Methods.Methods_Paciente;
import com.hospital.Models.Paciente;

public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        int escolha = 0;
        boolean sair = false;
        while(sair != true) {
            Methods_Paciente MP = new Methods_Paciente();
            ArrayList<Paciente> lista = MP.listarPacientes();
            System.out.println();
            System.out.println("Hospital Fox.");
            System.out.println("1 - Paciente\n2 - Medico\n3 - Consulta");
            escolha = Integer.parseInt(System.console().readLine("Digite a opção: "));
            switch (escolha) {
                case 1:
                System.out.println();
                System.out.println("Aba Paciente.");
                System.out.println("1 - Listar Paciente\n2 - Criar Paciente\n3 - Editar Paciente\n4 - Excluir Paciente");
                escolha = Integer.parseInt(System.console().readLine("Digite a opção: "));
                switch (escolha) {
                    case 1:
                    System.out.println("Listar Paciente");
                    for (Paciente item : lista) {
                        System.out.println(item.imprimir());
                                System.out.println();
                            }
                            break;
                        case 2:
                            System.out.println("Criar Paciente");
                            String nome = System.console().readLine("Nome Paciente: ");
                            String cpf = System.console().readLine("CPF Paciente: ");
                            String email = System.console().readLine("Email Paciente: ");
                            String senha = System.console().readLine("Senha Paciente: ");
                            MP.criarPac(new Paciente(nome, cpf, email, senha));;
                            break;
                        case 3:
                            System.out.println("Editar Paciente");
                            int id = Integer.parseInt(System.console().readLine("Informe o Id do paciente que deseja editar"));
                            nome = System.console().readLine("Nome Paciente: ");
                            cpf = System.console().readLine("CPF Paciente: ");
                            email = System.console().readLine("Email Paciente: ");
                            senha = System.console().readLine("Senha Paciente: ");
                            Paciente pacienteEditar = new Paciente(nome, cpf, email, senha);
                            pacienteEditar.setIdPaciente(id);
                            MP.editarPaciente(pacienteEditar);
                            break;
                        case 4:
                            System.out.println("Excluir Paciente");
                            for (Paciente item : lista) {
                                System.out.println(item.getIdPaciente() + " - " + item.getNome());
                                System.out.println();
                            }
                            id = Integer.parseInt(System.console().readLine("Informe o Id do paciente que deseja excluir"));
                            MP.excluirPaciente(id);
                            break;
                        default:
                            System.out.println("Erro encontrado");
                            break;
                    }
                    break;
                default:
                    System.out.println("Erro encontrado");
                    break;
            }
        }

    }
}
