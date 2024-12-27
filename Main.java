import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static class Item {
        int id;
        String name;

        public Item(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name;
        }
    }

    private static ArrayList<Item> items = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\nCRUD Básico Menu:");
            System.out.println("1. Criar item ");
            System.out.println("2. Ler itens");
            System.out.println("3. Atualizar item");
            System.out.println("4. Deletar item");
            System.out.println("5. Sair");

            escolha = leia.nextInt();
            leia.nextLine(); // Consumir nova linha

            switch (escolha) {
                case 1:
                    criarItem(leia);
                    break;
                case 2:
                    lerItem();
                    break;
                case 3:
                    atualizarItem(leia);
                    break;
                case 4:
                    deletarItem(leia);
                    break;
                case 5:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 5);
    }

    private static void criarItem(Scanner scanner) {
        System.out.println("Digite o nome do item a ser criado:");
        String nome = scanner.nextLine();
        items.add(new Item(nextId++, nome));
        System.out.println("Item adicionado com sucesso!");
    }

    private static void lerItem() {
        if (items.isEmpty()) {
            System.out.println("Nada encontrado!");
        } else {
            System.out.println("Itens:");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    private static void atualizarItem(Scanner scanner) {
        System.out.println("Digite o ID do item que deseja atualizar:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        for (Item item : items) {
            if (item.id == id) {
                System.out.println("Digite o novo nome para o item:");
                String novoNome = scanner.nextLine();
                item.name = novoNome;
                System.out.println("Item atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Item com ID " + id + " não encontrado.");
    }

    private static void deletarItem(Scanner scanner) {
        System.out.println("Digite o ID do item que deseja deletar:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).id == id) {
                items.remove(i);
                System.out.println("Item deletado com sucesso!");
                return;
            }
        }
        System.out.println("Item com ID " + id + " não encontrado.");
    }
}
