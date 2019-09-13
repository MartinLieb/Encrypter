package martinencrypter;

import javafx.scene.control.TextArea;

import java.awt.event.ActionEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {

    String path = "C:\\Users\\Pessi\\Desktop\\text.txt";

    public TextArea log;

    public void encryptButton(javafx.event.ActionEvent actionEvent) {
        String text = log.getText();
        String encryptedText = customEncryption(text);
        log.setText(encryptedText);
    }

    public void decryptButton (javafx.event.ActionEvent actionEvent){
        String encryptedText = log.getText();
        String decryptedText = customDecryption(encryptedText);
        log.setText(decryptedText);
    }

    public void loadFile(javafx.event.ActionEvent actionEvent){
        String text = readFile();
        log.setText(text);
    }

    public String customEncryption(String string){
        char[] chars = string.toCharArray();
        String encryptedText = "";
        for (int i = 0; i < chars.length; i++) {
            encryptedText +=(char) (((int) chars[i]) +5);

        }
        writeFile(encryptedText);
        return encryptedText;
    }

    public String customDecryption(String string){
        char[] chars = string.toCharArray();
        String decryptedText = "";
        for (int i = 0; i < chars.length; i++) {
            decryptedText +=(char) (((int) chars[i]) -5);

        }
        writeFile(decryptedText);
        return decryptedText;
    }

    public String readFile(){
        String document = "";
        try (FileReader fileReader = new FileReader(path)) {
            int txt = fileReader.read();
            while (txt != -1) {
                document += (char) txt;
                txt = fileReader.read();
            }
        }
            catch (IOException e){
                e.printStackTrace();
            }
        return document;

        }

        public void writeFile(String text){
        try(FileWriter fileWriter = new FileWriter(path, false)){
            fileWriter.write(text);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
