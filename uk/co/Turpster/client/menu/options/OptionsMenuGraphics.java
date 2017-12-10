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
	Slider slider1;

	CheckBox fullscreen;
//	CheckBox option1;
	CheckBox option2;
	CheckBox option3;
	CheckBox option4;
	CheckBox option5;
	CheckBox option6;
	CheckBox option7;
	CheckBox option8;
	CheckBox option9;
	CheckBox option10;
	CheckBox option11;
	CheckBox option12;
	CheckBox option13;
	CheckBox option14;
	
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
		slider1.render(g);
		fullscreen.render(g);
		
		option2.render(g);
		option3.render(g);
		option4.render(g);
		option5.render(g);
		option6.render(g);
		option7.render(g);
		option8.render(g);
		option9.render(g);
		option10.render(g);
		option11.render(g);
		option12.render(g);
		option13.render(g);
		option14.render(g);
	}

	public void mouseUpdate(MouseEvent e)
	{
		slider1.mouseUpdate(e);
	}

	@Override
	public void mouseClick(MouseEvent e) 
	{	
		Rectangle point = new Rectangle(e.getX(), e.getY(), 1, 1);

		if (point.intersects(slider1.getButtonHitbox()) || point.intersects(slider1.getSliderHitBox()))
		{
			slider1.mouseClick(e);
		}
		else if (point.intersects(back.getButtonHitbox()))
		{
			this.handler.optionMenu = OptionsMenuType.MAIN;
		}
		else if (point.intersects(fullscreen.getButtonHitbox()))
		{
			fullscreen.mouseClick(e);
			
			/*
			 * TODO
			 * Set fullscreen
			 */
			
			handler.setFullscreen(fullscreen.isChecked());
		}
		
//		else if (point.intersects(option1.getButtonHitbox()))
//		{
//			option1.mouseClick(e);
//		}
		
		else if (point.intersects(option2.getButtonHitbox()))
		{
			option2.mouseClick(e);
		}
		else if (point.intersects(option3.getButtonHitbox()))
		{
			option3.mouseClick(e);
		}
		else if (point.intersects(option4.getButtonHitbox()))
		{
			option4.mouseClick(e);
		}
		else if (point.intersects(option5.getButtonHitbox()))
		{
			option5.mouseClick(e);
		}
		else if (point.intersects(option6.getButtonHitbox()))
		{
			option6.mouseClick(e);
		}
		else if (point.intersects(option7.getButtonHitbox()))
		{
			option7.mouseClick(e);
		}
		else if (point.intersects(option8.getButtonHitbox()))
		{
			option8.mouseClick(e);
		}
		else if (point.intersects(option9.getButtonHitbox()))
		{
			option9.mouseClick(e);
		}
		else if (point.intersects(option10.getButtonHitbox()))
		{
			option10.mouseClick(e);
		}
		else if (point.intersects(option11.getButtonHitbox()))
		{
			option11.mouseClick(e);
		}
		else if (point.intersects(option12.getButtonHitbox()))
		{
			option12.mouseClick(e);
		}
		else if (point.intersects(option13.getButtonHitbox()))
		{
			option13.mouseClick(e);
		}
		else if (point.intersects(option14.getButtonHitbox()))
		{
			option14.mouseClick(e);
		}
	}

	@Override
	public void defineButtons() 
	{
		back = new Button(new Rectangle((WarGauge.WIDTH / 2) - 100, (WarGauge.HEIGHT) - 55, 200, 30));
		back.setTextColor(new Color(155, 0, 0));
		back.setText("Back");

		boolean tick = false;
		
		if (fullscreen != null)
		{
			tick = fullscreen.isChecked();
		}
		fullscreen = new CheckBox(WarGauge.getMiddleX(250) - 170, WarGauge.getMiddleY(30) - 120, 250, 30);
		//		fullscreen = new CheckBox(WarGauge.getMiddleX((int) fullscreen.buttonHitbox.getWidth()) + 220, WarGauge.getMiddleY((int) fullscreen.buttonHitbox.getHeight()) - 230, (int) fullscreen.buttonHitbox.getWidth() + 100, (int) fullscreen.buttonHitbox.getHeight());
		fullscreen.setText("Fullscreen");
		fullscreen.setCheck(tick);
		
		float percentage = 0.5f;
		if (slider1 != null)
		{
			percentage = slider1.getPercentage();
		}
		
		/*
		 * TODO
		 * FIX SLIDER SIZE BUG
		 * - Slider goes off the mark of where it is supposed to be.
		 * 
		 * TODO
		 * ALLOW SLIDERS TO BE SMALLER
		 */
		
		slider1 = new Slider(WarGauge.getMiddleX(500), WarGauge.getMiddleY(30) + 300, 500, 30);
		slider1.setArcHeight(5);
		slider1.setArcWidth(5);
		slider1.setPercentage(percentage);
		slider1.setText("Slider 1");
		
		option2 = new CheckBox(WarGauge.getMiddleX(250) - 170, WarGauge.getMiddleY(30) - 80, 250, 30);
		option2.setText("Option 2");
		
		option3 = new CheckBox(WarGauge.getMiddleX(250) - 170, WarGauge.getMiddleY(30) - 40, 250, 30);
		option3.setText("Option 3");
		
		option4 = new CheckBox(WarGauge.getMiddleX(250) - 170, WarGauge.getMiddleY(30), 250, 30);
		option4.setText("Option 4");
		
		option5 = new CheckBox(WarGauge.getMiddleX(250) - 170, WarGauge.getMiddleY(30) + 40, 250, 30);
		option5.setText("Option 5");
		
		option6 = new CheckBox(WarGauge.getMiddleX(250) - 170, WarGauge.getMiddleY(30) + 80, 250, 30);
		option6.setText("Option 6");
		
		option7 = new CheckBox(WarGauge.getMiddleX(250) - 170, WarGauge.getMiddleY(30) + 120, 250, 30);
		option7.setText("Option 7");
		
		option8 = new CheckBox(WarGauge.getMiddleX(250) + 170, WarGauge.getMiddleY(30) - 120, 250, 30);
		option8.setText("Option 8");
		
		option9 = new CheckBox(WarGauge.getMiddleX(250) + 170, WarGauge.getMiddleY(30) - 80 , 250, 30);
		option9.setText("Option 9");
		
		option10 = new CheckBox(WarGauge.getMiddleX(250) + 170, WarGauge.getMiddleY(30) - 40, 250, 30);
		option10.setText("Option 10");
		
		option11 = new CheckBox(WarGauge.getMiddleX(250) + 170, WarGauge.getMiddleY(30), 250, 30);
		option11.setText("Option 11");
		
		option12 = new CheckBox(WarGauge.getMiddleX(250) + 170, WarGauge.getMiddleY(30) + 40, 250, 30);
		option12.setText("Option 12");
		
		option13 = new CheckBox(WarGauge.getMiddleX(250) + 170, WarGauge.getMiddleY(30) + 80, 250, 30);
		option13.setText("Option 13");
		
		option14 = new CheckBox(WarGauge.getMiddleX(250) +170, WarGauge.getMiddleY(30) + 120, 250, 30);
		option14.setText("Option 14");
		
	}
}
