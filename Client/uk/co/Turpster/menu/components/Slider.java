package uk.co.Turpster.menu.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import uk.co.Turpster.Renderable;

public class Slider extends Button implements Renderable
{
	public Rectangle sliderHitBox;

	private Rectangle slider;
	
	//floats 0 to 1 only
	private float percentage;
	
	int sliderWidth;
	
	public Slider(int x, int y, int width, int height) 
	{
		super(x, y, (int) (width * 0.333333333), height);
		
		sliderWidth = (int) (width * 0.666666666);
		
		makeRectangles();
	}
	
	@Override
	public void render(Graphics g)
	{
		super.render(g);
		
		makeRectangles();
		
		g.setColor(super.getRectangleColor());
		g.drawRect(sliderHitBox.x, sliderHitBox.y, sliderHitBox.width, sliderHitBox.height);
		Color color = new Color((float) super.getRectangleColor().getRed() / 255, (float) super.getRectangleColor().getGreen() / 255, (float) super.getRectangleColor().getRed() / 255, 0.15f);
 //		color = new Color((float) 40 / 255, (float) 55 / 255, (float) 200 / 255, 0.4f);
		g.setColor(color);
		g.fillRect(sliderHitBox.x, sliderHitBox.y, sliderHitBox.width, sliderHitBox.height);
		
		color = new Color((float) super.getRectangleColor().getRed() / 255, (float) super.getRectangleColor().getGreen() / 255, (float) super.getRectangleColor().getRed() / 255, 1f);
		
		color = color.darker();
		color = color.darker();
		
		g.setColor(color);
		g.fillRect(slider.x, slider.y, slider.width, slider.height);
		
		color = color.brighter();
		
		g.setColor(color);
		g.drawRect(slider.x, slider.y, slider.width, slider.height);
		
	}
	
	private void makeRectangles()
	{
		super.setArcHeight(0);
		super.setArcWidth(0);
		
		sliderHitBox = new Rectangle(super.buttonHitbox.x + super.buttonHitbox.width, super.buttonHitbox.y, sliderWidth, super.buttonHitbox.height - 1);
		slider = new Rectangle((int)((super.buttonHitbox.x + super.buttonHitbox.width) + ((super.buttonHitbox.width * 2) * percentage)), (int) sliderHitBox.getY(), 5, (int) sliderHitBox.getHeight());	
	}
	
	public void mouseClick(MouseEvent e)
	{
		Rectangle point = new Rectangle(e.getX() - 2, e.getY(), 1, 1);
		
		if (point.intersects(sliderHitBox))
		{
			int selectedPercentagePixel = (int) (point.getX() - sliderWidth);
			this.percentage = (float) selectedPercentagePixel / sliderWidth - 0.69f;
		}
	}
	
	public void mouseUpdate(MouseEvent e)
	{
		mouseClick(e);
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
	
	public Rectangle getSliderHitBox() 
	{
		return sliderHitBox;
	}

	public void setSliderHitBox(Rectangle sliderHitBox) 
	{
		this.sliderHitBox = sliderHitBox;
	}
}
