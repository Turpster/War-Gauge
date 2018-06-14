package packet;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class PacketLogin extends Packet
{
    private static final long serialVersionUID = 1L;
	
    String username;
    String password;

    public PacketLogin(String username, String password)
    {
        super("01");
        this.username = username;
        this.password = PacketLogin.md5Enc(password);
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }


    public static String md5Enc(String target)
    {
        Mac sha256_HMAC = null;
        try
        {
            sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec("1234".getBytes(), "HmacSHA256");
            sha256_HMAC.init(secretKey);
        } catch (InvalidKeyException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        byte[] hash = sha256_HMAC.doFinal(target.getBytes());
        String check = HexBin.encode(hash);
        return new String(check);
    }
}
