package escola;

public class Email {
    private String endereco;

    public Email(String endereco) throws IllegalAccessException {
        if(endereco ==null || endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9._]+\\.[a-zA-Z]{2,}$")){
                throw new IllegalAccessException("Email invalido");
        }
        this.endereco = endereco;
    }
}
