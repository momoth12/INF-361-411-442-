
////////// ne pas modifier
import java.security.MessageDigest;

public class H {

  private static final MessageDigest MD = init();

  private static MessageDigest init() {
    try {
      return MessageDigest.getInstance("MD5");
    } catch (java.security.NoSuchAlgorithmException e) {
      System.err.println("Erreur initialisation MD5");
      return null;
    }
  }

  @SuppressWarnings("unused")
  private static int counterH = 0; // VALIDATION

  public static String hasher(String mdp) {
    if (mdp == null)
      throw new IllegalArgumentException("argument of H.hasher is null");
    return hasher(mdp.getBytes());
  }

  private static final char[] HEX = "0123456789ABCDEF".toCharArray();

  public static String toHex(byte[] bytes) {
    char[] chars = new char[2 * bytes.length];
    for (int i = 0; i < bytes.length; ++i) {
      int v = bytes[i] & 0xFF;
      chars[i * 2] = HEX[v >>> 4];
      chars[i * 2 + 1] = HEX[v & 0x0F];
    }
    return new String(chars);
  }

  public static String hasher(byte[] mdp) {
    ++counterH; // VALIDATION
    if (mdp == null)
      throw new IllegalArgumentException("argument of H.hasher is null");
    MD.update(mdp);
    byte[] digest = MD.digest();
    return toHex(digest);
  }

  public static boolean est_mdp(String hash, String mdp) {
    if (mdp == null)
      throw new IllegalArgumentException("argument mdp of H.est_mdp is null");
    return est_mdp(hash, mdp.getBytes());
  }

  public static boolean est_mdp(String hash, byte[] mdp) {
    if (mdp == null)
      throw new IllegalArgumentException("argument mdp of H.est_mdp is null");
    String myHash = hasher(mdp);
    return myHash.equals(hash);
  }

  public static String trouver_mdp(String hash, String mot_racine, String carac) {
    if (est_mdp(hash, mot_racine))
      return mot_racine;
    byte[] buffer = mot_racine.getBytes();
    byte[] chars = carac.getBytes();
    for (int i1 = 0; i1 < buffer.length; i1++) {
      byte save1 = buffer[i1];
      for (int c1 = 0; c1 < chars.length; c1++) {
        buffer[i1] = chars[c1];
        if (H.est_mdp(hash, buffer))
          return new String(buffer);
        for (int i2 = 0; i2 < buffer.length; i2++) {
          if (i2 == i1)
            continue;
          byte save2 = buffer[i2];
          for (int c2 = 0; c2 < chars.length; c2++) {
            buffer[i2] = chars[c2];
            if (H.est_mdp(hash, buffer))
              return new String(buffer);
          }
          buffer[i2] = save2;
        }
      }
      buffer[i1] = save1;
    }
    return null;
  }
}
