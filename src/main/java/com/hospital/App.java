package com.hospital;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hospital.Menu.TemplateMenu;
import com.hospital.Methods.Methods_Consulta;
import com.hospital.Methods.Methods_Medico;
import com.hospital.Methods.Methods_Paciente;
import com.hospital.Models.Consulta;
import com.hospital.Models.Medico;
import com.hospital.Models.Paciente;

public class App {
    public static void main(String[] args) throws SQLException {
        boolean sair = false;
        while (sair != true) {
            int escolha = 0;
            int opcoes = 0;

            Methods_Paciente MP = new Methods_Paciente();
            ArrayList<Paciente> listaPacientes = MP.listarPacientes();

            Methods_Medico MM = new Methods_Medico();
            ArrayList<Medico> listaMedicos = MM.listarMedicos();

            Methods_Consulta MC = new Methods_Consulta();
            ArrayList<Consulta> listaConsultas = MC.listarConsultas();

            TemplateMenu menu = new TemplateMenu();

            System.out.println();
            System.out.println("Hospital Fox.");
            System.out.println("1 - Paciente\n2 - Medico\n3 - Consulta\n4 - sair");
            escolha = Integer.parseInt(System.console().readLine("Digite a opção: "));
            switch (escolha) {
                case 1:
                    System.out.println();
                    System.out.println("Aba Paciente.");
                    System.out.println(menu.mostrarMenu("Paciente"));
                    opcoes = Integer.parseInt(System.console().readLine("Digite a opção: "));
                    switch (opcoes) {
                        case 1:
                            System.out.println("Listar Paciente");
                            for (Paciente item : listaPacientes) {
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
                            MP.criarPac(new Paciente(nome, cpf, email));
                            break;
                        case 3:
                            System.out.println("Editar Paciente");
                            int id = Integer
                                    .parseInt(System.console().readLine("Informe o Id do paciente que deseja editar"));
                            nome = System.console().readLine("Nome Paciente: ");
                            cpf = System.console().readLine("CPF Paciente: ");
                            email = System.console().readLine("Email Paciente: ");
                            senha = System.console().readLine("Senha Paciente: ");
                            Paciente pacienteEditar = new Paciente(nome, cpf, email);
                            pacienteEditar.setIdPaciente(id);
                            MP.editarPaciente(pacienteEditar);
                            break;
                        case 4:
                            System.out.println("Excluir Paciente");
                            for (Paciente item : listaPacientes) {
                                System.out.println(item.getIdPaciente() + " - " + item.getNome());
                                System.out.println();
                            }
                            id = Integer
                                    .parseInt(System.console().readLine("Informe o Id do paciente que deseja excluir"));
                            MP.excluirPaciente(id);
                            break;
                        default:
                            System.out.println("Erro encontrado");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Aba Medico.");
                    System.out.println(menu.mostrarMenu("Medico"));
                    opcoes = Integer.parseInt(System.console().readLine("Digite a opção: "));
                    switch (opcoes) {
                        case 1:
                            System.out.println("Listar Medicos");
                            for (Medico item : listaMedicos) {
                                System.out.println(item.imprimir());
                                System.out.println();
                            }
                            break;
                        case 2:
                            System.out.println("Criar medico");
                            String nome = System.console().readLine("Nome do medico: ");
                            String CRM = System.console().readLine("CRM do medico: ");
                            String espc = System.console().readLine("Especialidade: ");
                            MM.criarMed(new Medico(nome, CRM, espc));
                            break;
                        case 3:
                            System.out.println("Editar medico");
                            int id = Integer
                                    .parseInt(System.console().readLine("Informe o Id do Medico que deseja editar: "));
                            nome = System.console().readLine("Nome do medico: ");
                            CRM = System.console().readLine("CRM do medico ");
                            espc = System.console().readLine("Especialidade: ");
                            Medico medicoEditar = new Medico(nome, CRM, espc);
                            medicoEditar.setIdMedico(id);
                            MM.editarMedico(medicoEditar);
                            break;
                        case 4:
                            System.out.println("Excluir Medico");
                            for (Medico item : listaMedicos) {
                                System.out.println(item.getIdMedico() + " - " + item.getNome());
                                System.out.println();
                            }
                            id = Integer
                                    .parseInt(System.console().readLine("Informe o Id do medico que deseja excluir"));
                            MM.excluirMedico(id);
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Aba Consulta.");
                    System.out.println(menu.mostrarMenu("Consulta"));
                    opcoes = Integer.parseInt(System.console().readLine("Digite a opção: "));
                    switch (opcoes) {
                        case 1:
                            System.out.println("Listar Consultas");
                            for (Consulta item : listaConsultas) {
                                System.out.println(item.imprimir());
                                System.out.println();
                            }
                            break;
                        case 2:
                            System.out.println("Criar Consulta");
                            int IdMedico = Integer.parseInt(System.console().readLine("Id Medico: "));
                            int IdPaciente = Integer.parseInt(System.console().readLine("Id Paciente: "));
                            String desc = System.console().readLine("Descrição: ");
                            MC.criarCons(new Consulta(IdMedico, IdPaciente, desc));
                            break;
                        case 3:
                            System.out.println("Editar Consulta");
                            int id = Integer
                                    .parseInt(System.console().readLine("Informe o Id da Consulta que deseja editar: "));
                            IdMedico = Integer.parseInt(System.console().readLine("Id Medico: "));
                            IdPaciente = Integer.parseInt(System.console().readLine("Id Paciente: "));
                            desc = System.console().readLine("Descrição: ");
                            Consulta consultaEditar = new Consulta(IdMedico, IdPaciente, desc);
                            consultaEditar.setIdConsulta(id);
                            MC.editarConsulta(consultaEditar);
                            break;
                        case 4:
                            System.out.println("Excluir Consulta");
                            for (Consulta item : listaConsultas) {
                                System.out.println("Id Consulta: " + item.getIdConsulta());
                                System.out.println();
                            }
                            id = Integer
                                    .parseInt(System.console().readLine("Informe o Id da Consulta que deseja excluir: "));
                            MC.excluirConsulta(id);
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    sair = true;
                default:
                    System.out.println("Erro encontrado");
                    break;
            }
        }

    }
}
