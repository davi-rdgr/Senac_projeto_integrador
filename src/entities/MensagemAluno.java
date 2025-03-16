package entities;

public class MensagemAluno {

    private Mensagem mensagem;
    private Aluno aluno;

    // construtor
    public MensagemAluno(Mensagem mensagem, Aluno aluno) {
        this.mensagem = mensagem;
        this.aluno = aluno;
    }

    // getters

    public Mensagem getMensagem() {
        return mensagem;
    }

    public Aluno getAluno() {
        return aluno;
    }

    //setters

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

}
