import java.util.Scanner;

class Impostos {

    public static void main(String[] args) {
        String nome = "";
        String profissao = "";
        Double[] salarios = new Double[12];

        while (true) {

            int menu = mostrarMenu();

            if (menu == 1) {
                nome = lerNome();
                profissao = lerProfissao();
                salarios = lerSalarios();
            } else if (menu == 2) {
                mostrarDados(nome, profissao);
            } else if (menu == 3) {
                mostrarSalarios(salarios);
            } else if (menu == 4) {
                calcularImpostos(salarios);
            } else if (menu == 5) {
                System.exit(0);
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    // Método que mostra o menu para o usuário e lê um inteiro que é a opção
    // Este método retorna um inteiro para o método main
    private static int mostrarMenu() {
        Scanner s = new Scanner(System.in);
        System.out.println();
        System.out.println("1. Cadastrar dados do habitante");
        System.out.println("2. Ver dados do habitante");
        System.out.println("3. Ver salários");
        System.out.println("4.  Calcular impostos");
        System.out.println("5. Sair");
        System.out.println();
        System.out.println("Selecione uma opção [1-5]: ");
        // Usamos a classe Scanner para ler um inteiro
        // E o retornamos para o método que chamou
        return s.nextInt();
    }

    // Método que lê o nome do usuário
    // Usamos para retornar o nome para o método main
    private static String lerNome() {
        Scanner s = new Scanner(System.in);
        System.out.println("Por favor informe seu nome: ");
        return s.next();
    }

    private static String lerProfissao() {
        Scanner s = new Scanner(System.in);
        System.out.println("Por favor informe sua profissão: ");
        return s.next();
    }

    private static Double[] lerSalarios() {
        Scanner s = new Scanner(System.in);
        Double[] salarios = new Double[12];
        System.out.println("Informe o salário para cada mês do ano:");
        for (int i = 0; i < 12; i++) {
            System.out.println(i + 1 + ":");

            salarios[i] = s.nextDouble();
        }

        return salarios;
    }

    private static void mostrarDados(String nome, String profissao) {
        System.out.println();
        System.out.println("Dados do habitante:");
        System.out.println("Nome: " + nome);
        System.out.println("Profissão: " + profissao);
        System.out.println();
    }

    private static void mostrarSalarios(Double[] salarios) {
        System.out.println();
        System.out.println("Mês\'Salário'");
        for (int i = 0; i < 12; i++) {
            System.out.println(i + 1 + "\t" + salarios[i]);
        }
        System.out.println();
    }

    private static void calcularImpostos(Double[] salarios) {
        System.out.println();
        System.out.println("Mês\'Salário'\tImposto");
        for (int i = 0; i < 12; i++) {
            Double quota = 0.0;
            if (salarios[i] > 4500) {
                quota = 0.28;
            } else if (salarios[i] > 3000) {
                quota = 0.18;
            } else if (salarios[i] > 2000) {
                quota = 0.8;
            }
            System.out.println(i + 1 + "\t" + salarios[i] + "\t" + salarios[i] * quota);
        }
        System.out.println();
    }
}