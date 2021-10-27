package com.home.jester.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NoteDto {
    @JsonAlias({"ID"})
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("context")
    private String context;
    @JsonProperty("description")
    private String description;
    @JsonAlias({"createdDate"})
    @JsonProperty("created_date")
    private ZonedDateTime createdDate;
    @JsonAlias({"updatedDate"})
    @JsonProperty("updated_date")
    private ZonedDateTime updatedDate;
    @JsonProperty("attributes")
    private List<AttributeDto> attributes;
}
