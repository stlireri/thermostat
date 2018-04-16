package thermostat;


	
	import java.awt.*;
	import javax.swing.event.*;
	import javax.swing.*;
	import java.text.DecimalFormat;

	public class thermometer extends JFrame
	{
	private JLabel label1, label2; //Display labels
	private JTextField fahrenheitTemp, centigradeTemp;
	private JPanel fpanel, cpanel, sliderPanel;
	private JSlider slider; //Temperature adjuster
	private Container contentPane; //Content pane
	/**
	*Constructor
	*/
	public thermometer()
	{
	//Set the title
	setTitle("Thermostat");

	//Specify what happens when the
	//close button is clicked.
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//Create the labels.
	label1 = new JLabel("Fahrenheit: ");
	label2 = new JLabel("Centigrade: ");

	//Create the read-only text fields.
	fahrenheitTemp = new JTextField("23.0", 5);
	fahrenheitTemp.setEditable(false);
	centigradeTemp = new JTextField("23.0", 5);
	centigradeTemp.setEditable(false);

	//Create the slider
	slider = new JSlider(JSlider.VERTICAL,-50,50,23);
	slider.setMajorTickSpacing(10);
	slider.setMinorTickSpacing(5);
	slider.setPaintTicks(true);
	slider.setPaintLabels(true);
	slider.addChangeListener(new SliderListener());

	//Create panels and place the components in them.
	fpanel = new JPanel();
	fpanel.add(label1);
	fpanel.add(fahrenheitTemp);
	cpanel = new JPanel();
	cpanel.add(label2);
	cpanel.add(centigradeTemp);
	sliderPanel = new JPanel();
	sliderPanel.add(slider);

	//Get the content pane.
	contentPane = getContentPane();
	contentPane.setLayout(new GridLayout(3,1));
	contentPane.add(fpanel);
	//contentPane.add(cpanel);
	contentPane.add(sliderPanel);

	//Pack and display the frame.
	pack();
	setVisible(true);
	}
	/**
	*Private inner clas to handle the change events
	*that are generated when the slider is moved.
	*/
	private class SliderListener implements ChangeListener
	{
	public void stateChanged(ChangeEvent e)
	{
	double fahrenheit, centigrade;
	DecimalFormat fmt = new DecimalFormat("0.0");

	//Get the slider value
	centigrade = slider.getValue();

	//Convert the value to Fahrenheit.
	//fahrenheit = (9.0 / 5.0) * centigrade + 32.0;
	fahrenheit = slider.getValue();

	//Store the centigrade temp in its display field.
	centigradeTemp.setText(Double.toString(centigrade));

	//Store the Fahrenheit temp in its display field.
	fahrenheitTemp.setText(fmt.format(fahrenheit));
	}
	}

	/**
	*This program creaates an instance of the thermometer
	*class, which displays a window with a slider.
	*/

	public static void main(String[] args)
	{
	// TODO, add your application code
	thermometer tc = new thermometer();
	System.out.println("Thermostat Program.");
	}
	}


