package raven.modal.demo.forms;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;
import raven.modal.ModalDialog;
import raven.modal.component.SimpleModalBorder;
import raven.modal.demo.component.TabelaGenerica;
import raven.modal.demo.model.Atendimento;
import raven.modal.demo.model.ModelProfile;
import raven.modal.demo.model.dto.AtendimentoDTO;
import raven.modal.demo.model.resumo.AtendimentoResumo;
import raven.modal.demo.service.AtendimentoService;
import raven.modal.demo.service.impl.AtendimentoServiceImpl;
import raven.modal.demo.simple.AtendimentoForm;
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

@SystemForm(name = "Atendimento", description = "Tabela de Atendimentos")
public class ListaAtendimento extends FormTableGeneric {
    private JTable tabela;
    private AtendimentoService atendimentoService;
    private AtendimentoForm atendimentoForm;
    private Atendimento atendimento;
    List<AtendimentoResumo> listaAtendimentos;
    TabelaGenerica<AtendimentoResumo> tabelaGenerica;

    @Override
    protected void init() {
        this.setLayout(new MigLayout("fillx,wrap", "[fill]", "[][fill,grow]"));
        this.add(this.faixaTitulo("Atendimentos", "", 1));
    }

    @Override
    protected void carregarObjetos() {
        AtendimentoDTO filtro = new AtendimentoDTO();
        filtro.setItensPorPagina(20);

        this.atendimentoService = new AtendimentoServiceImpl();
        this.listaAtendimentos = this.atendimentoService.filtrando(filtro);
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
        String[] colunas = {"Código", "Paciente", "Data Atendimento", "Tipo", "Status", "Médico", "Unidade"};

        List<Function<AtendimentoResumo, Object>> acessadores = Arrays.asList(
                AtendimentoResumo::getCodigo,
                AtendimentoResumo::getNomePaciente,
                AtendimentoResumo::getDataatendimento,
                AtendimentoResumo::getTipo,
                AtendimentoResumo::getStatus,
                AtendimentoResumo::getNomeMedico,
                AtendimentoResumo::getUnidade
        );

        this.tabelaGenerica = new TabelaGenerica<>(colunas, acessadores, this.listaAtendimentos);

        this.tabela = new JTable(this.tabelaGenerica);
        JScrollPane scrollPane = new JScrollPane(this.tabela);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        this.tabela.getColumnModel().getColumn(0);
        this.tabela.getColumnModel().getColumn(1);
        this.tabela.getColumnModel().getColumn(2);
        this.tabela.getColumnModel().getColumn(3);
        this.tabela.getColumnModel().getColumn(4);
        this.tabela.getColumnModel().getColumn(5);
        this.tabela.getColumnModel().getColumn(6);

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

        JLabel title = new JLabel("Lista de Atendimentos");
        title.putClientProperty(FlatClientProperties.STYLE, "" + "font:bold +2");
        panel.add(title, "gapx 20");
        panel.add(this.createHeaderAction());
        panel.add(scrollPane);

        tabb.addTab("Listagem", this.createBorder(panel));
        this.add(tabb, "gapx 7 7");
    }

    @Override
    protected void pesquisar(String texto) {
        AtendimentoDTO filtro = new AtendimentoDTO();
        filtro.setItensPorPagina(20);
        filtro.setNomePaciente(texto);

        this.atendimentoService = new AtendimentoServiceImpl();
        this.listaAtendimentos = this.atendimentoService.filtrando(filtro);

        this.tabelaGenerica.atualizarDados(this.listaAtendimentos);
        this.tabela.repaint();
    }


    private void dialogAdicionar(ActionEvent e) {
        if (this.atendimentoForm == null)
            this.atendimentoForm = new AtendimentoForm();

        Option option = ModalDialog.createOption();
        option.getLayoutOption().setSize(-1, 1f)
                .setLocation(Location.CENTER, Location.CENTER)
                .setSize(900, 460)
                .setAnimateDistance(0.7f, 0);

        ModalDialog.showModal(this, new SimpleModalBorder(
                this.atendimentoForm,
                "Cadastro de Atendimento",
                SimpleModalBorder.YES_NO_OPTION,
                (controller, action) -> {
                    if (action == SimpleModalBorder.YES_NO_OPTION) {
                        this.salvar();
                        this.atendimentoForm = new AtendimentoForm();
                    }
                }), option);
    }

    private void salvar() {
        if (this.atendimento == null)
            this.atendimento = new Atendimento();

        this.atendimento.setCodigo(Long.valueOf(this.atendimentoForm.getRegistro().getText()));

        this.atendimentoService.salvar(this.atendimento);
        this.atendimento = new Atendimento();
    }

    private void dialogEditar(ActionEvent event) {
        if (this.atendimentoForm == null)
            this.atendimentoForm = new AtendimentoForm();

        Long codigo = this.selecionarLinha();

        if (codigo == null)
            return;

        this.atendimento = this.atendimentoService.buscarId(codigo);

        this.dialogAdicionar(null);
    }

    private Long selecionarLinha() {
        int selectedRow = this.tabela.getSelectedRow();
        return selectedRow == -1 ? null : (Long) this.tabela.getValueAt(selectedRow, 0);
    }
}