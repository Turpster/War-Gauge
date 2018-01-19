package packet;

public enum PacketType
{
    PACKET_LOGIN,
    PACKET_LOGIN_VALIDATE;

    public String getLoginID()
    {
        switch (this)
        {
            case PACKET_LOGIN:
                return "01";
            case PACKET_LOGIN_VALIDATE:
                return "02";
            default:
                return "00";
        }
    }
}
