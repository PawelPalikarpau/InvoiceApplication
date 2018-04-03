package my.projects.invoiceapplication.application.ui.shared.model;

import org.assertj.core.util.Lists;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public abstract class DefaultTableModel<T> extends AbstractTableModel {

    protected List<T> entities = Lists.newArrayList();

    public abstract String[] getColumnLabels();

    @Override
    public int getRowCount() {
        return entities.size();
    }

    @Override
    public int getColumnCount() {
        return getColumnLabels().length;
    }

    @Override
    public String getColumnName(int index) {
        return getColumnLabels()[index];
    }

    public void addEntity(T entity) {
        this.entities.add(entity);
        fireTableDataChanged();
    }

    public void addEntities(List<T> entities) {
        this.entities.addAll(entities);
        fireTableDataChanged();
    }

    public T getEntityByRow(int row) {
        return entities.get(row);
    }

    public void removeRow(int row) {
        entities.remove(row);
        fireTableDataChanged();
    }

    public void clear() {
        entities.clear();
    }
}
