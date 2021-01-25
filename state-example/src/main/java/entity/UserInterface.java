package entity;

public class UserInterface {
    private final AudioPlayer player;

    public UserInterface(AudioPlayer player) {
        this.player = player;
    }

    public AudioPlayer getPlayer() {
        return player;
    }

    public void clickLock() {
        player.clickLock();
    }

    public void clickPlay() {
        player.clickPlay();
    }

    public void clickNext() {
        player.clickNext();
    }

    public void clickPrevious() {
        player.clickPrevious();
    }
}
