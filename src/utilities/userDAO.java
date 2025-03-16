package utilities;

import entities.Aluno;
import entities.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class userDAO {

    private Aluno aluno;

    public userDAO(Aluno aluno) {
        this.aluno = aluno;
    }

    public userDAO() {
    }

    public Aluno executarLogin(String email, String senha) {

        String SQL = "SELECT a.id, a.nome, a.idade, a.email, t.nome AS turma FROM aluno a JOIN turma t ON t.aluno_id = a.id WHERE a.email = ? AND a.senha = ?";

        try (Connection conn = ConnectionDAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);

            try (ResultSet resultado = stmt.executeQuery()) {
                if (resultado.next()) {
                    Turma turma = new Turma(resultado.getString("turma"));
                    return new Aluno(resultado.getString("id"), resultado.getString("nome"), resultado.getInt("idade"), resultado.getString("email"), turma);
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciais incorretas para realizar o login!");
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Sem conexão com o banco!");
            e.printStackTrace();
        }
        return null;
    }

    public List<String[]> executarNotas(String aluno, String materia) {
        String SQL = "SELECT a.nome, n.valor, d.nome AS disciplina, p.nome AS professor FROM aluno_nota an JOIN nota n ON n.id = an.nota_id JOIN disciplina d ON d.id = n.disciplina_id JOIN professor p ON p.disciplina_id = d.id JOIN aluno a ON a.id = an.aluno_id WHERE a.nome = ? AND d.nome = ?";

        List<String[]> resultados = new ArrayList<>();

        try (Connection conn = ConnectionDAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setString(1, aluno);
            stmt.setString(2, materia);

            try (ResultSet resultado = stmt.executeQuery()) {
                while (resultado.next()) {
                    String[] linha = {
                        resultado.getString("nome"),
                        String.valueOf(resultado.getDouble("valor")),
                        resultado.getString("disciplina"),
                        resultado.getString("professor")
                    };
                    resultados.add(linha);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;
    }

    public void enviarMensagem(String destinatario, String mensagem, String data) {
        try (Connection conn = ConnectionDAO.getConnection()) {
            // 1️ INSERIR MENSAGEM
            String SQL = "INSERT INTO mensagem (id_remetente, conteudo, data_envio) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(SQL, java.sql.Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, aluno.getId()); // Aqui você precisa ter um objeto aluno com o ID
                ps.setString(2, mensagem);
                ps.setString(3, data);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    // 2️ OBTER ID DO DESTINATÁRIO
                    String idDestinatario = null;
                    String SQL2 = "SELECT id FROM aluno WHERE nome = ?";
                    try (PreparedStatement stmt = conn.prepareStatement(SQL2)) {
                        stmt.setString(1, destinatario);
                        try (ResultSet resultado = stmt.executeQuery()) {
                            if (resultado.next()) { // 🔴 Aqui chamamos `next()` antes de `getString()`
                                idDestinatario = resultado.getString("id");
                            }
                        }
                    }

                    // 3️ OBTER ID DA MENSAGEM INSERIDA
                    String idMensagem = null;
                    try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            idMensagem = generatedKeys.getString(1); // Obtendo ID gerado
                        }
                    }

                    // 4️ INSERIR RELAÇÃO MENSAGEM_ALUNO
                    if (idMensagem != null && idDestinatario != null) {
                        String SQL4 = "INSERT INTO mensagem_aluno (mensagem_id, aluno_id) VALUES (?, ?)";
                        try (PreparedStatement psp = conn.prepareStatement(SQL4)) {
                            psp.setString(1, idMensagem); // ID da mensagem inserida
                            psp.setString(2, idDestinatario); // ID do destinatário
                            psp.executeUpdate();
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Mensagem enviada!");
                } else {
                    JOptionPane.showMessageDialog(null, "Mensagem não enviada!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> receberMensagens() {

        List<String[]> mensagens = new ArrayList<>();

        String SQL = "SELECT mm.conteudo AS mensagem, aa.nome AS destinatario, mm.data_envio AS data_envio FROM mensagem_aluno ma JOIN mensagem mm ON mm.id = ma.mensagem_id JOIN aluno aa ON mm.id_remetente = aa.id WHERE ma.aluno_id = ?";

        try (Connection conn = ConnectionDAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setString(1, aluno.getId());

            try (ResultSet resultado = stmt.executeQuery()) {
                while (resultado.next()) {
                    String[] linha = {
                        resultado.getString("mensagem"),
                        resultado.getString("destinatario"),
                        resultado.getString("data_envio")
                    };
                    mensagens.add(linha);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mensagens;
    }

    public List<String[]> mensagensRecebidas() {

        List<String[]> mensagens = new ArrayList<>();

        String SQL = "SELECT mm.conteudo AS mensagem, aa.nome AS destinatario, mm.data_envio AS data FROM mensagem mm JOIN mensagem_aluno ma ON mm.id = ma.id JOIN aluno aa ON aa.id = ma.aluno_id WHERE mm.id_remetente = ?";

        try (Connection conn = ConnectionDAO.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setString(1, aluno.getId());

            try (ResultSet resultado = stmt.executeQuery()) {
                while (resultado.next()) {
                    String[] linha = {
                        resultado.getString("mensagem"),
                        resultado.getString("destinatario"),
                        resultado.getString("data")
                    };
                    mensagens.add(linha);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mensagens;

    }

}
