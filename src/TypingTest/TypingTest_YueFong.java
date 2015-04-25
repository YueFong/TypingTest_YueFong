package TypingTest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;

public class TypingTest_YueFong extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TypingTest_YueFong frame = new TypingTest_YueFong();
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
	public TypingTest_YueFong() {
		setTitle("打字測驗(Developer: Yue-Fong,Chung-20150425-1)");
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, screenSize.width, screenSize.height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel label_11 = new JLabel("");
		panel.add(label_11);
		
		textField_3 = new JTextField();
		textField_3.setText(">>>請由此，請輸入姓名<<<");
		textField_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("測驗開始");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(btnNewButton);
		
		JLabel label_12 = new JLabel("");
		panel.add(label_12);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel.add(lblNewLabel_3);
		//panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("合格條件：");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(lblNewLabel);
		//lblNewLabel.setBounds(604, 5, 61, 16);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setColumns(10);
		panel.add(textField);
		
		JLabel label_3 = new JLabel("");
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("");
		panel.add(label_4);
		
		JLabel lblNewLabel_1 = new JLabel("字數(正確/錯誤/總數)：");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_5 = new JLabel("");
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("");
		panel.add(label_6);
		
		JLabel label = new JLabel("倒數（秒數）：");
		label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.add(label);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_7 = new JLabel("");
		panel.add(label_7);
		
		JLabel label_9 = new JLabel("");
		panel.add(label_9);
		
		JLabel lblNewLabel_2 = new JLabel("字型大小：");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.add(lblNewLabel_2);
		
		JList list = new JList();
		list.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(list);
		
		JLabel label_8 = new JLabel("");
		panel.add(label_8);
		
		JLabel label_1 = new JLabel("打字區：");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(label_1);
		
		JLabel label_10 = new JLabel("");
		panel.add(label_10);
		
		JLabel label_2 = new JLabel("題目區：");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(label_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(new Rectangle(2, 2, 2, 2));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(new Rectangle(2, 2, 2, 2));
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textArea_1.setBackground(SystemColor.window);
		textArea_1.setCaretColor(Color.BLACK);
		textArea_1.setLineWrap(true);
		scrollPane_1.setViewportView(textArea_1);
		
	}
}
