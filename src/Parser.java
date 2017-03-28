import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.print.Doc;
import java.io.IOException;
import java.lang.annotation.Documented;

public class Parser {

    public Document getDocument(String url) throws ParseException{
        if(url==null)
            throw new ParseException("getDocument() failed. String url is null.");
        if(url=="")
            throw new ParseException("getDocument() failed. String url is empty.");

        Document d;
        try {
            d = Jsoup.connect(url).get();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ParseException("getDocument() failed. Connection failed.");
        }
        if(d==null){
            throw new ParseException("getDocument() failed: Document is null.");
        }
        return d;

    }

    public Elements getLinks(Document doc) throws ParseException{
        try {
            return doc.select("a[href]");
        } catch (NullPointerException e) {
//            e.printStackTrace();
            throw new ParseException("getLinks() failed. Document parameter is null.");
        }
    }

    public String getBody(Document doc) throws ParseException{
        try{
            return doc.body().text();
        } catch (NullPointerException e){
            throw new ParseException("getBody() failed. Document parameter is null.");
        }
    }


}
