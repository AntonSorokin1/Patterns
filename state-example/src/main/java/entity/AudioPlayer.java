package entity;

import entity.states.ReadyState;

public class AudioPlayer {
    private State state;

    public AudioPlayer() {
        this.state = new ReadyState(this);
    }

    public void changeState(State newState) {
        this.state = newState;
    }

    public State getState() {
        return state;
    }

    public void clickLock() {
        state.clickLock();
    }

    public void clickPlay() {
        state.clickPlay();
    }

    public void clickNext() {
        state.clickNext();
    }

    public void clickPrevious() {
        state.clickPrevious();
    }

    public void play() {
        // Some functionality
    }

    public void stop() {
        // Some functionality
    }

    public void nextSong() {
        // Some functionality
    }

    public void previousSong() {
        // Some functionality
    }
}
