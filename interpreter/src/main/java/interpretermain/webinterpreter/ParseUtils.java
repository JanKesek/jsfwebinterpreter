package interpretermain.webinterpreter;

import org.jsoup.Jsoup;

public class ParseUtils {
    public static String stripHtml(String sourceCode) {
        return Jsoup.parse(sourceCode).text();
    }
}
