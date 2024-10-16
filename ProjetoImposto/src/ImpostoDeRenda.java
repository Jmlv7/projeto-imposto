import java.util.Scanner;

public class ImpostoDeRenda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Renda anual com salário: ");
        double rendaSalarioAnual = scanner.nextDouble();

        System.out.print("Renda anual com prestação de serviço: ");
        double rendaServicosAnual = scanner.nextDouble();

        System.out.print("Renda anual com ganho de capital: ");
        double ganhoCapitalAnual = scanner.nextDouble();

        System.out.print("Gastos médicos: ");
        double gastosMedicos = scanner.nextDouble();

        System.out.print("Gastos educacionais: ");
        double gastosEducacionais = scanner.nextDouble();

        scanner.close();  // Fechando o scanner

        // Cálculo do imposto sobre salário
        double salarioMensal = rendaSalarioAnual / 12;
        double impostoSalario = calcularImpostoSalario(salarioMensal) * 12;

        // Cálculo dos impostos sobre serviços e ganho de capital
        double impostoServicos = rendaServicosAnual * 0.15;
        double impostoGanhoCapital = ganhoCapitalAnual * 0.20;

        // Cálculo do imposto bruto total
        double impostoBrutoTotal = impostoSalario + impostoServicos + impostoGanhoCapital;

        // Cálculo do máximo dedutível e gastos dedutíveis
        double maximoDedutivel = impostoBrutoTotal * 0.30;
        double gastosDedutiveis = Math.min(gastosMedicos + gastosEducacionais, maximoDedutivel);

        // Cálculo do imposto devido
        double impostoDevido = impostoBrutoTotal - gastosDedutiveis;

        // Exibindo o relatório final
        exibirRelatorio(impostoSalario, impostoServicos, impostoGanhoCapital, 
                        impostoBrutoTotal, maximoDedutivel, gastosDedutiveis, impostoDevido);
    }

    // Função para calcular o imposto sobre salário mensal
    public static double calcularImpostoSalario(double salarioMensal) {
        if (salarioMensal < 3000) {
            return 0.0;
        } else if (salarioMensal < 5000) {
            return salarioMensal * 0.10;
        } else {
            return salarioMensal * 0.20;
        }
    }

    // Função para exibir o relatório final
    public static void exibirRelatorio(double impostoSalario, double impostoServicos, 
                                       double impostoGanhoCapital, double impostoBrutoTotal, 
                                       double maximoDedutivel, double gastosDedutiveis, 
                                       double impostoDevido) {
        System.out.println("\n### RELATÓRIO DE IMPOSTO DE RENDA ###");
        System.out.println("* CONSOLIDADO DE RENDA:");
        System.out.printf("Imposto sobre salário: %.2f\n", impostoSalario);
        System.out.printf("Imposto sobre serviços: %.2f\n", impostoServicos);
        System.out.printf("Imposto sobre ganho de capital: %.2f\n", impostoGanhoCapital);

        System.out.println("* DEDUÇÕES:");
        System.out.printf("Máximo dedutível: %.2f\n", maximoDedutivel);
        System.out.printf("Gastos dedutíveis: %.2f\n", gastosDedutiveis);

        System.out.println("* RESUMO:");
        System.out.printf("Imposto bruto total: %.2f\n", impostoBrutoTotal);
        System.out.printf("Abatimento: %.2f\n", gastosDedutiveis);
        System.out.printf("Imposto devido: %.2f\n", impostoDevido);
    }
}