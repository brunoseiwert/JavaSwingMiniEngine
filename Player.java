package k4smaGame;

//BEISPIEL klasse für einen player

public class Player extends GameObject
{
	public Player(Vector3 position, String imgPath)
	{
		super(position, imgPath);

		col.x = img.getWidth(null);
		col.y = img.getHeight(null);
	}

	//fülle diese methode mit CODE!!
	public void update()
	{

	}
}
