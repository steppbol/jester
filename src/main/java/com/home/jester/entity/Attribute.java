package com.home.jester.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Builder
@ToString
@EqualsAndHashCode(callSuper = true)
@Table(value = "attributes")
public class Attribute extends BaseEntity {
    @Column("note_id")
    private UUID noteId;
    @Column("name")
    private String name;
    @Column("value")
    private String value;
}
