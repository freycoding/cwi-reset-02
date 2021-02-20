public class PropostaFinanciamento {

    private Beneficiario beneficiario;
    private Imovel imovel;
    private Integer prazoPagamento;

    public PropostaFinanciamento(Beneficiario cliente, Imovel imovelASerAvaliado, Integer mesesParaPagamento) {
        this.beneficiario = cliente;
        this.imovel = imovelASerAvaliado;
        this.prazoPagamento = mesesParaPagamento;
    }

    /**
     * Valida a proposta de financiamento e apresenta o resultado para o cliente.
     *
     * A proposta de financiamento é aceita somente se o salário do beneficiário multiplicado pelo prazo de pagamento
     *   for equivalente a pelo menos 50% do valor do imóvel.
     *
     *   Esta regra possui duas exceções: se o imóvel se localiza no estado SP ou RJ,
     *      o salário multiplicado pelo prazo deve ser equivalente a 65% e 60% do valor imóvel (respectivamente).
     */
    public void validarProposta() {

        /*if (UnidadeFederativa.SP == imovel.getEndereco().getEstado()) {
            if (beneficiario.getSalario() * prazoPagamento >= imovel.getValor() * 0.65) {
                imprimirPropostaAprovada();
            } else {
                imprimirPropostaNegada();
            }
        } else if (UnidadeFederativa.RJ.equals(imovel.getEndereco().getEstado())) {
            if (beneficiario.getSalario() * prazoPagamento >= imovel.getValor() * 0.6) {
                imprimirPropostaAprovada();
            } else {
                imprimirPropostaNegada();
            }
        } else {
            if (beneficiario.getSalario() * prazoPagamento >= imovel.getValor() * 0.5) {
                imprimirPropostaAprovada();
            } else {
                imprimirPropostaNegada();
            }
        }*/

        Double capacidadePagamento = beneficiario.getSalario() * prazoPagamento;
        Double minimoParaPagamento = imovel.getValor() * imovel.getEndereco().getEstado().getPercentualPagamento();
        boolean propostaAprovada = capacidadePagamento >= minimoParaPagamento;

        if (propostaAprovada) {
            imprimirPropostaAprovada();
        } else {
            imprimirPropostaNegada();
        }
    }

    private void imprimirPropostaAprovada() {
        System.out.println("Parabéns, rapazzz! Prepare tua mudança, proposta aprovada! :D");
        imprimirPropostaPadrao();
    }

    private void imprimirPropostaNegada() {
        System.out.println("Mas que merda hein! Proposta negada :(");
        imprimirPropostaPadrao();
    }

    private void imprimirPropostaPadrao() {
        System.out.println(" - Beneficiário: "+beneficiario.getNome());
        System.out.println(" - Imóvel: "+imovel.apresentacao());
        System.out.println(" - Prazo da desgraça: "+prazoPagamento);
    }
}
