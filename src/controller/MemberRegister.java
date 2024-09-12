package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.MemberData;
import service.impl.MemberRegisterServiceImpl;
import service.impl.PositionServiceImpl;
import util.TurnPage;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberRegister extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField memberID_textField;
	private JTextField member_name_textField;
	private JTextField account_textField;
	private JTextField password_textField;
	private JTextField address_textField;
	private JTextField mail_address_textField;
	private JTextField tel_textField;
	private JTextField txtBo;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberRegister frame = new MemberRegister();
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
	public MemberRegister() {
		setTitle("人資使用登錄員工資料");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("人事登錄員工資料");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel.setBounds(122, 10, 199, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("員工編號:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(35, 70, 116, 36);
		contentPane.add(lblNewLabel_1);
		
		memberID_textField = new JTextField();
		memberID_textField.setEditable(false);
		memberID_textField.setFont(new Font("新細明體", Font.PLAIN, 16));
		memberID_textField.setBounds(223, 70, 104, 36);
		contentPane.add(memberID_textField);
		memberID_textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("員工所屬部門:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(35, 116, 116, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("員工姓名:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(35, 168, 116, 36);
		contentPane.add(lblNewLabel_3);
		
		member_name_textField = new JTextField();
		member_name_textField.setFont(new Font("新細明體", Font.PLAIN, 16));
		member_name_textField.setColumns(10);
		member_name_textField.setBounds(171, 168, 156, 36);
		contentPane.add(member_name_textField);
		
		JLabel lblNewLabel_4 = new JLabel("帳號:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(35, 218, 116, 36);
		contentPane.add(lblNewLabel_4);
		
		account_textField = new JTextField();
		account_textField.setFont(new Font("新細明體", Font.PLAIN, 16));
		account_textField.setColumns(10);
		account_textField.setBounds(171, 218, 156, 36);
		contentPane.add(account_textField);
		
		JLabel lblNewLabel_5 = new JLabel("密碼:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(35, 271, 116, 36);
		contentPane.add(lblNewLabel_5);
		
		password_textField = new JTextField();
		password_textField.setFont(new Font("新細明體", Font.PLAIN, 16));
		password_textField.setColumns(10);
		password_textField.setBounds(171, 271, 156, 36);
		contentPane.add(password_textField);
		
		JLabel lblNewLabel_6 = new JLabel("聯絡地址:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(35, 317, 116, 36);
		contentPane.add(lblNewLabel_6);
		
		address_textField = new JTextField();
		address_textField.setFont(new Font("新細明體", Font.PLAIN, 16));
		address_textField.setColumns(10);
		address_textField.setBounds(171, 317, 156, 36);
		contentPane.add(address_textField);
		
		JLabel lblNewLabel_7 = new JLabel("信箱:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(35, 363, 116, 36);
		contentPane.add(lblNewLabel_7);
		
		mail_address_textField = new JTextField();
		mail_address_textField.setFont(new Font("新細明體", Font.PLAIN, 16));
		mail_address_textField.setColumns(10);
		mail_address_textField.setBounds(171, 363, 156, 36);
		contentPane.add(mail_address_textField);
		
		JLabel lblNewLabel_8 = new JLabel("連絡電話:");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(35, 409, 116, 36);
		contentPane.add(lblNewLabel_8);
		
		tel_textField = new JTextField();
		tel_textField.setFont(new Font("新細明體", Font.PLAIN, 16));
		tel_textField.setColumns(10);
		tel_textField.setBounds(171, 409, 156, 36);
		contentPane.add(tel_textField);
		
		String[] position=new PositionServiceImpl().choicePosition();
		
		PositionServiceImpl positionServiceImpl=new PositionServiceImpl();
		
		
		txtBo = new JTextField();
		txtBo.setEditable(false);
		txtBo.setFont(new Font("新細明體", Font.PLAIN, 16));
		txtBo.setBounds(168, 70, 41, 36);
		contentPane.add(txtBo);
		txtBo.setColumns(10);
		
		MemberRegisterServiceImpl mrsi=new MemberRegisterServiceImpl();
		memberID_textField.setText(mrsi.productMemberId());
		String id=mrsi.productMemberId();
		
		JComboBox position_comboBox = new JComboBox(position);
		position_comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String positionName=(String) position_comboBox.getSelectedItem();
				String memberCode=positionName.toString();
				//System.out.println(memberCode);
				String Productcode=positionServiceImpl.memberCode(memberCode);
				txtBo.setText(Productcode);
				
				account_textField.setText(txtBo.getText().concat(memberID_textField.getText()));
				password_textField.setText(txtBo.getText().concat(memberID_textField.getText()));

			}
		});
		position_comboBox.setFont(new Font("新細明體", Font.PLAIN, 16));
		position_comboBox.setBounds(171, 116, 156, 36);
		contentPane.add(position_comboBox);
		
		
		JButton btnNewButton = new JButton("登入資料");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//取memberID
				String full_memberID=txtBo.getText().concat(id);
				//System.out.println(full_memberID);
				MemberData memberdata=new MemberData();
				//取得職位
				String positionName=(String) position_comboBox.getSelectedItem();
				String memberPosition=positionName.toString();
				//取得欄位輸入資料
				String memberName=member_name_textField.getText();
				String account=account_textField.getText();
				String password=password_textField.getText();
				String address=address_textField.getText();
				String mail=mail_address_textField.getText();
				String tel=tel_textField.getText();
				
				//取得資料
				memberdata.setMember_id(full_memberID);
				memberdata.setPosition(memberPosition);
				memberdata.setMember_name(memberName);
				memberdata.setAccount(account);
				memberdata.setPassword(password);
				memberdata.setAddress(address);
				memberdata.setMail_address(mail);
				memberdata.setTelephone(tel);
				
				mrsi.addMemberData(memberdata);
				
				//測試多存入幾筆資料--方便之後登入使用
				MemberRegister frame = new MemberRegister();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnNewButton.setBounds(122, 471, 199, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("回登入頁");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TurnPage().turnPage_ChangeLogin();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton_1.setBounds(10, 10, 102, 38);
		contentPane.add(btnNewButton_1);
		
		
	}
}
