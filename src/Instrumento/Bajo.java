package Instrumento;

import javax.sound.midi.Instrument;

public class Bajo extends Instrumento{

    @Override
    public void tocar() {
        System.out.println("Tocar Bajo");
    }
}
