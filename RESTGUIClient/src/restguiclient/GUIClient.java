package restguiclient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.omg.CORBA.portable.InputStream;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GUIClient {
	
		
		private JTextField tfName;
		private JLabel lblMsg; 
	private JFrame frame;
	private JTextField TFrESTurl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIClient window = new GUIClient();
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
	public GUIClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rest URL");
		lblNewLabel.setBounds(10, 29, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		TFrESTurl = new JTextField();
		TFrESTurl.setBounds(104, 26, 227, 20);
		frame.getContentPane().add(TFrESTurl);
		TFrESTurl.setColumns(10);
		
		JButton btnGetDate = new JButton("Get Data");
		btnGetDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String RestURL = TFrESTurl.getText();
				try {
					URL url = new URL(RestURL);
					URLConnection urlConn = url.openConnection();
					InputStream inputStream = (InputStream) urlConn.getInputStream();
					BufferedReader in = new BufferedReader(new
					 InputStreamReader(inputStream));
					String line = in.readLine();
					while (line != null) {
					lblMsg.setText(line);
					line = in.readLine();
					}
					in.close();
					} catch (Exception e) {
					System.out.println(e);
					}
				}
			
		});
		btnGetDate.setBounds(35, 92, 89, 23);
		frame.getContentPane().add(btnGetDate);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(44, 170, 46, 14);
		frame.getContentPane().add(lblMsg);
	}
}
