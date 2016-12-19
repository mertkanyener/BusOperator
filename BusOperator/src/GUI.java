import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener{
	
	private Operator o = new Operator();
	private JLabel lblBusOperator;
	private JButton btnAddBus, btnAddTicket, btnExchangeTicket, btnWithdrawTicket, btnEditBaggage;
	
	
	
	public GUI() {
		
		getContentPane().setLayout(null);
		
		lblBusOperator = new JLabel("Bus Operator");
		lblBusOperator.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBusOperator.setForeground(Color.BLACK);
		lblBusOperator.setBounds(176, 11, 122, 25);
		getContentPane().add(lblBusOperator);
		
		btnAddBus = new JButton("Add Bus");
		btnAddBus.setBounds(35, 86, 89, 23);
		getContentPane().add(btnAddBus);
		
		btnAddTicket = new JButton("Add Ticket");
		btnAddTicket.setBounds(35, 239, 89, 23);
		getContentPane().add(btnAddTicket);
		
		btnExchangeTicket = new JButton("Exchange Ticket");
		btnExchangeTicket.setBounds(154, 239, 111, 23);
		getContentPane().add(btnExchangeTicket);
		
		btnWithdrawTicket = new JButton("Withdraw Ticket");
		btnWithdrawTicket.setBounds(285, 239, 122, 23);
		getContentPane().add(btnWithdrawTicket);
		
		btnEditBaggage = new JButton("Edit Baggage");
		btnEditBaggage.setBounds(35, 186, 111, 23);
		getContentPane().add(btnEditBaggage);
	
		
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAddBus)){
			
		}
		
	}



	public Operator getO() {
		return o;
	}



	public void setO(Operator o) {
		this.o = o;
	}
}
