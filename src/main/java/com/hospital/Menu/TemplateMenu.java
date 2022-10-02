package com.hospital.Menu;

public class TemplateMenu {
    public String mostrarMenu(String nome_objeto) {
        String saida = "1 - Listar " + nome_objeto + "\n2 - Criar " + nome_objeto + "\n3 - Editar " + nome_objeto + "\n4 - Excluir " + nome_objeto;
        return saida;
    }
}
