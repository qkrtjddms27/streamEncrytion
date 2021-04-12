package core.FileInOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileInOutputImpl implements FileInOutput{

    Byte len;
    FileOutputStream fos;
    FileInputStream fis;
    DataOutputStream dos;
    File fi;
    File fo;
    List<Object> inputData = new ArrayList<Object>();



    public FileInOutputImpl(Byte inputPath, Byte outputPath) {
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

    public List<Object> readFile(){
        try {

            for(int count=0 ; count < fi.length() ; count++)
            {
                inputData.add((byte)fis.read());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputData;
    }

    public void writeFile(Byte cypertext) { // 내용 추가 파일 생성 x
        try {
            dos.writeByte(cypertext);
        } catch(IOException e) {
            System.out.println(e);
        }
    }

}