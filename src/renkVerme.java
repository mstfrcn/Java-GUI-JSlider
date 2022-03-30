import java.awt.Color;

import javax.swing.JComponent;

public class renkVerme {
	public void renklendir(JComponent component, int sonuc) {
		if(sonuc >=80 && sonuc <= 100 )component.setBackground(Color.GREEN);
		else if(sonuc < 80 && sonuc>=60)component.setBackground(Color.YELLOW);
		else component.setBackground(Color.RED);
		
	}
}
