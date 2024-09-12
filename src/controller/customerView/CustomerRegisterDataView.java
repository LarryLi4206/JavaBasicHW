package controller.customerView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ChangeLoginView;
import controller.OrderView;
import model.CustomerData;
import service.impl.CustomerLoginServiceImpl;
import util.InputNotNull;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class CustomerRegisterDataView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField customerID_textField;
	private JTextField customerName_textField;
	private JTextField account_textField;
	private JTextField password_textField;
	private JTextField address_textField;
	private JTextField mail_address_textField;
	private JTextField tel_textField;
	
	private CustomerLoginServiceImpl customer_Login=new CustomerLoginServiceImpl();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					CustomerRegisterDataView frame = new CustomerRegisterDataView(null);
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
	public CustomerRegisterDataView(String[] Loginlist) {
		setTitle("註冊會員資料");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員填寫詳細資料");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 24));
		lblNewLabel.setBounds(89, 23, 238, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("會員編號:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(30, 83, 102, 44);
		contentPane.add(lblNewLabel_1);
		
		customerID_textField = new JTextField();
		customerID_textField.setText("自動填入");
		customerID_textField.setEditable(false);
		customerID_textField.setFont(new Font("新細明體", Font.PLAIN, 14));
		customerID_textField.setBounds(142, 83, 153, 44);
		contentPane.add(customerID_textField);
		customerID_textField.setColumns(10);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("姓名:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(30, 137, 102, 44);
		contentPane.add(lblNewLabel_2);
		
		
		customerName_textField = new JTextField();
		customerName_textField.setFont(new Font("新細明體", Font.PLAIN, 14));
		customerName_textField.setColumns(10);
		customerName_textField.setBounds(142, 137, 153, 44);
		contentPane.add(customerName_textField);
		
		
		JLabel lblNewLabel_3 = new JLabel("帳號:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(30, 191, 102, 44);
		contentPane.add(lblNewLabel_3);
		
		account_textField = new JTextField();
		account_textField.setFont(new Font("新細明體", Font.PLAIN, 14));
		account_textField.setColumns(10);
		account_textField.setBounds(142, 191, 153, 44);
		contentPane.add(account_textField);
		
		
		password_textField = new JTextField();
		password_textField.setFont(new Font("新細明體", Font.PLAIN, 14));
		password_textField.setColumns(10);
		password_textField.setBounds(142, 245, 153, 44);
		contentPane.add(password_textField);
		
		JLabel lblNewLabel_4 = new JLabel("密碼:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(30, 245, 102, 44);
		contentPane.add(lblNewLabel_4);
		
		address_textField = new JTextField();
		address_textField.setFont(new Font("新細明體", Font.PLAIN, 14));
		address_textField.setColumns(10);
		address_textField.setBounds(142, 299, 153, 44);
		contentPane.add(address_textField);
		
		JLabel lblNewLabel_5 = new JLabel("地址:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(30, 299, 102, 44);
		contentPane.add(lblNewLabel_5);
		
		mail_address_textField = new JTextField();
		mail_address_textField.setFont(new Font("新細明體", Font.PLAIN, 14));
		mail_address_textField.setColumns(10);
		mail_address_textField.setBounds(142, 353, 153, 44);
		contentPane.add(mail_address_textField);
		
		JLabel lblNewLabel_6 = new JLabel("信箱:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(30, 353, 102, 44);
		contentPane.add(lblNewLabel_6);
		
		tel_textField = new JTextField();
		tel_textField.setFont(new Font("新細明體", Font.PLAIN, 14));
		tel_textField.setColumns(10);
		tel_textField.setBounds(142, 407, 153, 44);
		contentPane.add(tel_textField);
		
		JLabel lblNewLabel_7 = new JLabel("連絡電話:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(30, 407, 102, 44);
		contentPane.add(lblNewLabel_7);
		
		customerName_textField.setText(Loginlist[1]);
		account_textField.setText(Loginlist[2]);
		password_textField.setText(Loginlist[3]);
		
		customerID_textField.setText(customer_Login.productUserID(Loginlist[1], Loginlist[2]));
		
		
		
		JButton btnNewButton = new JButton("註冊完整資料");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//輸入不能為空,否則會顯示為
				InputNotNull input_NN=new InputNotNull();
				customerID_textField.setText(input_NN.InputNotNullFunction(customerID_textField.getText()).toString());
				customerName_textField.setText(input_NN.InputNotNullFunction(customerName_textField.getText()).toString());
				account_textField.setText(input_NN.InputNotNullFunction(account_textField.getText()).toString());
				password_textField.setText(input_NN.InputNotNullFunction(password_textField.getText()).toString());
				address_textField.setText(input_NN.InputNotNullFunction(address_textField.getText()).toString());
				mail_address_textField.setText(input_NN.InputNotNullFunction(mail_address_textField.getText()).toString());
				tel_textField.setText(input_NN.InputNotNullFunction(tel_textField.getText()).toString());

				
				CustomerData customerData=new CustomerData();
				customerData.setCustomer_id(customerID_textField.getText());
				customerData.setCustomer_name(customerName_textField.getText());
				customerData.setAccount(account_textField.getText());
				customerData.setPassword(password_textField.getText());
				customerData.setAddress(address_textField.getText());
				customerData.setMail_address(mail_address_textField.getText());
				customerData.setTelephone(tel_textField.getText());
				customerData.setVip("銀牌會員");
				
				CustomerLoginServiceImpl customerLoginDaoImpl=new CustomerLoginServiceImpl();
				customerLoginDaoImpl.CustomerRegister(customerData, customerName_textField.getText(), account_textField.getText());
				
				int confirmResult = JOptionPane.showConfirmDialog(null, "點'是'則繼續使用點單系統,點'否'回到主頁面 ", "Confirm", JOptionPane.YES_NO_OPTION);
				String[] stringlist=new String[] {
						customerData.getCustomer_id(),
						customerData.getCustomer_name(),
						customerData.getAccount(),
						customerData.getPassword(),
						customerData.getVip()};
				
				if(confirmResult==JOptionPane.YES_OPTION) {
					
					OrderView orderView=new OrderView(stringlist);
					orderView.setVisible(true);
					dispose();
					
				}else if(confirmResult==JOptionPane.NO_OPTION) {
					ChangeLoginView changeLoginView=new ChangeLoginView();
					changeLoginView.setVisible(true);
					dispose();
				}
				
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnNewButton.setBounds(127, 470, 163, 50);
		contentPane.add(btnNewButton);
	}
}
