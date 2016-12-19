import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.NumberFormatter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

public class GUI extends JFrame{
	
	private Operator operator = new Operator();
	private Bus selectedBus;
	private JLabel lblBusOperator;
	private JButton btnAddBus, btnAddTicket, btnExchangeTicket, btnWithdrawTicket, btnShowBuses;
	private JButton btnShowTickets;
	private JLabel lblTicketOperations;
	private JLabel lblNewLabel_1;
	
	
	
	public GUI() {
		
		
		getContentPane().setLayout(null);
		
		
		
		lblBusOperator = new JLabel("Bus Operator");
		lblBusOperator.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBusOperator.setForeground(Color.BLACK);
		lblBusOperator.setBounds(176, 11, 122, 25);
		getContentPane().add(lblBusOperator);
		
		btnAddBus = new JButton("Add Bus");
		btnAddBus.setBounds(35, 102, 109, 23);
		getContentPane().add(btnAddBus);
		btnAddBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new AddBus();
			}
		});
		
		btnAddTicket = new JButton("Add Ticket");
		btnAddTicket.setBounds(35, 211, 99, 23);
		btnAddTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new AddTicket();
			}
		});
		getContentPane().add(btnAddTicket);
		
		btnExchangeTicket = new JButton("Exchange Ticket");
		btnExchangeTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ExchangeTicket();
			}
		});
		btnExchangeTicket.setBounds(176, 210, 137, 25);
		getContentPane().add(btnExchangeTicket);
		
		btnWithdrawTicket = new JButton("Withdraw Ticket");
		btnWithdrawTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = Integer.parseInt((String)JOptionPane.showInputDialog(
						null,
						"Please enter ticket number",
						"Remove Ticket",
						JOptionPane.INFORMATION_MESSAGE,
						null,
						null,
						null
						));
				
				if(operator.getTicket(n).equals(null)){
					JOptionPane.showMessageDialog(null, "Ticket can not be found.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}
				else{
					operator.removeTicket(n);
				}
				
			}
		});
		btnWithdrawTicket.setBounds(176, 259, 137, 23);
		getContentPane().add(btnWithdrawTicket);
		
		btnShowBuses = new JButton("Show Buses");
		btnShowBuses.setBounds(176, 102, 122, 23);
		btnShowBuses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new ShowBuses();
			}
		});
		getContentPane().add(btnShowBuses);
		
		btnShowTickets = new JButton("Show Tickets");
		btnShowTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShowTickets();
				
			}
		});
		btnShowTickets.setBounds(27, 259, 117, 23);
		getContentPane().add(btnShowTickets);
		
		lblTicketOperations = new JLabel("Ticket Operations");
		lblTicketOperations.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTicketOperations.setBounds(35, 165, 122, 25);
		getContentPane().add(lblTicketOperations);
		
		lblNewLabel_1 = new JLabel("Bus Operations");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(34, 49, 154, 25);
		getContentPane().add(lblNewLabel_1);
		
		int n = operator.getBusCounter();
		String[] str = new String[n];
		for(int i = 0; i < n; i++){
			str[i] = operator.getAllBuses()[i].getPlateNum();
		}
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Bus Operator");
		setSize(500,500);
		
	}
	
	public static void main(String[] args){
	
		new GUI();
	}
	
	
	
	private class ShowBuses extends JFrame{
		
		public ShowBuses(){
			
			
			
			String[] columnNames = {"Plate Number",
									  "Seats",
									  "Baggage cap.",
									  "Dep. Station",
									  "Dep. City",
									  "Arr. Station",
									  "Arr. City",
									  "Dep. Time",
									  "Arr. Time"
			};
			
			int n = operator.getBusCounter();
			
			Object[][] data = new Object[n][9];
			
			for(int i = 0; i < n; i++){
				

				Bus b = operator.getAllBuses()[i];
				Object[] arr = {b.getPlateNum(), b.getPassengers().length, b.getBaggageWeightCap(), b.getRoute().getDepStation(),
						b.getRoute().getDepCity(), b.getRoute().getArrStation(), b.getRoute().getArrCity(),
						b.getRoute().getSchedule().getDepTime(), b.getRoute().getSchedule().getArrTime()};
				data[i] = arr;
				
			}
			
			JTable table = new JTable(data, columnNames);
			JScrollPane scrollPane = new JScrollPane(table);
			table.setFillsViewportHeight(true);
		
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			setVisible(true);
			setTitle("All Buses");
			setSize(700, 700);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			
				 
			
		}
	}
	
	private class ShowTickets extends JFrame{
		
		public ShowTickets(){
			
			String[] columnNames = {"Ticket No",
									"Seat No",
									"First Name",
									"Last Name",
									"Gender",
									"Bus",
									"Baggage No",
									"Baggage Weight"
			};
			
			int n = operator.getTicketCounter();
			
			
			Object[][] data = new Object[n][8];
			
			for(int i = 0; i < n; i++){
				Ticket t = operator.getAllTickets()[i];
				Object[] arr = { t.getTicketNo(), t.getSeatNo(), t.getPassenger().getFirstName(), t.getPassenger().getLastName(),
						t.getPassenger().getGender(), t.getBus().getPlateNum(), t.getBaggage().getBaggageNo(), t.getBaggage().getWeight()
				};
				data[i] = arr;
			}
			
			JTable table = new JTable(data, columnNames);
			JScrollPane scrollPane = new JScrollPane(table);
			table.setFillsViewportHeight(true);
		
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			setVisible(true);
			setTitle("All Tickets");
			setSize(700, 700);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
	}
	
	

	private class AddBus extends JFrame  {
		private JTextField txtPlateNo;
		private JTextField txtDepStation;
		private JTextField txtDepCity;
		private JTextField txtArrStation;
		private JTextField txtArrCity;
		private JFormattedTextField txtSeatCap, txtBagCap;
		
		private String plateNo, depStation, depCity, arrStation, arrCity, depHour, depMin, arrHour, arrMin;
		private int seatCap, bagCap;
		
		
		public AddBus() {
			getContentPane().setLayout(null);
			
			
			
			
			
			
			JLabel lblAddANew = new JLabel("Add a new bus");
			lblAddANew.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblAddANew.setBounds(170, 11, 121, 35);
			getContentPane().add(lblAddANew);
			
			JLabel lblPlateNumber = new JLabel("Plate number:");
			lblPlateNumber.setBounds(10, 71, 67, 14);
			getContentPane().add(lblPlateNumber);
			
			txtPlateNo = new JTextField();
			txtPlateNo.setBounds(87, 68, 86, 20);
			getContentPane().add(txtPlateNo);
			txtPlateNo.setColumns(10);
			
			JLabel lblSeatCapacity = new JLabel("Seat Capacity:");
			lblSeatCapacity.setBounds(10, 96, 78, 14);
			getContentPane().add(lblSeatCapacity);
			
			NumberFormat intFormat = NumberFormat.getIntegerInstance();
			NumberFormatter intFormatter = new NumberFormatter(intFormat);
			intFormatter.setValueClass(Integer.class);
			intFormatter.setMinimum(0);
			intFormatter.setAllowsInvalid(false);
			
			txtSeatCap = new JFormattedTextField(intFormatter);
			txtSeatCap.setBounds(87, 93, 35, 20);
			getContentPane().add(txtSeatCap);
			
			
			JLabel lblBaggageWeightCapacityper = new JLabel("Baggage Weight Capacity(per passenger):");
			lblBaggageWeightCapacityper.setBounds(10, 108, 215, 35);
			getContentPane().add(lblBaggageWeightCapacityper);
			
			
			
			
			
			txtBagCap = new JFormattedTextField(intFormatter);
			txtBagCap.setBounds(220, 115, 53, 20);
			
			getContentPane().add(txtBagCap);
			
			JLabel lblRoute = new JLabel("Route:");
			lblRoute.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblRoute.setBounds(10, 154, 50, 20);
			getContentPane().add(lblRoute);
			
			JLabel lblDepartureStation = new JLabel("Departure Station:");
			lblDepartureStation.setBounds(10, 185, 90, 14);
			getContentPane().add(lblDepartureStation);
			
			txtDepStation = new JTextField();
			txtDepStation.setBounds(103, 182, 86, 20);
			getContentPane().add(txtDepStation);
			txtDepStation.setColumns(10);
			
			
			JLabel lblDepartureCity = new JLabel("Departure City:");
			lblDepartureCity.setBounds(213, 185, 78, 14);
			getContentPane().add(lblDepartureCity);
			
			txtDepCity = new JTextField();
			txtDepCity.setBounds(290, 182, 86, 20);
			getContentPane().add(txtDepCity);
			txtDepCity.setColumns(10);
			
			
			
			
			JLabel lblArrivalStation = new JLabel("Arrival Station:");
			lblArrivalStation.setBounds(10, 226, 90, 14);
			getContentPane().add(lblArrivalStation);
			
			txtArrStation = new JTextField();
			txtArrStation.setBounds(103, 223, 86, 20);
			getContentPane().add(txtArrStation);
			txtArrStation.setColumns(10);
			
		
			
			JLabel lblArrivalCity = new JLabel("Arrival City:");
			lblArrivalCity.setBounds(213, 226, 78, 14);
			getContentPane().add(lblArrivalCity);
			
			txtArrCity = new JTextField();
			txtArrCity.setBounds(290, 223, 86, 20);
			getContentPane().add(txtArrCity);
			txtArrCity.setColumns(10);
			
			
			JLabel lblSchedule = new JLabel("Schedule:");
			lblSchedule.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSchedule.setBounds(10, 267, 67, 14);
			getContentPane().add(lblSchedule);
			
			JLabel lblBusInfo = new JLabel("Bus Info:");
			lblBusInfo.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblBusInfo.setBounds(10, 46, 67, 14);
			getContentPane().add(lblBusInfo);
			
			JLabel lblDepartureHour = new JLabel("Departure time:");
			lblDepartureHour.setBounds(10, 292, 78, 14);
			getContentPane().add(lblDepartureHour);
			
			JComboBox cBoxDepHour = new JComboBox();
			cBoxDepHour.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
			cBoxDepHour.setBounds(103, 289, 43, 20);
			getContentPane().add(cBoxDepHour);
			
			JComboBox cBoxDepMin = new JComboBox();
			cBoxDepMin.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
			cBoxDepMin.setBounds(156, 289, 43, 20);
			getContentPane().add(cBoxDepMin);
			
			JLabel lblArrivalTime = new JLabel("Arrival Time:");
			lblArrivalTime.setBounds(213, 292, 60, 14);
			getContentPane().add(lblArrivalTime);
			
			JComboBox cBoxArrHour = new JComboBox();
			cBoxArrHour.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
			cBoxArrHour.setBounds(290, 289, 43, 20);
			getContentPane().add(cBoxArrHour);
			
			JComboBox cBoxArrMin = new JComboBox();
			cBoxArrMin.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
			cBoxArrMin.setBounds(343, 289, 43, 20);
			getContentPane().add(cBoxArrMin);
			
			
			JButton btnAddBus = new JButton("Add");
			btnAddBus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(txtPlateNo.getText().equals("") || txtSeatCap.getText().equals("") || txtDepStation.getText().equals("")
							|| txtDepCity.getText().equals("") || txtArrStation.getText().equals("") || txtArrCity.getText().equals("")
							|| txtBagCap.getText().equals("") ){
						JOptionPane.showMessageDialog(null, "There are null entries!",
								"Error",
								JOptionPane.ERROR_MESSAGE);
					}
					else{
						plateNo = txtPlateNo.getText();
						depHour = (String)cBoxDepHour.getSelectedItem();
						depMin = (String)cBoxDepMin.getSelectedItem();
						arrHour = (String)cBoxArrHour.getSelectedItem();
						arrMin = (String)cBoxArrMin.getSelectedItem();
						depStation = txtDepStation.getText();
						depCity = txtDepCity.getText();
						arrStation = txtArrStation.getText();
						arrCity = txtArrCity.getText();
						seatCap = (int)txtSeatCap.getValue();
						bagCap = (int)txtBagCap.getValue();
						
						operator.addBus(plateNo, depHour, depMin, arrHour, arrMin, depStation, depCity, arrStation, arrCity, seatCap, bagCap);
						JOptionPane.showMessageDialog(null, "Bus added successfully",
								"Success",
								JOptionPane.PLAIN_MESSAGE);	
					
						
					}
				
				
					
						
				
							
				}
			});
			btnAddBus.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnAddBus.setBounds(170, 349, 89, 23);
			getContentPane().add(btnAddBus);
			
			setVisible(true);
			setTitle("Add New Bus");
			setSize(500,500);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}

		
		
	}
	

	private class AddTicket extends JFrame implements PropertyChangeListener {
		private JTextField txtFirstName, txtLastName;
		private JFormattedTextField txtWeight;
		private double weight = 0.0;
		private NumberFormat doubleFormat;
		
		public AddTicket(){
			getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Add New Ticket");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(146, 11, 121, 14);
			getContentPane().add(lblNewLabel);
			
			JLabel lblChooseBus = new JLabel("Choose bus:");
			lblChooseBus.setBounds(144, 78, 66, 14);
			getContentPane().add(lblChooseBus);
			
			int n = operator.getBusCounter();
			String[] str = new String[n];
			for(int i = 0; i < n; i++){
				str[i] = operator.getAllBuses()[i].getPlateNum();
			}
			
			JComboBox cBoxBus = new JComboBox();
			cBoxBus.setModel(new DefaultComboBoxModel(str));
			cBoxBus.setBounds(220, 75, 76, 20);
			
			getContentPane().add(cBoxBus);
			
			
			NumberFormat intFormat = NumberFormat.getIntegerInstance();
			NumberFormatter intFormatter = new NumberFormatter(intFormat);
			intFormatter.setValueClass(Integer.class);
			intFormatter.setMinimum(0);
			intFormatter.setAllowsInvalid(false);
	
			
			JLabel lblSeatNo = new JLabel("Seat No:");
			lblSeatNo.setBounds(8, 78, 46, 14);
			getContentPane().add(lblSeatNo);
			
			
			JFormattedTextField txtSeatNo = new JFormattedTextField(intFormatter);
			txtSeatNo.setBounds(64, 75, 32, 20);
			getContentPane().add(txtSeatNo);
			
			JLabel lblPassengerName = new JLabel("First Name:");
			lblPassengerName.setBounds(10, 113, 55, 14);
			getContentPane().add(lblPassengerName);
			
			txtFirstName = new JTextField();
			txtFirstName.setBounds(68, 110, 86, 20);
			getContentPane().add(txtFirstName);
			txtFirstName.setColumns(10);
			
			JLabel lblPassengerLast = new JLabel("Last Name:");
			lblPassengerLast.setBounds(168, 113, 66, 14);
			getContentPane().add(lblPassengerLast);
			
			txtLastName = new JTextField();
			txtLastName.setBounds(225, 110, 86, 20);
			getContentPane().add(txtLastName);
			txtLastName.setColumns(10);
			
			JLabel lblGender = new JLabel("Gender:");
			lblGender.setBounds(320, 113, 46, 14);
			getContentPane().add(lblGender);
			
			JComboBox<Character> cBoxGender = new JComboBox();
			cBoxGender.setModel(new DefaultComboBoxModel(new Character[] {'M', 'F'}));
			cBoxGender.setBounds(365, 110, 40, 20);
			getContentPane().add(cBoxGender);
			
			JLabel lblBaggageWeight = new JLabel("Baggage Weight:");
			lblBaggageWeight.setBounds(10, 163, 86, 14);
			getContentPane().add(lblBaggageWeight);
			
			
			txtWeight = new JFormattedTextField(doubleFormat);
			txtWeight.setValue(new Double(weight));
			txtWeight.addPropertyChangeListener("value", this);
			txtWeight.setBounds(96, 160, 47, 20);
			getContentPane().add(txtWeight);
			
			JButton btnAdd = new JButton("Add New Ticket");
			btnAdd.setBounds(146, 212, 101, 23);
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					
					if(txtFirstName.getText().equals("") || txtLastName.getText().equals("") || txtWeight.getText().equals("")){
						JOptionPane.showMessageDialog(null, "There are null entries!",
								"Error",
								JOptionPane.ERROR_MESSAGE);
						
					}
					else{
					
						
						
						int seatNo = (int)txtSeatNo.getValue();
						String firstName = txtFirstName.getText();
						String lastName = txtLastName.getText();
						char gender = (char)cBoxGender.getSelectedItem();
						Bus bus = operator.findBus((String)cBoxBus.getSelectedItem());
	
						if(weight > bus.getBaggageWeightCap()){
							JOptionPane.showMessageDialog(null, "Baggage is too heavy!",
									"Error",
									JOptionPane.ERROR_MESSAGE);
						}
						else if(seatNo > bus.getPassengers().length || !operator.checkSeat(bus, seatNo)){
							JOptionPane.showMessageDialog(null, "Invalid seat number!",
									"Error",
									JOptionPane.ERROR_MESSAGE);
						}
						else{
							
						
							operator.addTicket(bus, seatNo, firstName, lastName, gender, weight);
							JOptionPane.showMessageDialog(null, "Ticket added successfully",
									"Success",
									JOptionPane.PLAIN_MESSAGE);
						}
					}
					
				}
			});
			getContentPane().add(btnAdd);
			setVisible(true);
			setSize(500,500);
			setTitle("Add a new ticket");
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
		}

		@Override
		public void propertyChange(PropertyChangeEvent arg0) {
			weight = ((Number)txtWeight.getValue()).doubleValue();
			
		}
		
		
	}
	
	
	public class ExchangeTicket extends JFrame{
		
		public ExchangeTicket(){
			
			getContentPane().setLayout(null);
			
			JLabel lblExchangeTickets = new JLabel("Exchange Tickets");
			lblExchangeTickets.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblExchangeTickets.setBounds(151, 11, 126, 20);
			getContentPane().add(lblExchangeTickets);
			
			JLabel lblTicketNo = new JLabel("Ticket No 1:");
			lblTicketNo.setBounds(10, 60, 70, 14);
			getContentPane().add(lblTicketNo);
			
			JLabel lblTicketNo_1 = new JLabel("Ticket No 2:");
			lblTicketNo_1.setBounds(202, 60, 75, 14);
			getContentPane().add(lblTicketNo_1);
			
			
			
			
			NumberFormat intFormat = NumberFormat.getIntegerInstance();
			NumberFormatter intFormatter = new NumberFormatter(intFormat);
			intFormatter.setValueClass(Integer.class);
			intFormatter.setMinimum(0);
			intFormatter.setAllowsInvalid(false);
			
			JFormattedTextField txtTicketOne = new JFormattedTextField(intFormatter);
			txtTicketOne.setBounds(90, 57, 70, 20);
			getContentPane().add(txtTicketOne);
			
			JFormattedTextField txtTicketTwo = new JFormattedTextField(intFormatter);
			txtTicketTwo.setBounds(276, 57, 70, 20);
			getContentPane().add(txtTicketTwo);
			
			
			JButton btnExchange = new JButton("Exchange");
			btnExchange.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(txtTicketOne.getText().equals("") || txtTicketTwo.getText().equals("")){
						JOptionPane.showMessageDialog(null, "There are null entries!",
								"Error",
								JOptionPane.ERROR_MESSAGE);
					}
					else{
						int t1 = (int)txtTicketOne.getValue();
						int t2 = (int)txtTicketTwo.getValue();
						
						if(operator.getTicket(t1).equals(null) || operator.getTicket(t2).equals(null)){
							JOptionPane.showMessageDialog(null, "You entered an invalid ticket number.",
									"Error",
									JOptionPane.ERROR_MESSAGE);
						}
						else if(operator.getTicket(t1).getBaggage().getWeight() > operator.getTicket(t2).getBus().getBaggageWeightCap()
								|| operator.getTicket(t2).getBaggage().getWeight() > operator.getTicket(t1).getBus().getBaggageWeightCap()){
							JOptionPane.showMessageDialog(null, "Baggage overload after exchange. Exchange incomplete.",
									"Error",
									JOptionPane.ERROR_MESSAGE);
						}
						else{
							operator.exchangeTicket(operator.getTicket(t1), operator.getTicket(t2));
							JOptionPane.showMessageDialog(null, "Tickets are exchanged successfully",
									"Success",
									JOptionPane.PLAIN_MESSAGE);	
						}
					}
					
					
				}
			});
			
			btnExchange.setBounds(151, 131, 89, 23);
			getContentPane().add(btnExchange);
			setVisible(true);
			setTitle("Exchange Tickets");
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
	}





	



	
}
