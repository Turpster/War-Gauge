package uk.co.Turpster.client.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import uk.co.Turpster.client.Renderable;
import uk.co.Turpster.client.Tickable;

public abstract class Button implements Renderable, Tickable
{
	public Rectangle buttonHitbox;
	public Color rectangleColor = Color.white;
	@SuppressWarnings("unused")
	private boolean shadow;
	private boolean rounded;
	public int arcWidth, arcHeight;
	public Font font = new Font("Comic Sans MS", Font.BOLD, 15);
	public String text = "";
	
	public Button(int x, int y, int width, int height, boolean shadow)
	{
		this.shadow = shadow;
		buttonHitbox = new Rectangle(x, y, width, height);
		rounded = false;
	}
	
	public Button(int x, int y, int width, int height, boolean shadow, String text)
	{
		this.shadow = shadow;
		buttonHitbox = new Rectangle(x, y, width, height);
		this.text = text;
		rounded = false;
	}
	
	public Button(int x, int y, int width, int height, boolean shadow, Font font, int arcWidth, int arcHeight)
	{
		this.shadow = shadow;
		buttonHitbox = new Rectangle(x, y, width, height);
		this.arcWidth = arcWidth;
		this.arcHeight = arcHeight;
		rounded = true;
	}
	
	public Button(int x, int y, int width, int height, boolean shadow, String text, Font font)
	{
		this.shadow = shadow;
		buttonHitbox = new Rectangle(x, y, width, height);
		this.font = font;
		this.text = text;
		rounded = false;
	}
	
	
	public Button(int x, int y, int width, int height, boolean shadow, String text, int arcWidth, int arcHeight)
	{
		this.shadow = shadow;
		buttonHitbox = new Rectangle(x, y, width, height);
		this.text = text;
		this.arcWidth = arcWidth;
		this.arcHeight = arcHeight;
		rounded = true;
	}
	public Button(int x, int y, int width, int height, boolean shadow, String text, Font font, int arcWidth, int arcHeight)
	{
		this.shadow = shadow;
		buttonHitbox = new Rectangle(x, y, width, height);
		this.text = text;
		this.font = font;
		this.arcWidth = arcWidth;
		this.arcHeight = arcHeight;
		rounded = true;
	}
	
	public Button(Rectangle buttonHitbox, boolean shadow)
	{
		this.shadow = shadow;
		this.buttonHitbox = buttonHitbox;
		rounded = false;
	}
	
	public Button(Rectangle buttonHitbox, boolean shadow, String text, int arcWidth, int arcHeight)
	{
		this.shadow = shadow;
		this.buttonHitbox = buttonHitbox;
		this.text = text;
		this.arcWidth = arcWidth;
		this.arcHeight = arcHeight;
		rounded = true;
	}
	
	public Button(Rectangle buttonHitbox, boolean shadow, String text, Font font, int arcWidth, int arcHeight)
	{
		this.shadow = shadow;
		this.buttonHitbox = buttonHitbox;
		this.text = text;
		this.font = font;
		this.arcWidth = arcWidth;
		this.arcHeight = arcHeight;
		rounded = true;
	}
	
	public Button(Rectangle buttonHitbox, boolean shadow, int arcWidth, int arcHeight)
	{
		this.shadow = shadow;
		this.buttonHitbox = buttonHitbox;
		this.arcWidth = arcWidth;
		this.arcHeight = arcHeight;
		rounded = true;
	}
	public Button(Rectangle buttonHitbox, boolean shadow, Font font, int arcWidth, int arcHeight)
	{
		this.shadow = shadow;
		this.buttonHitbox = buttonHitbox;
		this.font = font;
		this.arcWidth = arcWidth;
		this.arcHeight = arcHeight;
		rounded = true;
	}
	
	
	public Button(Rectangle buttonHitbox, boolean shadow, String text)
	{
		this.shadow = shadow;
		this.buttonHitbox = buttonHitbox;
		this.text = text;
		rounded = false;
	}
	
	public boolean isClicked(MouseEvent e)
	{
		if (e.getPoint().getX() >= buttonHitbox.getX() && e.getPoint().getX() <= buttonHitbox.getX() + buttonHitbox.getWidth())
		{
			if (e.getPoint().getY() >= buttonHitbox.getY() && e.getPoint().getY() <= buttonHitbox.getY() + buttonHitbox.getHeight())
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void render(Graphics g)
	{
		Color oldColor = g.getColor();
		Font oldFont = g.getFont();
		
		g.setFont(font);
		g.setColor(rectangleColor);
		
		if (rounded)
		{
			g.fillRoundRect(buttonHitbox.x, buttonHitbox.y, buttonHitbox.width, buttonHitbox.height, arcWidth, arcHeight);
		}
		else
		{
			g.fillRect(buttonHitbox.x, buttonHitbox.y, buttonHitbox.width, buttonHitbox.height);
		}
		
		/*
		 * TODO
		 * COMPLETE SHADOWS
		 */
		
		g.setFont(oldFont);
		g.setColor(oldColor);
	}
	
	@Override
	public abstract void tick();
}
