package com.hospital;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        Scanner inputNum = new Scanner(System.in);

        boolean programa = true;
        while (programa == true) {

            System.out.print("1. Marcar consulta; \n2. Sair \nDigite: ");
            int escolha = inputNum.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Sexo 3");
                    System.out.println("Retornando ao lobby...");
                    break;
                case 2:
                    programa = false;
                    break;
            
                default:
                    break;
            }
        }

        input.close();
        inputNum.close();
        System.out.println("Encerrando programa.");
    }
}
