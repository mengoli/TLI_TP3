import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;


public class EcouteurComposant implements ComponentListener {

	JFrame frame;
	public EcouteurComposant(JFrame frame){
		this.frame=frame;
	}
	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent arg0) {

	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		if(frame.getHeight()!=140){
			frame.setResizable(true);
			frame.setSize(new Dimension(frame.getWidth(), 140));
			frame.setResizable(false);
		}else{
			frame.setResizable(true);			
		}
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

}
