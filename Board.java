package k4smaGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener
{
	//anzahl an millisekunden zwischen jedem frame(bild)
	private final int DELAY = 17;

	private static final long serialVersionUID = 1L;
	private static Timer timer;
	private static boolean running = true;
	private static boolean restart = false;

	public Board()
	{
		initBoard();
	}

	private void initBoard()
	{
		setLayout(null);

		addKeyListener(new TAdapter());
		setFocusable(true);

		start();

		timer = new Timer(DELAY, this);
		timer.start();
	}

	//WICHTIG in dieser methode werden alle objekte erstellt!
	private void start()
	{

	}

	//diese methode wird zum rendern benötigt
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		doDrawing(g);
		Toolkit.getDefaultToolkit().sync();
	}

	//in dieser methode wird jedes GameObject, dass es gibt auf den bildschirm gezeichnet!
	private void doDrawing(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;

		ArrayList<GameObject> objects = GameObject.objects;

		Collections.sort(objects);

		System.out.println(objects.size());

		for(int i = 0; i < objects.size(); i++)
		{
			if(objects.get(i).img != null)
			{
				g2d.drawImage(objects.get(i).img, objects.get(i).pos.x, objects.get(i).pos.y, this);
			}
		}
	}

	//in dieser methode werden alle GameObjects "geupdated", also die "update" methode aller GameObjects wird aufgerufen
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(running)
		{
			for(int i = 0; i < GameObject.objects.size(); i++)
			{
				GameObject.objects.get(i).update();
			}
			pp.update();

			repaint();
		}
	}

	//mit dieser methode wird das spiel beendet -> kein GameObject wird geupdated
	public void endGame()
	{
		running = false;
	}

	//mit dieser methode wird das spiel neu gestartet und alle GameObjects resettet
	public void restartGame()
	{
		GameObject.objects.clear();
		start();
		running = true;
	}

	//diese methode wird für tastatureingaben benötigt
	private class TAdapter extends KeyAdapter
	{
		@Override
		public void keyReleased(KeyEvent e)
		{
			Input.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e)
		{
			Input.keyPressed(e);
		}
	}
}
