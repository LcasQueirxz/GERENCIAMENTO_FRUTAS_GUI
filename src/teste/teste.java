package teste;

// importando as classes necessarias de outros pacotes, aplicando e estruturando a minha interface
import gerenciamento.*;
import gerenciamentoFrutas.Main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> frutas = new ArrayList<>(); // utilizando os arrays para tirar e colocar o que eu quero
        interfacee frutaManager = new implementacao(); // identificando as classes

        while (true) {
            try {
                System.out.println("\nescolha uma opcao:");
                System.out.println("1. adicionar uma fruta");
                System.out.println("2. listar todas as frutas");
                System.out.println("3. modificar uma fruta");
                System.out.println("4. remover uma fruta");
                System.out.println("5. usar metodo de outraclasse");
                System.out.println("6. sair");
                System.out.print("opcao: ");
                
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("digite o nome da fruta para adicionar: ");
                        String novaFruta = scanner.nextLine();
                        frutaManager.addFruta(novaFruta); // aplicando dados que eu quero que sejam exibidos
                        System.out.println(novaFruta + " foi adicionada.");
                        break;
                    case 2:
                        System.out.println("frutas:");
                        for (String fruta : frutaManager.listarFrutas()) { // mostrando como eu quero estruturar o chamado para a lista
                            System.out.println(fruta);
                        }
                        break;
                    case 3:
                        System.out.print("digite o indice da fruta que deseja modificar: ");
                        int indiceModificar = scanner.nextInt();
                        scanner.nextLine();
                        if (indiceModificar >= 0 && indiceModificar < frutaManager.listarFrutas().length) {
                            System.out.print("digite o novo nome da fruta: ");
                            String frutaModificada = scanner.nextLine();
                            frutas.set(indiceModificar, frutaModificada); // utilizando os arrays para tirar e colocar o que eu quero
                            System.out.println("fruta no indice " + indiceModificar + " foi modificada para " + frutaModificada);
                        } else {
                            System.out.println("indice invalido.");
                        }
                        break;
                    case 4:
                        System.out.print("digite o nome da fruta que deseja remover: ");
                        String frutaRemover = scanner.nextLine();
                        frutaManager.deleteFruta(frutaRemover); // aplicando dados que eu quero que sejam exibidos
                        System.out.println(frutaRemover + " foi removida.");
                        break;
                    case 5:
                        Main.main(new String[0]); // usando extends para chamar outro diretorio
                        break;
                    case 6:
                        System.out.println("saindo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("opcao invalida. tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("entrada invalida. por favor, digite um numero.");
                scanner.nextLine();
            }
        }
    }
}
