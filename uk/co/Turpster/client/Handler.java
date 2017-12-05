package uk.co.Turpster.client;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import uk.co.Turpster.client.menu.MenuHandler;

public class Handler implements MouseListener
{
	public LinkedList<Renderable> renderables = new LinkedList<Renderable>();
	public LinkedList<Tickable> tickables = new LinkedList<Tickable>();
	
	private MenuHandler menuHandler;
	
	public Handler(MenuHandler menuHandler)
	{
		this.menuHandler = menuHandler;
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

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		menuHandler.click(e);
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}































