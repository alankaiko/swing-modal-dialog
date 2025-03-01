package raven.modal.demo.system;

import com.formdev.flatlaf.FlatClientProperties;

import javax.swing.*;

public abstract class FormModalDialogGeneric extends JPanel {

    protected void createTitle(String title) {
        JLabel lb = new JLabel(title);
        lb.putClientProperty(FlatClientProperties.STYLE, "" +
                "font:+2");
        add(lb, "gapy 5 0");
        add(new JSeparator(), "height 2!,gapy 0 0");
    }
}
