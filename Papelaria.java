package app;

import java.util.Arrays;
import java.util.List;
import model.ItemPedido;

public class Papelaria {

    private static final double FRETE_GRATIS = 150.0;
    private static final double VALOR_FRETE = 12.90;
    private static final double ZERO = 0.0;

    public static void main(String[] args) {

        System.out.println("=== PAPELARIA PONTO FINAL ===\n");

        List<ItemPedido> itens = Arrays.asList(
            new ItemPedido("Caderno 10 materias", 24.90, 1, false),
            new ItemPedido("Lapis grafite", 1.50, 12, false),
            new ItemPedido("Kit escolar basico", 84.00, 1, true),
            new ItemPedido("Caneta azul", 2.80, 10, false)
        );

        double soma = ZERO;

        for (ItemPedido item : itens) {
            item.exibirLinha();
            soma += item.calcularValorLiquido();
        }

        double frete = calcularFrete(soma);

        System.out.printf("%nItens:  R$ %.2f%n", soma);
        System.out.printf("Frete:  R$ %.2f%n", frete);
        System.out.printf("Total do pedido: R$ %.2f%n", soma + frete);
    }

    public static double calcularFrete(double valorItens) {
        if (valorItens >= FRETE_GRATIS) {
            return ZERO;
        }

        return VALOR_FRETE;
    }

    /*
     * RESPOSTAS DO EXERCÍCIO
     *
     * a) O bloco repetido é o cálculo do valor bruto,
     * desconto, valor líquido e a impressão de cada item.
     *
     * b) As variáveis numeradas eram descricao1 a descricao4,
     * valor1 a valor4, qtd1 a qtd4, kit1 a kit4,
     * bruto1 a bruto4, abatimento1 a abatimento4
     * e liquido1 a liquido4.
     *
     * c) Números mágicos:
     * 0.15  = desconto de 15% para kits.
     * 0.08  = desconto de 8% por quantidade.
     * 10    = quantidade mínima para desconto.
     * 150.0 = valor mínimo para frete grátis.
     * 12.90 = valor do frete.
     * 0.0   = desconto zero ou frete grátis.
     *
     * Esses valores foram substituídos por constantes.
     */
}