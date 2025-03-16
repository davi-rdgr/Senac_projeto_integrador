package entities;

public class Aluno extends Usuario {

    private Turma turma;

    // construtor:
    public Aluno() {
    }

    public Aluno(String id, String nome, int idade, String email, String senha) {
        super(id, nome, idade, email, senha);
    }

    public Aluno(String id, String nome, int idade, String email, Turma turma) {
        super(id, nome, idade, email, "");
        this.turma = turma;
    }

    public String getTurma() {
        return turma.getNome();
    }

    // métodos
    @Override
    public String toString() {
        return "ALUNO: \n nome: " + nome + "\n idade: " + idade + "\n email: " + email + "\n senha: " + senha;
    }

}
