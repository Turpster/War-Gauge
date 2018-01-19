package packet;

public class PacketLoginValidate extends Packet
{
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
