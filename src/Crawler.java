import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;


public class Crawler {
    static int currentID;
    static String domain;
    static int limit;
    static List<Page> parsed;
    static Parser parser;
    MyQueue toParse;
    static int totalURLs;
    static List<String> visited;
    static List<Word> words;

    Crawler(String seed, String domain, int limit){
        Crawler.domain=domain;
        Crawler.limit=limit;
        Crawler.totalURLs=-1;
        Crawler.currentID=0;
        Crawler.parser = new Parser();
        this.toParse = new MyQueue();
        Crawler.parsed = new ArrayList<>();
        Crawler.visited = new ArrayList<>();
        Crawler.words = new ArrayList<>();
        addToQueue(seed);
    }

    public void addPageToList(Page p){
        Crawler.parsed.add(p);
    }

    public void addToQueue(String url){
        if (toParse.size() == 0) {
            toParse.add(url);
            Crawler.totalURLs++;
        }
        else {
            if(!visited.contains(url)){
                toParse.add(url);
                Crawler.totalURLs++;
            }
        }
    }

    public void addWordToList(String word, int id){
        Crawler.words.add(new Word(word, id));
    }

    public void crawl(){
        while(!toParse.isEmpty()){
            String url = (String) toParse.remove().getData();
            if(! Crawler.visited.contains(url)) try {
                this.parse(Crawler.parser.getDocument(url),currentID);
                this.addPageToList(new Page(url, Crawler.currentID));
                visited.add(url);
                Crawler.currentID++;
            } catch (ParseException E) {
                Crawler.currentID++;
            }
        }
    }

    public boolean isInDomain(String url){
        return url.contains(Crawler.domain);
    }

    public boolean isValidURL(String url){
        return url.contains("http://") || url.contains("https://");
    }

    public boolean parse(Document doc, int id){
        try {
            parseLinks(doc);
            parseText(doc, id);
        } catch(ParseException E){
            return false;
        }
        return true;
    }

    public void parseLinks(Document doc) throws  ParseException{
        for (Element link : parser.getLinks(doc)) {
            String url = link.attr("abs:href");
            if(this.isValidURL(url) && this.isInDomain(url) && totalURLs <= Crawler.limit)
                addToQueue(url);
        }
    }

    public void parseText(Document doc, int id) throws ParseException{
    // To remove puncuation instert replaceAll("[^a-zA-Z ]", "")
        for (String s : parser.getBody(doc).toLowerCase().split("\\s+")){
            addWordToList(s, id);
        }
    }
}
