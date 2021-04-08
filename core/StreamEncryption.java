package core;

import core.CreateKeyStream.CreateKeyStream;
import core.EDcrption.EDcrptionImpl;
import core.FileInOutput.FileInOutputImpl;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class StreamEncryption { // EDcrption
    public void main(String[] args) {
        List<Object> KeyStream = new ArrayList<Object>();
        List<Object> inputData = new ArrayList<Object>();
        File out = new File(args[5]);

        if (args[1].length() > 80) //key 값 처리
        {
            System.out.println("키 길이가 초과입니다. 최대 80글자");
        }
        int[] key = new int[80];

        for (int count = 0 ; count <args[1].length(); count++) {
            key[count] = args[1].charAt(count);
        }

        if (out.exists()) {
            System.out.println("이미 동일한 이름의 출력파일이 존재합니다.");
            System.exit(0);
        }

        if (args[3] == args[5]) {
            System.out.println("입력파일과 출력파일의 이름이 같습니다.");
            System.exit(0);
        }


        EDcrptionImpl ED = new EDcrptionImpl();

        FileInOutputImpl FIO = new FileInOutputImpl(args[3], args[5]);
        long fileSize = FIO.inputFileSize();

        CreateKeyStream Stream = new CreateKeyStream(fileSize);

        long befor_time = System.nanoTime();
        KeyStream = Stream.CreateStream(key);
        long after_time = System.nanoTime();
        long key_time = after_time - befor_time;
        inputData = FIO.readFile();

        befor_time = System.nanoTime();
        for(int count = 0 ; count < inputData.size() ; count++)
        {
            FIO.writeFile(ED.EDcrption((Byte)inputData.get(count), (Byte)KeyStream.get(count)));
        }
        after_time = System.nanoTime();

        for(int count = 0 ; count < inputData.size() ; count++)
        {
            System.out.print(KeyStream.get(count) + " ");
            if (count % 10 == 9) System.out.println();
            if (count >= 99) break;
        }
        System.out.println("키스트림 사이즈 : " + KeyStream.size());
        System.out.println("키 생성 소요 시간 : " + (float)key_time/1000000000);
        System.out.println("암호화 소요 시간 : " + (float)(after_time-befor_time)/1000000000);
    }
}

