package entities;

public class Frequencia {

    private String data;
    private boolean presente;
    private HorarioAula horarioAula;
    private Aluno aluno;
    private Disciplina disciplina;

    // construtor
    public Frequencia(String data, boolean presente, HorarioAula horarioAula, Aluno aluno, Disciplina disciplina) {
        this.data = data;
        this.presente = presente;
        this.horarioAula = horarioAula;
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

    // getters

    public String getData() {
        return data;
    }

    public boolean estaPresente() {
        return presente;
    }

    public HorarioAula getHorarioAula() {
        return horarioAula;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
    // setters

    public void setData(String data) {
        this.data = data;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public void setHorarioAula(HorarioAula horarioAula) {
        this.horarioAula = horarioAula;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

}
