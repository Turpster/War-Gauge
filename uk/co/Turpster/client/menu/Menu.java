package uk.co.Turpster.client.menu;

import java.awt.Graphics;

import uk.co.Turpster.client.Renderable;
import uk.co.Turpster.client.Tickable;

public abstract class Menu implements Tickable, Renderable
{
	@Override
	public abstract void tick();
	
	@Override
	public abstract void render(Graphics g);
}
