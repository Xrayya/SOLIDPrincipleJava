package main.L.before;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;

/**
 * Document
 */
public class Document {
    private String data;
    private String fullPathFileName;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFullPathFileName() {
        return fullPathFileName;
    }

    public void setFullPathFileName(String fullPathFileName) {
        this.fullPathFileName = fullPathFileName;
    }

    public void open() {
        this.data = "";
        try {
            File file = new File(this.fullPathFileName);
            InputStream in = new FileInputStream(file);
            int c;
            while ((c = in.read()) != -1) {
                this.data += (char) c;
            }
            in.close();
        } catch (Exception e) {
            this.data = null;
        }
    }

    public void save() {
        try {
            FileWriter myWriter = new FileWriter(fullPathFileName);
            myWriter.write(data);
            myWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
