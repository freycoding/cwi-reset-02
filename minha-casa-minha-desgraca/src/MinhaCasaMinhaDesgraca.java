import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MinhaCasaMinhaDesgraca {

    public static void main(String[] args) throws Exception {

        System.out.println("\n ### Olá, seja bem vindo ao magnífico programa Minha Casa - Minha Desgraça ###\n");

        ImoveisParaFinanciamento opcoesParaFinanciamento = new ImoveisParaFinanciamento();



        /**
         * INÍCIO
         *
         * NÃO MODIFICAR ESTA CLASSE ANTES DESTA LINHA.
         */

        Endereco enderecoMg = new Endereco("Rua Mg", 0, null, "Bairro Mg", "Belo Horizonte", UnidadeFederativa.MG);
        Imovel casaMg = new Casa(enderecoMg, 100000.0, false);

        Endereco enderecoSp1 = new Endereco("Rua Sp 1", 1, null, "Bairro Sp", "São Paulo", UnidadeFederativa.SP);
        Imovel casaSp = new Casa(enderecoSp1, 975000.0, true);

        Endereco enderecoSp2 = new Endereco("Rua Sp 2", 2, "Apto 202", "Bairro Sp 2", "São Paulo", UnidadeFederativa.SP);
        Imovel apartamentoSp = new Apartamento(enderecoSp2, 750000.0, 8);

        Endereco enderecoRs1 = new Endereco("Rua Rs 1", 3, null, "Bairro Rs", "Porto Alegre", UnidadeFederativa.RS);
        Imovel casaRs = new Casa(enderecoRs1, 300000.0, true);

        Endereco enderecoRs2 = new Endereco("Rua Rs 2", 4, "Apto 908", "Bairro Rs", "Porto Alegre", UnidadeFederativa.RS);
        Imovel apartamentoRs = new Apartamento(enderecoRs2, 400000.0, 2);

        Endereco enderecoRj = new Endereco("Rua Rj", 5, null, "Bairro Rj", "Rio de Janeiro", UnidadeFederativa.RJ);
        Imovel casaRj = new Casa(enderecoRj, 650000.0, true);

        opcoesParaFinanciamento.registrarImovel(casaMg);
        opcoesParaFinanciamento.registrarImovel(casaSp);
        opcoesParaFinanciamento.registrarImovel(apartamentoSp);
        opcoesParaFinanciamento.registrarImovel(casaRs);
        opcoesParaFinanciamento.registrarImovel(apartamentoRs);
        opcoesParaFinanciamento.registrarImovel(casaRj);

        /**
         * FIM
         *
         * NÃO MODIFICAR ESTA CLASSE APÓS ESTA LINHA.
         */



        List<Imovel> todasAsOpcoes = opcoesParaFinanciamento.buscarOpcoes(Double.MAX_VALUE);
        if (todasAsOpcoes == null || todasAsOpcoes.isEmpty()) {
            throw new RuntimeException("\n\nAtenção! Você precisa registrar opções de financiamento antes de começar a usar o programa.\n"
                + "Use o método 'registrarImovel', do objeto 'opcoesParaFinanciamento', para incluir algumas opções.\n");
        }

        System.out.println("\nVamos lá, preciso de algumas respostas...\n");
        Thread.sleep(1000);

        System.out.println(" Qual é o teu nome?");
        String nomeBeneficiario = new Scanner(System.in).next();
        Thread.sleep(500);

        System.out.println(" Agora eu preciso saber sobre a mascada, "+ nomeBeneficiario +". Qual é o teu salário?");
        double salarioBeneficiario = new Scanner(System.in).nextDouble();
        Thread.sleep(500);

        Beneficiario beneficiario = new Beneficiario(nomeBeneficiario, salarioBeneficiario);

        System.out.println(" Hummmm, tá grandão hein. E qual é o limite do valor de imóveis que você procura?");
        double valorParaPesquisa = new Scanner(System.in).nextDouble();
        Thread.sleep(500);

        System.out.println("\nTá, deixa eu ver aqui o que eu tenho de opções até "+ DecimalFormat.getCurrencyInstance().format(valorParaPesquisa) +"...");
        Thread.sleep(new Random().nextInt(4000) + 1000);

        List<Imovel> opcoesViaveis = opcoesParaFinanciamento.buscarOpcoes(valorParaPesquisa);
        if (opcoesViaveis == null || opcoesViaveis.isEmpty()) {
            throw new RuntimeException("\n\nPQP! Essa desgraça de programa não tem casas neste valor! Comece uma nova simulação.");
        }

        System.out.println("\nCerto! Encontrei "+ opcoesViaveis.size() + " opções aqui. Dá uma olhada:");
        int index = 0;
        for (Imovel imovel : opcoesViaveis) {
            System.out.printf(" [%d] %s\n", ++index, imovel.apresentacao());
            Thread.sleep(250);
        }

        Imovel imovelEscolhido = null;
        while (imovelEscolhido == null) {

            Thread.sleep(250);

            System.out.println("\nQual a opção que mais te agrada? (Me diz apenas o número.)");
            int opcaoEscolhida = new Scanner(System.in).nextInt();

            Thread.sleep(250);

            if (opcaoEscolhida < 1 || opcaoEscolhida > opcoesViaveis.size()) {
                System.out.println(" > Opção inválida!");
            } else {
                imovelEscolhido = opcoesViaveis.get(opcaoEscolhida - 1);
            }
        }

        System.out.println("\nShow de bola! Agora me diz em quantos meses você quer pagar essa tranqueira:");
        int mesesParaPagamento = new Scanner(System.in).nextInt();

        System.out.printf("\nHumm, certo %s. Você ganha %s e quer financiar um imóvel de %s, no estado %s, pagando em %d meses. Deixa eu ver se é possível...\n\n",
                beneficiario.getNome(),
                DecimalFormat.getCurrencyInstance().format(beneficiario.getSalario()),
                DecimalFormat.getCurrencyInstance().format(imovelEscolhido.getValor()),
                imovelEscolhido.getEndereco().getEstado(),
                mesesParaPagamento);
        Thread.sleep(new Random().nextInt(4000) + 1000);

        PropostaFinanciamento financiamento = new PropostaFinanciamento(beneficiario, imovelEscolhido, mesesParaPagamento);
        financiamento.validarProposta();
    }
}
