package raven.modal.demo.forms;

import net.miginfocom.swing.MigLayout;
import raven.modal.demo.component.CapturaImagens;
import raven.modal.demo.model.Paciente;
import raven.modal.demo.system.Form;
import raven.modal.demo.utils.SystemForm;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

@SystemForm(name = "Captura", description = "Página de captura", tags = {"profile", "photo", "image", "circle", "picture"})
public class FormCaptura extends Form {
    JTextField nomePaciente, nomeProcedimento;
    private Paciente paciente = new Paciente();
    private JButton botaoCapturarImagem;

    @Override
    protected void init() {
        this.setLayout(new MigLayout("fillx,wrap", "[fill]", "[][fill,grow]"));
        this.add(this.faixaTitulo("Captura de imagens", "", 1));
        this.add(dadosAtendimento());
    }

    private Component dadosAtendimento() {
        JPanel panel = new JPanel(new MigLayout("fillx,wrap,insets 5 30 5 30", "[grow][grow][grow][grow][grow]", ""));
        panel.add(this.dadosPaciente(), "growx, span 1");
        panel.add(this.dadosProcedimento(), "growx, span 4");
        panel.add(this.componenteCaptura(), "growx, span 3");
        panel.add(this.informacoesLateral(), "growx, span 2");
        return panel;
    }

    private Component dadosProcedimento() {
        JPanel panel = new JPanel(new MigLayout("wrap 2"));
        panel.setBorder(new TitledBorder("Procedimento Médico Selecionado"));

        this.nomeProcedimento = new JTextField();
        this.nomeProcedimento.setEditable(false);

        panel.add(new JLabel("Procedimento Médico"), "cell 0 0");
        panel.add(this.nomeProcedimento, "cell 0 1,growx");

        return panel;
    }

    private Component dadosPaciente() {
        JPanel panel = new JPanel(new MigLayout("wrap 2"));
        panel.setBorder(new TitledBorder("Nome Paciente"));

        this.nomePaciente = new JTextField();
        this.nomePaciente.setEditable(false);

        panel.add(new JLabel("Paciente"), "cell 0 0");
        panel.add(this.nomePaciente, "cell 0 1,growx");

        return panel;
    }

    private Component componenteCaptura() {
        CapturaImagens panel = new CapturaImagens();
        panel.setBorder(new TitledBorder("Captura"));

        this.botaoCapturarImagem = new JButton("Capturar Imagem");
        this.botaoCapturarImagem.setPreferredSize(new Dimension(130, 30));
        this.botaoCapturarImagem.addActionListener(e -> panel.captureImage());  // Captura a imagem quando o botão for clicado

        return panel;
    }


    private Component informacoesLateral() {
        JPanel panel = new JPanel(new MigLayout("wrap 2"));
        panel.setBorder(new TitledBorder("Opções"));

        this.nomePaciente = new JTextField();
        this.nomePaciente.setEditable(false);

        panel.add(this.botaoCapturarImagem);

        return panel;
    }


}
