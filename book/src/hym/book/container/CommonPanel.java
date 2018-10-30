package hym.book.container;

import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//����JPanel�Ļ���
public abstract class CommonPanel extends JPanel {

	//������ݵ�table
	private JTable table;
	
	//�б�����
	protected Vector<Vector> datas;
	
	public void setJTable(JTable table) {
		this.table = table;
	}
	
	public JTable getJTable() {
		return this.table;
	}
	
	public Vector<Vector> getDatas() {
		return datas;
	}

	public void setDatas(Vector<Vector> datas) {
		this.datas = datas;
	}

	/*
	 * ���������ý�JTable��
	 */
	public void initData() {
		if (this.table == null) return; 
		DefaultTableModel tableModel = (DefaultTableModel)this.table.getModel();
		//������������Model��
		tableModel.setDataVector(getDatas(), getColumns());
		//���ñ����ʽ
		setTableFace();
	}
	
	/*
	 * ˢ���б�ķ���
	 */
	public void refreshTable() {
		initData();
		getJTable().repaint();
	}
	
	/*
	 * ��ȡ���м���, ������ȥʵ��
	 */
	public abstract Vector<String> getColumns();
	
	/*
	 * �����б����ʽ, ������ȥʵ��
	 */
	public abstract void setTableFace();
	
	/*
	 * ���������б�ķ�����������ʵ��
	 */
	public abstract void setViewDatas();
	
	/*
	 * ��ս����±ߵ��б�
	 */
	public abstract void clear();
	
	/*
	 * �ָ��õ�box
	 */
	public Box getSplitBox() {
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(new JLabel("             "));
		return box;
	}
	
	//������ʹ�õķ���, ���ڻ�ȡһ���б��id��ֵ
	public String getSelectId(JTable table) {
		int row = table.getSelectedRow();
		int column = table.getColumn("id").getModelIndex();
		String id = (String)table.getValueAt(row, column);
		return id;
	}
	
	
	//��ʾ����
	protected int showWarn(String message) {
		return JOptionPane.showConfirmDialog(this, message, "����", 
				JOptionPane.OK_CANCEL_OPTION);
	}
}
