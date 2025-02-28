package raven.modal.demo.system;

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

}
