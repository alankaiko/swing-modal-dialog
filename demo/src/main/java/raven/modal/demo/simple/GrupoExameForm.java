package raven.modal.demo.simple;

import net.miginfocom.swing.MigLayout;
import raven.modal.demo.system.FormModalDialogGeneric;

import javax.swing.*;

public class GrupoExameForm extends FormModalDialogGeneric {
    JTextField registro = new JTextField();

    public GrupoExameForm() {
        this.init();
    }

    private void init() {
        this.setLayout(new MigLayout("fillx,wrap,insets 5 30 5 30", "[grow][grow][grow][grow]", ""));

        //---------------------------------------------------------------
        this.add(new JLabel("Registro"), "cell 0 0");
        this.add(this.registro, "cell 0 1,growx");

    }

    public JTextField getRegistro() {
        return registro;
    }


}