package uk.co.Turpster.client.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import uk.co.Turpster.client.Renderable;

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
			g.fillRoundRect(buttonHitbox.x, buttonHitbox.y, buttonHitbox.width, buttonHitbox.height, arcWidth, arcHeight);
		else
			g.fillRect(buttonHitbox.x, buttonHitbox.y, buttonHitbox.width, buttonHitbox.height);
		
		
		/*
		 * TODO
		 * COMPLETE SHADOWS
		 */
		
		this.drawCenteredString(g, text, buttonHitbox, font);
		
		g.setFont(oldFont);
		g.setColor(oldColor);
	}
	
	public void drawCenteredString(Graphics g, String s, Rectangle r, Font font) 
	{
		/*
		 * IMPLEMENTED FROM SOURCE:
		 * https://stackoverflow.com/questions/27706197/how-can-i-center-graphics-drawstring-in-java
		 */
		
		FontRenderContext frc = 
	            new FontRenderContext(null, true, true);

	    Rectangle2D r2D = font.getStringBounds(s, frc);
	    int rWidth = (int) Math.round(r2D.getWidth());
	    int rHeight = (int) Math.round(r2D.getHeight());
	    int rX = (int) Math.round(r2D.getX());
	    int rY = (int) Math.round(r2D.getY());

	    int a = (r.width / 2) - (rWidth / 2) - rX;
	    int b = (r.height / 2) - (rHeight / 2) - rY;

	    g.setFont(this.font);
	    g.setColor(textColor);
	    g.drawString(s, r.x + a, r.y + b);
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
