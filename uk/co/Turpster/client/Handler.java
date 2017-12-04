package uk.co.Turpster.client;

import java.awt.Color;
import java.awt.Graphics;

public class Handler 
{
	
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		Color oldColor = g.getColor();
		g.setColor(Color.red);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.setColor(oldColor);
	}
}































