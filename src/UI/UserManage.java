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
import BLL.User;
import MODEL.UserModel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserManage extends JDialog {


	private final JPanel contentPanel = new JPanel();
	private JTextField txt_searchid;
	private JTextField txt_id;
	private JTextField txt_password;
	private String btncmd=null;
	private JButton bt_insert;
	private JButton bt_updata;
	private JButton bt_delete;
	private JButton bt_cancel;
	private JButton	bt_sure;
	private JTextField txt_code;
	private JLabel lb_code;
	private JTable tb_user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		try {
			UserManage dialog = new UserManage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UserManage()
	{
		setBounds(100, 100, 744, 512);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent arg0) 
				{			
					
				}
			});
			scrollPane.setBounds(30, 79, 298, 283);
			contentPanel.add(scrollPane);
			
			tb_user = new JTable();
			tb_user.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) 
				{
					txt_id.setText((String)tb_user.getValueAt(tb_user.getSelectedRow(),0));
					txt_password.setText((String)tb_user.getValueAt(tb_user.getSelectedRow(), 1));
				}
			});
			tb_user.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u7528\u6237id", "\u5BC6\u7801"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, true
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			scrollPane.setViewportView(tb_user);
			
		}
		
		JLabel lblid_1 = new JLabel("\u7528\u6237id");
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
		JLabel lblid = new JLabel("\u7528\u6237id");
		lblid.setBounds(361, 130, 81, 21);
		contentPanel.add(lblid);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801");
		label_2.setBounds(361, 199, 81, 21);
		contentPanel.add(label_2);
		
		txt_id = new JTextField();
		txt_id.setBounds(476, 127, 159, 39);
		contentPanel.add(txt_id);
		txt_id.setColumns(10);
		
		txt_password = new JTextField();
		txt_password.setColumns(10);
		txt_password.setBounds(476, 196, 159, 39);
		contentPanel.add(txt_password);
		
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
		bt_sure.setBounds(361, 289, 123, 29);
		contentPanel.add(bt_sure);
		
		bt_cancel = new JButton("\u53D6\u6D88");
		bt_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				txt_id.setText("");
				txt_password.setText("");
				showOne(false);
				showTwo(true);
			}
		});
		bt_cancel.setBounds(521, 289, 123, 29);
		contentPanel.add(bt_cancel);
		
		JLabel label_3 = new JLabel("\u9A8C\u8BC1\u7801");
		label_3.setBounds(361, 264, 54, 15);
		contentPanel.add(label_3);
		
		lb_code = new JLabel(judgecode());
		lb_code.setBounds(417, 264, 54, 15);
		contentPanel.add(lb_code);
		
		txt_code = new JTextField();
		txt_code.setBounds(510, 261, 66, 21);
		contentPanel.add(txt_code);
		txt_code.setColumns(10);
		showOne(false);
		showTwo(true);
		manage("search");
	}
	public void showOne(boolean flag)
	{
		bt_cancel.setEnabled(flag);
		bt_sure.setEnabled(flag);
		txt_id.setEditable(flag);
		txt_password.setEditable(flag);
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

			DefaultTableModel defaultTableModel=(DefaultTableModel) tb_user.getModel();
			User user=new User();
			defaultTableModel.setRowCount(0);
			Vector vector=new Vector();
			UserModel userModel=new UserModel(txt_id.getText().trim(), txt_password.getText().trim());
			if(cmd.equals("search"))
			{
				userModel.setUsername(txt_searchid.getText().trim());
				userModel.setPassword("");
				vector=user.user(cmd,userModel);
			}
			else
			{
				vector=user.user(cmd,userModel);
			}
			for(int i=0;i<vector.size();i+=2)
			{
				Vector vt=new Vector();
				vt.add(vector.get(i));
				vt.add(vector.get(i+1));
				defaultTableModel.addRow(vt);
			}
	}
}
