package hym.book.container;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;

import hym.book.dao.BookDao;
import hym.book.dao.BookInRecordDao;
import hym.book.dao.BookSaleRecordDao;
import hym.book.dao.ConcernDao;
import hym.book.dao.InRecordDao;
import hym.book.dao.SaleRecordDao;
import hym.book.dao.TypeDao;
import hym.book.dao.impl.BookDaoImpl;
import hym.book.dao.impl.BookInRecordDaoImpl;
import hym.book.dao.impl.BookSaleRecordDaoImpl;
import hym.book.dao.impl.ConcernDaoImpl;
import hym.book.dao.impl.InRecordDaoImpl;
import hym.book.dao.impl.SaleRecordDaoImpl;
import hym.book.dao.impl.TypeDaoImpl;
import hym.book.service.BookService;
import hym.book.service.ConcernService;
import hym.book.service.InRecordService;
import hym.book.service.SaleRecordService;
import hym.book.service.TypeService;
import hym.book.service.impl.BookServiceImpl;
import hym.book.service.impl.ConcernServiceImpl;
import hym.book.service.impl.InRecordServiceImpl;
import hym.book.service.impl.SaleRecordServiceImpl;
import hym.book.service.impl.TypeServiceImpl;

//�������JFrame
public class MainFrame extends JFrame{
	
	SalePanel salePanel;
	
	RepertoryPanel repertoryPanel;
	
	BookPanel bookPanel;
	
	ConcernPanel concernPanel;
	
	TypePanel typePanel;
	
	CommonPanel currentPanel;
	
	//ҵ��ӿ�
	TypeService typeService;
	
	ConcernService concernService;
	
	BookService bookService;
	
	SaleRecordService saleRecordService;
	
	InRecordService inRecordService;
	
	private Action sale = new AbstractAction("���۹���", new ImageIcon("images/sale.png")) {
		public void actionPerformed(ActionEvent e) {
			changePanel(salePanel);
		}
	};

	private Action repertory = new AbstractAction("������", new ImageIcon("images/repertory.png")) {
		public void actionPerformed(ActionEvent e) {
			changePanel(repertoryPanel);
		}
	};
	private Action book = new AbstractAction("�鱾����", new ImageIcon("images/book.png")) {
		public void actionPerformed(ActionEvent e) {
			changePanel(bookPanel);
			bookPanel.initImage();
			bookPanel.repaint();
		}
	};
	
	private Action type = new AbstractAction("�������", new ImageIcon("images/type.png")) {
		public void actionPerformed(ActionEvent e) {
			changePanel(typePanel);
		}
	};
	
	private Action concern = new AbstractAction("���������", new ImageIcon("images/concern.png")) {
		public void actionPerformed(ActionEvent e) {
			changePanel(concernPanel);
		}
	};
	
	public MainFrame() {
		TypeDao typeDao = new TypeDaoImpl();
		ConcernDao concernDao = new ConcernDaoImpl();
		BookDao bookDao = new BookDaoImpl();
		SaleRecordDao saleRecordDao = new SaleRecordDaoImpl();
		BookSaleRecordDao bookSaleRecordDao = new BookSaleRecordDaoImpl();
		InRecordDao inRecordDao = new InRecordDaoImpl();
		BookInRecordDao bookInRecordDao = new BookInRecordDaoImpl();
		this.typeService = new TypeServiceImpl(typeDao);
		this.concernService = new ConcernServiceImpl(concernDao);
		this.bookService = new BookServiceImpl(bookDao, typeDao, concernDao);
		this.saleRecordService = new SaleRecordServiceImpl(saleRecordDao, 
				bookSaleRecordDao, bookDao);
		this.inRecordService = new InRecordServiceImpl(inRecordDao, bookInRecordDao, bookDao);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("ϵͳ");
		menuBar.add(menu);
		//���ò˵����ݼ�
		menu.add(sale).setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK));
		menu.add(repertory).setAccelerator(KeyStroke.getKeyStroke('R', InputEvent.CTRL_MASK));
		menu.add(book).setAccelerator(KeyStroke.getKeyStroke('B', InputEvent.CTRL_MASK));
		menu.add(type).setAccelerator(KeyStroke.getKeyStroke('T', InputEvent.CTRL_MASK));
		menu.add(concern).setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_MASK));
		
		//�ý�����Ϊ��һ��ʾ����
		this.salePanel = new SalePanel(this.bookService, this.saleRecordService);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/book.jpg"));
		this.add(salePanel);
		this.currentPanel = salePanel;
		//��ʼ�����۽��������
		this.salePanel.initData();
		
		//��ʼ�����������
		repertoryPanel = new RepertoryPanel(this.inRecordService, this.bookService);
		//��ʼ���鱾�������
		bookPanel = new BookPanel(this.bookService, this.typeService, 
				this.concernService);
		//��ʼ��������������
		concernPanel = new ConcernPanel(this.concernService);
		//��ʼ������������
		typePanel = new TypePanel(this.typeService);
		
		this.setJMenuBar(menuBar);
		this.setTitle("ͼ�����۹���ϵͳ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}
	
	//�л���������
	private void changePanel(CommonPanel commonPanel) {
		//�Ƴ���ǰ��ʾ��JPanel
		this.remove(currentPanel);
		//�����Ҫ��ʾ��JPanel
		this.add(commonPanel);
		//���õ�ǰ��JPanel
		this.currentPanel = commonPanel;
		this.repaint();
		this.setVisible(true);
		//���¶�ȡ����
		commonPanel.setViewDatas();
		//ˢ���б�
		commonPanel.clear();
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
