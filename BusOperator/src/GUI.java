import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class GUI extends JFrame{
	
	private JButton btnAddBus, btnAddTicket, btnRemTicket, btnExTicket, btnShowPassengers;
	
	
	public GUI() {
		
		getContentPane().setLayout(null);
		
		JLabel lblBusOperator = new JLabel("Bus Operator");
		lblBusOperator.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBusOperator.setForeground(Color.BLACK);
		lblBusOperator.setBounds(176, 11, 122, 25);
		getContentPane().add(lblBusOperator);
		
		
		
		
		
	}
}
