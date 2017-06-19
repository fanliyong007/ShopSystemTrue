package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Random;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BLL.Customer;
import BLL.Shop;
import MODEL.CustomerModel;
import MODEL.ShopModel;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopManage extends JDialog {


	private final JPanel contentPanel = new JPanel();
	private JTextField txt_searchname;
	private JTextField txt_id;
	private JTextField txt_name;
	private String btncmd=null;
	private JButton bt_insert;
	private JButton bt_updata;
	private JButton bt_delete;
	private JButton bt_cancel;
	private JButton	bt_sure;
	private JTextField txt_code;
	private JLabel lb_code;
	private JTextField txt_inprice;
	private JTextField txt_outprice;
	private JTextField txt_num;
	private JTable tb_shop;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		try {
			ShopManage dialog = new ShopManage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("main wrong");
		}
	}

	/**
	 * Create the dialog.
	 */
	public ShopManage()
	{
		setBounds(100, 100, 974, 512);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(7, 79, 629, 283);
			contentPanel.add(scrollPane);
			
			tb_shop = new JTable();
			tb_shop.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) 
				{
					txt_id.setText((String)tb_shop.getValueAt(tb_shop.getSelectedRow(),0));
					txt_name.setText((String)tb_shop.getValueAt(tb_shop.getSelectedRow(), 1));
					txt_inprice.setText((String)tb_shop.getValueAt(tb_shop.getSelectedRow(), 2));
					txt_outprice.setText((String)tb_shop.getValueAt(tb_shop.getSelectedRow(), 3));
					txt_num.setText((String)tb_shop.getValueAt(tb_shop.getSelectedRow(), 4));
				}
			});
			tb_shop.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u5546\u54C1ID", "\u5546\u54C1\u540D\u79F0", "\u5546\u54C1\u8FDB\u4EF7", "\u5546\u54C1\u552E\u4EF7", "\u5546\u54C1\u6570\u91CF"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			scrollPane.setViewportView(tb_shop);
			
		}
		
		JLabel lblid_1 = new JLabel("\u5546\u54C1\u540D\u79F0");
		lblid_1.setBounds(30, 38, 79, 15);
		contentPanel.add(lblid_1);
		
		txt_searchname = new JTextField();
		txt_searchname.setBounds(124, 32, 109, 26);
		contentPanel.add(txt_searchname);
		txt_searchname.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				manage("search");
			}
		});
		button.setBounds(258, 34, 93, 23);
		contentPanel.add(button);
		JLabel lblid = new JLabel("\u5546\u54C1id");
		lblid.setBounds(666, 59, 81, 21);
		contentPanel.add(lblid);
		
		JLabel label_2 = new JLabel("\u5546\u54C1\u540D");
		label_2.setBounds(666, 106, 81, 21);
		contentPanel.add(label_2);
		
		txt_id = new JTextField();
		txt_id.setBounds(772, 50, 159, 39);
		contentPanel.add(txt_id);
		txt_id.setColumns(10);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(772, 97, 159, 39);
		contentPanel.add(txt_name);
		
		bt_insert = new JButton("\u589E\u52A0 ");
		bt_insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				showOne(true);
				showTwo(false);
				btncmd="insert";
				
			}
		});
		bt_insert.setBounds(35, 394, 123, 29);
		contentPanel.add(bt_insert);
		
		bt_updata = new JButton("\u4FEE\u6539");
		bt_updata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				showOne(true);
				showTwo(false);
				btncmd="updata";
			}
		});
		bt_updata.setBounds(188, 394, 123, 29);
		contentPanel.add(bt_updata);
		
		bt_delete = new JButton("\u5220\u9664");
		bt_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				showOne(true);
				showTwo(false);
				btncmd="delete";
			}
		});
		bt_delete.setBounds(348, 394, 123, 29);
		contentPanel.add(bt_delete);
		
		bt_sure = new JButton("\u786E\u5B9A");
		bt_sure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String incode=txt_code.getText().trim();
				if(incode.equals(lb_code.getText()))
				{
					showOne(false);
					showTwo(true);
					manage(btncmd);
					manage("search");
				}
				else
				{
					showOne(false);
					showTwo(true);
					JOptionPane.showMessageDialog(null, "验证码错误");
				}
				lb_code.setText(judgecode());
			}

			
		});
		bt_sure.setBounds(661, 366, 123, 29);
		contentPanel.add(bt_sure);
		
		bt_cancel = new JButton("\u53D6\u6D88");
		bt_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				txt_id.setText("");
				txt_name.setText("");
				txt_inprice.setText("");
				showOne(false);
				showTwo(true);
			}
		});
		bt_cancel.setBounds(825, 366, 123, 29);
		contentPanel.add(bt_cancel);
		
		JLabel label_3 = new JLabel("\u9A8C\u8BC1\u7801");
		label_3.setBounds(713, 331, 54, 15);
		contentPanel.add(label_3);
		
		lb_code = new JLabel(judgecode());
		lb_code.setBounds(777, 331, 54, 15);
		contentPanel.add(lb_code);
		
		txt_code = new JTextField();
		txt_code.setBounds(865, 328, 66, 21);
		contentPanel.add(txt_code);
		txt_code.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u8FDB\u4EF7");
		lblNewLabel.setBounds(666, 154, 110, 21);
		contentPanel.add(lblNewLabel);
		
		txt_inprice = new JTextField();
		txt_inprice.setBounds(772, 145, 159, 39);
		contentPanel.add(txt_inprice);
		txt_inprice.setColumns(10);
		
		JLabel fd = new JLabel("\u5546\u54C1\u552E\u4EF7");
		fd.setBounds(666, 207, 110, 21);
		contentPanel.add(fd);
		
		txt_outprice = new JTextField();
		txt_outprice.setEditable(false);
		txt_outprice.setColumns(10);
		txt_outprice.setBounds(772, 198, 159, 39);
		contentPanel.add(txt_outprice);
		
		JLabel label = new JLabel("\u5546\u54C1\u6570\u91CF");
		label.setBounds(666, 262, 110, 21);
		contentPanel.add(label);
		
		txt_num = new JTextField();
		txt_num.setEditable(false);
		txt_num.setColumns(10);
		txt_num.setBounds(772, 253, 159, 39);
		contentPanel.add(txt_num);
		showOne(false);
		showTwo(true);
		manage("search");
	}
	public void showOne(boolean flag)
	{
		bt_cancel.setEnabled(flag);
		bt_sure.setEnabled(flag);
		txt_id.setEditable(flag);
		txt_name.setEditable(flag);
		txt_inprice.setEditable(flag);
		txt_outprice.setEditable(flag);
		txt_num.setEditable(flag);
	}
	public void showTwo(boolean flag)
	{
		bt_delete.setEnabled(flag);
		bt_insert.setEnabled(flag);
		bt_updata.setEnabled(flag);
	}
	public String judgecode() 
	{
		Random random=new Random();
		String [] codeset={"天","王","盖","地","虎","宝","塔","镇","河","妖"};
		int a=random.nextInt(10);
		return codeset[a];	
	}
	public void manage(String cmd) 
	{
			Shop shop=new Shop();
			DefaultTableModel defaultTableModel=(DefaultTableModel) tb_shop.getModel();
			defaultTableModel.setRowCount(0);
			Vector vector=new Vector();
			ShopModel shopModel=new ShopModel(txt_id.getText().trim(), txt_name.getText().trim(), txt_inprice.getText().trim(), txt_outprice.getText().trim(), txt_num.getText().trim());
			if(cmd.equals("search"))
			{
				shopModel.setShopname(txt_searchname.getText().trim());
				vector=shop.shop(cmd, shopModel);
			}
			else
			{
				vector=shop.shop(cmd, shopModel);
			}
			for(int i=0;i<vector.size();i+=5)
			{
				Vector vt=new Vector();
				vt.add(vector.get(i));
				vt.add(vector.get(i+1));
				vt.add(vector.get(i+2));
				vt.add(vector.get(i+3));
				vt.add(vector.get(i+4));
				defaultTableModel.addRow(vt);
			}
			vector.clear();
	}
}
