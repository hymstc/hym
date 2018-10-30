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

//主界面的JFrame
public class MainFrame extends JFrame{
	
	SalePanel salePanel;
	
	RepertoryPanel repertoryPanel;
	
	BookPanel bookPanel;
	
	ConcernPanel concernPanel;
	
	TypePanel typePanel;
	
	CommonPanel currentPanel;
	
	//业务接口
	TypeService typeService;
	
	ConcernService concernService;
	
	BookService bookService;
	
	SaleRecordService saleRecordService;
	
	InRecordService inRecordService;
	
	private Action sale = new AbstractAction("销售管理", new ImageIcon("images/sale.png")) {
		public void actionPerformed(ActionEvent e) {
			changePanel(salePanel);
		}
	};

	private Action repertory = new AbstractAction("库存管理", new ImageIcon("images/repertory.png")) {
		public void actionPerformed(ActionEvent e) {
			changePanel(repertoryPanel);
		}
	};
	private Action book = new AbstractAction("书本管理", new ImageIcon("images/book.png")) {
		public void actionPerformed(ActionEvent e) {
			changePanel(bookPanel);
			bookPanel.initImage();
			bookPanel.repaint();
		}
	};
	
	private Action type = new AbstractAction("种类管理", new ImageIcon("images/type.png")) {
		public void actionPerformed(ActionEvent e) {
			changePanel(typePanel);
		}
	};
	
	private Action concern = new AbstractAction("出版社管理", new ImageIcon("images/concern.png")) {
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
		JMenu menu = new JMenu("系统");
		menuBar.add(menu);
		//设置菜单项快捷键
		menu.add(sale).setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK));
		menu.add(repertory).setAccelerator(KeyStroke.getKeyStroke('R', InputEvent.CTRL_MASK));
		menu.add(book).setAccelerator(KeyStroke.getKeyStroke('B', InputEvent.CTRL_MASK));
		menu.add(type).setAccelerator(KeyStroke.getKeyStroke('T', InputEvent.CTRL_MASK));
		menu.add(concern).setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_MASK));
		
		//让界面作为第一显示界面
		this.salePanel = new SalePanel(this.bookService, this.saleRecordService);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/book.jpg"));
		this.add(salePanel);
		this.currentPanel = salePanel;
		//初始化销售界面的数据
		this.salePanel.initData();
		
		//初始化库存管理界面
		repertoryPanel = new RepertoryPanel(this.inRecordService, this.bookService);
		//初始化书本管理界面
		bookPanel = new BookPanel(this.bookService, this.typeService, 
				this.concernService);
		//初始化出版社管理界面
		concernPanel = new ConcernPanel(this.concernService);
		//初始化种类管理界面
		typePanel = new TypePanel(this.typeService);
		
		this.setJMenuBar(menuBar);
		this.setTitle("图书销售管理系统");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}
	
	//切换各个界面
	private void changePanel(CommonPanel commonPanel) {
		//移除当前显示的JPanel
		this.remove(currentPanel);
		//添加需要显示的JPanel
		this.add(commonPanel);
		//设置当前的JPanel
		this.currentPanel = commonPanel;
		this.repaint();
		this.setVisible(true);
		//重新读取数据
		commonPanel.setViewDatas();
		//刷新列表
		commonPanel.clear();
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
