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
//		defineButtons();

		back.render(g);
		slider.render(g);
		checkBox.render(g);
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
		}
	}


	@Override
	public void defineButtons() 
	{
		back = new Button(new Rectangle((WarGauge.WIDTH / 2) - 100, (WarGauge.HEIGHT) - 55, 200, 30));
		back.setTextColor(new Color(155, 0, 0));
		back.setText("Back");

		slider = new Slider(500, 500, 500, 30);
		slider.setArcHeight(5);
		slider.setArcWidth(5);

		checkBox = new CheckBox((WarGauge.WIDTH / 2) - 100, (WarGauge.HEIGHT) - 400, 200, 30);
	}

}
