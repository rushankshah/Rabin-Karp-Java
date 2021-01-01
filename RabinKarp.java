public class RabinKarp {
    public static void main(String[] args) {
        String text = "RUSHANKSHAH";
        String pattern = "SHA";
        // Let's assume any prime number for taking the mod value, so that the Hash
        // Pattern stays in Integer range
        int p = 13;
        int patternHash = 0, textHash = 0;
        for (int i = 0; i < pattern.length(); i++) {
            // Assuming that the range of characters in input is 256
            patternHash = ((256 * patternHash) + pattern.charAt(i)) % p;
            textHash = ((256 * textHash) + text.charAt(i)) % p;
        }
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            if (patternHash == textHash) {
                int j;
                for (j = 0; j < pattern.length(); j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }
                if (j == pattern.length())
                    System.out.println("Pattern found at index " + (i + 1));
            }

            if (i < text.length() - pattern.length()) {
                textHash = (256 * (textHash - (text.charAt(i) * (int) (Math.pow(256, pattern.length() - 1) % p)))
                        + text.charAt(i + pattern.length())) % p;
                if (textHash < 0)
                    textHash = textHash + p;
            }
        }
    }
}