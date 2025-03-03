package raven.modal.demo.forms;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;
import raven.modal.ModalDialog;
import raven.modal.component.SimpleModalBorder;
import raven.modal.demo.component.TabelaGenerica;
import raven.modal.demo.model.Exame;
import raven.modal.demo.model.ModelProfile;
import raven.modal.demo.model.dto.ExameDTO;
import raven.modal.demo.service.ExameService;
import raven.modal.demo.service.impl.ExameServiceImpl;
import raven.modal.demo.simple.ExameForm;
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

@SystemForm(name = "Exames", description = "Tabela de Exames")
public class ListaExame extends FormTableGeneric {
    private JTable tabela;
    private ExameService exameService;
    private ExameForm exameForm;
    private Exame exame;
    List<Exame> listaExame;
    TabelaGenerica<Exame> tabelaGenerica;

    @Override
    protected void init() {
        this.setLayout(new MigLayout("fillx,wrap", "[fill]", "[][fill,grow]"));
        this.add(this.faixaTitulo("Exames", "", 1));
    }

    @Override
    protected void carregarObjetos() {
        ExameDTO filtro = new ExameDTO();
        filtro.setItensPorPagina(20);

        this.exameService = new ExameServiceImpl();
        this.listaExame = this.exameService.filtrando(filtro);
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
        String[] colunas = {"Código", "Título"};

        List<Function<Exame, Object>> acessadores = Arrays.asList(
                Exame::getCodigo,
                Exame::getTitulo
        );

        this.tabelaGenerica = new TabelaGenerica<>(colunas, acessadores, this.listaExame);

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

        JLabel title = new JLabel("Lista de Exames");
        title.putClientProperty(FlatClientProperties.STYLE, "" + "font:bold +2");
        panel.add(title, "gapx 20");
        panel.add(this.createHeaderAction());
        panel.add(scrollPane);

        tabb.addTab("Listagem", this.createBorder(panel));
        this.add(tabb, "gapx 7 7");
    }

    @Override
    protected void pesquisar(String texto) {
        ExameDTO filtro = new ExameDTO();
        filtro.setItensPorPagina(20);
        filtro.setTitulo(texto);

        this.exameService = new ExameServiceImpl();
        this.listaExame = this.exameService.filtrando(filtro);

        this.tabelaGenerica.atualizarDados(this.listaExame);
        this.tabela.repaint();
    }


    private void dialogAdicionar(ActionEvent e) {
        if (this.exameForm == null)
            this.exameForm = new ExameForm();

        Option option = ModalDialog.createOption();
        option.getLayoutOption().setSize(-1, 1f)
                .setLocation(Location.CENTER, Location.CENTER)
                .setSize(900, 460)
                .setAnimateDistance(0.7f, 0);

        ModalDialog.showModal(this, new SimpleModalBorder(
                this.exameForm,
                "Cadastro de Exame",
                SimpleModalBorder.YES_NO_OPTION,
                (controller, action) -> {
                    if (action == SimpleModalBorder.YES_NO_OPTION) {
                        this.salvar();
                        this.exameForm = new ExameForm();
                    }
                }), option);
    }

    private void salvar() {
        if (this.exame == null)
            this.exame = new Exame();

        this.exame.setCodigo(Long.valueOf(this.exameForm.getRegistro().getText()));

        this.exameService.salvar(this.exame);
        this.exame = new Exame();
    }

    private void dialogEditar(ActionEvent event) {
        if (this.exameForm == null)
            this.exameForm = new ExameForm();

        Long codigo = this.selecionarLinha();

        if (codigo == null)
            return;

        this.exame = this.exameService.buscarId(codigo);

        this.dialogAdicionar(null);
    }

    private Long selecionarLinha() {
        int selectedRow = this.tabela.getSelectedRow();
        return selectedRow == -1 ? null : (Long) this.tabela.getValueAt(selectedRow, 0);
    }
}