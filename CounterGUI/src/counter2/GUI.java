/** @author Sotiris Emmanouil
A simple applet that counts the amount of times you click on the botton 
*/

package counter2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUI extends JFrame implements ActionListener{
    
	TextArea number;
	public static long number1 = 0;
	JButton button, button2;
	JLabel label;
	
	/** The GUI setup */
	
    GUI(){
		label = new JLabel();
	    label.setBounds(150, 250, 150, 150);
		label.setVisible(false);
		
		button = new JButton();
		button.setBounds(400, 25, 100, 100); 
		button.addActionListener(this);
		button.setText("+");
		button.setFocusable(false);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setFont(new Font("Times New Roman",Font.PLAIN,25));
		button.setIconTextGap(-15);
		button.setForeground(Color.black);
		button.setBackground(Color.lightGray);
		button.setBorder(BorderFactory.createEtchedBorder());
		
		button2 = new JButton();
		button2.setBounds(400, 160, 100, 100); 
		button2.addActionListener(this);
		button2.setText("Reset");
		button2.setFocusable(false);
		button2.setHorizontalTextPosition(JButton.CENTER);
		button2.setVerticalTextPosition(JButton.BOTTOM);
		button2.setFont(new Font("Times New Roman",Font.PLAIN,25));
		button2.setIconTextGap(-15);
		button2.setForeground(Color.black);
		button2.setBackground(Color.lightGray);
		button2.setBorder(BorderFactory.createEtchedBorder());
		
		number = new TextArea(100,100);
		number.setFont(new Font("Times New Roman",Font.PLAIN,25));
		number.setBounds(50, 100, 300, 50); 
		number.append(String.valueOf(number1));
		number.setEditable(false); 
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,300);
		this.setTitle("Counter");
		this.add(button);
		this.add(button2);
		this.add(label);
		this.add(number);	
		this.setVisible(true);
		}

    
    /**
     * @param e The event occurring. In this case, one of the two buttons being clicked on.
     */
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==button) {
			number.setText(null);
			  number1 += 1;
			number.append(String.valueOf(number1));
			button.setEnabled(true);
			label.setVisible(true);
		}
		   if (e.getSource()==button2) {
			   number.setText(null);
			   number1 = 0;
			   number.append(String.valueOf(number1));
				button.setEnabled(true);
				label.setVisible(true);
			}
		}
	}