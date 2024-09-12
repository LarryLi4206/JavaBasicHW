package controller.customerView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderView;
import service.impl.CustomerLoginServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerAfterRegisterView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name_textField;
	private JTextField account_textField;
	private JTextField password_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerAfterRegisterView frame = new CustomerAfterRegisterView();
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
	public CustomerAfterRegisterView() {
		setTitle("顧客登入");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("顧客登入");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 22));
		lblNewLabel.setBounds(133, 31, 142, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(65, 75, 83, 34);
		contentPane.add(lblNewLabel_1);
		
		name_textField = new JTextField();
		name_textField.setBounds(160, 75, 132, 34);
		contentPane.add(name_textField);
		name_textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(65, 119, 83, 34);
		contentPane.add(lblNewLabel_1_1);
		
		account_textField = new JTextField();
		account_textField.setColumns(10);
		account_textField.setBounds(160, 119, 132, 34);
		contentPane.add(account_textField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("密碼:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(65, 163, 83, 34);
		contentPane.add(lblNewLabel_1_1_1);
		
		password_textField = new JTextField();
		password_textField.setColumns(10);
		password_textField.setBounds(160, 163, 132, 34);
		contentPane.add(password_textField);
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=name_textField.getText();
				String account=account_textField.getText();
				String password=password_textField.getText();
				try {
					String[] listData=new CustomerLoginServiceImpl().checkedLoginData(name,account,password);
					
					if(listData.length!=0) {
						OrderView orderView=new OrderView(listData);
						orderView.setVisible(true);
						dispose();
					}
				}catch(NullPointerException x) {
					JOptionPane.showMessageDialog(null,"查無資料請重新登入");
					name_textField.setText("");
					account_textField.setText("");
					password_textField.setText("");
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnNewButton.setBounds(133, 215, 142, 34);
		contentPane.add(btnNewButton);
	}
}
