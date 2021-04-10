package core.CreateKeyStream;

import core.MersenneTwister.MersenneTwister;

import java.util.ArrayList;
import java.util.List;

public class CreateKeyStreamImpl implements CreateKeyStream{
    ArrayList<Byte> KeyStream = new ArrayList<>();
    long fileSize;

    public CreateKeyStreamImpl(long fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public ArrayList<Byte> CreateStream(int[] key) {
        MersenneTwister mt = new MersenneTwister(key);

        for (int count = 0; count < this.fileSize ; count++) {
            Byte b = mt.nextByte();
            KeyStream.add(b);
        }

        return KeyStream;
    }

}