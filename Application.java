package k4smaGame;

import java.awt.EventQueue;

import javax.swing.JFrame;

//Application is sozusagen das fenster, das auf dem bildschirm angezeigt wird
//Board is das, was man in dem fenster sieht
//APPLICATION WIRD AUSGEFÜHRT!!!!

public class Application extends JFrame
{
	private static final long serialVersionUID = 1L;
	public static Board brd;

	public Application()
	{
		//UI wird vorbeireitet
		initUI();
	}

	private void initUI()
	{
		brd = new Board();
		add(brd);

		//Einstellungen zum fenster
		setSize(1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setUndecorated(true);
		setTitle("Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				Application ex = new Application();
				ex.setVisible(true);
			}
		});
	}
}
