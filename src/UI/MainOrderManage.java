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

import BLL.MainOrder;
import MODEL.MainOrderModel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.management.ManagementPermission;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MainOrderManage extends JDialog {


	private final JPanel contentPanel = new JPanel();
	private JTextField txt_searchid;
	private JTextField txt_id;
	private JTextField txt_orderprice;
	private String btncmd=null;
	private JButton bt_insert;
	private JButton bt_updata;
	private JButton bt_delete;
	private JButton bt_cancel;
	private JButton	bt_sure;
	private JTextField txt_code;
	private JLabel lb_code;
	private JTextField txt_buytime;
	private JTextField txt_vcode;
	private JTextField txt_seller;
	private JTable tb_mainorder;
	private JTextField txt_number;
	private JTextField txt_paymoney;
	private JTextField txt_changemoney;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		try {
			MainOrderManage dialog = new MainOrderManage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("main wrong");
		}
	}

	public MainOrderManage()
	{
		setBounds(100, 100, 1100, 765);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(15, 68, 710, 534);
			contentPanel.add(scrollPane);
			
			tb_mainorder = new JTable();
			tb_mainorder.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) 
				{
					txt_id.setText((String)tb_mainorder.getValueAt(tb_mainorder.getSelectedRow(),0));
					txt_number.setText((String)tb_mainorder.getValueAt(tb_mainorder.getSelectedRow(), 1));
					txt_orderprice.setText((String)tb_mainorder.getValueAt(tb_mainorder.getSelectedRow(), 2));
					txt_paymoney.setText((String)tb_mainorder.getValueAt(tb_mainorder.getSelectedRow(), 3));
					txt_changemoney.setText((String)tb_mainorder.getValueAt(tb_mainorder.getSelectedRow(), 4));
					txt_buytime.setText((String)tb_mainorder.getValueAt(tb_mainorder.getSelectedRow(), 5));
					txt_vcode.setText((String)tb_mainorder.getValueAt(tb_mainorder.getSelectedRow(), 6));
					txt_seller.setText((String)tb_mainorder.getValueAt(tb_mainorder.getSelectedRow(), 7));
				}
			});
			tb_mainorder.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u8BA2\u5355ID", "\u5546\u54C1\u4EF6\u6570", "\u603B\u4EF7", "\u5B9E\u4ED8", "\u627E\u96F6", "\u8D2D\u4E70\u65F6\u95F4", "\u4F1A\u5458\u5361\u53F7", "\u6536\u94F6\u5458"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			tb_mainorder.getColumnModel().getColumn(1).setPreferredWidth(89);
			tb_mainorder.getColumnModel().getColumn(5).setPreferredWidth(114);
			tb_mainorder.getColumnModel().getColumn(6).setPreferredWidth(118);
			scrollPane.setViewportView(tb_mainorder);
			
		}
		
		JLabel lblid_1 = new JLabel("\u8BA2\u5355ID");
		lblid_1.setBounds(30, 38, 79, 15);
		contentPanel.add(lblid_1);
		
		txt_searchid = new JTextField();
		txt_searchid.setBounds(124, 32, 109, 26);
		contentPanel.add(txt_searchid);
		txt_searchid.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				manage("search");
			}
		});
		button.setBounds(258, 34, 93, 23);
		contentPanel.add(button);
		JLabel lblid = new JLabel("\u8BA2\u5355id");
		lblid.setBounds(773, 77, 81, 21);
		contentPanel.add(lblid);
		
		JLabel label_2 = new JLabel("\u5B9E\u4ED8");
		label_2.setBounds(773, 245, 81, 21);
		contentPanel.add(label_2);
		
		txt_id = new JTextField();
		txt_id.setBounds(869, 68, 159, 39);
		contentPanel.add(txt_id);
		txt_id.setColumns(10);
		
		txt_orderprice = new JTextField();
		txt_orderprice.setColumns(10);
		txt_orderprice.setBounds(869, 176, 159, 39);
		contentPanel.add(txt_orderprice);
		
		bt_insert = new JButton("\u589E\u52A0 ");
		bt_insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				showOne(true);
				showTwo(false);
				btncmd="insert";
				
			}
		});
		bt_insert.setBounds(30, 646, 123, 29);
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
		bt_updata.setBounds(185, 646, 123, 29);
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
		bt_delete.setBounds(340, 646, 123, 29);
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
		bt_sure.setBounds(729, 627, 123, 29);
		contentPanel.add(bt_sure);
		
		bt_cancel = new JButton("\u53D6\u6D88");
		bt_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				txt_id.setText("");
				txt_orderprice.setText("");
				txt_buytime.setText("");
				txt_changemoney.setText("");
				txt_vcode.setText("");
				txt_paymoney.setText("");
				txt_seller.setText("");
				txt_number.setText("");
				showOne(false);
				showTwo(true);
			}
		});
		bt_cancel.setBounds(887, 627, 123, 29);
		contentPanel.add(bt_cancel);
		
		JLabel label_3 = new JLabel("\u9A8C\u8BC1\u7801");
		label_3.setBounds(740, 587, 54, 15);
		contentPanel.add(label_3);
		
		lb_code = new JLabel(judgecode());
		lb_code.setBounds(833, 587, 54, 15);
		contentPanel.add(lb_code);
		
		txt_code = new JTextField();
		txt_code.setBounds(914, 584, 66, 21);
		contentPanel.add(txt_code);
		txt_code.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8D2D\u4E70\u65F6\u95F4");
		lblNewLabel.setBounds(773, 351, 110, 21);
		contentPanel.add(lblNewLabel);
		
		txt_buytime = new JTextField();
		txt_buytime.setBounds(869, 342, 159, 39);
		contentPanel.add(txt_buytime);
		txt_buytime.setColumns(10);
		
		JLabel fd = new JLabel("\u4F1A\u5458\u5361\u53F7");
		fd.setBounds(773, 407, 110, 21);
		contentPanel.add(fd);
		
		txt_vcode = new JTextField();
		txt_vcode.setColumns(10);
		txt_vcode.setBounds(869, 398, 159, 39);
		contentPanel.add(txt_vcode);
		
		JLabel label = new JLabel("\u6536\u94F6\u5458");
		label.setBounds(773, 474, 110, 21);
		contentPanel.add(label);
		
		txt_seller = new JTextField();
		txt_seller.setColumns(10);
		txt_seller.setBounds(869, 465, 159, 39);
		contentPanel.add(txt_seller);
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u4EF6\u6570");
		label_1.setBounds(773, 127, 81, 21);
		contentPanel.add(label_1);
		
		txt_number = new JTextField();
		txt_number.setColumns(10);
		txt_number.setBounds(869, 122, 159, 39);
		contentPanel.add(txt_number);
		
		JLabel label_4 = new JLabel("\u603B\u4EF7");
		label_4.setBounds(773, 185, 81, 21);
		contentPanel.add(label_4);
		
		txt_paymoney = new JTextField();
		txt_paymoney.setColumns(10);
		txt_paymoney.setBounds(869, 236, 159, 39);
		contentPanel.add(txt_paymoney);
		
		JLabel label_5 = new JLabel("\u627E\u96F6");
		label_5.setBounds(773, 293, 81, 21);
		contentPanel.add(label_5);
		
		txt_changemoney = new JTextField();
		txt_changemoney.setColumns(10);
		txt_changemoney.setBounds(869, 290, 159, 39);
		contentPanel.add(txt_changemoney);
		showOne(false);
		showTwo(true);
		manage("search");
	}
	public void showOne(boolean flag)
	{
		bt_cancel.setEnabled(flag);
		bt_sure.setEnabled(flag);
		txt_id.setEditable(flag);
		txt_orderprice.setEditable(flag);
		txt_buytime.setEditable(flag);
		txt_vcode.setEditable(flag);
		txt_seller.setEditable(flag);
		txt_changemoney.setEditable(flag);
		txt_paymoney.setEditable(flag);
		txt_number.setEditable(flag);
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
			MainOrder mainOrder=new MainOrder();
			DefaultTableModel defaultTableModel=(DefaultTableModel) tb_mainorder.getModel();
			defaultTableModel.setRowCount(0);
			Vector vector=new Vector();
			MainOrderModel mainOrderModel=new MainOrderModel(txt_id.getText().trim()
					,txt_number.getText().trim(), txt_orderprice.getText().trim(), txt_paymoney.getText().trim(), 
					txt_changemoney.getText().trim(), txt_buytime.getText().trim(), txt_vcode.getText().trim(),
					txt_seller.getText().trim());
			if(cmd.equals("search"))
			{
				mainOrderModel.setOrderid(txt_searchid.getText().trim());
				vector=mainOrder.mainorder(cmd, mainOrderModel);
			}
			else
			{
				vector=mainOrder.mainorder(cmd, mainOrderModel);
			}
			for(int i=0;i<vector.size();i+=8)
			{
				Vector vt=new Vector();
				for(int j=i;j<8;j++)
				{
					vt.add(vector.get(j));
				}
				defaultTableModel.addRow(vt);
			}
			vector.clear();
	}
}
