package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.TurnPage;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderView frame = new OrderView(null);
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
	public OrderView(String[] stringlist) {
		setTitle("下單");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("取得顧客姓名");
		lblNewLabel.setBounds(104, 64, 46, 15);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText(stringlist[1]);
		
		JLabel lblNewLabel_1 = new JLabel("送出訂單還沒想到怎麼做");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(53, 127, 275, 48);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("登出");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TurnPage().turnPage_ChangeLogin();
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton.setBounds(10, 10, 112, 39);
		contentPane.add(btnNewButton);
		
		/*
		for(int i=0; i<stringlist.length;i++) {
			System.out.println("==========================");
			System.out.println(stringlist[i]);
		}
		*/
		
	}
}
