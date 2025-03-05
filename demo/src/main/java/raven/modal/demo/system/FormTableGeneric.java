package raven.modal.demo.system;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public abstract class FormTableGeneric extends Form {

    private JButton botaoCriar, botaoEditar;
    private JTextField buscar = new JTextField();

    public FormTableGeneric() {
        this.carregarObjetos();
        this.criarTabela();
        this.adicionarActionListener();
    }

    protected abstract void carregarObjetos();

    protected abstract void adicionarActionListener();

    protected abstract void criarTabela();

    protected abstract void pesquisar(String texto);

    protected Component createBorder(Component component) {
        JPanel panel = new JPanel(new MigLayout("fill,insets 7 0 7 0", "[fill]", "[fill]"));
        panel.add(component);

        return panel;
    }

    protected Component createHeaderAction() {
        JPanel panel = new JPanel(new MigLayout("insets 5 20 5 20", "[fill,230]push[][]"));

        this.buscar.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar...");
        this.buscar.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("raven/modal/demo/icons/search.svg", 0.4f));
        this.buscar.setPreferredSize(new Dimension(200, 30));
        this.botaoCriar = new JButton("Adicionar");
        this.botaoCriar.setPreferredSize(new Dimension(130, 30));
        this.botaoEditar = new JButton("Editar");
        this.botaoEditar.setPreferredSize(new Dimension(130, 30));

        panel.add(this.buscar);
        panel.add(this.botaoCriar);
        panel.add(this.botaoEditar);
        panel.putClientProperty(FlatClientProperties.STYLE, "" + "background:null;");

        this.buscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pesquisar(buscar.getText());
                }
            }
        });

        return panel;
    }

    public JButton getBotaoCriar() {
        return botaoCriar;
    }

    public JButton getBotaoEditar() {
        return botaoEditar;
    }
}
