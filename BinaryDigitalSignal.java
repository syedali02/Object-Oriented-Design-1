package problem2;

import java.util.Arrays;

public class BinaryDigitalSignal implements DigitalSignal
{
    private byte[] data;

    public BinaryDigitalSignal(byte[] data) {
        this.data = data;
    }

    @Override
    public byte[] getDigital() {
        return data;
    }

    @Override
    public void setDigital(byte[] data) {
        this.data = data;
    }

    @Override
    public String sendDigital() {
        return Arrays.toString(getDigital());
    }
}
