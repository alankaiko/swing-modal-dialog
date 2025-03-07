package raven.modal.demo.forms;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;
import raven.modal.ModalDialog;
import raven.modal.component.SimpleModalBorder;
import raven.modal.demo.component.TabelaGenerica;
import raven.modal.demo.model.Convenio;
import raven.modal.demo.model.dto.ConvenioDTO;
import raven.modal.demo.service.ConvenioService;
import raven.modal.demo.service.impl.ConvenioServiceImpl;
import raven.modal.demo.simple.ConvenioForm;
import raven.modal.demo.system.FormTableGeneric;
import raven.modal.demo.utils.PageResponse;
import raven.modal.demo.utils.SystemForm;
import raven.modal.option.Location;
import raven.modal.option.Option;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;

@SystemForm(name = "Convenio", description = "Tabela de Convênios")
public class ListaConvenio extends FormTableGeneric {
    private JTable tabela;
    private ConvenioService convenioService;
    private ConvenioForm convenioForm;
    private Convenio convenio;
    private PageResponse pageResponse;
    private TabelaGenerica<Convenio> tabelaGenerica;

    @Override
    protected void init() {
        this.setLayout(new MigLayout("fillx,wrap", "[fill]", "[][fill,grow]"));
        this.add(this.faixaTitulo("Convênios", "", 1));
    }

    @Override
    protected void carregarObjetos() {
        ConvenioDTO filtro = new ConvenioDTO();
        filtro.setItensPorPagina(10);
        filtro.setPagina(0);
        this.convenioService = new ConvenioServiceImpl();

        this.pageResponse = this.convenioService.filtrando(filtro);
        this.tabelaGenerica = new TabelaGenerica<>(new String[]{"Código", "Descrição"},
                Arrays.asList(Convenio::getCodigo, Convenio::getNome), this.pageResponse);
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

        this.tabela = new JTable(this.tabelaGenerica);
        JScrollPane scrollPane = new JScrollPane(this.tabela);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

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

        panel.add(new JLabel("Lista de Convênios"), "gapx 20");
        panel.add(this.createHeaderAction());
        panel.add(scrollPane);

        this.criarBotoesDeNavegacao(panel);

        tabb.addTab("Listagem", this.createBorder(panel));
        this.add(tabb, "gapx 7 7");
    }

    private void criarBotoesDeNavegacao(JPanel panel) {
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton btnPrimeiraPagina = new JButton("<<");
        btnPrimeiraPagina.addActionListener(e -> this.irParaPagina(0));

        JButton btnPaginaAnterior = new JButton("<");
        btnPaginaAnterior.addActionListener(e -> this.paginaAnterior());

        JButton btnPaginaProxima = new JButton(">");
        btnPaginaProxima.addActionListener(e -> this.proximaPagina());

        JButton btnUltimaPagina = new JButton(">>");
        btnUltimaPagina.addActionListener(e -> this.irParaPagina(this.tabelaGenerica.getTotalPaginas() - 1));

        navPanel.add(btnPrimeiraPagina);
        navPanel.add(btnPaginaAnterior);

        List<Integer> paginasVisiveis = this.tabelaGenerica.getPaginasVisiveis(5);

        for (int pagina : paginasVisiveis) {
            JButton btnPagina = new JButton(String.valueOf(pagina));
            btnPagina.addActionListener(e -> this.irParaPagina(pagina - 1));
            navPanel.add(btnPagina);
        }

        navPanel.add(btnPaginaProxima);
        navPanel.add(btnUltimaPagina);

        panel.add(navPanel, "span 2, growx, center");
    }


    private void proximaPagina() {
        this.tabelaGenerica.proximaPagina();
        this.tabela.repaint();
    }

    private void paginaAnterior() {
        this.tabelaGenerica.paginaAnterior();
        this.tabela.repaint();
    }

    private void irParaPagina(int pagina) {
        ConvenioDTO filtro = new ConvenioDTO();
        filtro.setItensPorPagina(10);
        filtro.setPagina(pagina);

        this.pageResponse = this.convenioService.filtrando(filtro);
        this.tabelaGenerica.atualizarPagina(this.pageResponse);
        this.tabela.repaint();
    }

    @Override
    protected void pesquisar(String texto) {
        ConvenioDTO filtro = new ConvenioDTO();
        filtro.setItensPorPagina(10);
        filtro.setNome(texto);
        filtro.setPagina(0);

        this.pageResponse = this.convenioService.filtrando(filtro);
        this.tabelaGenerica.atualizarPagina(this.pageResponse);
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

    private void dialogEditar(ActionEvent event) {
        if (this.convenioForm == null)
            this.convenioForm = new ConvenioForm();

        Long codigo = this.selecionarLinha();

        if (codigo == null)
            return;

        this.convenio = this.convenioService.buscarId(codigo);

        this.dialogAdicionar(null);
    }

    private void salvar() {
        if (this.convenio == null)
            this.convenio = new Convenio();

        this.convenio.setCodigo(Long.valueOf(this.convenioForm.getRegistro().getText()));

        this.convenioService.salvar(this.convenio);
        this.convenio = new Convenio();
    }

    private Long selecionarLinha() {
        int selectedRow = this.tabela.getSelectedRow();
        return selectedRow == -1 ? null : (Long) this.tabela.getValueAt(selectedRow, 0);
    }
}
