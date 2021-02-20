public class Endereco {

    // logradouro, número, complemento, bairro, cidade e estado (unidade federativa)
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private UnidadeFederativa estado;

    public Endereco(String logradouro, Integer numero, String complemento, String bairro, String cidade, UnidadeFederativa uf) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public UnidadeFederativa getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return getLogradouro() + ", nº "+ getNumero()+", no bairro "+getBairro()
                + ", em "+getCidade()+"/"+getEstado();
    }
}
