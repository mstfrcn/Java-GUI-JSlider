

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class slider extends JFrame {

	private JPanel contentPane;
	private JTextField vizeTxt;
	private JTextField finalTxt;
	private JTextField sonucTxt;

	/**
	 * Launch the application.
	 */
	
	int vizeNotu, finalNotu, sonucNotu;
	renkVerme renkver = new renkVerme();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					slider frame = new slider();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public slider() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 673);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVize = new JLabel("VIZE");
		lblVize.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblVize.setBounds(40, 33, 55, 38);
		contentPane.add(lblVize);
		
		JLabel lblFinal = new JLabel("FINAL");
		lblFinal.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblFinal.setBounds(188, 33, 73, 38);
		contentPane.add(lblFinal);
		
		JLabel lblSonuc = new JLabel("SONUC");
		lblSonuc.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblSonuc.setBounds(327, 33, 84, 38);
		contentPane.add(lblSonuc);
		
		JSlider vizeSlider = new JSlider();
		vizeSlider.setValue(60);
		vizeSlider.setToolTipText("");
		vizeSlider.setPaintTicks(true);
		vizeSlider.setPaintLabels(true);
		vizeSlider.setBackground(Color.WHITE);
		vizeSlider.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		vizeSlider.setMinorTickSpacing(1);
		vizeSlider.setMajorTickSpacing(10);
		vizeSlider.setOrientation(SwingConstants.VERTICAL);
		vizeSlider.setBounds(29, 82, 66, 446);
		contentPane.add(vizeSlider);
		
		JSlider finalSlider = new JSlider();
		finalSlider.setValue(60);
		finalSlider.setPaintTicks(true);
		finalSlider.setPaintLabels(true);
		finalSlider.setOrientation(SwingConstants.VERTICAL);
		finalSlider.setMinorTickSpacing(1);
		finalSlider.setMajorTickSpacing(10);
		finalSlider.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		finalSlider.setBackground(Color.WHITE);
		finalSlider.setBounds(188, 82, 66, 446);
		contentPane.add(finalSlider);
		
		JSlider sonucSlider = new JSlider();
		sonucSlider.setValue(60);
		sonucSlider.setPaintTicks(true);
		sonucSlider.setPaintLabels(true);
		sonucSlider.setOrientation(SwingConstants.VERTICAL);
		sonucSlider.setMinorTickSpacing(1);
		sonucSlider.setMajorTickSpacing(10);
		sonucSlider.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		sonucSlider.setBackground(Color.WHITE);
		sonucSlider.setBounds(337, 82, 66, 446);
		contentPane.add(sonucSlider);
		
		vizeTxt = new JTextField();
		vizeTxt.setFont(new Font("Times New Roman", Font.BOLD, 18));
		vizeTxt.setHorizontalAlignment(SwingConstants.CENTER);
		vizeTxt.setBounds(17, 539, 90, 31);
		contentPane.add(vizeTxt);
		vizeTxt.setColumns(10);
		
		finalTxt = new JTextField();
		finalTxt.setHorizontalAlignment(SwingConstants.CENTER);
		finalTxt.setFont(new Font("Times New Roman", Font.BOLD, 18));
		finalTxt.setColumns(10);
		finalTxt.setBounds(177, 539, 90, 31);
		contentPane.add(finalTxt);
		
		sonucTxt = new JTextField();
		sonucTxt.setHorizontalAlignment(SwingConstants.CENTER);
		sonucTxt.setFont(new Font("Times New Roman", Font.BOLD, 18));
		sonucTxt.setColumns(10);
		sonucTxt.setBounds(327, 539, 90, 31);
		contentPane.add(sonucTxt);
		vizeNotu = vizeSlider.getValue();
		finalNotu = finalSlider.getValue();
		sonucNotu = (int) ((vizeNotu*0.40) + (finalNotu * 0.60));
		vizeTxt.setText(Integer.toString(vizeNotu));
		finalTxt.setText(Integer.toString(finalNotu));
		sonucTxt.setText(Integer.toString(sonucNotu));
		sonucSlider.setValue(sonucNotu);
		
		JLabel lblNewLabel = new JLabel("MUSTAFA ERCAN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(146, 593, 194, 30);
		contentPane.add(lblNewLabel);
		// EVENETLER
		vizeSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				vizeNotu = vizeSlider.getValue();
				vizeTxt.setText(Integer.toString(vizeNotu));
				
				sonucNotu = (int) ((vizeNotu*0.40) + (finalNotu * 0.60));
				sonucSlider.setValue(sonucNotu);
				sonucTxt.setText(Integer.toString(sonucNotu));
				
				renkver.renklendir(sonucSlider, sonucNotu);
				renkver.renklendir(vizeSlider, vizeNotu);
				
				
				
			}
		});
		
		finalSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				finalNotu = finalSlider.getValue();
				finalTxt.setText(Integer.toString(finalNotu));
				
				sonucNotu = (int) ((vizeNotu*0.40) + (finalNotu * 0.60));
				sonucSlider.setValue(sonucNotu);
				sonucTxt.setText(Integer.toString(sonucNotu));
				
				renkver.renklendir(sonucSlider, sonucNotu);
				renkver.renklendir(vizeSlider, vizeNotu);
				renkver.renklendir(finalSlider, finalNotu);

			}
		});

		
		
		
		
		
		
		
	}
}
