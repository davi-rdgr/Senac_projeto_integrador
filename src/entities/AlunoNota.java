package entities;

public class AlunoNota {

    private Aluno aluno;
    private Nota nota;
    private Disciplina disciplina;

    // construtor
    public AlunoNota(Aluno aluno, Nota nota, Disciplina disciplina) {
        this.aluno = aluno;
        this.nota = nota;
        this.disciplina = disciplina;
    }

    // getters

    public Aluno getAluno() {
        return aluno;
    }

    public Nota getNota() {
        return nota;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    // setters

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

}
