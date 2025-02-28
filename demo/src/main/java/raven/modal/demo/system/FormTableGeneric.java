package raven.modal.demo.system;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public abstract class FormTableGeneric extends Form {

    private JButton botaoCriar, botaoEditar, botaoDeletar;

    public FormTableGeneric() {
        this.carregarObjetos();
        this.criarTabela();
        this.adicionarActionListener();
    }

    protected abstract void carregarObjetos();

    protected abstract void criarTabela();

    protected abstract void adicionarActionListener();

    protected JPanel faixaTitulo(String titulo, String subTitulo, int level) {
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
        this.botaoCriar = new JButton("Adicionar");
        this.botaoCriar.setPreferredSize(new Dimension(130, 30));
        this.botaoEditar = new JButton("Editar");
        this.botaoEditar.setPreferredSize(new Dimension(130, 30));
        this.botaoDeletar = new JButton("Deletar");
        this.botaoDeletar.setPreferredSize(new Dimension(130, 30));

        panel.add(txtSearch);
        panel.add(this.botaoCriar);
        panel.add(this.botaoEditar);
        panel.add(this.botaoDeletar);
        panel.putClientProperty(FlatClientProperties.STYLE, "" + "background:null;");

        return panel;
    }

    public JButton getBotaoCriar() {
        return botaoCriar;
    }

    public JButton getBotaoEditar() {
        return botaoEditar;
    }

    public JButton getBotaoDeletar() {
        return botaoDeletar;
    }
}
