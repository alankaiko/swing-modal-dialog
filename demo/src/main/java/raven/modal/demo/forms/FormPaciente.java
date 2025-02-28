package raven.modal.demo.forms;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;
import raven.modal.ModalDialog;
import raven.modal.component.SimpleModalBorder;
import raven.modal.demo.component.TabelaGenerica;
import raven.modal.demo.model.ModelProfile;
import raven.modal.demo.model.Paciente;
import raven.modal.demo.model.dto.PacienteDTO;
import raven.modal.demo.service.PacienteService;
import raven.modal.demo.service.impl.PacienteServiceImpl;
import raven.modal.demo.simple.SimpleInputForms;
import raven.modal.demo.system.FormTableGeneric;
import raven.modal.demo.utils.SystemForm;
import raven.modal.demo.utils.table.TableHeaderAlignment;
import raven.modal.demo.utils.table.TableProfileCellRenderer;
import raven.modal.option.Location;
import raven.modal.option.Option;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@SystemForm(name = "Pacientes", description = "Tabela de Pacientes")
public class FormPaciente extends FormTableGeneric {
    List<Paciente> lista;
    private PacienteService pacienteService;

    @Override
    protected void init() {
        this.setLayout(new MigLayout("fillx,wrap", "[fill]", "[][fill,grow]"));
        this.add(this.faixaTitulo("Pacientes", "", 1));
    }

    @Override
    protected void carregarObjetos() {
        PacienteDTO filtro = new PacienteDTO();
        filtro.setItensPorPagina(20);

        this.pacienteService = new PacienteServiceImpl();
        this.lista = this.pacienteService.filtrando(filtro);
    }

    @Override
    protected void criarTabela() {
        JTabbedPane tabb = new JTabbedPane();
        tabb.putClientProperty(FlatClientProperties.STYLE, "" + "tabType:card");

        JPanel panel = new JPanel(new MigLayout("fillx,wrap,insets 10 0 10 0", "[fill]", "[][]0[fill,grow]"));
        String[] colunas = {"Título", "Descrição"};

        List<Function<Paciente, Object>> acessadores = Arrays.asList(
                Paciente::getNome,
                Paciente::getNome
        );

        TabelaGenerica<Paciente> tabela = new TabelaGenerica<>(colunas, acessadores, this.lista);

        JTable table = new JTable(tabela);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        table.getColumnModel().getColumn(0).setMaxWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);

        table.getTableHeader().setReorderingAllowed(false);
        table.setDefaultRenderer(ModelProfile.class, new TableProfileCellRenderer(table));

        table.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(table) {
            @Override
            protected int getAlignment(int column) {
                if (column == 1)
                    return SwingConstants.LEADING;

                return SwingConstants.LEFT;
            }
        });

        panel.putClientProperty(FlatClientProperties.STYLE, "" +
                "arc:20;" +
                "background:$Table.background;");
        table.getTableHeader().putClientProperty(FlatClientProperties.STYLE, "" +
                "height:30;" +
                "hoverBackground:null;" +
                "pressedBackground:null;" +
                "separatorColor:$TableHeader.background;");
        table.putClientProperty(FlatClientProperties.STYLE, "" +
                "rowHeight:70;" +
                "showHorizontalLines:true;" +
                "intercellSpacing:0,1;" +
                "cellFocusColor:$TableHeader.hoverBackground;" +
                "selectionBackground:$TableHeader.hoverBackground;" +
                "selectionInactiveBackground:$TableHeader.hoverBackground;" +
                "selectionForeground:$Table.foreground;");
        scrollPane.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, "" +
                "trackArc:$ScrollBar.thumbArc;" +
                "trackInsets:3,3,3,3;" +
                "thumbInsets:3,3,3,3;" +
                "background:$Table.background;");

        JLabel title = new JLabel("Lista de Pacientes");
        title.putClientProperty(FlatClientProperties.STYLE, "" + "font:bold +2");
        panel.add(title, "gapx 20");
        panel.add(this.createHeaderAction());
        panel.add(scrollPane);

        tabb.addTab("Listagem", this.createBorder(panel));
        this.add(tabb, "gapx 7 7");
    }

    @Override
    protected void adicionarActionListener() {
        this.getBotaoCriar().addActionListener(this::showModal);
    }

    private void showModal(ActionEvent e) {
        Option option = ModalDialog.createOption();
        option.getLayoutOption().setSize(-1, 1f)
                .setLocation(Location.TRAILING, Location.TOP)
                .setAnimateDistance(0.7f, 0);
        ModalDialog.showModal(this, new SimpleModalBorder(
                new SimpleInputForms(), "Create", SimpleModalBorder.YES_NO_OPTION,
                (controller, action) -> {

                }), option);
    }

}