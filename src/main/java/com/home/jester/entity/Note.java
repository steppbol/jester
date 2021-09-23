package com.home.jester.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;


@Data
@SuperBuilder
@ToString
@EqualsAndHashCode(callSuper = true)
@Table(value = "notes")
public class Note extends BaseEntity {
    @Column("name")
    private String name;
    @Column("context")
    private String context;
    @Column("description")
    private String description;
    @CreatedDate
    @Column("created_date")
    private LocalDateTime createdDate;
    @LastModifiedDate
    @Column("updated_date")
    private LocalDateTime updatedDate;
    @Transient
    private List<Attribute> attributes;
}
