package raven.modal.demo.forms;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;
import raven.modal.ModalDialog;
import raven.modal.component.SimpleModalBorder;
import raven.modal.demo.component.TabelaGenerica;
import raven.modal.demo.model.ModelProfile;
import raven.modal.demo.model.ProcedimentoMedico;
import raven.modal.demo.model.dto.ProcedimentoMedicoDTO;
import raven.modal.demo.service.ProcedimentoMedicoService;
import raven.modal.demo.service.impl.ProcedimentoMedicoServiceImpl;
import raven.modal.demo.simple.ProcedimentoMedicoForm;
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

@SystemForm(name = "Procedimentos Médico", description = "Tabela de Procedimentos Médico")
public class ListaProcedimentoMedico extends FormTableGeneric {
    private JTable tabela;
    private ProcedimentoMedicoService procedimentoMedicoService;
    private ProcedimentoMedicoForm procedimentoMedicoForm;
    private ProcedimentoMedico procedimentoMedico;
    List<ProcedimentoMedico> listaProcedimentoMedicos;
    TabelaGenerica<ProcedimentoMedico> tabelaGenerica;

    @Override
    protected void init() {
        this.setLayout(new MigLayout("fillx,wrap", "[fill]", "[][fill,grow]"));
        this.add(this.faixaTitulo("Procedimentos Médico", "", 1));
    }

    @Override
    protected void carregarObjetos() {
        ProcedimentoMedicoDTO filtro = new ProcedimentoMedicoDTO();
        filtro.setItensPorPagina(20);

        this.procedimentoMedicoService = new ProcedimentoMedicoServiceImpl();
        this.listaProcedimentoMedicos = this.procedimentoMedicoService.filtrando(filtro);
    }

    @Override
    protected void adicionarActionListener() {
        this.getBotaoCriar().addActionListener(this::dialogAdicionar);
        this.getBotaoEditar().addActionListener(this::dialogEditar);
    }

    @Override
    protected void criarTabela() {
        JTabbedPane tabb = new JTabbedPane();
        tabb.putClientProperty(FlatClientProperties.STYLE, "" + "tabType:card");

        JPanel panel = new JPanel(new MigLayout("fillx,wrap,insets 10 0 10 0", "[fill]", "[][]0[fill,grow]"));
        String[] colunas = {"Código", "Descrição"};

        List<Function<ProcedimentoMedico, Object>> acessadores = Arrays.asList(
                ProcedimentoMedico::getCodigo,
                ProcedimentoMedico::getTitulo
        );

//        this.tabelaGenerica = new TabelaGenerica<>(colunas, acessadores, this.listaProcedimentoMedicos);

        this.tabela = new JTable(this.tabelaGenerica);
        JScrollPane scrollPane = new JScrollPane(this.tabela);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        this.tabela.getTableHeader().setReorderingAllowed(false);
        this.tabela.setDefaultRenderer(ModelProfile.class, new TableProfileCellRenderer(this.tabela));

        this.tabela.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(this.tabela) {
            @Override
            protected int getAlignment(int column) {
                if (column == 1)
                    return SwingConstants.LEADING;

                return SwingConstants.CENTER;
            }
        });

        panel.putClientProperty(FlatClientProperties.STYLE, "" +
                "arc:40;" +
                "background:$Table.background;");
        this.tabela.getTableHeader().putClientProperty(FlatClientProperties.STYLE, "" +
                "height:30;" +
                "hoverBackground:null;" +
                "pressedBackground:null;" +
                "separatorColor:$TableHeader.background;");
        this.tabela.putClientProperty(FlatClientProperties.STYLE, "" +
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

        JLabel title = new JLabel("Lista de Procedimentos Médico");
        title.putClientProperty(FlatClientProperties.STYLE, "" + "font:bold +2");
        panel.add(title, "gapx 20");
        panel.add(this.createHeaderAction());
        panel.add(scrollPane);

        tabb.addTab("Listagem", this.createBorder(panel));
        this.add(tabb, "gapx 7 7");
    }

    @Override
    protected void pesquisar(String texto) {
        ProcedimentoMedicoDTO filtro = new ProcedimentoMedicoDTO();
        filtro.setItensPorPagina(20);
        filtro.setNome(texto);

        this.procedimentoMedicoService = new ProcedimentoMedicoServiceImpl();
        this.listaProcedimentoMedicos = this.procedimentoMedicoService.filtrando(filtro);

        this.tabelaGenerica.atualizarDados(this.listaProcedimentoMedicos);
        this.tabela.repaint();
    }


    private void dialogAdicionar(ActionEvent e) {
        if (this.procedimentoMedicoForm == null)
            this.procedimentoMedicoForm = new ProcedimentoMedicoForm();

        Option option = ModalDialog.createOption();
        option.getLayoutOption().setSize(-1, 1f)
                .setLocation(Location.CENTER, Location.CENTER)
                .setSize(900, 460)
                .setAnimateDistance(0.7f, 0);

        ModalDialog.showModal(this, new SimpleModalBorder(
                this.procedimentoMedicoForm,
                "Cadastro de Procedimento Médico",
                SimpleModalBorder.YES_NO_OPTION,
                (controller, action) -> {
                    if (action == SimpleModalBorder.YES_NO_OPTION) {
                        this.salvar();
                        this.procedimentoMedicoForm = new ProcedimentoMedicoForm();
                    }
                }), option);
    }

    private void salvar() {
        if (this.procedimentoMedico == null)
            this.procedimentoMedico = new ProcedimentoMedico();

        this.procedimentoMedico.setCodigo(Long.valueOf(this.procedimentoMedicoForm.getRegistro().getText()));

        this.procedimentoMedicoService.salvar(this.procedimentoMedico);
        this.procedimentoMedico = new ProcedimentoMedico();
    }

    private void dialogEditar(ActionEvent event) {
        if (this.procedimentoMedicoForm == null)
            this.procedimentoMedicoForm = new ProcedimentoMedicoForm();

        Long codigo = this.selecionarLinha();

        if (codigo == null)
            return;

        this.procedimentoMedico = this.procedimentoMedicoService.buscarId(codigo);

        this.dialogAdicionar(null);
    }

    private Long selecionarLinha() {
        int selectedRow = this.tabela.getSelectedRow();
        return selectedRow == -1 ? null : (Long) this.tabela.getValueAt(selectedRow, 0);
    }
}