/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view.model.table;

import hr.algebra.model.Director;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jo
 */
public class DirectorTableModel extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"Id", "Name", "Movies", "Picture path"};
    private List<Director> directors;

    public DirectorTableModel(List<Director> directors) {
        this.directors = directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return directors.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return directors.get(rowIndex).getId();
            case 1:
                return directors.get(rowIndex).getDirectorName();
            case 2:
                return directors.get(rowIndex).getMovies().toString();
            case 3:
                return directors.get(rowIndex).getPicturePath();
        }
        throw new RuntimeException("Choose another, that column doesn't exist.");
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
        }
        return super.getColumnClass(columnIndex);
    }

}
