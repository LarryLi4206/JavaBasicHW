package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.impl.PositionServiceImpl;
import util.TurnPage;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPositionView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField code;
	private JTextField positionCode_textField;
	private JTextField positionName_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPositionView frame = new AddPositionView();
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
	public AddPositionView() {
		setTitle("新增部門");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("現有部門:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel.setBounds(89, 31, 114, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("新增部門");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(154, 128, 113, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("現有部門代號:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(89, 87, 113, 31);
		contentPane.add(lblNewLabel_2);
		
		code = new JTextField();
		code.setEditable(false);
		code.setFont(new Font("新細明體", Font.PLAIN, 16));
		code.setBounds(213, 87, 105, 31);
		contentPane.add(code);
		code.setColumns(10);
		
		positionCode_textField = new JTextField();
		positionCode_textField.setFont(new Font("新細明體", Font.PLAIN, 16));
		positionCode_textField.setColumns(10);
		positionCode_textField.setBounds(213, 180, 105, 31);
		contentPane.add(positionCode_textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("新增部門代號:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(89, 180, 113, 31);
		contentPane.add(lblNewLabel_2_1);
		
		positionName_textField = new JTextField();
		positionName_textField.setFont(new Font("新細明體", Font.PLAIN, 16));
		positionName_textField.setColumns(10);
		positionName_textField.setBounds(213, 232, 105, 31);
		contentPane.add(positionName_textField);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("新增部門:");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(89, 232, 113, 31);
		contentPane.add(lblNewLabel_2_1_1);
		
		String[] position=new PositionServiceImpl().choicePosition();
		PositionServiceImpl positionServiceImpl=new PositionServiceImpl();

		JComboBox position_comboBox = new JComboBox(position);
		position_comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String positionName=(String) position_comboBox.getSelectedItem();
				String memberCode=positionName.toString();
				//System.out.println(memberCode);
				String Productcode=positionServiceImpl.memberCode(memberCode);
				code.setText(Productcode);
				
			}
		});
		position_comboBox.setFont(new Font("新細明體", Font.PLAIN, 16));
		position_comboBox.setBounds(213, 31, 105, 31);
		contentPane.add(position_comboBox);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pos_code=positionCode_textField.getText();
				String positionName=positionName_textField.getText();
				
				positionServiceImpl.addPosition(positionName,pos_code);
				
				int selectPage=JOptionPane.showConfirmDialog(null, "按'是'回新增頁按'否'回登入頁", "確認",JOptionPane.YES_NO_OPTION);
				
				if(selectPage==JOptionPane.YES_OPTION) {
					AddPositionView addPositionView=new AddPositionView();
					addPositionView.setVisible(true);
					dispose();
				}else if(selectPage==JOptionPane.NO_OPTION) {
					
					ChangeLoginView changeLoginView=new ChangeLoginView();
					changeLoginView.setVisible(true);
					dispose();
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnNewButton.setBounds(154, 288, 113, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("登出");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TurnPage().turnPage_ChangeLogin();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton_1.setBounds(10, 10, 97, 31);
		contentPane.add(btnNewButton_1);
	}
}
