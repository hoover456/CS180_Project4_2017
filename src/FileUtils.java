/**
 * Created by James on 4/6/2017.
 */
import java.io.*;
import java.util.List;

public class FileUtils {

    public boolean saveWordTable(List<Word> wordTable, String filePath) {
        ObjectOutputStream outStream = null;
        if (wordTable == null) {
            return false;
        }
        try {
            outStream = new ObjectOutputStream(new FileOutputStream(new File (filePath)));
        } catch(IOException | NullPointerException e) {
            e.printStackTrace();
            return false;
        }

        try {
            outStream.writeObject(wordTable);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return false;
        }
        try {
            outStream.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    public boolean savePageTable(List<Page> pageTable, String filePath) {
        ObjectOutputStream outStream = null;
        try {
            outStream = new ObjectOutputStream(new FileOutputStream(new File (filePath)));
            if (pageTable == null) {
                return false;
            }
        } catch(IOException | NullPointerException e) {
            e.printStackTrace();
            return false;
        }

        try {
            outStream.writeObject(pageTable);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return false;
        }
        try {
            outStream.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Word> getWordList(String filePath) {
        ObjectInputStream inStream = null;
        List<Word> wordList = null;
        try {
            inStream = new ObjectInputStream(new FileInputStream(new File (filePath)));
        } catch(IOException | NullPointerException e) {
            e.printStackTrace();
        }

        try {
            wordList = (List<Word>) inStream.readObject();
        } catch (IOException | ClassNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }
        try {
            inStream.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return wordList;
    }

    public List<Page> getPageList(String filePath) {
        ObjectInputStream inStream = null;
        List<Page> pageList = null;
        try {
            inStream = new ObjectInputStream(new FileInputStream(new File (filePath)));
        } catch(IOException | NullPointerException e) {
            e.printStackTrace();
        }

        try {
            pageList = (List<Page>) inStream.readObject();
        } catch (IOException | ClassNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }
        try {
            inStream.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return pageList;
    }
}