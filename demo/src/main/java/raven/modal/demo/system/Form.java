package raven.modal.demo.system;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public abstract class Form extends JPanel {

    private LookAndFeel oldTheme = UIManager.getLookAndFeel();

    public Form() {
        this.init();
    }

    protected abstract void init();

    public void formInit() {
    }

    public void formOpen() {
    }

    public void formRefresh() {
    }

    protected final void formCheck() {
        if (oldTheme != UIManager.getLookAndFeel()) {
            oldTheme = UIManager.getLookAndFeel();
            SwingUtilities.updateComponentTreeUI(this);
        }
    }

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

}
