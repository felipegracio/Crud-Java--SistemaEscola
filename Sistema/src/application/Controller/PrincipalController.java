package application.Controller;

import application.model.Disciplina;
import application.model.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.SQLException;

public class PrincipalController {

    // Professor

    @FXML
    private TextField tfCodigoProfessor;

    @FXML
    private TextField tfNomeProfessor;

    @FXML
    private TextField tfTitulacaoProfessor;

    @FXML
    private TextArea taListaProfessores;

    @FXML
    private Button btnAtualizarProfessor;

    @FXML
    private Button btnBuscarProfessor;

    @FXML
    private Button btnExcluirProfessor;

    @FXML
    private Button btnPesquisarProfessor;

    @FXML
    private Button btnCopiarProfessor;

    @FXML
    private Button btnInserirProfessor;



    @FXML
    public void acaoProfessor(ActionEvent event) {
        String cmd = event.getSource().toString();
        System.out.println(cmd);

        ProfessorController professorController = new ProfessorController(tfCodigoProfessor, tfNomeProfessor, tfTitulacaoProfessor, taListaProfessores);

        if((cmd.contains("Inserir") || cmd.contains("Atualizar"))
                && (tfCodigoProfessor.getText().isEmpty() || tfNomeProfessor.getText().isEmpty()
                || tfTitulacaoProfessor.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha os campos.", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else {
            if((cmd.contains("Excluir") || cmd.contains("Buscar") || cmd.contains("tfCodigoProfessor"))
                    && tfCodigoProfessor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha o código.", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    if(cmd.contains("Listar")) {
                        professorController.buscarProfessores();
                    } else {
                        Professor professor = new Professor();
                        professor.setCodigo(Integer.parseInt(tfCodigoProfessor.getText()));
                        professor.setNome(tfNomeProfessor.getText());
                        professor.setTitulacao(tfTitulacaoProfessor.getText());
                        if(cmd.contains("Inserir")) {
                            professorController.inserirProfessor(professor);
                        } else if(cmd.contains("Atualizar")) {
                            professorController.atualizarProfessor(professor);
                        } else if(cmd.contains("Excluir")) {
                            professorController.excluirProfessor(professor);
                        } else if(cmd.contains("Buscar") || cmd.contains("tfCodigoProfessor")) {
                            professorController.buscarProfessor(professor);
                        }
                    }
                } catch (ClassNotFoundException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        }
    }
    @FXML
    public void copiarProfessor(ActionEvent event) {
        if(tfCodigoProfessor.getText().isEmpty() || tfNomeProfessor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else {
            tfDisciplinaCodigoProfessor.setText(tfCodigoProfessor.getText());
            lblNomeProfessor.setText(tfNomeProfessor.getText());
        }
    }

    // Disciplina

    @FXML
    private TextField tfCodigoDisciplina;

    @FXML
    private TextField tfDisciplinaCodigoProfessor;

    @FXML
    private TextField tfNomeDisciplina;

    @FXML
    private TextArea taListarDisciplinas;

    @FXML
    private Button btnAtualizarDisciplina;

    @FXML
    private Button btnBuscarDisciplina;

    @FXML
    private Button btnExcluirDisciplina;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnCopiarDisciplina;

    @FXML
    private Button btnInserirDisciplina;

    @FXML
    private Label lblNomeProfessor;

    @FXML
    public void acaoDisciplina(ActionEvent event) {
        application.Controller.DisciplinaController disciplinaController = new application.Controller.DisciplinaController(tfCodigoDisciplina, tfNomeDisciplina, tfDisciplinaCodigoProfessor, lblNomeProfessor, taListarDisciplinas);
        String cmd = event.getSource().toString();
        System.out.println(cmd);
        if((cmd.contains("Inserir") || cmd.contains("Atualizar")) &&
                tfCodigoDisciplina.getText().isEmpty() || tfNomeProfessor.getText().isEmpty() ||
                tfDisciplinaCodigoProfessor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else {
            if((cmd.contains("Excluir") || cmd.contains("Buscar") || cmd.contains("tfDisciplinaCodigoProfessor")) &&
                    tfCodigoDisciplina.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha o código", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    if(cmd.contains("Listar")) {
                        disciplinaController.buscarDisciplinas();
                    } else {
                        Disciplina disciplina = new Disciplina();
                        disciplina.setCodigo(Integer.parseInt(tfCodigoDisciplina.getText()));
                        disciplina.setNome(tfNomeDisciplina.getText());
                        if(!tfCodigoDisciplina.getText().isEmpty()) {
                            Professor professor = new Professor();
                            professor.setCodigo(Integer.parseInt(tfDisciplinaCodigoProfessor.getText()));
                            disciplina.setProfessor(professor);
                        }
                        if(cmd.contains("Inserir")) {
                            disciplinaController.inserirDisciplina(disciplina);
                        } else if(cmd.contains("Atualizar")) {
                            disciplinaController.atualizarDisciplina(disciplina);
                        } else if(cmd.contains("Excluir")) {
                            disciplinaController.excluirDisciplina(disciplina);
                        } else if(cmd.contains("Buscar") || cmd.contains("tfCodigoDisciplina")) {
                            disciplinaController.buscarDisciplna(disciplina);
                        }
                    }
                } catch (ClassNotFoundException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }

            }
        }
    }
}
