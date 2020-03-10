package problem2;

import java.util.Arrays;

public class FloatAnalogSignal implements AnalogSignal
{
    private float[] data;

    public FloatAnalogSignal(float[] data) {
        this.data = data;
    }

    @Override
    public float[] getAnalog() {
        return data;
    }

    @Override
    public void setAnalog(float[] data) {
        this.data = data;
    }

    @Override
    public String sendAnalog() {
        return Arrays.toString(getAnalog());
    }
}
