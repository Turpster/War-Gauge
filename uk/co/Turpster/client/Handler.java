package uk.co.Turpster.client;

import java.awt.Color;
import java.awt.Font;
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































