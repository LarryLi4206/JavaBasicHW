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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MemberLoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField memberId_textField;
	private JTextField member_name_textField;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberLoginView frame = new MemberLoginView();
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
	public MemberLoginView() {
		setTitle("員工登錄");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("內部員工登錄");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 22));
		lblNewLabel.setBounds(132, 29, 157, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("員工編號:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(59, 65, 97, 26);
		contentPane.add(lblNewLabel_1);
		
		memberId_textField = new JTextField();
		memberId_textField.setFont(new Font("新細明體", Font.PLAIN, 16));
		memberId_textField.setBounds(168, 65, 121, 26);
		contentPane.add(memberId_textField);
		memberId_textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("員工所屬部門:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(35, 101, 121, 26);
		contentPane.add(lblNewLabel_1_1);
		
		member_name_textField = new JTextField();
		member_name_textField.setFont(new Font("新細明體", Font.PLAIN, 16));
		member_name_textField.setColumns(10);
		member_name_textField.setBounds(168, 142, 121, 26);
		contentPane.add(member_name_textField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("員工姓名:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(59, 142, 97, 26);
		contentPane.add(lblNewLabel_1_1_1);
		//取得職位選項
		PositionServiceImpl psi=new PositionServiceImpl();
		String[] position=psi.choicePosition();
		
		MemberRegisterServiceImpl mrsi=new MemberRegisterServiceImpl();
		
		JComboBox position_comboBox = new JComboBox(position);
		/* 
		position_comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getPosition=(String) position_comboBox.getSelectedItem();
			}
		});
		*/
		position_comboBox.setFont(new Font("新細明體", Font.PLAIN, 16));
		position_comboBox.setBounds(168, 101, 121, 23);
		contentPane.add(position_comboBox);
		
		
		JButton Login_btnNewButton = new JButton("登入");
		Login_btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String memberId=memberId_textField.getText();
				String getPosition=(String) position_comboBox.getSelectedItem();
				String member_name=member_name_textField.getText();
				
				List<MemberData> list_m=mrsi.checkLoginMemberData(memberId, getPosition, member_name);
				try {
					if(list_m.get(0)!=null) {
						//判斷每個部門登入頁面不同
						if(list_m.get(0).getPosition().equals("老闆")) {	
							//進入新增產品或修改產品價格頁面
							AddPositionView addPositionView=new AddPositionView();
							addPositionView.setVisible(true);
							dispose();
							
						}else if(list_m.get(0).getPosition().equals("人事部")) {
							MemberRegister memberRegister=new MemberRegister();
							memberRegister.setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null,"功能開發中");
						}
						
					}
				}catch(IndexOutOfBoundsException x) {
					JOptionPane.showMessageDialog(null,"資料錯誤請重新輸入");
					memberId_textField.setText("");
					member_name_textField.setText("");
					//System.out.println("帳密輸入錯誤");
				}
				
			}
		});
		Login_btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 20));
		Login_btnNewButton.setBounds(132, 199, 157, 26);
		contentPane.add(Login_btnNewButton);
		
		JButton btnNewButton = new JButton("回選擇身分頁");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new TurnPage().turnPage_ChangeLogin();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton.setBounds(299, 218, 137, 35);
		contentPane.add(btnNewButton);
		
	}
	
}
