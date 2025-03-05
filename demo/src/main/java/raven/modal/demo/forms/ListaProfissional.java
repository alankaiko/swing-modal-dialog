package raven.modal.demo.forms;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;
import raven.modal.ModalDialog;
import raven.modal.component.SimpleModalBorder;
import raven.modal.demo.component.TabelaGenerica;
import raven.modal.demo.model.ModelProfile;
import raven.modal.demo.model.Profissional;
import raven.modal.demo.model.dto.ProfissionalDTO;
import raven.modal.demo.service.ProfissionalService;
import raven.modal.demo.service.impl.ProfissionalServiceImpl;
import raven.modal.demo.simple.ProfissionalForm;
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

@SystemForm(name = "Médicos", description = "Tabela de Médicos")
public class ListaProfissional extends FormTableGeneric {
    private JTable tabela;
    private ProfissionalService profissionalService;
    private ProfissionalForm profissionalForm;
    private Profissional profissional;
    List<Profissional> listaProfissionais;
    TabelaGenerica<Profissional> tabelaGenerica;

    @Override
    protected void init() {
        this.setLayout(new MigLayout("fillx,wrap", "[fill]", "[][fill,grow]"));
        this.add(this.faixaTitulo("Médicos", "", 1));
    }

    @Override
    protected void carregarObjetos() {
        ProfissionalDTO filtro = new ProfissionalDTO();
        filtro.setItensPorPagina(20);

        this.profissionalService = new ProfissionalServiceImpl();
        this.listaProfissionais = this.profissionalService.filtrando(filtro);
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

        List<Function<Profissional, Object>> acessadores = Arrays.asList(
                Profissional::getCodigo,
                Profissional::getNome
        );

        this.tabelaGenerica = new TabelaGenerica<>(colunas, acessadores, this.listaProfissionais);

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

        JLabel title = new JLabel("Lista de Médicos");
        title.putClientProperty(FlatClientProperties.STYLE, "" + "font:bold +2");
        panel.add(title, "gapx 20");
        panel.add(this.createHeaderAction());
        panel.add(scrollPane);

        tabb.addTab("Listagem", this.createBorder(panel));
        this.add(tabb, "gapx 7 7");
    }

    @Override
    protected void pesquisar(String texto) {
        ProfissionalDTO filtro = new ProfissionalDTO();
        filtro.setItensPorPagina(20);
        filtro.setNome(texto);

        this.profissionalService = new ProfissionalServiceImpl();
        this.listaProfissionais = this.profissionalService.filtrando(filtro);

        this.tabelaGenerica.atualizarDados(this.listaProfissionais);
        this.tabela.repaint();
    }


    private void dialogAdicionar(ActionEvent e) {
        if (this.profissionalForm == null)
            this.profissionalForm = new ProfissionalForm();

        Option option = ModalDialog.createOption();
        option.getLayoutOption().setSize(-1, 1f)
                .setLocation(Location.CENTER, Location.CENTER)
                .setSize(900, 460)
                .setAnimateDistance(0.7f, 0);

        ModalDialog.showModal(this, new SimpleModalBorder(
                this.profissionalForm,
                "Cadastro de Médico",
                SimpleModalBorder.YES_NO_OPTION,
                (controller, action) -> {
                    if (action == SimpleModalBorder.YES_NO_OPTION) {
                        this.salvar();
                        this.profissionalForm = new ProfissionalForm();
                    }
                }), option);
    }

    private void salvar() {
        if (this.profissional == null)
            this.profissional = new Profissional();

        this.profissional.setCodigo(Long.valueOf(this.profissionalForm.getRegistro().getText()));

        this.profissionalService.salvar(this.profissional);
        this.profissional = new Profissional();
    }

    private void dialogEditar(ActionEvent event) {
        if (this.profissionalForm == null)
            this.profissionalForm = new ProfissionalForm();

        Long codigo = this.selecionarLinha();

        if (codigo == null)
            return;

        this.profissional = this.profissionalService.buscarId(codigo);

        this.dialogAdicionar(null);
    }

    private Long selecionarLinha() {
        int selectedRow = this.tabela.getSelectedRow();
        return selectedRow == -1 ? null : (Long) this.tabela.getValueAt(selectedRow, 0);
    }
}