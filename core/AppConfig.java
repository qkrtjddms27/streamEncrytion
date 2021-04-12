package core;

import core.CreateKeyStream.CreateKeyStream;
import core.CreateKeyStream.CreateKeyStreamImpl;
import core.EDcrption.EDcrption;
import core.EDcrption.EDcrptionImpl;
import core.FileInOutput.FileInOutput;
import core.FileInOutput.FileInOutputImpl;

public class AppConfig {

    public CreateKeyStream createKeyStream (long fileSize) {
        return new CreateKeyStreamImpl(fileSize);
    }

    public EDcrption eDcrption() {
        return new EDcrptionImpl();
    }

    public FileInOutput fileInOutput(Byte inputFileData, Byte keyStream) {
        return new FileInOutputImpl(inputFileData, keyStream);
    }
}
