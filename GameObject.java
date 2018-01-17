package k4smaGame;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class GameObject implements Comparable<GameObject>
{
	//eine static liste auf die man von überall aus zugreifen kann, in der alle GameObjects aufgelistet sind
	public static ArrayList<GameObject> objects = new ArrayList<GameObject>();

	//position des GameObjects in einem Vector gespeichert
	public Vector3 pos = new Vector3();
	//bild des GameObjects (Icon)
	public Image img;

	//constructor
	public GameObject(Vector3 position, String imgPath)
	{
		objects.add(this);

		pos = position;

		//das bild, das bei dem pfad angegeben wurde (im constructor) wird der img variable hinzugefügt
		loadImage(imgPath);
	}

	private void loadImage(String path)
	{
		ImageIcon ii = new ImageIcon(path);
		img = ii.getImage();
	}

	//WICHTIG das ist die update methode
	public void update()
	{

	}

	//für das sortieren (ansonsten unwichtig)
	@Override
	public int compareTo(GameObject g)
	{
		return this.pos.z - g.pos.z;
	}
}
