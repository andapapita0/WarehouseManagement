package start;

import presentation.MainController;
import presentation.MainView;

public class Start {
	public static void main(String[] args) {
		MainView v = new MainView();
		MainController c = new MainController(v);
		v.setVisible(true);
	}
}


