package gerenciamentoFrutas;

import java.util.ArrayList; // importando a classe arraylist para criar listas dinamicas
import java.util.InputMismatchException; // importando a classe para tratar excecoes de entrada invalida
import java.util.Scanner; // importando a classe scanner para ler entradas do usuario

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // instanciando a classe scanner para ler entradas do usuario
        ArrayList<String> frutas = new ArrayList<>(); // instanciando a classe arraylist para armazenar frutas

        while (true) {
            try {
                // exibindo o menu de opcoes
                System.out.println("\nescolha uma opcao:");
                System.out.println("1. adicionar uma fruta");
                System.out.println("2. listar todas as frutas");
                System.out.println("3. modificar uma fruta");
                System.out.println("4. remover uma fruta");
                System.out.println("5. sair");
                System.out.print("opcao: ");
                
                int opcao = scanner.nextInt(); // lendo a opcao escolhida pelo usuario
                scanner.nextLine(); // limpando o buffer

                switch (opcao) {
                    case 1:
                        // adicionando uma nova fruta
                        System.out.print("digite o nome da fruta para adicionar: ");
                        String novaFruta = scanner.nextLine();
                        frutas.add(novaFruta);
                        System.out.println(novaFruta + " foi adicionada.");
                        break;
                    case 2:
                        // listando todas as frutas
                        System.out.println("frutas:");
                        for (String fruta : frutas) {
                            System.out.println(fruta);
                        }
                        break;
                    case 3:
                        // modificando uma fruta existente
                        System.out.print("digite o indice da fruta que deseja modificar: ");
                        int indiceModificar = scanner.nextInt();
                        scanner.nextLine(); // limpando o buffer
                        if (indiceModificar >= 0 && indiceModificar < frutas.size()) {
                            System.out.print("digite o novo nome da fruta: ");
                            String frutaModificada = scanner.nextLine();
                            frutas.set(indiceModificar, frutaModificada);
                            System.out.println("fruta no indice " + indiceModificar + " foi modificada para " + frutaModificada);
                        } else {
                            System.out.println("indice invalido.");
                        }
                        break;
                    case 4:
                        // removendo uma fruta
                        System.out.print("digite o nome da fruta que deseja remover: ");
                        String frutaRemover = scanner.nextLine();
                        if (frutas.remove(frutaRemover)) {
                            System.out.println(frutaRemover + " foi removida.");
                        } else {
                            System.out.println(frutaRemover + " nao foi encontrada.");
                        }
                        break;
                    case 5:
                        // saindo do programa
                        System.out.println("saindo...");
                        scanner.close();
                        return;
                    default:
                        // tratando opcao invalida
                        System.out.println("opcao invalida. tente novamente.");
                }
            } catch (InputMismatchException e) {
                // tratando entrada invalida
                System.out.println("entrada invalida. por favor, digite um numero.");
                scanner.nextLine(); // limpando o buffer
            }
        }
    }
}
