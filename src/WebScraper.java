import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String unused) {
        String[] splits = unused.split("\\s+");
        int count = 0;
        for (int i = 0; i < splits.length; i++) {
            if (splits[i] == "Prince" || splits[i] == "prince") {
                count++;
            } else if (splits[i] == "Prince," || splits[i] == "prince,") {
                count++;
            } else if (splits[i] == "Prince." || splits[i] == "prince.") {
                count++;
            }
        }
        System.out.println(count);
    }
}
System.out.println(main(urlToString("http://erdani.com/tdpl/hamlet.txt")));

