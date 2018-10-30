package hym.book.container;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hym.book.service.UserService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JButton;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField JTFuser;
	private JPasswordField JTFpass;
	private JButton BTNlogin;
	UserService userService;

	public LoginFrame(UserService userService) {
		this.userService = userService;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("登录");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/book.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 600, 500);
		contentPane = new JPanel() {
			// 屏幕自适应背景
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("images/bg.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		Component vr1 = Box.createVerticalStrut(30);
		contentPane.add(vr1);
		JPanel JP1 = new JPanel();
		JP1.setBackground(new Color(240, 240, 240));
		contentPane.add(JP1);
		JP1.setLayout(new BoxLayout(JP1, BoxLayout.Y_AXIS));

		JLabel JLB1 = new JLabel("欢迎使用图书管理系统！");
		JLB1.setAlignmentY(Component.TOP_ALIGNMENT);
		JLB1.setAlignmentX(Component.CENTER_ALIGNMENT);
		JP1.add(JLB1);
		JLB1.setVerticalAlignment(SwingConstants.TOP);
		JLB1.setHorizontalAlignment(SwingConstants.CENTER);
		JLB1.setForeground(new Color(0, 0, 0));
		JLB1.setFont(new Font("楷体", Font.PLAIN, 38));

		Component vr2 = Box.createVerticalStrut(150);
		contentPane.add(vr2);

		JPanel JP2 = new JPanel();
		contentPane.add(JP2);

		JPanel JPL = new JPanel();
		JP2.add(JPL);
		JPL.setLayout(new BoxLayout(JPL, BoxLayout.Y_AXIS));

		JLabel lblNewLabel = new JLabel("账号：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		JPL.add(lblNewLabel);

		Component vr3 = Box.createVerticalStrut(20);
		JPL.add(vr3);

		JLabel JLBuser = new JLabel("密码：");
		JLBuser.setFont(new Font("宋体", Font.PLAIN, 18));
		JPL.add(JLBuser);

		Component hr1 = Box.createHorizontalStrut(20);
		JP2.add(hr1);

		JPanel JPR = new JPanel();
		JP2.add(JPR);
		JPR.setLayout(new BoxLayout(JPR, BoxLayout.Y_AXIS));

		JTFuser = new JTextField();
		JTFuser.setFont(new Font("宋体", Font.PLAIN, 18));
		JPR.add(JTFuser);
		JTFuser.setColumns(18);

		Component hr2 = Box.createVerticalStrut(20);
		JPR.add(hr2);

		JTFpass = new JPasswordField();
		JTFpass.setFont(new Font("宋体", Font.PLAIN, 18));
		JPR.add(JTFpass);

		JPanel JRbut = new JPanel();
		contentPane.add(JRbut);
		JRbut.setLayout(new BoxLayout(JRbut, BoxLayout.X_AXIS));

		Component horizontalStrut = Box.createHorizontalStrut(300);
		JRbut.add(horizontalStrut);

		BTNlogin = new JButton("登录");
		BTNlogin.setFont(new Font("宋体", Font.PLAIN, 18));
		BTNlogin.setVerticalAlignment(SwingConstants.TOP);
		BTNlogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		JRbut.add(BTNlogin);

		Component vr4 = Box.createVerticalStrut(250);
		contentPane.add(vr4);
		// 设置透明
		JP1.setOpaque(false);
		JP2.setOpaque(false);
		JPL.setOpaque(false);
		JPR.setOpaque(false);
		JRbut.setOpaque(false);
		initListeners();
		this.setVisible(true);
	}

	public void initListeners() {
		this.BTNlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
	}

	public void login() {
		String name = this.JTFuser.getText().trim();
		char[] passes = this.JTFpass.getPassword();
		StringBuffer password = new StringBuffer();
		for (char c : passes) {
			password.append(c);
		}
		try {
			userService.login(name, password.toString());
			new MainFrame();
			this.setVisible(false);
		} catch (Exception e) {
			showWarn(e.getMessage());
		}
	}

	// 显示警告
	protected int showWarn(String message) {
		return JOptionPane.showConfirmDialog(this, message, "警告", JOptionPane.OK_CANCEL_OPTION);
	}
}
