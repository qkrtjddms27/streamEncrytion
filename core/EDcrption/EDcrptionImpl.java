package core.EDcrption;

public class EDcrptionImpl {

    public byte EDcrption(Byte inputFiledata, Byte KeyStream) {
        return (byte) (inputFiledata ^ KeyStream);
    }

}