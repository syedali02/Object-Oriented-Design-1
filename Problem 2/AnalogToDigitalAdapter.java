package problem2;

import java.util.Arrays;

public class AnalogToDigitalAdapter implements DigitalSignal {
    private AnalogSignal analogSignal;
    private byte[] digitalData;
    private float threshold;
    static final float DEFAULT_THRESHOLD= (float) 1.0;

    public AnalogToDigitalAdapter(AnalogSignal analogSignal,float threshold){
    this.analogSignal=analogSignal;
    this.threshold=threshold;
}
   public AnalogToDigitalAdapter(AnalogSignal analogSignal){
    this(analogSignal,DEFAULT_THRESHOLD);
}
  public byte[] getDigital(){
    float [] analog =analogSignal.getAnalog();
    byte [] digital = new byte[analog.length];
    int i=0;
    while(i<analog.length) {
        if (analog[i] > threshold)
            digital[i] = 1;
        else
            digital[i] = 0;
    }
    return digital;
    }
   public void setDigital(byte[] data){
     throw new UnsupportedOperationException("Goal is to convert analog to digital");
    }
    public String sendDigital(){
      digitalData=getDigital();
        return digitalData.toString();
    }
    public void setAnalogData(float [] data){
       analogSignal.setAnalog(data);
    }
}
