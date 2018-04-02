package calculator;

/**
 * 
 */
/**
 * @author Akshat Bisht
 *
 */



import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Calculator {

	private static JFrame frmEternity;
	private JTextField textField;
	String expressiondisplay;
	String expressioncalc;
	String operations;
	String answer="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frmEternity.setVisible(true);
					window.frmEternity.setSize(400,400);									
					window.frmEternity.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
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
		frmEternity = new JFrame();
		frmEternity.setResizable(false);
		frmEternity.setTitle("Eternity");
		frmEternity.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmEternity.getContentPane().add(panel, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setBounds(25, 25, 350, 50);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textField.setBackground(Color.black);//--------------> text background can will be black
		textField.setForeground(new Color(255,255,255));//--------> text color will be white
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		//textField.setText("0");
		
		
		//----------------Numbers-------------------------------------
		//------------------------------------------------------------
		
		final JButton button_0 = new JButton("0");
		button_0.setBounds(165, 275, 70, 40);
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				expressiondisplay=textField.getText()+button_0.getText();
				expressioncalc=textField.getText()+button_0.getText();
				textField.setText(expressiondisplay);
			}
		});
		
		
		final JButton button_1 = new JButton("1");
		button_1.setBounds(95, 235, 70, 40);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expressiondisplay=textField.getText()+button_1.getText();
				expressioncalc=textField.getText()+button_1.getText();
				textField.setText(expressiondisplay);
			}
		});
		
		;
		final JButton button_2 = new JButton("2");
		button_2.setBounds(165, 235, 70, 40);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expressiondisplay=textField.getText()+button_2.getText();
				expressioncalc=textField.getText()+button_2.getText();
				textField.setText(expressiondisplay);
			}
		});
		
		
		final JButton button_3 = new JButton("3");
		button_3.setBounds(235, 235, 70, 40);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expressiondisplay=textField.getText()+button_3.getText();
				expressioncalc=textField.getText()+button_3.getText();
				textField.setText(expressiondisplay);
			}
		});
		
		
		final JButton button_4 = new JButton("4");
		button_4.setBounds(95, 195, 70, 40);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expressiondisplay=textField.getText()+button_4.getText();
				expressioncalc=textField.getText()+button_4.getText();
				textField.setText(expressiondisplay);
			}
		});
		
		
		final JButton button_5 = new JButton("5");
		button_5.setBounds(165, 195, 70, 40);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expressiondisplay=textField.getText()+button_5.getText();
				expressioncalc=textField.getText()+button_5.getText();
				textField.setText(expressiondisplay);
			}
		});
		
		
		final JButton button_6 = new JButton("6");
		button_6.setBounds(235, 195, 70, 40);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expressiondisplay=textField.getText()+button_6.getText();
				expressioncalc=textField.getText()+button_6.getText();
				textField.setText(expressiondisplay);
			}
		});
		
		
		final JButton button_7 = new JButton("7");
		button_7.setBounds(95, 155, 70, 40);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expressiondisplay=textField.getText()+button_7.getText();
				expressioncalc=textField.getText()+button_7.getText();
				textField.setText(expressiondisplay);
			}
		});
		
		
		final JButton button_8 = new JButton("8");
		button_8.setBounds(165, 155, 70, 40);
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expressiondisplay=textField.getText()+button_8.getText();
				expressioncalc=textField.getText()+button_8.getText();
				textField.setText(expressiondisplay);
			}
		});
		
		
		final JButton button_9 = new JButton("9");
		button_9.setBounds(235, 155, 70, 40);
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expressiondisplay=textField.getText()+button_9.getText();
				expressioncalc=textField.getText()+button_9.getText();
				textField.setText(expressiondisplay);
			}
		});
		
		
		//----------------------------------------------------------------------
		JButton button_sign = new JButton("+/-");
		button_sign.setBounds(95, 275, 70, 40);
		button_sign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			double ops = Double.parseDouble(String.valueOf(textField.getText()));
			ops=ops*-1;
			textField.setText(String.valueOf(ops));
			}
		});
		
		
		
		
		//-----------------------------------------------------------------
		final JButton button_dot = new JButton(".");
		button_dot.setBounds(235, 275, 70, 40);
		button_dot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_dot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(! textField.getText().contains("."))
		          {
					textField.setText(textField.getText() + button_dot.getText());
		          }
			}
		});
		
		
		//------------------------------------------------------------------------
		//--------------------Basic Operators----------------------------------------

		final JButton button_div = new JButton("/");
		button_div.setBounds(305, 115, 70, 40);
		button_div.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button_div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				expressiondisplay=textField.getText()+button_div.getText();
				expressioncalc=textField.getText()+button_div.getText();
				textField.setText(expressiondisplay);
			}
		});
		
		//-----------------------------------------------------------------
		final JButton button_mul = new JButton("*");
		button_mul.setBounds(305, 155, 70, 40);
		button_mul.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button_mul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				expressiondisplay=textField.getText()+button_mul.getText();
				expressioncalc=textField.getText()+button_mul.getText();
				textField.setText(expressiondisplay);
			}
		});
		
		//-----------------------------------------------------------------
		final JButton button_add = new JButton("+");
		button_add.setBounds(305, 195, 70, 40);
		button_add.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				expressiondisplay=textField.getText()+button_add.getText();
				expressioncalc=textField.getText()+button_add.getText();
				textField.setText(expressiondisplay);
				
			}
		});
		
		
		final JButton button_sub = new JButton("-");
		button_sub.setBounds(305, 235, 70, 40);
		button_sub.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button_sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				expressiondisplay=textField.getText()+button_sub.getText();
				expressioncalc=textField.getText()+"m";
				textField.setText(expressiondisplay);
			}
		});
		//--------------------------------------------------------------
		final JButton button_rem = new JButton("%");
		button_rem.setBounds(305, 75, 70, 40);
		button_rem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_rem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				expressiondisplay=textField.getText()+button_rem.getText();
				expressioncalc=textField.getText()+button_rem.getText();
				textField.setText(expressiondisplay);
			}
		});
		
		//-----------------Clear, Clear All and BackSpace Functions--------------------------
		//-----------------------------------------------------------------------------------
		JButton button_clearall = new JButton("CE");//------------> clear everything
		button_clearall.setBounds(95, 115, 70, 40);
		button_clearall.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_clearall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				answer="";
			}
			
		});
		
		JButton button_clear = new JButton("C");//---------------> clear
		button_clear.setBounds(165, 115, 70, 40);
		button_clear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		
		JButton button_backspace = new JButton("<=");//---------------->backspace
		button_backspace.setBounds(235, 115, 70, 40);
		button_backspace.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
		
		
		//--------------------Equals to Button----------------------
		
		
		
		JButton btnNewButton = new JButton("=");
		btnNewButton.setBounds(305, 275, 70, 40);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(EpressionIp.stack(expressioncalc).equals("1.0E20")) //error if negative log return error
				{					
					answer="Logarithm can't be negative";
				}
				else if(EpressionIp.stack(expressioncalc).equals("1.0E21")) // error if log is zero then return error
				{					
					answer =  "Negative Infinity";
				}
				else if(EpressionIp.stack(expressioncalc).equals("1.0E22")) // error if divide by zero
				{
					answer = "Cannot divide by zero";
				}
				else if(EpressionIp.stack(expressioncalc).equals("1.0E25")) //error if root of negative number
				{
					answer = "Root Negative Number Error";	// error if square root of negative number
				}
				else
				{
					answer=(EpressionIp.stack(expressioncalc));
				}
				
				textField.setText(answer);
			}
		});
		
		//--------------------------------------------------
		//-------------SpeciaL Functions--------------------
		final JButton btnPi = new JButton("\u03C0");//---------->PI
		btnPi.setBounds(25, 115, 70, 40);
		btnPi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				expressiondisplay=textField.getText()+btnPi.getText();
				expressioncalc=textField.getText()+"3.14159265358979323846264338327950288419716939937510582097494";
				textField.setText(expressiondisplay);
			}
		});
		
		
		final JButton btnLnx = new JButton("ln");
		btnLnx.setBounds(25, 155, 70, 40);
		btnLnx.setFont(new Font("Tahoma", Font.PLAIN, 12));		
		btnLnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				expressiondisplay=textField.getText()+btnLnx.getText()+"(";
				expressioncalc=textField.getText()+"1l"+"(";
				textField.setText(expressiondisplay);
			}
		});
		
		final JButton btnEx = new JButton("e");//------> euler's number
		btnEx.setBounds(25, 195, 70, 40);
		btnEx.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				expressiondisplay=textField.getText()+btnEx.getText();
				expressioncalc=textField.getText()+"2.7182818284590452353602874713527 ";

				textField.setText(expressiondisplay);
			}
		});
		
		
		final JButton btnx = new JButton("\u221A");//-------> square root
		btnx.setBounds(25, 235, 70, 40);
		btnx.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				expressiondisplay=textField.getText()+btnx.getText()+"(";
				expressioncalc=textField.getText()+"1r";
				textField.setText(expressiondisplay);
			}
		});
		
		final JButton btnSinx = new JButton("sin");//-------> value of sin
		btnSinx.setBounds(25, 75, 70, 40);
		btnSinx.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSinx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expressioncalc=textField.getText()+"1s"+"(";
				expressiondisplay=textField.getText()+btnSinx.getText()+"(";
				textField.setText(expressiondisplay);
			}
		});
		
		final JButton btnXy = new JButton("^");//------> power
		btnXy.setBounds(25, 275, 70, 40);
		btnXy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				expressiondisplay=textField.getText()+btnXy.getText()+"(";
				expressioncalc=textField.getText()+btnXy.getText();
				textField.setText(expressiondisplay);
			}
		});
		
		//----------------------------------------------------------------------------------
		panel.setLayout(null);
		panel.add(textField);
		panel.add(button_4);
		panel.add(btnEx);
		panel.add(button_7);
		panel.add(btnLnx);
		panel.add(button_1);
		panel.add(btnSinx);
		panel.add(btnPi);
		panel.add(button_clearall);
		panel.add(button_clear);
		panel.add(button_2);
		panel.add(button_8);
		panel.add(button_5);
		panel.add(button_9);
		panel.add(button_6);
		panel.add(button_3);
		panel.add(button_backspace);
		panel.add(button_rem);
		panel.add(button_mul);
		panel.add(button_add);
		panel.add(button_div);
		panel.add(btnx);
		panel.add(button_sign);
		panel.add(button_0);
		panel.add(button_dot);
		panel.add(button_sub);
		panel.add(btnXy);
		panel.add(btnNewButton);
		
		JButton button = new JButton(")");
		button.setBounds(235, 75, 70, 40);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				expressiondisplay=textField.getText()+")";
				expressioncalc=textField.getText()+")";
				textField.setText(expressiondisplay);
			}
		});
		panel.add(button);
		
		JButton button_10 = new JButton("(");
		button_10.setBounds(165, 75, 70, 40);
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				expressiondisplay=textField.getText()+"(";
				expressioncalc=textField.getText()+"(";
				textField.setText(expressiondisplay);
			}
		});
		panel.add(button_10);
		
		final JButton btnAns = new JButton("Ans");
		btnAns.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAns.setBounds(95, 75, 70, 40);
		btnAns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				expressiondisplay=textField.getText()+btnAns.getText();
				expressioncalc=textField.getText()+btnAns.getText();
				textField.setText(expressiondisplay);
			}
		});
		panel.add(btnAns);
		
		
	}
}
