package demo.Profile.model.event;

import demo.Profile.annotation.KafkaPayload;

import java.time.LocalDate;

@KafkaPayload
public record RegistrationEvent(Long id, String firstName, String lastName, LocalDate bornOn) {
}