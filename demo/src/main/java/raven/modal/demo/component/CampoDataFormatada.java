package raven.modal.demo.component;

import net.miginfocom.swing.MigLayout;
import raven.datetime.DatePicker;

import javax.swing.*;
import java.awt.*;

public class CampoDataFormatada extends JPanel {
    DatePicker datePicker = new DatePicker();

    public Component createDatePanel() {
        this.setLayout(new MigLayout("fillx,wrap", "[grow]", ""));

        this.datePicker = new DatePicker();
        JFormattedTextField dateEditor = new JFormattedTextField();
        this.datePicker.setEditor(dateEditor);
        this.add(dateEditor);

        return this;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public void setDatePicker(DatePicker datePicker) {
        this.datePicker = datePicker;
    }
}
