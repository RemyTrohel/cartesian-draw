import javax.swing.JFrame;

public class CartesianFrame extends JFrame {

	private static final long serialVersionUID = -7701923380968299722L;
	CartesianPanel panel;

    public CartesianFrame() {
        panel = new CartesianPanel();
        add(panel);
    }

    public void showUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cartesian");
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setVisible(true);
    }
}