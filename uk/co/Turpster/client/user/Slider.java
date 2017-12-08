package uk.co.Turpster.client.user;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import uk.co.Turpster.client.menu.components.Button;

public class Slider extends Button
{
	private Rectangle sliderHitBox;
	private Rectangle slider;
	
	//floats 0 to 1 only
	private float percentage;
	
	public Slider(int x, int y, int width, int height) 
	{
		super(x, y, width, height);
		makeRectangles();
	}
	
	@Override
	public void render(Graphics g)
	{
		super.render(g);
		
		makeRectangles();
		
		g.setColor(super.getRectangleColor());
		g.drawRect(sliderHitBox.x, sliderHitBox.y, sliderHitBox.width, sliderHitBox.height);
		Color color = new Color((float) super.getRectangleColor().getRed() / 255, (float) super.getRectangleColor().getGreen() / 255, (float) super.getRectangleColor().getRed() / 255, 0.5f);
		g.setColor(color);
		g.fillRect(sliderHitBox.x, sliderHitBox.y, sliderHitBox.width, sliderHitBox.height);
		
		color = new Color((float) super.getRectangleColor().getRed() / 255, (float) super.getRectangleColor().getGreen() / 255, (float) super.getRectangleColor().getRed() / 255, 1f);
		color.darker();
		g.setColor(color);
		g.fillRect(slider.x, slider.y, slider.width, slider.height);
	}
	
	private void makeRectangles()
	{
		super.setArcHeight(0);
		super.setArcWidth(0);
		
		super.setText("Render Speed");
		
		sliderHitBox = new Rectangle(super.buttonHitbox.x + (super.buttonHitbox.width / 1), super.buttonHitbox.y, super.buttonHitbox.width * 2, super.buttonHitbox.height - 1);
		slider = new Rectangle((int)((super.buttonHitbox.x + super.buttonHitbox.width) + ((super.buttonHitbox.width * 2) * percentage)), 500, 5, 30);	
	}
	
	public void mouseClick(MouseEvent e)
	{
		Rectangle point = new Rectangle(e.getX() - 2, e.getY(), 1, 1);
		
		if (point.intersects(sliderHitBox))
		{
			int selectedPercentagePixel = (int) (point.getX() - sliderHitBox.getWidth());
			this.percentage = (float) (selectedPercentagePixel / sliderHitBox.getWidth() - 0.75f);	
		}
		
	}
	
	public void mouseUpdate(MouseEvent e)
	{
		Rectangle point = new Rectangle(e.getX() - 2, e.getY(), 1, 1);
		
		if (point.intersects(sliderHitBox))
		{
			int selectedPercentagePixel = (int) (point.getX() - sliderHitBox.getWidth());
			this.percentage = (float) (selectedPercentagePixel / sliderHitBox.getWidth() - 0.75f);	
		}
		
		
	}
	
	public float getPercentage() 
	{
		return percentage;
	}

	public void setPercentage(float percentage) 
	{
		if (percentage > 1)
		{
			percentage = 1f;
		}
		else if (percentage < 0)
		{
			percentage = 0f;
		}
		this.percentage = percentage;
	}
	
}
