package packet;

import java.io.Serializable;

public abstract class Packet implements Serializable
{
    String codename;

    public Packet(String codename)
    {
        this.codename = codename;
    }
}
