package nyc.c4q.yuliyakaleda;

/**
 * C4Q Access Code
 * Web Page Sanitizer
 * This class removes <script> tags and information they contain
 * Created by Yuliya Kaleda on 3/30/15.
 */

import java.net.URL;

public class WebPageSanitizer {

    public static String bodyUrl(String html) {
        //converts a string to a URL
        URL url = HTTP.stringToURL(html);

        //retrieves the body of a URL
        String contents = HTTP.get(url);
        return contents;
    }

    public static String sanitize(String html) {

        while (html.contains("<script")) {
            //get indexes of <script> tags
            int idx = html.indexOf("<script");
            int idxEnd = html.indexOf("</script>", idx);

            //set a substring btw the found indexes to delete
            String delStr = html.substring(idx, idxEnd + 9);
            html = html.replace(delStr, "");
        }
        return html;
    }

    public static void main(String[] args) throws Exception {
        String html = bodyUrl("https://www.google.com/");
        System.out.println(sanitize(html));
    }
}



