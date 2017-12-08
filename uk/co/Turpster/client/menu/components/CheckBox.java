package uk.co.Turpster.client.menu.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import uk.co.Turpster.client.WarGauge;

public class CheckBox extends Button
{
	private String clickBoxText = "";

	private Rectangle checkHitbox;
	private Color checkBoxColor = Color.LIGHT_GRAY;
	private Color checkColor = new Color(200, 0, 0);
	private boolean check = false;

	public CheckBox(int x, int y, int width, int height) 
	{
		super(x, y, width, height);

		makeRectangles();
	}

	private void makeRectangles() 
	{

		int checkHeight = (int) (super.buttonHitbox.getHeight() - 8);
		if (checkHeight < 2)
		{
			checkHeight = 3;
		}

		int checkWidth = checkHeight;

		int x = (int)(super.buttonHitbox.getX() + 3);
		int y = (int)(super.buttonHitbox.getY() + 3);

		if (checkWidth > this.buttonHitbox.width)
		{
			checkWidth = (int) (this.buttonHitbox.width - 7);
		}

		checkHitbox = new Rectangle(x, y, checkWidth, checkHeight);

	}

	public boolean isChecked()
	{
		return check;
	}

	public void setCheckBoxColor(Color checkBoxColor)
	{
		this.checkBoxColor = checkBoxColor;
	}

	public void setCheckColor(Color checkColor)
	{
		this.checkColor = checkColor;
	}

	@Override
	public String getText()
	{
		return clickBoxText;
	}

	@Override
	public void setText(String text)
	{
		this.clickBoxText = text;
	}
	
	public void mouseClick(MouseEvent e)
	{
		if (check)
		{
			check = false;
		}
		else if (!check)
		{
			check = true;
		}
	}
	@Override
	public void render(Graphics g)
	{
		super.render(g);

		Color oldColor = g.getColor();
		g.setColor(checkBoxColor);
		g.drawRect((int)this.checkHitbox.getX(), (int)this.checkHitbox.getY(), (int)this.checkHitbox.getWidth(), (int)this.checkHitbox.getHeight());

		if (check)
		{
			checkColor = new Color(255, 50, 50);
			
			WarGauge.drawCenteredString(g, "\u2713", this.checkHitbox, new Font("null", Font.PLAIN, 37), checkColor);
		}
		g.setColor(oldColor);
		
		this.clickBoxText = "This is a test";
		
		WarGauge.drawCenteredString(g, this.getText(), new Rectangle((int) (buttonHitbox.x + (checkHitbox.getWidth() - 9)), buttonHitbox.y - 1, buttonHitbox.width, buttonHitbox.height), this.font, this.getTextColor());
	}
}
