package vista_Controlador;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerListModel;
import javax.swing.table.TableCellEditor;

public class SpinnerEditor extends AbstractCellEditor
        implements TableCellEditor
    {
    final JSpinner spinner = new JSpinner();    

    // Initializes the spinner.
    public SpinnerEditor(String[] items) 
    {
        spinner.setModel(new SpinnerListModel(java.util.Arrays.asList(items)));
    }

    // Prepares the spinner component and returns it.
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) 
    {
        //spinner.setValue(value);
        return spinner;
    }

    // Enables the editor only for double-clicks.
    public boolean isCellEditable(EventObject evt) 
    {
        spinner.setVisible(true);
        return true;
    }

    // Returns the spinners current value.
    public Object getCellEditorValue() {
        return spinner.getValue();
    }
}


//String maxId = Metodos.EnteroAFactura(Solicitud_compra.getUltId_SC());
//String[] proveedores=Proveedor.getProveedores();
//String [] numot_nombreot=Orden_Trabajo.getId_nom_OT();


