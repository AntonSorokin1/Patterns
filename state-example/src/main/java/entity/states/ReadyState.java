package entity.states;

import entity.AudioPlayer;
import entity.State;

public class ReadyState extends State {
    public ReadyState(AudioPlayer player) {
        super(player);
    }

    @Override
    public void clickPlay() {
        player.play();
        player.changeState(new PlayingState(player));
    }
}
