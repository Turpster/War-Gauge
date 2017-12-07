package uk.co.Turpster.client.menu;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import uk.co.Turpster.client.Renderable;
import uk.co.Turpster.client.Tickable;

public abstract class Menu implements Tickable, Renderable
{
	@Override
	public abstract void tick();
	
	@Override
	public abstract void render(Graphics g);
	
	public void mouseClick(MouseEvent e)
	{
		return;
	}
	
	public void mousePress(MouseEvent e)
	{
		return;
	}
	
	public void mouseRelease(MouseEvent e)
	{
		return;
	}
	
	public void mouseUpdate(MouseEvent e)
	{
		return;
	}
	
	public abstract void defineButtons();
	
	protected MenuHandler handler;
	
	public Menu(MenuHandler handler)
	{
		this.handler = handler;
	}
}
