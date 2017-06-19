package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartApp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartApp frame = new StartApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u57FA\u7840\u7BA1\u7406");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("\u90E8\u95E8\u7BA1\u7406");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				SectorManage sectorManage=new SectorManage();
				sectorManage.setModal(true);
				sectorManage.setVisible(true);
			}
		});

		mnNewMenu.add(menuItem);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u7528\u6237\u7BA1\u7406");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				UserManage userManage=new UserManage();
				userManage.setModal(true);
				userManage.setVisible(true);
			}
		});

		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u5546\u54C1\u7BA1\u7406");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ShopManage shopManage=new ShopManage();
				shopManage.setModal(true);
				shopManage.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u987E\u5BA2\u7BA1\u7406");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				CustomerManage customerManage=new CustomerManage();
				customerManage.setModal(true);
				customerManage.setVisible(true);
			}
		});

		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("\u9500\u552E\u7BA1\u7406");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("\u8BA2\u5355\u603B\u8868\u7BA1\u7406");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				MainOrderManage mainOrderManage=new MainOrderManage();
				mainOrderManage.setModal(true);
				mainOrderManage.setVisible(true);
			}
		});
		mnNewMenu_1.add(menuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u8BA2\u5355\u660E\u7EC6\u8868");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		//setExtendedState(MAXIMIZED_BOTH);×î´ó»¯
	}
}
