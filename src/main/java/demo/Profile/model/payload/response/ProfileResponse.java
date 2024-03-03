package demo.Profile.model.payload.response;

import java.time.LocalDate;

public record ProfileResponse(String firstName,
                              String lastName,
                              LocalDate bornOn,
                              String imageUrl,
                              String thumbnailUrl,
                              Long gold,
                              Long credits) {
}