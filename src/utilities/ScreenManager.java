package utilities;

import entities.Aluno;
import entities.Usuario;
import ui.Calendario;
import ui.Homepage;
import ui.Mensagens;
import ui.Mensagens_escrever;
import ui.Mensagens_recebidas;
import ui.Notas;
import ui.Notificacoes;
import ui.Perfil;
import ui.Sala_aula;

public class ScreenManager extends javax.swing.JFrame {

    private Usuario usuario;

    public ScreenManager() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void abrirCalendario(Aluno aluno) {
        Calendario calendario = new Calendario(aluno);
        calendario.setVisible(true);
        calendario.setLocationRelativeTo(this);
    }

    public void abrirNotas(Aluno aluno) {
        Notas notas = new Notas(aluno);
        notas.setVisible(true);
        notas.setLocationRelativeTo(this);
    }

    public void abrirSalaaula(Aluno aluno) {
        Sala_aula salaaula = new Sala_aula(aluno);
        salaaula.setVisible(true);
        salaaula.setLocationRelativeTo(this);
    }

    public void abrirPerfil(Aluno aluno) {
        Perfil perfil = new Perfil(aluno);
        perfil.setVisible(true);
        perfil.setLocationRelativeTo(this);
    }

    public void abrirMensagens(Aluno aluno) {
        Mensagens mensagens = new Mensagens(aluno);
        mensagens.setVisible(true);
        mensagens.setLocationRelativeTo(this);
    }

    public void abrirMensagensEscrever(Aluno aluno) {
        Mensagens_escrever mse = new Mensagens_escrever(aluno);
        mse.setVisible(true);
        mse.setLocationRelativeTo(this);
    }

    public void abrirMensagensRecebidas(Aluno aluno) {
        Mensagens_recebidas msr = new Mensagens_recebidas(aluno);
        msr.setVisible(true);
        msr.setLocationRelativeTo(this);
    }

    public void abrirNotificacoes(Aluno aluno) {
        Notificacoes notificacoes = new Notificacoes(aluno);
        notificacoes.setVisible(true);
        notificacoes.setLocationRelativeTo(this);
    }

    public void abrirHomepage(Aluno aluno) {
        Homepage homepage = new Homepage(aluno);
        homepage.setVisible(true);
        homepage.setLocationRelativeTo(this);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ScreenManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScreenManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
