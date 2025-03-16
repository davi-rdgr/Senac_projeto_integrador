package entities;

public class Diretoria extends Usuario {

    private String tipo;

    // construtor
    public Diretoria(String id, String nome, int idade, String email, String senha, String tipo) {
        super(id, nome, idade, email, senha);
        this.tipo = tipo;
    }

    // getters
    public String getTipo() {
        return tipo;
    }

    // setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // métodos
    @Override
    public String toString() {
        return "DIRETORIA:\n nome: " + nome + "\n tipo: " + tipo + "\n email: " + email + "\n senha: " + senha;
    }
}
