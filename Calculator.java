package testing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;



//Problems to Fix-
//1. Display of default "0" Value 
//2. Replace that 0 when an integer is added but keep that zero if Decimal point is used
//3. Perform a multiplication and then Press "C" and then press "=" it will keep giving 0
//4. "CE" should make it completely forget all its' previous calculations and restart an expression
//5. The window size is always opening in maximum mode or minimized mode
//6. The window runs even after closing the GUI.
//These are just a few problems I noticed, I am sure there might be more but it should get us through the 1st Deliverable.

public class Calculator {

	private static JFrame frame;
	private JTextField textField;
	
	double firstnum;
	double secondnum;
	double result;
	String operations;
	String answer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
					window.frame.setSize(700,400);									//-------------> Problem 5. fixed
					window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	//--------------->Problem 6. fixed
					//frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 27, 576, 50);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textField);
		textField.setColumns(10);
		//textField.setText("0");
		
		
		//----------------Numbers-------------------------------------
		//------------------------------------------------------------
		
		final JButton button_0 = new JButton("0");
		button_0.setBounds(407, 264, 53, 33);
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=textField.getText()+button_0.getText();
				textField.setText(EnterNumber);
			}
		});
		panel.add(button_0);
		
		
		final JButton button_1 = new JButton("1");
		button_1.setBounds(344, 132, 53, 33);
		panel.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=textField.getText()+button_1.getText();
			textField.setText(EnterNumber);
			}
		});
		
		
		final JButton button_2 = new JButton("2");
		button_2.setBounds(407, 132, 53, 33);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=textField.getText()+button_2.getText();
				textField.setText(EnterNumber);
			}
		});
		panel.add(button_2);
		
		final JButton button_3 = new JButton("3");
		button_3.setBounds(470, 132, 53, 33);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=textField.getText()+button_3.getText();
				textField.setText(EnterNumber);
			}
		});
		panel.add(button_3);
		
		final JButton button_4 = new JButton("4");
		button_4.setBounds(344, 176, 53, 33);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String EnterNumber=textField.getText()+button_4.getText();
				textField.setText(EnterNumber);
			}
		});
		panel.add(button_4);
		
		final JButton button_5 = new JButton("5");
		button_5.setBounds(407, 176, 53, 33);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=textField.getText()+button_5.getText();
				textField.setText(EnterNumber);
			}
		});
		panel.add(button_5);
		
		final JButton button_6 = new JButton("6");
		button_6.setBounds(470, 176, 53, 33);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=textField.getText()+button_6.getText();
				textField.setText(EnterNumber);
			}
		});
		panel.add(button_6);
		
		final JButton button_7 = new JButton("7");
		button_7.setBounds(344, 221, 53, 33);
		panel.add(button_7);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=textField.getText()+button_7.getText();
				textField.setText(EnterNumber);
			}
		});
		
		
		final JButton button_8 = new JButton("8");
		button_8.setBounds(407, 220, 53, 33);
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=textField.getText()+button_8.getText();
				textField.setText(EnterNumber);
			}
		});
		panel.add(button_8);
		
		final JButton button_9 = new JButton("9");
		button_9.setBounds(470, 220, 53, 33);
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=textField.getText()+button_9.getText();
				textField.setText(EnterNumber);
			}
		});
		panel.add(button_9);
		//----------------------------------------------------------------------
		JButton button_sign = new JButton("+/-");
		button_sign.setBounds(344, 265, 53, 33);
		button_sign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			double ops = Double.parseDouble(String.valueOf(textField.getText()));
			ops=ops*-1;
			textField.setText(String.valueOf(ops));
			}
		});
		panel.add(button_sign);
		
		
		
		
		//-----------------------------------------------------------------
		final JButton button_dot = new JButton(".");
		button_dot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(! textField.getText().contains("."))
		          {
					textField.setText(textField.getText() + button_dot.getText());
		          }
			}
		});
		button_dot.setBounds(470, 264, 53, 33);
		panel.add(button_dot);
		
		
		//------------------------------------------------------------------------
		//--------------------Basic Operators----------------------------------------
		
		JButton button_div = new JButton("/");
		button_div.setBounds(533, 132, 53, 33);
		button_div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "/";
			}
		});
		panel.add(button_div);
		
		//-----------------------------------------------------------------
		JButton button_mul = new JButton("*");
		button_mul.setBounds(533, 176, 53, 33);
		button_mul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "*";
			}
		});
		panel.add(button_mul);
		
		//-----------------------------------------------------------------
		JButton button_add = new JButton("+");
		button_add.setBounds(533, 221, 53, 33);
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "+";
				
			}
		});
		panel.add(button_add);
		
		
		JButton button_sub = new JButton("-");
		button_sub.setBounds(533, 265, 53, 33);
		button_sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "-";
			}
		});
		
		//--------------------------------------------------------------
		JButton button_19 = new JButton("%");
		button_19.setBounds(533, 88, 53, 33);
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstnum=Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "%";
			}
		});
		panel.add(button_19);
		panel.add(button_sub);
		//-----------------Clear, Clear All and BackSpace Functions--------------------------
		//-----------------------------------------------------------------------------------
		JButton button_16 = new JButton("CE");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				result =0;
				answer= String.valueOf(result);
				operations=null;
				String EnterNumber=" ";
				textField.setText(EnterNumber);
			}
			
		});
		button_16.setBounds(344, 88, 53, 33);
		panel.add(button_16);
		
		JButton button_17 = new JButton("C");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("0");
			}
		});
		button_17.setBounds(407, 88, 53, 33);
		panel.add(button_17);
		
		JButton button_backspace = new JButton("<=");
		button_backspace.setBounds(470, 88, 53, 33);
		button_backspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backspace=null;
				if(textField.getText().length()>0){
					StringBuilder strB= new StringBuilder(textField.getText());
					strB.deleteCharAt(textField.getText().length()-1);
					backspace= strB.toString();
					textField.setText(backspace);
				}
			}
		});
		panel.add(button_backspace);
		
		
		//--------------------Equals to Button----------------------
		
		
		
		JButton btnNewButton = new JButton("=");
		btnNewButton.setBounds(344, 308, 242, 40);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String answer;
				secondnum =Double.parseDouble(textField.getText());
				
				if(operations=="+"){
					result =firstnum+secondnum;
					answer = String.valueOf(result);
					textField.setText(answer);
				}else if(operations=="-"){
					result =firstnum-secondnum;
					answer = String.valueOf(result);
					textField.setText(answer);
				}else if(operations=="*"){
					result =firstnum*secondnum;
					answer = String.valueOf(result);
					textField.setText(answer);
				}else if(operations=="/"){
					result =firstnum/secondnum;
					answer = String.valueOf(result);
					textField.setText(answer);
				}else if(operations=="%"){
					result =firstnum%secondnum;
					answer = String.valueOf(result);
					textField.setText(answer);
				}
			}
		});
		panel.add(btnNewButton);
		
		
	}
}
