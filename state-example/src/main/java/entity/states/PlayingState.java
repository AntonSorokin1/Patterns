package entity.states;

import entity.AudioPlayer;
import entity.State;

public class PlayingState extends State {
    public PlayingState(AudioPlayer player) {
        super(player);
    }

    @Override
    public void clickPlay() {
        player.stop();
        player.changeState(new ReadyState(player));
    }
}
