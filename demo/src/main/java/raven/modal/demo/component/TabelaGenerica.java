package raven.modal.demo.component;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TabelaGenerica<T> extends AbstractTableModel {
    private static final long serialVersionUID = 1L;

    private List<T> linhas;
    private String[] colunas;
    private List<Function<T, Object>> acessadores;
    private int paginaAtual = 0;
    private int itensPorPagina;

    public TabelaGenerica(String[] colunas, List<Function<T, Object>> acessadores, List<T> dados, int itensPorPagina) {
        this.colunas = colunas;
        this.acessadores = acessadores;
        this.itensPorPagina = itensPorPagina;
        this.linhas = new ArrayList<>(dados);
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
        int linhasIniciadas = paginaAtual * itensPorPagina;
        int linhasRestantes = totalLinhas - linhasIniciadas;
        return Math.min(linhasRestantes, itensPorPagina);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int row = paginaAtual * itensPorPagina + rowIndex;
        T objeto = this.linhas.get(row);
        return this.acessadores.get(columnIndex).apply(objeto);
    }

    public void atualizarDados(List<T> dados) {
        this.linhas = new ArrayList<>(dados);
        fireTableDataChanged();
    }

    public void proximaPagina() {
        if ((paginaAtual + 1) * itensPorPagina < this.linhas.size()) {
            paginaAtual++;
            fireTableDataChanged();
        }
    }

    public void paginaAnterior() {
        if (paginaAtual > 0) {
            paginaAtual--;
            fireTableDataChanged();
        }
    }

    public void irParaPagina(int pagina) {
        int totalPaginas = (int) Math.ceil((double) this.linhas.size() / itensPorPagina);
        if (pagina >= 0 && pagina < totalPaginas) {
            paginaAtual = pagina;
            fireTableDataChanged();
        }
    }

    public int getTotalPaginas() {
        return (int) Math.ceil((double) this.linhas.size() / itensPorPagina);
    }

    public List<Integer> getPaginasVisiveis(int numPaginasVisiveis) {
        int totalPaginas = getTotalPaginas();
        int inicio = Math.max(paginaAtual - numPaginasVisiveis / 2, 0);
        int fim = Math.min(inicio + numPaginasVisiveis - 1, totalPaginas - 1);

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

