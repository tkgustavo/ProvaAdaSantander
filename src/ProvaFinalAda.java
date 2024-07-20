import java.util.InputMismatchException;
import java.util.Scanner;

public class ProvaFinalAda {
    public static void main(String[] args) {
        final int QUANTIDADE_DE_ENTRADA = 5;
        double[] salarios = new double[QUANTIDADE_DE_ENTRADA];

        Scanner scanner = new Scanner(System.in);

        final String MENSAGEM_ENTRADA_INVALIDA = "Salário deve ser um número real positivo.";

        for (int i = 0; i < QUANTIDADE_DE_ENTRADA; i++) {
            boolean isSalarioValido = false;

            do {
                System.out.println("Insira o " + (i + 1) + "º salário:");

                try {
                    salarios[i] = scanner.nextDouble();

                    if(!salarioPositivo(salarios[i]))
                        throw new InputMismatchException();

                    isSalarioValido = true;
                } catch(InputMismatchException e) {
                    System.out.println(MENSAGEM_ENTRADA_INVALIDA);
                    scanner.nextLine();
                }
            } while (!isSalarioValido);
        }
        for (double salarioBruto : salarios) {
            double descontoInss = calcularInss(salarioBruto);
            double descontoImpostoRenda = calcularImpostoRenda(salarioBruto);
            double salarioLiquido = salarioBruto - descontoInss - descontoImpostoRenda;

            System.out.printf("Salário Bruto: R$%.2f\n", salarioBruto);
            System.out.printf("Desconto INSS: R$%.2f\n", descontoInss);
            System.out.printf("Desconto imposto de renda: R$%.2f\n", descontoImpostoRenda);
            System.out.printf("Salário líquido: R$%.2f\n", salarioLiquido);
            System.out.println("----------------------------------------------------");
        }

    }
    private static double calcularInss(double salarioBruto) {
        double porcentoDesconto;

        if(salarioBruto <= 1212.00)
            porcentoDesconto = 7.5;
        else if(salarioBruto <= 2427.35)
            porcentoDesconto = 9;
        else if(salarioBruto <= 3641.03)
            porcentoDesconto = 12;
        else
            porcentoDesconto = 14;

        return salarioBruto * porcentoDesconto / 100;
    }
    private static double calcularImpostoRenda(double salarioBruto) {
        double porcentoDesconto;

        if(salarioBruto <= 1903.98)
            porcentoDesconto = 0;
        else if(salarioBruto <= 2826.65)
            porcentoDesconto = 7.5;
        else if(salarioBruto <= 3751.05)
            porcentoDesconto = 15;
        else if(salarioBruto <= 4664.68)
            porcentoDesconto = 22.5;
        else
            porcentoDesconto = 27.5;

        return salarioBruto * porcentoDesconto / 100;
    }
    private static boolean salarioPositivo(double entrada) {
        return entrada > 0;
    }
}
