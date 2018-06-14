package packet;

import java.io.Serializable;

public abstract class Packet implements Serializable
{
    private static final long serialVersionUID = 1L;
	
    String codename;

    public Packet(String codename)
    {
        this.codename = codename;
    }
}
