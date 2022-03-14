package core.EDCrption;

public class EDCrptionImpl implements EDCrption {

    public byte EDCrption(Byte inputFileData, Byte keyStream) {
        return (byte) (inputFileData ^ keyStream);
    }

}