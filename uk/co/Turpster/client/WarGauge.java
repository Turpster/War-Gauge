package uk.co.Turpster.client;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import uk.co.Turpster.client.connection.ConnectionManager;
import uk.co.Turpster.client.menu.MenuHandler;
import uk.co.Turpster.client.user.Session;

public class WarGauge extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;

	public static int HEIGHT, WIDTH;

	@SuppressWarnings("unused")
	private Session session;
	public ConnectionManager connectionMang;
	public boolean running = false;
	private Thread gamethread;
	private MenuHandler menuHandler;
	Handler handler;
	int frames;
	int ticks;

	public WarGauge(String[] args, int width, int height)
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
			System.exit(1);
		}
		connectionMang = new ConnectionManager();

		session = new Session(connectionMang, username, password);

		WarGauge.WIDTH = width;
		WarGauge.HEIGHT = height;
	}

	private void initialiseGameVariables()
	{
		this.handler = new Handler();
		this.menuHandler = new MenuHandler();
		
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

}

