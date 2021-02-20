import java.text.DecimalFormat;

public class Casa extends Imovel {

    private Boolean patio;

    public Casa(Endereco endereco, Double valor, Boolean possuiPatio) {
        super(endereco, valor);
        this.patio = possuiPatio;
    }

    public Boolean getPatio() {
        return patio;
    }

    @Override
    public String apresentacao() {
        return String.format("Casa localizada em %s, %s pátio, ao custo de %s", getEndereco(), (patio ? "com" : "sem"),
                DecimalFormat.getCurrencyInstance().format(getValor()));
    }
}
