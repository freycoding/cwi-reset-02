import java.util.ArrayList;
import java.util.List;

public class ImoveisParaFinanciamento {

    private static final Double VALOR_MINIMO_IMOVEL = 50000.0;
    private static final Double VALOR_MAXIMO_IMOVEL = 1000000.0;

    private List<Imovel> imoveis;

    public ImoveisParaFinanciamento() {
        imoveis = new ArrayList<>();
    }

    /**
     * Registra um imóvel como opção de financiamento. O imóvel só pode ser aceito se o valor dele for
     *   maior ou igual a R$ 50.000,00 e menor ou igual a R$ 1.000.000,00.
     *
     *   Obs.: quando o valor do imóvel não estiver na faixa solicitada, deve ser apresentada a seguinte mensagem
     *   (substituindo XXX pelo valor do imóvel):
     *      " > Atenção, problema de registro! Imóveis com valor R$ XXX não são aceitos no programa."
     */
    public void registrarImovel(Imovel imovel) {

        if (imovel.getValor() >= VALOR_MINIMO_IMOVEL && imovel.getValor() <= VALOR_MAXIMO_IMOVEL) {
            imoveis.add(imovel);
        } else {
            System.out.println(" > Atenção, problema de registro! Imóveis com valor R$ "+imovel.getValor()+" não são aceitos no programa.");
        }
    }

    /**
     * Retorna opções de financiamento cujo valor do imóvel seja inferior ou igual ao valor limite que foi informado.
     */
    public List<Imovel> buscarOpcoes(double valorLimite) {

        List<Imovel> opcoes = new ArrayList<>();

        // percorre a lista de imóveis
        for (Imovel imovel : imoveis) {
            if (imovel.getValor() <= valorLimite) {
                opcoes.add(imovel);
            }
        }

        return opcoes;
    }
}
