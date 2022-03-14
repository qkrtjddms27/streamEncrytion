package core;

import core.CreateKeyStream.CreateKeyStream;
import core.EDCrption.EDCrption;
import core.FileInOutput.FileInOutput;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public void main(String[] args) throws Exception {
        AppConfig ap = new AppConfig();
        EDCrption ed = ap.edCrption();
        List<Byte> KeyStream = new ArrayList<>();
        List<Integer> inputData = new ArrayList<>();
        int[] key = new int[args[1].length()];
        File out = new File(args[5]);

        if (args[1].length() > 80) { //key 값 처리
            throw new IOException("키 길이가 초과되었습니다. 최대 80글자를 입력해주세요.");
        }

        for (int count = 0 ; count <args[1].length(); count++) { // 키 생성
            key[count] = args[1].charAt(count);
        }

        if (out.exists()) {
            throw new IOException("이미 동일한 이름의 출력파일이 존재합니다.");
        }

        if (args[3].equals(args[5])) {
            throw new IOException("입력파일과 출력파일의 이름이 같습니다.");
        }

        /*
        * 파일 입출력 시작.
        * */
        FileInOutput FIO = ap.fileInOutput(args[3], args[5]);
        long fileSize = FIO.inputFileSize();

        // keySteam 생성
        CreateKeyStream createKeyStream = ap.createKeyStream(fileSize);
        KeyStream = createKeyStream.CreateStream(key);
        inputData = FIO.readFile();

        for(int count = 0; count < inputData.size(); count++) {
            FIO.writeFile(ed.EDCrption((Byte)inputData.get(count), (Byte)KeyStream.get(count)));
        }

        for(int count = 0; count < inputData.size(); count++) {
            System.out.print(KeyStream.get(count) + " ");
            if (count % 10 == 9) System.out.println();
            if (count >= 99) break;
        }
    }
}

