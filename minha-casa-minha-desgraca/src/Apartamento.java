import java.text.DecimalFormat;

public class Apartamento extends Imovel {

    private Integer andar;

    public Apartamento(Endereco endereco, Double valor, Integer andar) {
        super(endereco, valor);
        this.andar = andar;
    }

    public Integer getAndar() {
        return andar;
    }

    @Override
    public String apresentacao() {
        return String.format("Apartamento no %sº andar, localizado em %s, ao custo de %s", andar, getEndereco(),
                DecimalFormat.getCurrencyInstance().format(getValor()));
    }
}
