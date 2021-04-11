package core.EDcrption;

public class EDcrptionImpl implements EDcrption{

    public byte EDCrption(Byte inputFileData, Byte keyStream) {
        return (byte) (inputFileData ^ keyStream);
    }

}