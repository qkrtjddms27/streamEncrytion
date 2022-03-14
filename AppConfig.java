package core;

import core.CreateKeyStream.CreateKeyStream;
import core.CreateKeyStream.CreateKeyStreamImpl;
import core.EDCrption.EDCrption;
import core.EDCrption.EDCrptionImpl;
import core.FileInOutput.FileInOutput;
import core.FileInOutput.FileInOutputImpl;

public class AppConfig {

    public CreateKeyStream createKeyStream (long fileSize) {
        return new CreateKeyStreamImpl(fileSize);
    }

    public EDCrption edCrption() {
        return new EDCrptionImpl();
    }

    public FileInOutput fileInOutput(String inputFileData, String keyStream) {
        return new FileInOutputImpl(inputFileData, keyStream);
    }
}
