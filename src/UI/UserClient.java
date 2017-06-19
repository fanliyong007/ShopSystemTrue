package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import BLL.UserJudge;
import MODEL.UserModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class UserClient extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username;
	private JTextField txt_password;
	private JTextField txt_code;
	private JLabel lb_code;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserClient frame = new UserClient();
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
	public UserClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setBounds(101, 58, 81, 26);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(101, 106, 81, 26);
		contentPane.add(label_1);
		
		txt_username = new JTextField();
		txt_username.setBounds(192, 57, 116, 29);
		contentPane.add(txt_username);
		txt_username.setColumns(10);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(192, 103, 116, 29);
		contentPane.add(txt_password);
		txt_password.setColumns(10);
		
		JButton btn_signin = new JButton("\u767B\u5F55");
		btn_signin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(txt_code.getText().trim().equals(lb_code.getText()))
				{	
					UserModel user=new UserModel(txt_username.getText(),txt_password.getText());
					UserJudge userJudge=new UserJudge();
					boolean result=userJudge.judge(user);
					if(result==true)
					{
						dispose();
						StartApp startApp=new StartApp();
						startApp.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "用户不存在");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "验证码错误");
				}
				lb_code.setText(judgecode());
			}
		});
		btn_signin.setBounds(101, 195, 93, 23);
		contentPane.add(btn_signin);
		
		JButton btn_clear = new JButton("\u6E05\u9664");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				txt_username.setText("");
				txt_password.setText("");
			}
		});
		btn_clear.setBounds(241, 195, 93, 23);
		contentPane.add(btn_clear);
		
		JLabel lblNewLabel = new JLabel("\u9A8C\u8BC1\u7801");
		lblNewLabel.setBounds(101, 156, 54, 15);
		contentPane.add(lblNewLabel);
		
		lb_code = new JLabel(judgecode());
		lb_code.setBounds(165, 156, 54, 15);
		contentPane.add(lb_code);
		
		txt_code = new JTextField();
		txt_code.setBounds(242, 153, 66, 21);
		contentPane.add(txt_code);
		txt_code.setColumns(10);
	}
	public String judgecode() 
	{
		Random random=new Random();
		String [] codeset={"天","王","盖","地","虎","宝","塔","镇","河","妖"};
		int a=random.nextInt(10);
		return codeset[a];	
	}
}
