package me.Skippysunday12.Commands.backbone;

public class OnlinePlayerException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = -5067103089159783475L;

    public OnlinePlayerException(String message) {
        super(message);
    }

    public OnlinePlayerException(String message, Throwable t) {
        super(message, t);
    }


}
