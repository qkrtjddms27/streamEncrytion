package core.FileInOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileInOutputImpl implements FileInOutput {

    FileOutputStream fos;
    FileInputStream fis;
    DataOutputStream dos;
    File fi;
    File fo;
    List<Integer> inputData = new ArrayList<>();

    public FileInOutputImpl(String inputPath, String outputPath) {
        try {
            this.fos = new FileOutputStream(outputPath);
            this.fis = new FileInputStream(inputPath);
            this.dos = new DataOutputStream(fos);
            this.fi = new File(inputPath);
            this.fo = new File(outputPath);
        }	catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public long inputFileSize() {
        return fi.length();
    }

    public List<Integer> readFile(){
        try {
            for(int count=0 ; count < fi.length() ; count++) {
                inputData.add((fis.read()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputData;
    }

    public void writeFile(Byte ciphertext) { // 내용 추가 파일 생성 x
        try {
            dos.writeByte(ciphertext);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}