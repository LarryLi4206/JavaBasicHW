package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.customerView.CustomerAfterRegisterView;
import controller.customerView.CustomerFirstLoginView;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class ChangeLoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeLoginView frame = new ChangeLoginView();
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
	public ChangeLoginView() {
		setTitle("使用者身分選擇");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton customer_Button = new JButton("客戶沒帳號請註冊");
		customer_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CustomerFirstLoginView c=new CustomerFirstLoginView();
				c.setVisible(true);
				dispose();
			}
		});
		customer_Button.setFont(new Font("新細明體", Font.PLAIN, 22));
		customer_Button.setBounds(32, 61, 250, 60);
		contentPane.add(customer_Button);
		
		JButton btnNewButton = new JButton("已經有帳號直接登入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CustomerAfterRegisterView customerAfterRegisterView=new CustomerAfterRegisterView();
				customerAfterRegisterView.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 22));
		btnNewButton.setBounds(32, 131, 250, 60);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("時間");
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel.setBounds(32, 10, 283, 41);
		contentPane.add(lblNewLabel);
		
		//不知道為甚麼(整理ChatGpt成功的)
		Timer timer = new Timer(100,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formatter = new SimpleDateFormat("現在時間:YYY/MM/DD HH:mm:ss");
                Date now = new Date();
                lblNewLabel.setText(formatter.format(now));
			}
        });
        timer.start();
	
        JButton member_Button = new JButton("員工登入");
		member_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberLoginView memberLoginView=new MemberLoginView();
				memberLoginView.setVisible(true);
				dispose();
				
			}
		});
		member_Button.setFont(new Font("新細明體", Font.PLAIN, 22));
		member_Button.setBounds(300, 95, 179, 60);
		contentPane.add(member_Button);
	}
	
}
