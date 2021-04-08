package core.CreateKeyStream;

import core.MersenneTwister.MersenneTwister;

import java.util.ArrayList;
import java.util.List;

public class CreateKeyStream {
    List<Object> KeyStream = new ArrayList<Object>();
    long filesize;

    public CreateKeyStream (long fileSize) {
        this.filesize = fileSize;
    }

    public List<Object> CreateStream(int[] key) {
        MersenneTwister r;
        r = new MersenneTwister(key);

        for (int count = 0; count < this.filesize ; count++) {
            Byte l = r.nextByte();
            KeyStream.add(l);
        }

        return KeyStream;
    }
}