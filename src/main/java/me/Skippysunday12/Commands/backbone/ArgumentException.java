package me.Skippysunday12.Commands.backbone;

public class ArgumentException extends Exception{

    private static final long serialVersionUID = 5941595947947991481L;

    public ArgumentException(String message) {
        super(message);
    }

    public ArgumentException(String message, Throwable t) {
        super(message, t);
    }
}
