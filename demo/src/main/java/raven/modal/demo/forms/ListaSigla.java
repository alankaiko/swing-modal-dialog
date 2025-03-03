package raven.modal.demo.forms;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;
import raven.modal.ModalDialog;
import raven.modal.component.SimpleModalBorder;
import raven.modal.demo.component.TabelaGenerica;
import raven.modal.demo.model.ModelProfile;
import raven.modal.demo.model.Sigla;
import raven.modal.demo.model.dto.SiglaDTO;
import raven.modal.demo.service.SiglaService;
import raven.modal.demo.service.impl.SiglaServiceImpl;
import raven.modal.demo.simple.SiglaForm;
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

@SystemForm(name = "Sigla", description = "Tabela de Siglas")
public class ListaSigla extends FormTableGeneric {
    private JTable tabela;
    private SiglaService siglaService;
    private SiglaForm siglaForm;
    private Sigla sigla;
    List<Sigla> listaSiglas;
    TabelaGenerica<Sigla> tabelaGenerica;

    @Override
    protected void init() {
        this.setLayout(new MigLayout("fillx,wrap", "[fill]", "[][fill,grow]"));
        this.add(this.faixaTitulo("Siglas", "", 1));
    }

    @Override
    protected void carregarObjetos() {
        SiglaDTO filtro = new SiglaDTO();
        filtro.setItensPorPagina(20);

        this.siglaService = new SiglaServiceImpl();
        this.listaSiglas = this.siglaService.filtrando(filtro);
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

        List<Function<Sigla, Object>> acessadores = Arrays.asList(
                Sigla::getCodigo,
                Sigla::getDescricao
        );

        this.tabelaGenerica = new TabelaGenerica<>(colunas, acessadores, this.listaSiglas);

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

        JLabel title = new JLabel("Lista de Siglas");
        title.putClientProperty(FlatClientProperties.STYLE, "" + "font:bold +2");
        panel.add(title, "gapx 20");
        panel.add(this.createHeaderAction());
        panel.add(scrollPane);

        tabb.addTab("Listagem", this.createBorder(panel));
        this.add(tabb, "gapx 7 7");
    }

    @Override
    protected void pesquisar(String texto) {
        SiglaDTO filtro = new SiglaDTO();
        filtro.setItensPorPagina(20);
        filtro.setDescricao(texto);

        this.siglaService = new SiglaServiceImpl();
        this.listaSiglas = this.siglaService.filtrando(filtro);

        this.tabelaGenerica.atualizarDados(this.listaSiglas);
        this.tabela.repaint();
    }


    private void dialogAdicionar(ActionEvent e) {
        if (this.siglaForm == null)
            this.siglaForm = new SiglaForm();

        Option option = ModalDialog.createOption();
        option.getLayoutOption().setSize(-1, 1f)
                .setLocation(Location.CENTER, Location.CENTER)
                .setSize(900, 460)
                .setAnimateDistance(0.7f, 0);

        ModalDialog.showModal(this, new SimpleModalBorder(
                this.siglaForm,
                "Cadastro de Sigla",
                SimpleModalBorder.YES_NO_OPTION,
                (controller, action) -> {
                    if (action == SimpleModalBorder.YES_NO_OPTION) {
                        this.salvar();
                        this.siglaForm = new SiglaForm();
                    }
                }), option);
    }

    private void salvar() {
        if (this.sigla == null)
            this.sigla = new Sigla();

        this.sigla.setCodigo(Long.valueOf(this.siglaForm.getRegistro().getText()));

        this.siglaService.salvar(this.sigla);
        this.sigla = new Sigla();
    }

    private void dialogEditar(ActionEvent event) {
        if (this.siglaForm == null)
            this.siglaForm = new SiglaForm();

        Long codigo = this.selecionarLinha();

        if (codigo == null)
            return;

        this.sigla = this.siglaService.buscarId(codigo);
        this.siglaForm.getRegistro().setText(this.sigla.getCodigo() + "");

        this.dialogAdicionar(null);
    }

    private Long selecionarLinha() {
        int selectedRow = this.tabela.getSelectedRow();
        return selectedRow == -1 ? null : (Long) this.tabela.getValueAt(selectedRow, 0);
    }
}