package escola;

 public class CPF {

    private String numero;

    public CPF(String numero) throws IllegalAccessException {
        if(numero ==null || !numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")){
            throw new IllegalAccessException("CPF invalido!");
        }
        this.numero = numero;
    }
}
