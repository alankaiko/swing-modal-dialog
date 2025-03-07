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
import java.util.function.Function;

@SystemForm(name = "Convenio", description = "Tabela de Convênios")
public class ListaConvenio extends FormTableGeneric {
    private JTable tabela;
    private ConvenioService convenioService;
    private ConvenioForm convenioForm;
    private Convenio convenio;
    private List<Convenio> listaConvenios;
    private TabelaGenerica<Convenio> tabelaGenerica;
    private int itensPorPagina;
    private long totalItens;
    private long totalPaginas;

    @Override
    protected void init() {
        this.setLayout(new MigLayout("fillx,wrap", "[fill]", "[][fill,grow]"));
        this.add(this.faixaTitulo("Convênios", "", 1));
    }

    @Override
    protected void carregarObjetos() {
        ConvenioDTO filtro = new ConvenioDTO();

        filtro.setItensPorPagina(filtro.getItensPorPagina());
        this.convenioService = new ConvenioServiceImpl();
        PageResponse pageResponse = this.convenioService.filtrando(filtro);
        this.listaConvenios = pageResponse.getContent();
        this.itensPorPagina = pageResponse.getSize();
        this.totalItens = pageResponse.getTotalElements();
        this.totalPaginas = pageResponse.getTotalPages();
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

        this.tabelaGenerica = new TabelaGenerica<>(colunas, acessadores, this.listaConvenios, this.itensPorPagina);

        this.tabela = new JTable(this.tabelaGenerica);
        JScrollPane scrollPane = new JScrollPane(this.tabela);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        this.tabela.getTableHeader().setReorderingAllowed(false);

        panel.add(new JLabel("Lista de Convênios"), "gapx 20");
        panel.add(this.createHeaderAction());
        panel.add(scrollPane);

        criarBotoesDeNavegacao(panel);

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
            btnPagina.addActionListener(e -> irParaPagina(pagina - 1));
            navPanel.add(btnPagina);
        }

        navPanel.add(btnPaginaProxima);
        navPanel.add(btnUltimaPagina);

        panel.add(navPanel, "span 2, growx, center");
    }

    private void proximaPagina() {
        tabelaGenerica.proximaPagina();
        tabela.repaint();
    }

    private void paginaAnterior() {
        tabelaGenerica.paginaAnterior();
        tabela.repaint();
    }

    private void irParaPagina(int pagina) {
        tabelaGenerica.irParaPagina(pagina);
        tabela.repaint();
    }

    @Override
    protected void pesquisar(String texto) {
        ConvenioDTO filtro = new ConvenioDTO();

        filtro.setItensPorPagina(filtro.getItensPorPagina());
        filtro.setNome(texto);

        this.convenioService = new ConvenioServiceImpl();
        PageResponse pageResponse = this.convenioService.filtrando(filtro);
        this.listaConvenios = pageResponse.getContent();
        this.itensPorPagina = pageResponse.getSize();
        this.totalItens = pageResponse.getTotalElements();
        this.totalPaginas = pageResponse.getTotalPages();

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
