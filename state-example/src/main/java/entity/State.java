package entity;

import entity.states.LockedState;

public abstract class State {
    protected AudioPlayer player;

    protected State(AudioPlayer player) {
        this.player = player;
    }

    public void clickLock() {
        player.changeState(new LockedState(player));
    }

    public abstract void clickPlay();

    public void clickNext() {
        player.nextSong();
    }

    public void clickPrevious() {
        player.previousSong();
    }
}
