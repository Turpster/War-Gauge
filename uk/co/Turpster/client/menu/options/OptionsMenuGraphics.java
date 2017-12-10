package uk.co.Turpster.client.menu.options;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import uk.co.Turpster.client.WarGauge;
import uk.co.Turpster.client.menu.Menu;
import uk.co.Turpster.client.menu.MenuHandler;
import uk.co.Turpster.client.menu.components.Button;
import uk.co.Turpster.client.menu.components.CheckBox;
import uk.co.Turpster.client.menu.components.Slider;

public class OptionsMenuGraphics extends Menu
{
	Button back;
	Slider slider;
	CheckBox checkBox;

	CheckBox fullscreen;

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
		back.render(g);
		slider.render(g);
		checkBox.render(g);
		fullscreen.render(g);
	}

	public void mouseUpdate(MouseEvent e)
	{
		slider.mouseUpdate(e);
	}

	@Override
	public void mouseClick(MouseEvent e) 
	{	
		Rectangle point = new Rectangle(e.getX(), e.getY(), 1, 1);

		if (point.intersects(slider.getButtonHitbox()) || point.intersects(slider.getSliderHitBox()))
		{
			slider.mouseClick(e);
		}
		if (point.intersects(back.getButtonHitbox()))
		{
			this.handler.optionMenu = OptionsMenuType.MAIN;
		}
		if (point.intersects(checkBox.getButtonHitbox()))
		{
			checkBox.mouseClick(e);
			fullscreen.mouseClick(e);
			
			/*
			 * TODO
			 * Set fullscreen
			 */
			
			handler.setFullscreen(fullscreen.isChecked());
		}
	}


	@Override
	public void defineButtons() 
	{
		back = new Button(new Rectangle((WarGauge.WIDTH / 2) - 100, (WarGauge.HEIGHT) - 55, 200, 30));
		back.setTextColor(new Color(155, 0, 0));
		back.setText("Back");

		fullscreen = new CheckBox(WarGauge.getMiddleX(250) + 170, WarGauge.getMiddleY(30) - 110, 250, 30);
		//		fullscreen = new CheckBox(WarGauge.getMiddleX((int) fullscreen.buttonHitbox.getWidth()) + 220, WarGauge.getMiddleY((int) fullscreen.buttonHitbox.getHeight()) - 230, (int) fullscreen.buttonHitbox.getWidth() + 100, (int) fullscreen.buttonHitbox.getHeight());
		fullscreen.setText("Fullscreen");
		slider = new Slider(500, 500, 500, 30);
		slider.setArcHeight(5);
		slider.setArcWidth(5);
		slider.setRectangleColor(new Color(250, 249, 215));
		
		checkBox = new CheckBox((WarGauge.WIDTH / 2) - 100, (WarGauge.HEIGHT) - 400, 200, 30);
	}

}
