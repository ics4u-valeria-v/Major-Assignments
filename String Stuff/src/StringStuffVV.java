import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.io.File;
import java.io.PrintWriter;
import static java.lang.System.*;
import javax.swing.JTextField;

public class StringStuffVV {

	//declare global variables and constant
	JButton btnMaxrun;
	JButton btnBlowup;
	JLabel lblResult;
	JLabel lblInstruction;
	JButton btnCheck;
	JLabel lblAnswOne;
	
	
	//MAXRUN
	char mainLetter = 'a';
	char displayLetter = 'a';
	int maxRun = 1;
	int currentRun = 1;
	
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StringStuffVV window = new StringStuffVV();
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
	public StringStuffVV() {
		initialize();
	}

	/**
	 * MaxRun Function
	 * Input: String str
	 * Output: string
	 * This function returns the length of the largest run in the string
	 */
	
	public int maxRun(String str)
	{
		//break the string into characters and add them to an array
		char[] characterArray=str.toCharArray(); 
		//loop through the array
		for(int counter=0;counter<characterArray.length;counter++){
			//get the element at the position
			char lowerChar = Character.toLowerCase(characterArray[counter]);
				//check if the character is the same as main character
				if (lowerChar == mainLetter)
				{
					//increment the max run
					currentRun++;
					if (currentRun > maxRun)
					{
						displayLetter = mainLetter;
						System.out.println(displayLetter);
						maxRun =currentRun;
						
					}
				}
				else
				{
					//set the main character to be equal to lowerChar
					mainLetter = lowerChar;
					//set the max run to be equal to 0
					currentRun = 1;
				}
			}  
		//return the number of maximum runs
		return maxRun;
	}
	
	/**
	 * Blowup Function
	 * Input: String str
	 * Output: string
	 * This function for each digit 0-9 that appears in the original string is replaced by that many occurrences of the character to the right of the digit.
	 */
	
	public String Blowup(String str)
	{
		//break the string into characters and add them to an array
		char[] characArray=str.toCharArray(); 
		//check what's the length of the string
		if (characArray.length > 9) {
			
		}
		
		String result = "";
		//return the resultant string
		return result;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 165, 0));
		frame.setBounds(100, 100, 496, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblInstruction = new JLabel("Pick a function:");
		lblInstruction.setForeground(new Color(255, 255, 255));
		lblInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstruction.setFont(new Font("Cooper Std Black", Font.PLAIN, 23));
		lblInstruction.setBackground(new Color(255, 165, 0));
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		//hide the text field
		textField.setVisible(false);
		textField.setFont(new Font("Cooper Std Black", Font.PLAIN, 16));
		textField.setColumns(10);
		
		btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userStr = textField.getText();
				String resultStr = Blowup(userStr);
				
			}
		});
		//hide the button
		btnCheck.setVisible(false);
		//hide the check button
		btnCheck.setForeground(Color.WHITE);
		btnCheck.setFont(new Font("Cooper Std Black", Font.PLAIN, 16));
		btnCheck.setBackground(new Color(139, 0, 0));
		
		lblResult = new JLabel("Answer");
		//hide the label
		lblResult.setVisible(false);
		lblResult.setFont(new Font("Cooper Std Black", Font.PLAIN, 16));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnBlowup = new JButton("Blowup\r\n");
		btnBlowup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Hide the buttons and instructions
				btnBlowup.setVisible(false);
				btnMaxrun.setVisible(false);
				lblInstruction.setVisible(false);
				//display the text field, instructions and check button
				textField.setVisible(true);
				btnCheck.setVisible(true);
				lblAnswOne.setVisible(true);
				lblAnswOne.setText("Enter astring that has 9 characters");
			}
		});
		btnBlowup.setForeground(new Color(139, 0, 0));
		btnBlowup.setFont(new Font("Cooper Std Black", Font.PLAIN, 16));
		btnBlowup.setBackground(new Color(255, 255, 255));
		
		lblAnswOne = new JLabel("New label");
		//set the label to be invisible
		lblAnswOne.setVisible(false);
		lblAnswOne.setForeground(new Color(139, 0, 0));
		lblAnswOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswOne.setFont(new Font("Cooper Std Black", Font.PLAIN, 20));
		
		btnMaxrun = new JButton("MaxRun");
		btnMaxrun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//hide the buttons and instructions
				btnMaxrun.setVisible(false);
				btnBlowup.setVisible(false);
				lblInstruction.setVisible(false);
				//read the file from the bin
				try
				{
					FileReader fileR = new FileReader("MaxRun.txt");
					BufferedReader bufferedR = new BufferedReader(fileR);
					//declare local variables
					String exampleStr;
					
					//loop through the file
					while ((exampleStr = bufferedR.readLine()) != null)
					{
						//call the maxRun function
						int result = maxRun(exampleStr);
						
						//create a file that displays the result
						File resultFile = new File("result.txt");
						try (PrintWriter pw = new PrintWriter(resultFile))
				        {
							//print the results
				            pw.print(""+result+ ", " + displayLetter + "\n");
				            pw.close();
				          //set the label to be invisible
				    		lblAnswOne.setVisible(true);
				            lblAnswOne.setText("Output file is in the project folder");
				            
				        }
						//if the file is not created display an error message to the console
				        catch (FileNotFoundException e1)
				        {
				            System.out.println("File not found");
				        }
						
					}
					
				}
				catch(IOException e1)
				{
					 System.out.println("Couldn't find the file");
				}
			}

		});
		btnMaxrun.setForeground(new Color(139, 0, 0));
		btnMaxrun.setFont(new Font("Cooper Std Black", Font.PLAIN, 16));
		btnMaxrun.setBackground(Color.WHITE);
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(109, Short.MAX_VALUE)
					.addComponent(lblInstruction, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addGap(107))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(87)
					.addComponent(btnBlowup, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addComponent(btnMaxrun, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(86))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(147)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(165, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(167)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblResult, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCheck, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
					.addContainerGap(187, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblAnswOne, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInstruction, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBlowup, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMaxrun, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(84)
					.addComponent(lblAnswOne, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCheck)
					.addGap(18)
					.addComponent(lblResult, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(60, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		
	}
}
