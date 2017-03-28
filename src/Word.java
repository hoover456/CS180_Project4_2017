import java.io.Serializable;
import java.util.List;

public class Word implements Serializable {

    private String word;
    private List<Integer> postings;
    public static final long serialVersionUID = -3696191086353573895L; //from documentation

    public Word(String word, int urlID) {
        this.word = word;
        this.postings.add(urlID);
    }

    public void addURLID(int urlID) {
        this.postings.add(urlID);
    }

    public String getWord() {
        return word;
    }

    public List<Integer> getList() {
        return postings;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Word wordObj = (Word) obj; // Convert obj to type Word
            return (wordObj.getWord().equals(this.getWord())); //return true if the word strings are the same
        } catch (Exception e) {} // catch error in conversion of object
        return false; //return false in any other case
    }
}