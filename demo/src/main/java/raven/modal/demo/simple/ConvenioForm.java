package raven.modal.demo.simple;

import net.miginfocom.swing.MigLayout;
import raven.modal.component.ModalBorderAction;
import raven.modal.component.SimpleModalBorder;
import raven.modal.demo.component.CampoDataFormatada;
import raven.modal.demo.system.FormModalDialogGeneric;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConvenioForm extends FormModalDialogGeneric {
    JTextField registroConvenio = new JTextField();
    JTextField nomeConvenio = new JTextField();
    JTextField codImportacao = new JTextField();
    JCheckBox ativo = new JCheckBox();
    JTextArea observacao = new JTextArea();
    CampoDataFormatada campoDataFormatada = new CampoDataFormatada();

    public ConvenioForm() {
        this.init();
    }

    private void init() {
        this.setLayout(new MigLayout("fillx,wrap,insets 5 30 5 30", "[grow][grow][grow][grow]", ""));

        this.add(new JLabel("Registro"), "cell 0 0");
        this.add(this.registroConvenio, "cell 0 1,growx");

        this.add(new JLabel("Cód Importação"), "cell 1 0");
        this.add(this.codImportacao, "cell 1 1,growx");

        this.add(new JLabel("Data Cadastro"), "cell 2 0");
        this.add(this.campoDataFormatada.createDatePanel(), "cell 2 1,growx");

        this.add(new JLabel("Ativo"), "cell 3 0");
        this.add(this.ativo, "cell 3 1");

        this.add(new JLabel("Nome"), "cell 0 2, span 5");
        this.add(this.nomeConvenio, "cell 0 3,grow, span 5");

        this.add(new JLabel("Observação"), "cell 0 4, span 5");
        this.observacao.setWrapStyleWord(true);
        this.observacao.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(this.observacao);
        this.add(scroll, "height 150,grow,pushy,cell 0 5, span 5");

        this.observacao.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.isControlDown() && e.getKeyChar() == 10) {
                    ModalBorderAction modalBorderAction = ModalBorderAction.getModalBorderAction(ConvenioForm.this);
                    if (modalBorderAction != null) {
                        modalBorderAction.doAction(SimpleModalBorder.YES_OPTION);
                    }
                }
            }
        });
    }

    public JTextField getRegistroConvenio() {
        return registroConvenio;
    }

    public void setRegistroConvenio(JTextField registroConvenio) {
        this.registroConvenio = registroConvenio;
    }

    public JTextField getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(JTextField nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public JTextField getCodImportacao() {
        return codImportacao;
    }

    public void setCodImportacao(JTextField codImportacao) {
        this.codImportacao = codImportacao;
    }

    public JCheckBox getAtivo() {
        return ativo;
    }

    public void setAtivo(JCheckBox ativo) {
        this.ativo = ativo;
    }

    public JTextArea getObservacao() {
        return observacao;
    }

    public void setObservacao(JTextArea observacao) {
        this.observacao = observacao;
    }

    public CampoDataFormatada getCampoDataFormatada() {
        return campoDataFormatada;
    }

    public void setCampoDataFormatada(CampoDataFormatada campoDataFormatada) {
        this.campoDataFormatada = campoDataFormatada;
    }
}