package core.FileInOutput;

import java.util.List;

public interface FileInOutput {
    long inputFileSize();

    List<Object> readFile();

    void writeFile(Byte cypertext);

}
