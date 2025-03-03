package raven.modal.demo.forms;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;
import raven.modal.ModalDialog;
import raven.modal.component.SimpleModalBorder;
import raven.modal.demo.component.TabelaGenerica;
import raven.modal.demo.model.Convenio;
import raven.modal.demo.model.ModelProfile;
import raven.modal.demo.model.dto.ConvenioDTO;
import raven.modal.demo.service.ConvenioService;
import raven.modal.demo.service.impl.ConvenioServiceImpl;
import raven.modal.demo.simple.ConvenioForm;
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

@SystemForm(name = "Convenio", description = "Tabela de Convênios")
public class ListaConvenio extends FormTableGeneric {
    private JTable tabela;
    private ConvenioService convenioService;
    private ConvenioForm convenioForm;
    private Convenio convenio;
    List<Convenio> listaConvenios;
    TabelaGenerica<Convenio> tabelaGenerica;

    @Override
    protected void init() {
        this.setLayout(new MigLayout("fillx,wrap", "[fill]", "[][fill,grow]"));
        this.add(this.faixaTitulo("Convênios", "", 1));
    }

    @Override
    protected void carregarObjetos() {
        ConvenioDTO filtro = new ConvenioDTO();
        filtro.setItensPorPagina(20);

        this.convenioService = new ConvenioServiceImpl();
        this.listaConvenios = this.convenioService.filtrando(filtro);
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

        List<Function<Convenio, Object>> acessadores = Arrays.asList(
                Convenio::getCodigo,
                Convenio::getNome
        );

        this.tabelaGenerica = new TabelaGenerica<>(colunas, acessadores, this.listaConvenios);

        this.tabela = new JTable(this.tabelaGenerica);
        JScrollPane scrollPane = new JScrollPane(this.tabela);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        this.tabela.getColumnModel().getColumn(0);
        this.tabela.getColumnModel().getColumn(1);

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

        JLabel title = new JLabel("Lista de Convênios");
        title.putClientProperty(FlatClientProperties.STYLE, "" + "font:bold +2");
        panel.add(title, "gapx 20");
        panel.add(this.createHeaderAction());
        panel.add(scrollPane);

        tabb.addTab("Listagem", this.createBorder(panel));
        this.add(tabb, "gapx 7 7");
    }

    @Override
    protected void pesquisar(String texto) {
        ConvenioDTO filtro = new ConvenioDTO();
        filtro.setItensPorPagina(20);
        filtro.setNome(texto);

        this.convenioService = new ConvenioServiceImpl();
        this.listaConvenios = this.convenioService.filtrando(filtro);

        this.tabelaGenerica.atualizarDados(this.listaConvenios);
        this.tabela.repaint();
    }


    private void dialogAdicionar(ActionEvent e) {
        if (this.convenioForm == null)
            this.convenioForm = new ConvenioForm();

        Option option = ModalDialog.createOption();
        option.getLayoutOption().setSize(-1, 1f)
                .setLocation(Location.CENTER, Location.CENTER)
                .setSize(900, 460)
                .setAnimateDistance(0.7f, 0);

        ModalDialog.showModal(this, new SimpleModalBorder(
                this.convenioForm,
                "Cadastro de Convênio",
                SimpleModalBorder.YES_NO_OPTION,
                (controller, action) -> {
                    if (action == SimpleModalBorder.YES_NO_OPTION) {
                        this.salvar();
                        this.convenioForm = new ConvenioForm();
                    }
                }), option);
    }

    private void salvar() {
        if (this.convenio == null)
            this.convenio = new Convenio();

        this.convenio.setCodigo(Long.valueOf(this.convenioForm.getRegistro().getText()));
        this.convenio.setCodconvenio(Long.valueOf(this.convenioForm.getCodImportacao().getText()));
        this.convenio.setNome(this.convenioForm.getNomeConvenio().getText());
        this.convenio.setObservacoes(this.convenioForm.getObservacao().getText());
        this.convenio.setDatacadastro(this.convenioForm.getCampoDataFormatada().getDatePicker().getSelectedDate());
        this.convenio.setAtivo(this.convenioForm.getAtivo().isSelected());

        this.convenioService.salvar(this.convenio);
        this.convenio = new Convenio();
    }

    private void dialogEditar(ActionEvent event) {
        if (this.convenioForm == null)
            this.convenioForm = new ConvenioForm();

        Long codigo = this.selecionarLinha();

        if (codigo == null)
            return;

        this.convenio = this.convenioService.buscarId(codigo);
        this.convenioForm.getNomeConvenio().setText(this.convenio.getNome());
        this.convenioForm.getRegistro().setText(this.convenio.getCodigo() + "");
        this.convenioForm.getCodImportacao().setText(this.convenio.getCodconvenio() + "");
        this.convenioForm.getObservacao().setText(this.convenio.getObservacoes());
//        this.convenioForm.getCampoDataFormatada().getDatePicker().setSelectedDate(this.convenio.getDatacadastro());
        this.convenioForm.getAtivo().setText(String.valueOf(this.convenio.isAtivo()));

        this.dialogAdicionar(null);
    }

    private Long selecionarLinha() {
        int selectedRow = this.tabela.getSelectedRow();
        return selectedRow == -1 ? null : (Long) this.tabela.getValueAt(selectedRow, 0);
    }
}