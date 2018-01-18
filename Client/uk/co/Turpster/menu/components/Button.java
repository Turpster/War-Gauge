package uk.co.Turpster.menu.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import uk.co.Turpster.Renderable;
import uk.co.Turpster.WarGauge;

public class Button implements Renderable
{
	public Rectangle buttonHitbox;
	private Color rectangleColor = Color.white, textColor = Color.BLACK;
	private boolean shadow;
	private String text = "";
	public int arcWidth = 6, arcHeight = 6;
	public Font font = new Font("DotumChe Pixel", Font.PLAIN, 15);
	
	public Button(int x, int y, int width, int height)
	{
		buttonHitbox = new Rectangle(x, y, width, height);
	}
	
	public Button(Rectangle buttonHitbox)
	{
		this.buttonHitbox = buttonHitbox;
		shadow = false;
	}
	
	@Override
	public void render(Graphics g)
	{
		Color oldColor = g.getColor();
		Font oldFont = g.getFont();
		
		g.setFont(font);
		g.setColor(rectangleColor);
		
		if (arcWidth != 0 || arcHeight != 0)
		{
			g.fillRoundRect(buttonHitbox.x, buttonHitbox.y, buttonHitbox.width, buttonHitbox.height, arcWidth, arcHeight);
			
			g.setColor(rectangleColor.darker().darker());
			g.drawRoundRect(buttonHitbox.x, buttonHitbox.y, buttonHitbox.width, buttonHitbox.height, arcWidth, arcHeight);
		}
		else
		{
			g.fillRect(buttonHitbox.x, buttonHitbox.y, buttonHitbox.width, buttonHitbox.height);
		}
		
		/*
		 * TODO
		 * COMPLETE SHADOWS
		 * ADD MOUSE HOVER FUNCTIONALITY	
		 */
		
		WarGauge.drawCenteredString(g, text, buttonHitbox, font, textColor);
		
		g.setFont(oldFont);
		g.setColor(oldColor);
	}
	

	public Rectangle getButtonHitbox() 
	{
		return buttonHitbox;
	}

	public void setButtonHitbox(Rectangle buttonHitbox)
	{
		this.buttonHitbox = buttonHitbox;
	}

	public Color getRectangleColor() 
	{
		return rectangleColor;
	}

	public void setRectangleColor(Color rectangleColor)
	{
		this.rectangleColor = rectangleColor;
	}

	public Color getTextColor()
	{
		return textColor;
	}

	public void setTextColor(Color textColor) 
	{
		this.textColor = textColor;
	}

	public boolean isShadow() 
	{
		return shadow;
	}

	public void setShadow(boolean shadow) 
	{
		this.shadow = shadow;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text) 
	{
		this.text = text;
	}

	public int getArcWidth() 
	{
		return arcWidth;
	}

	public void setArcWidth(int arcWidth)
	{
		this.arcWidth = arcWidth;
	}

	public int getArcHeight() 
	{
		return arcHeight;
	}

	public void setArcHeight(int arcHeight) 
	{
		this.arcHeight = arcHeight;
	}

	public Font getFont() 
	{
		return font;
	}

	public void setFont(Font font) 
	{
		this.font = font;
	}
}
