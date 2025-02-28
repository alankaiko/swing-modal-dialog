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

    public TabelaGenerica(String[] colunas, List<Function<T, Object>> acessadores, List<T> dados) {
        this.colunas = colunas;
        this.linhas = new ArrayList<>(dados);
        this.acessadores = acessadores;
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return acessadores.get(columnIndex).apply(linhas.get(0)).getClass();
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        T objeto = linhas.get(rowIndex);
        return acessadores.get(columnIndex).apply(objeto);
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        T objeto = linhas.get(rowIndex);
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void adicionarLinha(T objeto) {
        linhas.add(objeto);
        fireTableRowsInserted(linhas.size() - 1, linhas.size() - 1);
    }

    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }
}
