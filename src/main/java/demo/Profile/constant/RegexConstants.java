package demo.Profile.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegexConstants {

    public static final String NAME_REGEX = "^[A-Z][a-z]{2,29}$";
}