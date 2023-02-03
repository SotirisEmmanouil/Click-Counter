/** @author Sotiris Emmanouil
A simple app that counts the amount of times you click on the botton 
*/

package counter2;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

  public class GUI extends JFrame implements ActionListener{
    
	static JTextField textField;
	TextArea number;
	static TextArea time;
	public static long number1 = 0;
	JButton button, button2;
	static JButton button3;
	JLabel label,title,title2;
	static Timer timer;
	static int interval,counter;
	static String secs;


	/** The GUI setup */
	 
         GUI(){
    	
		label = new JLabel();
	        label.setBounds(150, 250, 100, 100);
		label.setVisible(false);
		
		title = new JLabel("Time Left:");
		title.setBounds(50, 25, 100, 30); 
		title.setLayout(null);
		
		title2 = new JLabel("Enter secs:");
		title2.setBounds(162, 30, 75, 20); 
		title2.setLayout(null);
		
		
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
		
		button3 = new JButton();
		button3.setBounds(260, 35, 100, 50); 
		button3.addActionListener(this);
		button3.setText("Enter");
		button3.setFocusable(false);
		button3.setHorizontalTextPosition(JButton.CENTER);
		button3.setVerticalTextPosition(JButton.BOTTOM);
		button3.setFont(new Font("Times New Roman",Font.PLAIN,15));
		button3.setIconTextGap(-15);
		button3.setForeground(Color.black);
		button3.setBackground(Color.lightGray);
		button3.setBorder(BorderFactory.createEtchedBorder());
		
		number = new TextArea("",0,0,TextArea.SCROLLBARS_NONE);
		number.setFont(new Font("Times New Roman",Font.PLAIN,25));
		number.setBounds(50, 100, 300, 50); 
		number.append(String.valueOf(number1));
		number.setEditable(false); 
		
		time = new TextArea("",0,0,TextArea.SCROLLBARS_NONE);
		time.setBackground(getBackground());
		time.setFont(new Font("Times New Roman",Font.PLAIN,15));
		time.setBounds(50, 50, 100, 30); 
		time.setEditable(false); 
		
		textField = new JTextField();
		textField.setBounds(160, 50, 75, 20); 
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,300);
		this.setTitle("Click Counter");
		this.add(button);
		this.add(button2);
		this.add(button3);
		this.add(number);	
		this.add(time);
		this.add(title);
		this.add(title2);
		this.add(textField);
		this.setVisible(true);
    }

    
    /**
     * @param e The event occurring. In this case, one of the two buttons being clicked on.
     */
 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		  if (e.getSource()==button) {
			  
			  if(counter==1) {
				  time();
				 counter = 0;
			  }
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
		     if (e.getSource()==button3) {
			if(!(textField.getText().equals(""))) {
			    counter+=1;
			    button3.setEnabled(false);
			   textField.setEditable(false);
			    }
			}
		   }
		
 /** No parameter method which sets up the time and speed of count down and displays it onto the GUI */
  
  public void time() {
	
    time.setText(null);
    button3.setEnabled(false);
    secs = textField.getText();
    int delay = 1000;
    int period = 1000;
    timer = new Timer();
    interval = Integer.parseInt(secs);
    time.append(secs);
    timer.scheduleAtFixedRate(new TimerTask() {
    
        public void run() {
        	time.setText(null);
            time.append(String.valueOf(setInterval()));
            
        }
    }, delay, period);
	}

	/**
	 * Method which actually subtracts the seconds down to 1
	 * @return seconds counting down 
	 */
  private static final int setInterval() {
     if (interval == 0) {
        timer.cancel();	
     	JOptionPane.showMessageDialog(null,"You clicked the button "+ number1 + " times in "+ secs + " seconds!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
      	button3.setEnabled(true);
      	textField.setEditable(true);
	    }
       		return --interval;
	}
}
