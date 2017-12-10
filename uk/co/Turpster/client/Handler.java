package uk.co.Turpster.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import uk.co.Turpster.client.menu.MenuHandler;

public class Handler implements MouseListener, MouseMotionListener, Renderable, Tickable
{
	public LinkedList<Renderable> renderables = new LinkedList<Renderable>();
	public LinkedList<Tickable> tickables = new LinkedList<Tickable>();
	private MenuHandler menuHandler;
	private WarGauge warGauge;
	
	public Handler(WarGauge warGauge)
	{
		this.warGauge = warGauge;
		this.menuHandler = warGauge.menuHandler;
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
		
		this.overlay(g);
	}
	
	private String versionText = "War Gauge Version: " + WarGauge.version + ".";
	private void overlay(Graphics g)
	{
		if (WarGauge.notReleased)
		{
			Font oldFont = g.getFont();
			Color oldColor = g.getColor();
			Font font = new Font("DotumChe Pixel", Font.PLAIN, 15);
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString(versionText, 10, 25);
			if (!warGauge.session.validate())
			{
				font = new Font("DotumChe Pixel", Font.PLAIN, 12);
				g.setFont(font);
				g.drawString("This session is invalid. :( Please log-in correctly or contact an administrator", 10, 40);
			}
			g.setColor(oldColor);
			g.setFont(oldFont);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		return;
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		menuHandler.mouseClick(e);		
		menuHandler.mousePress(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		menuHandler.mouseReleased(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		return;
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		return;
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		menuHandler.mouseUpdate(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		return;
	}
}































