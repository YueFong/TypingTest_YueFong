package TypingTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.Timer;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.TimerTask;

//import com.opencsv.CSVReader;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TypingTest_YueFong extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String[] CSVList;
	public static double correctText;
	public static double errorText;
	public static double totalText;
	public static int[] truefalse = new int[10000];
	public static int startTime;
	public static Timer timer;
	public boolean timemark;
	public static String pname;
	public static String PassorNone;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private JTextArea textArea_1;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myTimer(true);
					
					// ReadCSV("./config.csv");
					TypingTest_YueFong frame = new TypingTest_YueFong();
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					PrintWriter pw;
					try {
						pw = new PrintWriter(new File("Exception.txt"));
						e.printStackTrace(pw);
						pw.flush();
						pw.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
//	public static void ReadCSV(String Filename) throws Exception {
//		File file = new File(Filename);
//		if (file.exists()) {
////			CSVReader csvReader = new CSVReader(new FileReader(Filename));
//			String[] row = null;
//			while ((row = csvReader.readNext()) != null) {
//				CSVList[0] = row[0];
//			}
//			csvReader.close();
//		}
//	}
	

	public static void myTimer(Boolean control) throws IOException {
		// 計時器
		try {
			startTime = 300;
			testi = startTime;
			timer = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					countdown();
					if (testi == -1) {
						
						if ((correctText/totalText)*100 > 89 && (correctText*60/startTime) > 19 ){
							PassorNone = "合格";
						}else{
							PassorNone = "未通過";
						}
						SimpleDateFormat nowdate = new java.text.SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");
						nowdate.setTimeZone(TimeZone.getTimeZone("GMT+8"));
						String sdate = nowdate.format(new java.util.Date());
						BigDecimal b1 = new BigDecimal(Double.toString((correctText)));
						BigDecimal b2 = new BigDecimal(Double.toString((totalText)));
						JOptionPane.showMessageDialog(null,
								"測驗結束!!\r\n\r\n\r\n" + "現在時間是:" + sdate
										+ "\r\n" + textField_3.getText()
										+ "(先生/小姐)" + "\r\n您測驗結果為:   "
										+ PassorNone + "\r\n總共:" + totalText + "字"
										+ "\r\n錯誤:" + errorText + "字"
										+ "\r\n正確:" + correctText + "字"
										+ "\r\n正確率:" + b1.divide(b2,4,BigDecimal.ROUND_HALF_UP).doubleValue()*100 + "%" 
										+ "\r\n每分鐘:" + (correctText*60/startTime) + "個字" );

						timer.stop();
						integerate();
					}
				}
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static int testi;
	public static void countdown(){
		
		textField_2.setText( testi +"");
		testi = testi-1;
	}

	public static void integerate() {
		PrintWriter pw;

		SimpleDateFormat nowdate = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		nowdate.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		String sdate = nowdate.format(new java.util.Date());
		try {
			pw = new PrintWriter(new File("Result.txt"));
			BigDecimal b1 = new BigDecimal(Double.toString((correctText)));
			BigDecimal b2 = new BigDecimal(Double.toString((totalText)));
			pw.print("測驗結束!!\r\n\r\n\r\n" + "現在時間是:" + sdate
					+ "\r\n" + textField_3.getText()
					+ "(先生/小姐)" + "\r\n您測驗結果為:   "
					+ PassorNone + "\r\n總共:" + totalText + "字"
					+ "\r\n錯誤:" + errorText + "字"
					+ "\r\n正確:" + correctText + "字"
					+ "\r\n正確率:" + b1.divide(b2,4,BigDecimal.ROUND_HALF_UP).doubleValue()*100 + "%" 
					+ "\r\n每分鐘:" + (correctText*60/startTime) + "個字" );
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public void CountTrueFalse() throws IOException {
		// truefalse -1沒東西 0錯 1對
		try {

			totalText = 0;
			errorText = 0;
			correctText = 0;
			String betest = "";
			betest = textArea.getText();
			String test = "";
			test = textArea_1.getText();
			
			for (int i = 0; i < betest.length(); i++) {
				if (test.charAt(i) != betest.charAt(i)) {
					truefalse[i] = 0;
				} else {
					truefalse[i] = 1;
				}
			}
			for (int i = 0; i < betest.length(); i++) {
				if (truefalse[i] > -1) {
					totalText = totalText + 1;
					if (truefalse[i] == 0) {
						errorText = errorText + 1;
					} else if (truefalse[i] == 1) {
						correctText = correctText + 1;
					}
				}
			}

			textField_1.setText(correctText + " / " + errorText + " / "
					+ totalText);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public TypingTest_YueFong() throws IOException {

		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea_1 = new JTextArea();
		textArea_1.setDisabledTextColor(SystemColor.windowText);
		textArea_1.setEnabled(false);
		textArea_1.setEditable(false);
		textArea.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					CountTrueFalse();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					CountTrueFalse();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		

		setTitle("打字測驗(Developer: Yue-Fong,Chung-20150509-6)");
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, screenSize.width, screenSize.height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 4, 0, 0));

		JLabel label_9 = new JLabel("");
		panel.add(label_9);

		textField_3 = new JTextField();
		textField_3.setText(">>>請由此，請輸入姓名<<<");
		textField_3.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		panel.add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("測驗開始");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(testi < 0){
					testi = startTime;
					textArea.setText(null);
				}
				timer.start();
				textField_3.setEditable(false);
				textArea.setEditable(true);
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		panel.add(btnNewButton);

		JLabel label_8 = new JLabel("");
		panel.add(label_8);
		// panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("合格條件：");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		panel.add(lblNewLabel);
		// lblNewLabel.setBounds(604, 5, 61, 16);

		textField = new JTextField();
		textField.setText("每分鐘20個字以上，正確率達90%，為合格。");
		textField.setEditable(false);
		textField.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		textField.setColumns(10);
		panel.add(textField);

		JLabel lblNewLabel_1 = new JLabel("字數(正確/錯誤/總數)：");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel label = new JLabel("倒數（秒數）：");
		label.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		label.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.add(label);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("字型大小：");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.add(lblNewLabel_2);

		String[] comString = { "14", "20", "30", "40" };
		JComboBox<?> comboBox = new JComboBox<Object>(comString);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					int fontsize = 0;
					try {
						fontsize = Integer.parseInt((String) e.getItem());
						textArea.setFont(new Font("Lucida Grande", 0,
								fontsize));
						textArea_1.setFont(new Font("Lucida Grande", 0,
								fontsize));
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		comboBox.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		panel.add(comboBox);

		JLabel label_1 = new JLabel("打字區：");
		label_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		label_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(label_1);

		JLabel label_10 = new JLabel("");
		panel.add(label_10);

		JLabel label_2 = new JLabel("題目區：");
		label_2.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		label_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(label_2);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(new Rectangle(2, 2, 2, 2));
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane);

		textArea.setFont(new Font("Lucida Grande", Font.BOLD, 14));

		textArea.setCaretColor(Color.BLACK);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		// panel_1.add(textArea);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(new Rectangle(2, 2, 2, 2));
		scrollPane_1
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane_1);

		try {
			FileReader fReader = new FileReader("Text");
			BufferedReader br = new BufferedReader(fReader);
			textArea_1.read(br, null);
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		textArea_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		textArea_1.setBackground(SystemColor.window);
		textArea_1.setCaretColor(SystemColor.textText);
		textArea_1.setLineWrap(true);
//		JTextPane textPane = new JTextPane();
		
		scrollPane_1.setViewportView(textArea_1);
//		scrollPane_1.setViewportView(textPane);
		
		
		//panel_1.add(textPane);
		

	}

}
