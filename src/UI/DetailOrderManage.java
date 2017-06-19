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

import BLL.DetailOrder;
import MODEL.DetailOrderModel;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DetailOrderManage extends JDialog {


	private final JPanel contentPanel = new JPanel();
	private JTextField txt_searchid;
	private JTextField txt_id;
	private JTextField txt_shopid;
	private String btncmd=null;
	private JButton bt_insert;
	private JButton bt_updata;
	private JButton bt_delete;
	private JButton bt_cancel;
	private JButton	bt_sure;
	private JTextField txt_code;
	private JLabel lb_code;
	private JTextField txt_orderid;
	private JTextField txt_shopprice;
	private JTable tb_detailorder;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		try {
			DetailOrderManage dialog = new DetailOrderManage();
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
	public DetailOrderManage()
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
			
			tb_detailorder = new JTable();
			tb_detailorder.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) 
				{
						txt_id.setText((String)tb_detailorder.getValueAt(tb_detailorder.getSelectedRow(),0));
						txt_shopid.setText((String)tb_detailorder.getValueAt(tb_detailorder.getSelectedRow(),1));
						txt_orderid.setText((String)tb_detailorder.getValueAt(tb_detailorder.getSelectedRow(),2));
						txt_shopprice.setText((String)tb_detailorder.getValueAt(tb_detailorder.getSelectedRow(),3));
				}
			});
			tb_detailorder.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u6D41\u6C34ID", "\u5546\u54C1ID", "\u6240\u5C5E\u8BA2\u5355\u7F16\u53F7", "\u5546\u54C1\u5355\u4EF7"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			tb_detailorder.getColumnModel().getColumn(2).setPreferredWidth(123);
			tb_detailorder.getColumnModel().getColumn(3).setPreferredWidth(96);
			scrollPane.setViewportView(tb_detailorder);
			
		}
		
		JLabel lblid_1 = new JLabel("\u5546\u54C1\u540D\u79F0");
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
		JLabel lblid = new JLabel("\u6D41\u6C34ID");
		lblid.setBounds(666, 101, 81, 21);
		contentPanel.add(lblid);
		
		JLabel lblid_2 = new JLabel("\u5546\u54C1ID");
		lblid_2.setBounds(666, 156, 81, 21);
		contentPanel.add(lblid_2);
		
		txt_id = new JTextField();
		txt_id.setBounds(772, 92, 159, 39);
		contentPanel.add(txt_id);
		txt_id.setColumns(10);
		
		txt_shopid = new JTextField();
		txt_shopid.setColumns(10);
		txt_shopid.setBounds(772, 147, 159, 39);
		contentPanel.add(txt_shopid);
		
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
				txt_shopid.setText("");
				txt_orderid.setText("");
				txt_shopprice.setText("");
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
		
		JLabel lblNewLabel = new JLabel("\u6240\u5C5E\u8BA2\u5355\u7F16\u53F7");
		lblNewLabel.setBounds(666, 212, 110, 21);
		contentPanel.add(lblNewLabel);
		
		txt_orderid = new JTextField();
		txt_orderid.setBounds(772, 203, 159, 39);
		contentPanel.add(txt_orderid);
		txt_orderid.setColumns(10);
		
		JLabel fd = new JLabel("\u5546\u54C1\u5355\u4EF7");
		fd.setBounds(666, 271, 110, 21);
		contentPanel.add(fd);
		
		txt_shopprice = new JTextField();
		txt_shopprice.setEditable(false);
		txt_shopprice.setColumns(10);
		txt_shopprice.setBounds(772, 262, 159, 39);
		contentPanel.add(txt_shopprice);
		showOne(false);
		showTwo(true);
		manage("search");
	}
	public void showOne(boolean flag)
	{
		bt_cancel.setEnabled(flag);
		bt_sure.setEnabled(flag);
		txt_id.setEditable(flag);
		txt_shopid.setEditable(flag);
		txt_orderid.setEditable(flag);
		txt_shopprice.setEditable(flag);
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
			DetailOrder detailOrder=new DetailOrder();
			DefaultTableModel defaultTableModel=(DefaultTableModel) tb_detailorder.getModel();
			defaultTableModel.setRowCount(0);
			DetailOrderModel detailOrderModel=new DetailOrderModel(txt_id.getText().trim(), txt_shopid.getText().trim(), txt_orderid.getText().trim(), txt_shopprice.getText().trim());
			Vector vector=new Vector();
			if(cmd.equals("search"))
			{
				detailOrderModel.setTimeid(txt_searchid.getText().trim());
				vector=detailOrder.detailorder(cmd, detailOrderModel);
			}
			else
			{
				vector=detailOrder.detailorder(cmd, detailOrderModel);
			}
			for(int i=0;i<vector.size();i+=4)
			{
				Vector vt=new Vector();
				vt.add(vector.get(i));
				vt.add(vector.get(i+1));
				vt.add(vector.get(i+2));
				vt.add(vector.get(i+3));
				defaultTableModel.addRow(vt);
			}
			vector.clear();
	}
}
