package uk.co.Turpster.client;

import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Window extends JFrame implements ComponentListener
{
	private static final long serialVersionUID = 1L;

	WarGauge game;
	
	public Window(String[] args)
	{
		super("War Gauge");
		int width = 1280, height = 768;

		this.addComponentListener(this);

		Image icon = null;
		try 
		{
			icon = ImageIO.read(new File(new File("").getAbsolutePath() + "\\assets\\icon.png"));
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		this.setIconImage(icon);
		
		this.setSize(width + 31, height + 44);
		//		this.setSize(width, height);
		//		this.setResizable(false);
		//		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		game = new WarGauge(args, width, height, this);
		this.add(game);
		this.setVisible(true);
		game.start();
	}

	@Override
	public void componentResized(ComponentEvent e) 
	{
		try
		{
			WarGauge.WIDTH = this.getWidth() - 16;
			WarGauge.HEIGHT = this.getHeight() - 39;

			game.refreshSize();
		}
		catch (NullPointerException ex)
		{
			return;
		}
		
	}

	@Override
	public void componentMoved(ComponentEvent e) 
	{

	}

	@Override
	public void componentShown(ComponentEvent e) 
	{

	}

	@Override
	public void componentHidden(ComponentEvent e) 
	{

	}
}