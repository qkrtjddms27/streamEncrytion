package core;

import core.CreateKeyStream.CreateKeyStream;
import core.CreateKeyStream.CreateKeyStreamImpl;
import core.EDcrption.EDcrption;
import core.EDcrption.EDcrptionImpl;
import core.FileInOutput.FileInOutput;
import core.FileInOutput.FileInOutputImpl;

public class AppConfig {

    public CreateKeyStream createKeyStream () {
        return new CreateKeyStreamImpl();
    }

    public EDcrption eDcrption() {
        return new EDcrptionImpl();
    }

    public FileInOutput fileInOutput() {
        return new FileInOutputImpl();
    }
}
