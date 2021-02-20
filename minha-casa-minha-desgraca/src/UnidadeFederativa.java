public enum UnidadeFederativa {

    AC("Acre"),
    AL("Alagoas"),
    AM("Amazonas"),
    AP("Amapá"),
    BA("Bahia"),
    CE("Ceará"),
    DF("Distrito Federal"),
    ES("Espíríto Santo"),
    GO("Goiás"),
    MA("Maranhão"),
    MG("Minas Gerais"),
    MS("Mato Grosso do Sul"),
    MT("Mato Grosso"),
    PA("Pará"),
    PB("Paraíba"),
    PE("Pernambuco"),
    PR("Paraná"),
    PI("Piauí"),
    RJ("Rio de Janeiro", 0.6),
    RN("Rio Grande do Norte"),
    RO("Rondônia"),
    RR("Roraima"),
    RS("Rio Grande do Sul"),
    SC("Santa Catarina"),
    SE("Sergipe"),
    SP("São Paulo", 0.65),
    TO("Tocantins");

    private String nome;
    private Double percentualPagamento;

    UnidadeFederativa(String nome) {
        this(nome, 0.5);
    }

    UnidadeFederativa(String nome, Double percentualPagamento) {
        this.nome = nome;
        this.percentualPagamento = percentualPagamento;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return getNome();
    }

    public Double getPercentualPagamento() {
        return percentualPagamento;
    }
}
