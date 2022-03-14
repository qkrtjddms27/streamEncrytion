package core.FileInOutput;

import java.util.List;

public interface FileInOutput {
    long inputFileSize();
    List<Integer> readFile();
    void writeFile(Byte cypertext);

}
