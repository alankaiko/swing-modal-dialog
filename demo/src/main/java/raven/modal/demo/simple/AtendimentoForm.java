package raven.modal.demo.simple;

import net.miginfocom.swing.MigLayout;
import raven.modal.demo.component.CampoDataFormatada;
import raven.modal.demo.system.FormModalDialogGeneric;

import javax.swing.*;

public class AtendimentoForm extends FormModalDialogGeneric {
    JTextField registro = new JTextField();
    JTextField nomePaciente = new JTextField();
    JTextField numGuias = new JTextField();
    JTextField usuarioAtendimento = new JTextField();
    JTextField codConvenio = new JTextField();
    JTextField nomeConvenio = new JTextField();
    JTextField numeroCarteira = new JTextField();
    JTextArea observacao = new JTextArea();
    JTextField medicoSolicitante = new JTextField();
    JTextField total = new JTextField();
    CampoDataFormatada dataNascimento = new CampoDataFormatada();
    CampoDataFormatada dataExame = new CampoDataFormatada();
    CampoDataFormatada dataValidadeCarteira = new CampoDataFormatada();

    public AtendimentoForm() {
        this.init();
    }

    private void init() {
        this.setLayout(new MigLayout("fillx,wrap,insets 5 30 5 30", "[grow][grow][grow][grow][grow][grow]", ""));

        //---------------------------------------------------------------
        this.add(new JLabel("Registro"), "cell 0 0");
        this.add(this.registro, "cell 0 1,growx");

        this.add(new JLabel("Nome Paciente"), "cell 1 0");
        this.add(this.nomePaciente, "cell 1 1,growx, span 5");

        //---------------------------------------------------------------
        this.add(new JLabel("Data Cadastro"), "cell 0 2");
        this.add(this.dataNascimento.createDatePanel(), "cell 0 3,growx");

        this.add(new JLabel("Data Exame"), "cell 1 2");
        this.add(this.dataExame.createDatePanel(), "cell 1 3,growx");

        this.add(new JLabel("Núm. guias"), "cell 2 2");
        this.add(this.numGuias, "cell 2 3,growx");

        this.add(new JLabel("Usuário att."), "cell 3 2");
        this.add(this.usuarioAtendimento, "cell 3 3,growx, span 3");

        //---------------------------------------------------------------
        this.add(new JLabel("Cód. convênio"), "cell 0 4");
        this.add(this.codConvenio, "cell 0 5,growx");

        this.add(new JLabel("Convênio"), "cell 1 4");
        this.add(this.nomeConvenio, "cell 1 5,growx, span 3");

        this.add(new JLabel("Cód. convênio"), "cell 4 4");
        this.add(this.numeroCarteira, "cell 4 5,growx");

        this.add(new JLabel("Data Exame"), "cell 5 4");
        this.add(this.dataValidadeCarteira.createDatePanel(), "cell 5 5,growx");

        //---------------------------------------------------------------
        this.add(new JLabel("Observação"), "cell 0 6, span 6");
        this.observacao.setWrapStyleWord(true);
        this.observacao.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(this.observacao);
        this.add(scroll, "height 50,grow,pushy,cell 0 7, span 6");

    }

    public JTextField getRegistro() {
        return registro;
    }


    public JTextField getNomePaciente() {
        return nomePaciente;
    }

    public JTextField getNumGuias() {
        return numGuias;
    }

    public JTextField getUsuarioAtendimento() {
        return usuarioAtendimento;
    }

    public JTextField getCodConvenio() {
        return codConvenio;
    }

    public JTextField getNomeConvenio() {
        return nomeConvenio;
    }

    public JTextField getNumeroCarteira() {
        return numeroCarteira;
    }

    public JTextArea getObservacao() {
        return observacao;
    }

    public JTextField getMedicoSolicitante() {
        return medicoSolicitante;
    }

    public JTextField getTotal() {
        return total;
    }

    public CampoDataFormatada getDataNascimento() {
        return dataNascimento;
    }

    public CampoDataFormatada getDataExame() {
        return dataExame;
    }

    public CampoDataFormatada getDataValidadeCarteira() {
        return dataValidadeCarteira;
    }
}