package demo.Profile.exception;

public class ProfileNotFoundException extends RuntimeException {

    public ProfileNotFoundException(String msg) {
        super(msg);
    }
}