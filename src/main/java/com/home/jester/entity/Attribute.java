package com.home.jester.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@SuperBuilder
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
