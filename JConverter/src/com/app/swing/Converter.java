package com.app.swing;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Converter {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Converter window = new Converter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Converter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 30));
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		JLabel lblConverter = new JLabel("CONVERTER");
		lblConverter.setFont(new Font("Tahoma", Font.BOLD, 31));
		lblConverter.setBounds(109, 11, 200, 46);
		frame.getContentPane().add(lblConverter);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mass", "Number", "Temperature", "Speed", "Angle", "Length", "Volume", "Area", "Energy", "Time", "Pressure"}));
		comboBox.setBounds(109, 58, 200, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuantity.setBounds(10, 61, 79, 20);
		frame.getContentPane().add(lblQuantity);
		
		JLabel lblSelectUnit = new JLabel("Select Unit1");
		lblSelectUnit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSelectUnit.setBounds(10, 92, 98, 20);
		frame.getContentPane().add(lblSelectUnit);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Kilogram", "grams", "milligram", "micrograms", "tonne", "metric ton", "pound", "carat"}));
		comboBox_1.setBounds(109, 92, 200, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblEnterValue = new JLabel("Enter Value");
		lblEnterValue.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterValue.setBounds(10, 123, 98, 20);
		frame.getContentPane().add(lblEnterValue);
		Float value = new Float(0.00);
		Float step = new Float(0.05);
		SpinnerNumberModel model = new SpinnerNumberModel(value, null, null, step);
		
		JLabel lblConvertTo = new JLabel("Convert To");
		lblConvertTo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConvertTo.setBounds(157, 156, 98, 20);
		frame.getContentPane().add(lblConvertTo);
		
		JLabel lblSelectUnit_1 = new JLabel("Select Unit2");
		lblSelectUnit_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSelectUnit_1.setBounds(10, 173, 104, 29);
		frame.getContentPane().add(lblSelectUnit_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Kilogram", "grams", "milligrams", "microgram", "tonne", "metric ton", "pound", "carat"}));
		comboBox_2.setBounds(111, 179, 198, 20);
		frame.getContentPane().add(comboBox_2);
		
		
		JButton btnGo = new JButton("GO");
		btnGo.setToolTipText("Click to see Action");
		btnGo.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGo.setBounds(141, 205, 120, 29);
		frame.getContentPane().add(btnGo);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOutput.setBounds(10, 237, 89, 29);
		frame.getContentPane().add(lblOutput);
		
		JLabel lblAbc = new JLabel("");
		lblAbc.setBounds(89, 245, 285, 106);
		frame.getContentPane().add(lblAbc);
		
		textField = new JTextField("0");
		textField.setBounds(109, 125, 200, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Select unit1 and unit2 from the combox and click go button to see output.");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ENV-08\\Desktop\\Capture1 (4).png"));
		btnNewButton.setBounds(10, 11, 65, 46);
		frame.getContentPane().add(btnNewButton);
		    btnNewButton.addActionListener(new ActionListener() {
		    	
				public void actionPerformed(ActionEvent arg0) {
		    		//frame.setVisible(false);
					JFrame frame1 = new JFrame("Help Window");
		    		frame1.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 30));
		    		frame1.setBounds(100, 100, 400, 400);
		    		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    		frame1.getContentPane().setLayout(null);
		    		frame1.setVisible(true);
		    		System.out.println("help window going to appear");
		    	}
		    });
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			    Connection conn = null;
			    ResultSet rs = null;
			    Statement stmt = null;
				try {
			    	String url ="jdbc:mysql://localhost:3306/Project";
			    	String user = "root";
			    	String password = "";
			    	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			    	conn = DriverManager.getConnection(url,user,password);
			    	System.out.println("Connection Established for Event ");
			    	String table_name = comboBox.getSelectedItem().toString();
			    	System.out.println(table_name);
			    	if(table_name!="Number"&&table_name!="Temperature") {
			    	stmt = conn.createStatement();
			    	stmt.execute("Select "+ table_name+" from "+table_name);
			    	rs = stmt.getResultSet();
			    	String[] a = new String[15];//take care of null values
			    	int size=0;
			    	while(rs.next()) {
			    		a[size++]=rs.getString(table_name);
			    		System.out.println(a[size-1]);
			    	}
			    	comboBox_1.setModel(new DefaultComboBoxModel(a));
			    	comboBox_2.setModel(new DefaultComboBoxModel(a));
			    	conn.close();
			    	lblAbc.setText("");
			    	}
			    	else if(table_name=="Temperature") {
			    	 String[] a = {"Celsius","Farenhite","Kelvin"};
			    	 comboBox_1.setModel(new DefaultComboBoxModel(a));
			    	 comboBox_2.setModel(new DefaultComboBoxModel(a));
			    	 lblAbc.setText("");
			    	}
			    	else {
			    		 String[] a = {"Binary","Octal","Hexadecimal","Decimal"};
				    	 comboBox_1.setModel(new DefaultComboBoxModel(a));
				    	 comboBox_2.setModel(new DefaultComboBoxModel(a));
				    	 lblAbc.setText("");
			    	}
			    	System.out.println("Connection terminated successfully");
			      }
			      catch(Exception e) {
			    	  System.out.println(e.getMessage());
			      }
				
			}
			
		});
		
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double value = 0.0;
				try {
					 value = Double.parseDouble(textField.getText());
				}
				catch(Exception e) {
					
				}
				String val = textField.getText();
				String table_name = comboBox.getSelectedItem().toString();
				System.out.println(table_name);
				if(table_name!="Number"&&table_name!="Temperature") {
				String unit1 = comboBox_1.getSelectedItem().toString();
				String unit2 = comboBox_2.getSelectedItem().toString();
				Statement stmt = null;
				ResultSet rs = null;
				Connection conn = null;
				try {
					
					String username = "root";
					String password ="";
					String url ="jdbc:mysql://localhost:3306/Project";
					Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					conn = DriverManager.getConnection(url,username,password);
					System.out.println("Connection Established");
					stmt= conn.createStatement();
					unit1="\'"+unit1+"\'";//so that becomes 'kilogram' and not kilogram
					stmt.execute("Select "+table_name+", Value from "+table_name+" where "+table_name+"  =  "+unit1);
					rs = stmt.getResultSet();
					String a = null;
					String b = null;
			        Double value1 = null;
			        Double value2 = null;
					while(rs.next()) {
						 a = rs.getString(table_name);
						 value1 = rs.getDouble("Value");
						System.out.println(a+" "+value1);
					}
					unit2="\'"+unit2+"\'";//so that becomes 'kilogram' and not kilogram
					stmt.execute("Select "+table_name+", Value from "+table_name+" where "+table_name+"  =  "+unit2);
					rs = stmt.getResultSet();
					while(rs.next()) {
						 b = rs.getString(table_name);
						value2 = rs.getDouble("Value");
						System.out.println(b+" "+value2);
					}
					System.out.print(value);
					
					//value = value*(value1/value2);
				    lblAbc.setText(value+" "+unit1.substring(1,unit1.length()-1)+" = "+(value*(value1/value2))+" "+unit2.substring(1,unit2.length()-1));
				    conn.close();
				    System.out.println("Connection Terminated Again");
				}
				catch(Exception e) {
					System.out.println("Problem : "+e.getMessage());
				}
				}
				else if(table_name=="Temperature") {
					String unit1 = comboBox_1.getSelectedItem().toString();
					String unit2 = comboBox_2.getSelectedItem().toString();
					Double value_1 = Double.parseDouble(textField.getText());
					Double u_val=new Double(value_1);
					if(unit1=="Celsius") {
						value_1=value_1;
					}
					else if(unit1=="Farenhite") {
						value_1=((value_1-32)*5.0/9.0);
					}
					else if(unit1=="Kelvin") {
						value_1-=273.15;
					}
					if(unit2=="Celsius") {
						lblAbc.setText(u_val+" "+unit1+" = "+value+" "+unit2);
					}
					else if(unit2=="Farenhite") {
						lblAbc.setText(u_val+" "+unit1+" = "+((value_1*9.0/5.0)+32)+" "+unit2);
					}
					else {
						lblAbc.setText(u_val+" "+unit1+" = "+(value_1+273.15)+" "+unit2);
					}
				}
				else {
					String unit1 = comboBox_1.getSelectedItem().toString();
					String unit2 = comboBox_2.getSelectedItem().toString();
					if(unit1=="Decimal"&&unit2=="Decimal") {
						value=value;
						lblAbc.setText(""+value);
					}
					else if(unit1=="Decimal"&&unit2=="Binary") {
						System.out.println(value);
						Integer num = (int)value;
						
						lblAbc.setText(""+convert_d_bin(num));
					}
					else if(unit1=="Decimal"&&unit2=="Octal") {
						int num = (int)value;
						lblAbc.setText(convert_d_oct(num)+"");
					}
					else if(unit1=="Decimal"&&unit2=="Hexadecimal") {
						int num = (int)value;
						lblAbc.setText(convert_d_hex(num));
					}
					else if(unit1=="Binary"&&unit2=="Decimal") {
						int flag=0;
						for(int i=0;i<val.length();i++) {
							if(val.charAt(i)>49) {
								lblAbc.setText("Enter the value according to the radix.\n Here radix is 2");
								flag=1;
								break;
								
							}
								
						}
						if(flag==0) {
						   int num = (int)value;
						   lblAbc.setText(convert_bin_d(num)+"");
						}
						
					}
					else if(unit1=="Binary"&&unit2=="Binary") {
						int flag=0;
						for(int i=0;i<val.length();i++) {
							if(val.charAt(i)>49) {
								lblAbc.setText("Enter the value according to the radix(2)");
								flag=1;
								break;
								
							}
								
						}
						if(flag==0) {
						  
						   lblAbc.setText(val);
						}
						
					}
					else if(unit1=="Binary"&&unit2=="Octal") {
						int flag=0;
						for(int i=0;i<val.length();i++) {
							if(val.charAt(i)>49) {
								lblAbc.setText("Enter the value according to the radix(2)");
								flag=1;
								break;
								
							}
								
						}
						if(flag==0) {
						   int num = (int)value;
						   //convert into decimal
						   num = convert_bin_d(num);
						   lblAbc.setText(convert_d_oct(num)+"");
						}
						
					}
					else if(unit1=="Binary"&&unit2=="Hexadecimal") {
						int flag=0;
						for(int i=0;i<val.length();i++) {
							if(val.charAt(i)>49) {
								lblAbc.setText("Enter the value according to the radix(2)");
								flag=1;
								break;
								
							}
								
						}
						if(flag==0) {
						   int num = (int)value;
						   num = convert_bin_d(num);
						   lblAbc.setText(convert_d_hex(num)+"");
						}
						
					}
					else if(unit1=="Octal"&&unit2=="Decimal") {
						int flag=0;
						for(int i=0;i<val.length();i++) {
							if(val.charAt(i)>=56) {
								lblAbc.setText("Enter the value according to the radix(8)");
								flag=1;
								break;
								
							}
								
						}
						if(flag==0) {
						   int num = (int)value;
						   lblAbc.setText(convert_oct_d(num)+"");
						}
						
					}
					else if(unit1=="Octal"&&unit2=="Binary") {
						int flag=0;
						for(int i=0;i<val.length();i++) {
							if(val.charAt(i)>=56) {
								lblAbc.setText("Enter the value according to the radix(8)");
								flag=1;
								break;
								
							}
								
						}
						if(flag==0) {
						   int num = (int)value;
					        //convert it into decimal 
						   num=convert_oct_d(num);
						   //decimal to binary
						   lblAbc.setText(convert_d_bin(num)+"");
						   
						}
						
					}
					else if(unit1=="Octal"&&unit2=="Octal") {
						int flag=0;
						for(int i=0;i<val.length();i++) {
							if(val.charAt(i)>=56) {
								lblAbc.setText("Enter the value according to the radix(8)");
								flag=1;
								break;
								
							}
								
						}
						if(flag==0) {
						  
						   lblAbc.setText(val);
						   
						}
						
						
					}
					else if(unit1=="Octal"&&unit2=="Hexadecimal") {
						
						int flag=0;
						for(int i=0;i<val.length();i++) {
							if(val.charAt(i)>=56) {
								lblAbc.setText("Enter the value according to the radix(8)");
								flag=1;
								break;
								
							}
								
						}
						if(flag==0) {
							int num = (int)value;
					        //convert it into decimal 
						   num=convert_oct_d(num);
						    //convert dec into hexa
						   lblAbc.setText(convert_d_hex(num));
						   
						}
						
						
					}
					else if(unit1=="Hexadecimal"&&unit2=="Decimal") {
					     int flag=0;
					     System.out.println(val);
					     for(int i=0;i<val.length();i++) {
					    	 
					    	 if(!(val.charAt(i)>=48&&val.charAt(i)<=70)) {
					    		 flag=1;
					    		 lblAbc.setText("Enter the value according to the radix(16)");
					    		 break;
					    	   }
					    	 
					    	 else
					    	 {
					    		 
					    	 }
					     }
					     if(flag==0) {
				    		 lblAbc.setText(convert_hex_d(val)+"");
					     }
					}
                    else if(unit1=="Hexadecimal"&&unit2=="Binary") {
                    	int flag=0;
					     for(int i=0;i<val.length();i++) {
					    	 if(val.charAt(i)!=46) {
					    	 if(!(val.charAt(i)>=48&&val.charAt(i)<=70)) {
					    		 flag=1;
					    		 lblAbc.setText("Enter the value according to the radix(16)");
					    		 break;
					    	 }
					    	 }
					    	 else
					    	 {
					    		 
					    	 }
					     }
					     if(flag==0) {
				    		 int num = convert_hex_d(val);
				    		 lblAbc.setText(convert_d_bin(num)+"");
					     }
					}
                    else if(unit1=="Hexadecimal"&&unit2=="Octal") {
                    	int flag=0;
                    	for(int i=0;i<val.length();i++) {
					    	 if(val.charAt(i)!=46) {
					    	 if(!(val.charAt(i)>=48&&val.charAt(i)<=70)) {
					    		 flag=1;
					    		 lblAbc.setText("Enter the value according to the radix(16)");
					    		 break;
					    	 }
					    	 }
					    	 else
					    	 {
					    		 
					    	 }
					     }
					     if(flag==0) {
				    		 int num = convert_hex_d(val);
				    		 lblAbc.setText(convert_d_oct(num)+"");
					     }  		
					}
                    else if(unit1=="Hexadecimal"&&unit2=="Hexadecimal") {
                    	int flag=0;
                    	for(int i=0;i<val.length();i++) {
					    	 if(val.charAt(i)!=46) {
					    	 if(!(val.charAt(i)>=48&&val.charAt(i)<=70)) {
					    		 flag=1;
					    		 lblAbc.setText("Enter the value according to the radix(16)");
					    		 break;
					    	    }
					    	 }
					    	 else
					    	 {    System.out.println(val);
					    		 break;
					    	 }
					     }
					     if(flag==0) {
				    		 
				    		 lblAbc.setText(val);
					     } 
					}
					
				}
			}
           private int convert_oct_d(int n) {
				// TODO Auto-generated method stub
        	   if(n>=1) {
					return convert_oct_d(n/10)*8+n%10;
				}
				else
					return 0;
			}
		private int convert_bin_d(int n) {
				// TODO Auto-generated method stub
        	   if(n>=1) {
					return convert_bin_d(n/10)*2+n%10;
				}
				else
					return 0;
			}
		private int convert_d_bin(Integer n) {
				// TODO Auto-generated method stub
				if(n>=1) {
					return convert_d_bin(n/2)*10+n%2;
				}
				else
					return 0;
			}
			private int convert_d_oct(Integer n) {
				// TODO Auto-generated method stub
				if(n>=1) {
					return convert_d_oct(n/8)*10+n%8;
				}
				else
					return 0;
			}
			private String convert_d_hex(Integer n) {
				String str = new String("");
				while(n>=1) {
					if(n%16<=9) {
						str=n%16+str;
					}
					else {
						str=(char)(55+n%16)+str;
					}
					n/=16;
				}
				return str;
			}
			private int convert_hex_d(String str) {
				int num=0;
				int i=0;
				while(i<str.length()) {
					if(str.charAt(i)>=65) {
						num = num*16+((int)str.charAt(i)-55);
					  
					}
					else {
						num=num*16+((int)str.charAt(i)-48);
					}
					System.out.println(num);
					i++;
				}
				return num;
			}
		});
		
	}
}