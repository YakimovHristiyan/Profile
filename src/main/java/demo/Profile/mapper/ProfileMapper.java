package demo.Profile.mapper;

import demo.Profile.model.entity.Profile;
import demo.Profile.model.event.RegistrationEvent;
import demo.Profile.model.payload.request.ProfileEditRequest;
import demo.Profile.model.payload.response.ProfileResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProfileMapper {

    Profile map(ProfileEditRequest profileEditRequest, @MappingTarget Profile profile);

    ProfileResponse map(Profile profile);

    Profile map(RegistrationEvent event);
}