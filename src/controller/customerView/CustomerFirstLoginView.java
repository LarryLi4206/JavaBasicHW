package controller.customerView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderView;
import model.CustomerData;
import service.impl.CustomerLoginServiceImpl;

import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class CustomerFirstLoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField number_textField;
	private JTextField account_textField;
	private JTextField password_textField;
	private JTextField name_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFirstLoginView frame = new CustomerFirstLoginView();
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
	public CustomerFirstLoginView() {
		setTitle("登入");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員編號:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel.setBounds(41, 62, 135, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("登入頁面");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(145, 10, 89, 42);
		contentPane.add(lblNewLabel_1);
		
		number_textField = new JTextField();
		number_textField.setFont(new Font("新細明體", Font.PLAIN, 16));
		number_textField.setBounds(193, 62, 135, 40);
		contentPane.add(number_textField);
		number_textField.setColumns(10);
		
		
		JLabel lblNewLabel_2 = new JLabel("帳號:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(41, 196, 135, 40);
		contentPane.add(lblNewLabel_2);
		
		account_textField = new JTextField();
		account_textField.setFont(new Font("新細明體", Font.PLAIN, 16));
		account_textField.setColumns(10);
		account_textField.setBounds(193, 196, 135, 40);
		contentPane.add(account_textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("密碼:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(41, 263, 135, 40);
		contentPane.add(lblNewLabel_2_1);
		
		password_textField = new JTextField();
		password_textField.setFont(new Font("新細明體", Font.PLAIN, 16));
		password_textField.setColumns(10);
		password_textField.setBounds(193, 263, 135, 40);
		contentPane.add(password_textField);
		
		name_textField = new JTextField();
		name_textField.setFont(new Font("新細明體", Font.PLAIN, 16));
		name_textField.setColumns(10);
		name_textField.setBounds(193, 126, 135, 40);
		contentPane.add(name_textField);
		
		JLabel lblNewLabel_2_2 = new JLabel("會員姓名:");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(41, 126, 135, 40);
		contentPane.add(lblNewLabel_2_2);
		
		JCheckBox Login_CheckBox = new JCheckBox("初次登入");
		Login_CheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(Login_CheckBox.isSelected()) {
					number_textField.setEditable(false);
				}else {
					number_textField.setEditable(true);
				}
				
			}
		});
		Login_CheckBox.setFont(new Font("新細明體", Font.PLAIN, 16));
		Login_CheckBox.setBounds(348, 71, 97, 23);
		contentPane.add(Login_CheckBox);
		
		JButton Login_Button = new JButton("登入");
		Login_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=number_textField.getText();
				String name=name_textField.getText();
				String account=account_textField.getText();
				String password=password_textField.getText();
				
				String[] getDataView={number,name,account,password};
				//System.out.println(getDataView[0]);
				//存資料
				new CustomerLoginServiceImpl().CustomerLogin(name,account,password);
				
				//將輸入的值直接送到下一頁顯示
				//JOptionPane.showConfirmDialog(訊息框架, 內容文字,標題文字, 訊息框選項);
		        int confirmResult = JOptionPane.showConfirmDialog(null, "會員資料補齊成為銅牌會員，享95折優惠?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
		        if (confirmResult == JOptionPane.YES_OPTION) {
		        	//做跳頁(註冊詳細會員資料)
		        	CustomerRegisterDataView cl=new CustomerRegisterDataView(getDataView);
		        	cl.setVisible(true);
		        	dispose();
		        } else if (confirmResult == JOptionPane.NO_OPTION) {
		        	//進入主程式點單頁面，註冊為一般會員
		        	//getDataView[0]="普通會員";
		        	CustomerData customerData=new CustomerData();
		        	customerData.setCustomer_name(name);
		        	customerData.setAccount(account);
		        	customerData.setPassword(password);
		        	customerData.setVip("普通會員");
					CustomerLoginServiceImpl customerLoginDaoImpl=new CustomerLoginServiceImpl();
					customerLoginDaoImpl.CustomerRegister(customerData,name ,account );
					
		        	OrderView orderView =new OrderView(getDataView);
		        	
		        	orderView.setVisible(true);
		        	dispose();
		            //JOptionPane.showMessageDialog(null, "You clicked NO.");
		        }else if (confirmResult == JOptionPane.CANCEL_OPTION) {
		            JOptionPane.showMessageDialog(null, "返回登入頁面");
		        	
		        }
				
				
			}
		});
		Login_Button.setFont(new Font("新細明體", Font.PLAIN, 20));
		Login_Button.setBounds(145, 333, 89, 33);
		contentPane.add(Login_Button);
		
		
	}
}
