package packet;

public class PacketLoginValidate extends Packet
{
    private static final long serialVersionUID = 1L;
	
    int SessionID;

    public PacketLoginValidate(int SessionID)
    {
        super("02");
        this.SessionID = SessionID;
    }

    public int getSessionID()
    {
        return SessionID;
    }
}
