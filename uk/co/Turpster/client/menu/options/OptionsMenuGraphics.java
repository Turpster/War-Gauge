package uk.co.Turpster.client.menu.options;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import uk.co.Turpster.client.WarGauge;
import uk.co.Turpster.client.menu.Menu;
import uk.co.Turpster.client.menu.MenuHandler;
import uk.co.Turpster.client.menu.components.Button;

public class OptionsMenuGraphics extends Menu
{
	Button back;
	
	public OptionsMenuGraphics(MenuHandler handler) 
	{
		super(handler);
		
		this.defineButtons();
	}

	@Override
	public void tick() 
	{
		
	}

	@Override
	public void render(Graphics g) 
	{
		this.defineButtons();
		back.render(g);
	}

	@Override
	public void click(MouseEvent e) 
	{
		Rectangle point = new Rectangle(e.getX(), e.getY(), 1, 1);
		
		if (point.intersects(back.getButtonHitbox()))
		{
			this.handler.optionMenu = OptionsMenuType.MAIN;
		}
	}

	@Override
	public void defineButtons() 
	{
		back = new Button(new Rectangle((WarGauge.WIDTH / 2) - 100, (WarGauge.HEIGHT) - 55, 200, 30));
		back.setTextColor(new Color(155, 0, 0));
		back.setText("Back");
	}
	
}
