import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class AddBus extends JFrame implements ActionListener {
	private JTextField txtPlateNo;
	private JTextField txtDepStation;
	private JTextField txtDepCity;
	private JTextField txtArrStation;
	private JTextField txtArrCity;
	private JFormattedTextField txtSeatCap, txtBagCap;
	
	public AddBus(Operator o) {
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
		intFormatter.setValueClass(int.class);
		intFormatter.setAllowsInvalid(false);
		intFormatter.setMinimum(0);
		
		txtSeatCap = new JFormattedTextField(intFormatter);
		txtSeatCap.setBounds(87, 93, 35, 20);
		getContentPane().add(txtSeatCap);
		
		
		JLabel lblBaggageWeightCapacityper = new JLabel("Baggage Weight Capacity(per passenger):");
		lblBaggageWeightCapacityper.setBounds(10, 108, 215, 35);
		getContentPane().add(lblBaggageWeightCapacityper);
		
		NumberFormat doubleFormat = NumberFormat.getCurrencyInstance();
		NumberFormatter doubleFormatter = new NumberFormatter(doubleFormat);
		doubleFormatter.setValueClass(double.class);
		doubleFormatter.setAllowsInvalid(false);
		doubleFormatter.setMinimum(0.0);
		
		
		txtBagCap = new JFormattedTextField(doubleFormat);
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
				String plateNo = txtPlateNo.getText();
				int seatCap = (int)txtSeatCap.getValue();
				double bagCap = (double)txtBagCap.getValue();
				String depStation = txtDepStation.getText();
				String depCity = txtDepCity.getText();
				String arrStation = txtArrStation.getText();
				String arrCity = txtArrCity.getText();
				String depHour = (String)cBoxDepHour.getSelectedItem();
				String depMin = (String)cBoxDepMin.getSelectedItem();
				String arrHour = (String)cBoxArrHour.getSelectedItem();
				String arrMin = (String)cBoxArrMin.getSelectedItem();
				
				o.addBus(plateNo, depHour, depMin, arrHour, arrMin, depStation, depCity, arrStation, arrCity, seatCap, bagCap);
				
				
			}
		});
		btnAddBus.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddBus.setBounds(170, 349, 89, 23);
		getContentPane().add(btnAddBus);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
