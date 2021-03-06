package uk.co.Turpster;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import uk.co.Turpster.connection.ConnectionManager;
import uk.co.Turpster.menu.MenuHandler;
import uk.co.Turpster.user.Session;

public class WarGauge extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;

	public static int HEIGHT, WIDTH;
	public static boolean notReleased = true;
	public static String version = "In-Dev";
	protected Session session;
	public ConnectionManager connectionMang;
	public boolean running = false;
	private Thread gamethread;
	MenuHandler menuHandler;
	Handler handler;
	int frames;
	int ticks;

	private Window window;
	
	public static final String assetsLoc = "C:\\Users\\Reece\\SkyDrive\\Documents\\GitHub\\War-Gauge\\assets";
	
	public WarGauge(String[] args, int width, int height, Window window)
	{
		String username = null;
		String password = null;

		if (args.length != 0)
		{
			for (int i = 0; i < args.length; i++)
			{
				if (args[i].equalsIgnoreCase("-username"))
				{
					username = args[i + 1];
				}
				if (args[i].equalsIgnoreCase("-password"))
				{
					password = args[i + 1];
				}
			}
		}
		if (username == null || password == null)
		{
			System.exit(0);
		}
		
		/*
		 * SETS HERE
		 */
		this.window = window;
		this.registerFonts();
		
		connectionMang = new ConnectionManager("127.0.0.1");

		session = new Session(connectionMang, username, password);

		WarGauge.WIDTH = width;
		WarGauge.HEIGHT = height;
	}

	private void initialiseGameVariables()
	{
		this.menuHandler = new MenuHandler(session, this);
		this.handler = new Handler(this);
		
		this.addMouseListener(handler);
		this.addMouseMotionListener(handler);
		
		this.handler.renderables.add(menuHandler);
		this.handler.tickables.add(menuHandler);
	}
	
	public void refreshSize()
	{
		menuHandler.refreshSize();
	}
	
	public synchronized void start()
	{
		this.initialiseGameVariables();
		
		gamethread = new Thread(this);
		gamethread.start();
		running = true;
	}

	@Override
	public void run() 
	{
		//Imported from RealTutsGML (Not my code)
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		ticks = 0;
		frames = 0;
		while (running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1)
			{
				this.tick();
				ticks++;
				delta--;
			}
			this.render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
			}
		}
	}

	public void tick()
	{
		handler.tick();
	}

	public void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		
		handler.render(g);

		g.dispose();
		bs.show();
	}

	public synchronized void stop()
	{
		running = false;
		try
		{
			gamethread.join();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		new Window(args);
	}
	
	private void registerFonts()
	{
		try
		{
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(WarGauge.assetsLoc + "\\DotumChe-Pixel.ttf")));
		}
		catch (IOException | FontFormatException e) 
		{
			
		}
	}
	
	public static void drawCenteredString(Graphics g, String s, Rectangle r, Font font, Color textColor) 
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

	    g.setFont(font);
	    g.setColor(textColor);
	    g.drawString(s, r.x + a, r.y + b);
	}
	public static int getMiddleY()
	{
		return WarGauge.HEIGHT / 2;
	}
	
	public static int getMiddleY(int height)
	{
		return (WarGauge.HEIGHT / 2) - (height / 2);
	}

	public static int getMiddleX()
	{
		return WarGauge.WIDTH / 2;
	}
	
	public static int getMiddleX(int width)
	{
		return (WarGauge.WIDTH / 2) - (width / 2);
	}
	
	public static Point getMiddlePoint()
	{
		return new Point(WarGauge.getMiddleX(), WarGauge.getMiddleY());
	}
	
	public static Point getMiddlePoint(int width, int height)
	{
		return new Point(WarGauge.getMiddleX(width), WarGauge.getMiddleY(height));
	}

	public synchronized void setFullscreen(boolean checked) 
	{
		if (checked)
		{
			/*
			 * TODO
			 * Complete actual fullscreen borderless
			 */
			window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
		else
		{
			window.setExtendedState(JFrame.NORMAL);
		}
	}
}

