package com.home.jester.util;

import com.home.jester.dto.NoteDto;
import com.home.jester.entity.Note;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePatchEntity(Note source, @MappingTarget Note target);

    NoteDto toDto(Note note);

    Note fromDto(NoteDto noteDto);
}
