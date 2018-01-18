package uk.co.Turpster.menu.options;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import uk.co.Turpster.WarGauge;
import uk.co.Turpster.menu.Menu;
import uk.co.Turpster.menu.MenuHandler;
import uk.co.Turpster.menu.components.Button;

public class OptionsMenuPlayerOptions extends Menu
{
	Button back;
	
	public OptionsMenuPlayerOptions(MenuHandler handler) 
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
	public void mouseClick(MouseEvent e) 
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
