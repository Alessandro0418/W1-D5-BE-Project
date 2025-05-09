package Project;

public class RegistrazioneAudio extends ElementoMultimediale implements Riproducibile{
    private int durata;
    private int volume;

    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }

    public void alzaVolume(){
        volume++;
    }
    public void abbassaVolume(){
        if (volume > 0) volume--;
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + "!".repeat(volume));
        }
    }
}
