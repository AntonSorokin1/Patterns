package entity.states;

import entity.AudioPlayer;
import entity.State;

public class LockedState extends State {
    public LockedState(AudioPlayer player) {
        super(player);
    }

    @Override
    public void clickLock() {
        player.changeState(new ReadyState(player));
    }

    @Override
    public void clickPlay() {
        // Do nothing
    }

    @Override
    public void clickNext() {
        // Do nothing
    }

    @Override
    public void clickPrevious() {
        // Do nothing
    }
}
