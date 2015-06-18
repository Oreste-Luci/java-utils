import java.security.Provider;
import java.security.Security;
import java.util.Arrays;

public class ShowCryptoProviders
{
    public static void main(final String[] args)
    {
        final Provider[] providers = Security.getProviders();
        for (final Provider p : providers)
        {
            System.out.format("%s %s%s", p.getName(), p.getVersion(), System.getProperty("line.separator"));
            for (final Object o : p.keySet())
            {
                if (Arrays.asList(args).contains("-v"))
                {
                    System.out.format("\t%s : %s%s", o, p.getProperty((String)o), System.getProperty("line.separator"));
                }
            }
        }
    }
}