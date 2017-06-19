package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BLL.Sector;
import MODEL.SetorModel;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SectorManage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tb_sector;
	private JTextField txt_sectorid;
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		try {
			SectorManage dialog = new SectorManage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SectorManage() 
	{
		
		setBounds(100, 100, 744, 512);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(30, 79, 298, 283);
			contentPanel.add(scrollPane);
			
			tb_sector = new JTable();
			tb_sector.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) 
				{
					txt_id.setText((String)tb_sector.getValueAt(tb_sector.getSelectedRow(),0));
					txt_name.setText((String)tb_sector.getValueAt(tb_sector.getSelectedRow(), 1));
				}
			});
			tb_sector.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u90E8\u95E8\u7F16\u53F7", "\u90E8\u95E8\u540D\u79F0"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			scrollPane.setViewportView(tb_sector);
			
		}
		
		JLabel label = new JLabel("\u90E8\u95E8\u7F16\u53F7");
		label.setBounds(30, 38, 79, 15);
		contentPanel.add(label);
		
		txt_sectorid = new JTextField();
		txt_sectorid.setBounds(124, 32, 109, 26);
		contentPanel.add(txt_sectorid);
		txt_sectorid.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				manage("search");
			}
		});
		button.setBounds(258, 34, 93, 23);
		contentPanel.add(button);
		JLabel label_1 = new JLabel("\u90E8\u95E8\u7F16\u53F7");
		label_1.setBounds(361, 130, 81, 21);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("\u90E8\u95E8\u540D\u79F0");
		label_2.setBounds(361, 199, 81, 21);
		contentPanel.add(label_2);
		
		txt_id = new JTextField();
		txt_id.setBounds(476, 127, 159, 39);
		contentPanel.add(txt_id);
		txt_id.setColumns(10);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(476, 196, 159, 39);
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
		bt_sure.setBounds(361, 289, 123, 29);
		contentPanel.add(bt_sure);
		
		bt_cancel = new JButton("\u53D6\u6D88");
		bt_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				txt_id.setText("");
				txt_name.setText("");
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
		txt_name.setEditable(flag);
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
			SetorModel setorModel=new SetorModel();
			Sector sector=new Sector();
			DefaultTableModel dtm=(DefaultTableModel) tb_sector.getModel();
			dtm.setRowCount(0);
			Vector vector=new Vector<>();
			if(cmd.equals("search"))
			{
				setorModel.setId(txt_sectorid.getText().trim());
				setorModel.setName(txt_name.getText().trim());
				vector=sector.sector(cmd,setorModel);
			}
			else
			{
				setorModel.setId(txt_id.getText().trim());
				setorModel.setName(txt_name.getText().trim());
				vector=Sector.sector(cmd,setorModel);
			}
			for(int i=0;i<vector.size();i+=2)
			{
				Vector vt=new Vector<>();
				vt.add(vector.get(i));
				vt.add(vector.get(i+1));
				dtm.addRow(vt);
			}
	}
}
