package com.home.jester.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.UUID;

@Data
@SuperBuilder
public abstract class BaseEntity {
    @Id
    @Column("id")
    private UUID id;
}
