package raven.modal.demo.system;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public abstract class FormTableGeneric extends Form {

    private JButton cmdCreate, cmdEdit, cmdDelete;

    public FormTableGeneric() {
        this.criarTabela();
        this.adicionarActionListener();
    }

    protected abstract void criarTabela();

    protected abstract void adicionarActionListener();

    protected JPanel createInfo(String titulo, String subTitulo, int level) {
        JPanel panel = new JPanel(new MigLayout("fillx,wrap", "[fill]"));
        JLabel lbTitle = new JLabel(titulo);
        JTextPane text = new JTextPane();
        text.setText(subTitulo);
        text.setEditable(false);
        text.setBorder(BorderFactory.createEmptyBorder());
        lbTitle.putClientProperty(FlatClientProperties.STYLE, "" + "font:bold +" + (4 - level));
        panel.add(lbTitle);
        panel.add(text, "width 500");
        return panel;
    }

    protected Component createBorder(Component component) {
        JPanel panel = new JPanel(new MigLayout("fill,insets 7 0 7 0", "[fill]", "[fill]"));
        panel.add(component);
        return panel;
    }

    protected Component createHeaderAction() {
        JPanel panel = new JPanel(new MigLayout("insets 5 20 5 20", "[fill,230]push[][]"));

        JTextField txtSearch = new JTextField();
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar...");
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("raven/modal/demo/icons/search.svg", 0.4f));
        txtSearch.setPreferredSize(new Dimension(200, 30));
        this.cmdCreate = new JButton("Adicionar");
        this.cmdCreate.setPreferredSize(new Dimension(130, 30));
        this.cmdEdit = new JButton("Editar");
        this.cmdEdit.setPreferredSize(new Dimension(130, 30));
        this.cmdDelete = new JButton("Deletar");
        this.cmdDelete.setPreferredSize(new Dimension(130, 30));

        panel.add(txtSearch);
        panel.add(this.cmdCreate);
        panel.add(this.cmdEdit);
        panel.add(this.cmdDelete);

        panel.putClientProperty(FlatClientProperties.STYLE, "" + "background:null;");
        return panel;
    }

    public JButton getCmdCreate() {
        return cmdCreate;
    }

    public void setCmdCreate(JButton cmdCreate) {
        this.cmdCreate = cmdCreate;
    }

    public JButton getCmdEdit() {
        return cmdEdit;
    }

    public void setCmdEdit(JButton cmdEdit) {
        this.cmdEdit = cmdEdit;
    }

    public JButton getCmdDelete() {
        return cmdDelete;
    }

    public void setCmdDelete(JButton cmdDelete) {
        this.cmdDelete = cmdDelete;
    }
}
