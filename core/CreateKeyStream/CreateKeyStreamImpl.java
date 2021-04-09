package core.CreateKeyStream;

import core.MersenneTwister.MersenneTwister;

import java.util.ArrayList;
import java.util.List;

public class CreateKeyStreamImpl implements CreateKeyStream{
    ArrayList<Integer> KeyStream = new ArrayList<>();
    long filesize;

    public CreateKeyStreamImpl(long fileSize) {
        this.filesize = fileSize;
    }

    public List<Integer> CreateStream(int[] key) {
        MersenneTwister r;
        r = new MersenneTwister(key);

        for (int count = 0; count < this.filesize ; count++) {
            Byte l = r.nextByte();
            KeyStream.add(l);
        }

        return KeyStream;
    }
}