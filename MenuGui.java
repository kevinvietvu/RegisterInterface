import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class MenuGUI extends JFrame {
	MenuPresenter presenter;
	JTextArea currentOrder;
	JTextField totalCost;
	JTextField ccEntry;
	JLabel orderLabel;
	JLabel costLabel;
	ArrayList<MenuItem> items;
	double sum = 0;
	
	public MenuGUI(MenuPresenter presenter) throws FileNotFoundException {
		
		this.presenter = presenter;
		presenter.attachView(this);
		showGUI();

	}
	private void showGUI() throws FileNotFoundException {
		items = presenter.getMenuItems();

		JFrame theFrame = new JFrame("Menu");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setLayout(new BorderLayout());
		
		JPanel title = new JPanel(new FlowLayout());
		JLabel titleLabel = new JLabel("Welcome to McPatterns");
		title.add(titleLabel);
		
		JPanel orderPane = new JPanel();
		orderPane.setLayout(new GridLayout(4,1,10,10));
		JLabel cardDetails = new JLabel("Enter Your Credit Card Number Below");
		orderPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
		orderPane.add(cardDetails);
		ccEntry = new JTextField(19);


		JButton confirm = new JButton("Place Order");
		//confirm.setPreferredSize(new Dimension(100, 60));
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cardNumber = ccEntry.getText();
				if(!currentOrder.getText().isEmpty())
				{
					if (cardNumber.length() > 5)
					{
						CreditCard cardToCheck = new CreditCard(cardNumber);
						cardChecker cCheck = new cardChecker(cardToCheck);
						if (cCheck.validate() != null)	{	
							cardDetails.setText("Order confirmed for: " + cCheck.getCreditCardName());
							String[] lines = currentOrder.getText().split("\\n");
							System.out.println("Order confirmed for " + cCheck.getCreditCardName() + " : " + cardToCheck.cardNumber);
							for (int i = 0; i < lines.length; i++)
							{
								System.out.println(lines[i]);
							}	
						}
						else { 
							cardDetails.setText("Invalid Card Number: " + ccEntry.getText());
							ccEntry.setText("Enter Your Credit Card Number");
						}
				    }
					else {
						cardDetails.setText("Invalid Card Number: " + ccEntry.getText());
						ccEntry.setText("Enter Your Credit Card Number");
					}
				}
				else { 
					ccEntry.setText("Enter Your Credit Card Number");
					JOptionPane.showMessageDialog(theFrame, "Current Order is Empty");
				}
				
			}
		});
		
		JButton cancel = new JButton("Cancel Order");
		//cancel.setPreferredSize(new Dimension(100, 60));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sum = 0;
				ccEntry.setText("");
				currentOrder.setText("");
				totalCost.setText("");
				cardDetails.setText("Order cancelled");
			}
		});
		orderPane.add(ccEntry);
		orderPane.add(confirm);
		orderPane.add(cancel);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //adds gap between other panels and edge of frame
		GridLayout grid = new GridLayout(7,7,5,5);
		buttonPanel.setLayout(grid);
		buttonPanel.add(new JLabel("Menu Items"));
	
		for (MenuItem item : items )
		{
			String itemName = item.name();
			JButton itemButton = new JButton(itemName);
			buttonPanel.add(itemButton);
			itemButton.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					for (MenuItem s : items)
					{
						if (((JButton) e.getSource()).getText().equals(s.name()))
						{
							if (ccEntry.getText().equals("Enter Your Credit Card Number"))
							{
								ccEntry.setText("");
							}
							cardDetails.setText("Enter Credit Card Number Below");
							sum = sum + s.price();
							double cost = sum;
							String result = String.format("%.2f", cost);
							totalCost.setText(result);
							currentOrder.append(s.name() + "\n");
							break;
						}
					}
				}
			});
		}
		
		
		
		JPanel receiptPanel = new JPanel();
		receiptPanel.setLayout(new BoxLayout(receiptPanel, BoxLayout.PAGE_AXIS));
		receiptPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
		currentOrder = new JTextArea("",35,35);
		currentOrder.setEditable(false);
		totalCost = new JTextField(20);
		totalCost.setEditable(false);
		orderLabel = new JLabel("Current Order");
		orderLabel.setHorizontalAlignment(2);
		costLabel = new JLabel("Total Cost");
		JScrollPane scrollPane = new JScrollPane(currentOrder);
		
		receiptPanel.add(orderLabel);
		receiptPanel.add(scrollPane);
		receiptPanel.add(costLabel);
		receiptPanel.add(totalCost);
			
		theFrame.add(title,BorderLayout.NORTH);
		theFrame.add(buttonPanel, BorderLayout.WEST);
		theFrame.add(orderPane, BorderLayout.EAST);
		theFrame.add(receiptPanel,BorderLayout.CENTER);
		theFrame.setSize(800,800);
		
		//theFrame.setLocationRelativeTo(null); //Centers the menu
		theFrame.pack();
		theFrame.setVisible(true);
		
	}

	
}
