import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Parser {

    public Document getDocument(String url) throws ParseException{
        if(url==null) //throw error if url is null
            throw new ParseException("getDocument() failed. String url is null.");
        if(url=="") //throw error if url is empty
            throw new ParseException("getDocument() failed. String url is empty.");

        Document d; //declare document object
        try {
            d = Jsoup.connect(url).get(); //try to get the document from the url via JSoup
        } catch (Exception e) {
            e.printStackTrace();
            throw new ParseException("getDocument() failed. Connection failed."); //throw connection failed error if JSoup couldn't connect to the site
        }
        if(d==null){ //throw an error if the document returned by JSoup is null
            throw new ParseException("getDocument() failed: Document is null.");
        }
        return d; //return the document

    }

    public Elements getLinks(Document doc) throws ParseException{
        try {
            return doc.select("a[href]"); // gets link from HTML of webpage via JSoup
        } catch (NullPointerException e) {
            throw new ParseException("getLinks() failed. Document parameter is null.");
        }
    }

    public String getBody(Document doc) throws ParseException{
        try{
            return doc.body().text(); //gets text betweeb <body></body> tags of an HTML file via JSoup
        } catch (NullPointerException e){
            throw new ParseException("getBody() failed. Document parameter is null.");
        }
    }


}
