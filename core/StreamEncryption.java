package core;

import core.CreateKeyStream.CreateKeyStreamImpl;
import core.EDcrption.EDcrption;
import core.FileInOutput.FileInOutputImpl;
import core.AppConfig;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class StreamEncryption { // EDcrption
    public void main(String[] args) {
        AppConfig ap = new AppConfig();
        EDcrption ed = ap.eDcrption();
        List<Byte> KeyStream = new ArrayList<>();
        List<Integer> inputData = new ArrayList<>();
        int[] key = new int[args[1].length()];
        File out = new File(args[5]);

        long afterTime, beforeTime = System.nanoTime();
        long keyTime;

        if (args[1].length() > 80) //key 값 처리
        {
            System.out.println("키 길이가 초과입니다. 최대 80글자");
        }

        for (int count = 0 ; count <args[1].length(); count++) { // 키 생성
            key[count] = args[1].charAt(count);
        }

        if (out.exists()) {
            System.out.println("이미 동일한 이름의 출력파일이 존재합니다.");
            System.exit(0);
        }

        if ( args[3].equals(args[5]) ) {
            System.out.println("입력파일과 출력파일의 이름이 같습니다.");
            System.exit(0);
        }




        FileInOutputImpl FIO = new FileInOutputImpl(args[3], args[5]);
        long fileSize = FIO.inputFileSize();

        CreateKeyStreamImpl Stream = new CreateKeyStreamImpl(fileSize);


        KeyStream = Stream.CreateStream(key);

        keyTime = afterTime - beforeTime;
        inputData = FIO.readFile();


        for(int count = 0 ; count < inputData.size() ; count++)
        {
            FIO.writeFile(ED.EDCrption((Byte)inputData.get(count), (Byte)KeyStream.get(count)));
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

