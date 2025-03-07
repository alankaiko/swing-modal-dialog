package raven.modal.demo.component;

import raven.modal.demo.utils.PageResponse;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TabelaGenerica<T> extends AbstractTableModel {
    private static final long serialVersionUID = 1L;

    private List<T> linhas;
    private String[] colunas;
    private List<Function<T, Object>> acessadores;
    private int paginaAtual;
    private int itensPorPagina;
    private int totalPaginas;
    private long totalItens;

    public TabelaGenerica(String[] colunas, List<Function<T, Object>> acessadores, PageResponse pageResponse) {
        this.colunas = colunas;
        this.acessadores = acessadores;
        atualizarPagina(pageResponse);
    }

    public void atualizarPagina(PageResponse pageResponse) {
        this.linhas = pageResponse.getContent();
        this.itensPorPagina = pageResponse.getSize();
        this.totalItens = pageResponse.getTotalElements();
        this.totalPaginas = pageResponse.getTotalPages();
        this.fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Object value = this.acessadores.get(columnIndex).apply(this.linhas.isEmpty() ? null : this.linhas.get(0));
        return value == null ? String.class : value.getClass();
    }

    @Override
    public int getRowCount() {
        int totalLinhas = this.linhas.size();
        int linhasIniciadas = this.paginaAtual * this.itensPorPagina;
        int linhasRestantes = totalLinhas - linhasIniciadas;
        return Math.min(linhasRestantes, this.itensPorPagina);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int row = this.paginaAtual * this.itensPorPagina + rowIndex;
        T objeto = this.linhas.get(row);
        return this.acessadores.get(columnIndex).apply(objeto);
    }

    public void proximaPagina() {
        if ((this.paginaAtual + 1) * this.itensPorPagina < this.linhas.size()) {
            this.paginaAtual++;
            this.fireTableDataChanged();
        }
    }

    public void paginaAnterior() {
        if (this.paginaAtual > 0) {
            this.paginaAtual--;
            this.fireTableDataChanged();
        }
    }

    public void irParaPagina(int pagina) {
        if (pagina >= 0 && pagina < this.totalPaginas) {
            this.paginaAtual = pagina;
            this.fireTableDataChanged();
        }
    }

    public int getTotalPaginas() {
        return this.totalPaginas;
    }

    public List<Integer> getPaginasVisiveis(int numPaginasVisiveis) {
        int inicio = Math.max(this.paginaAtual - numPaginasVisiveis / 2, 0);
        int fim = Math.min(inicio + numPaginasVisiveis - 1, this.totalPaginas - 1);

        List<Integer> paginas = new ArrayList<>();
        for (int i = inicio; i <= fim; i++) {
            paginas.add(i + 1);
        }

        return paginas;
    }

    public void setItensPorPagina(int itensPorPagina) {
        this.itensPorPagina = itensPorPagina;
    }
}
