import java.io.Serializable;
import java.util.Comparator;

public class Page implements Serializable, Comparable<Page> {
    public String url;
    private int urlID;
    public static final long serialVersionUID = -1827677255104766839L; //from documentation

    Page(String url, int urlID) {
        this.url = url;
        this.urlID = urlID;
    }

    public int getURLID() {
        return urlID;
    }

    public String getURL() {
        return url;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Page pageObj = (Page) obj; //convert obj to type Page
            return (pageObj.getURL().equals(this.url) || pageObj.getURLID() == this.urlID); //return true if URL or URLID is the same
        } catch (Exception e) {} //Catch error in obj conversion
        return false; //return false in all other cases
    }

    public int compareTo(Page candidate) { //implemented per JAVADOC
        if (candidate.getURLID() < this.urlID)
            return -1;
        if (candidate.getURLID() == this.urlID)
            return 0;
        return 1;
    }
}