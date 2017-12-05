package uk.co.Turpster.client;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler 
{
	public LinkedList<Renderable> renderables = new LinkedList<Renderable>();
	public LinkedList<Tickable> tickables = new LinkedList<Tickable>();
	
	public Handler()
	{
		
	}
	
	public void tick()
	{
		for (Tickable tickable : tickables)
		{
			tickable.tick();
		}
	}
	
	public void render(Graphics g)
	{
		for (Renderable renderable : renderables)
		{
			renderable.render(g);
		}
	}
}































