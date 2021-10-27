package com.home.jester.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@NamedEntityGraph(name = "note.attributes",
        attributeNodes = @NamedAttributeNode("attributes")
)
@Entity
@DynamicUpdate
@Table(name = "notes")
public class Note extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "context", nullable = false)
    private String context;
    @Column(name = "description")
    private String description;
    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private ZonedDateTime createdDate;
    @LastModifiedDate
    @Column(name = "updated_date", nullable = false)
    private ZonedDateTime updatedDate;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JoinColumn(name = "note_id", nullable = false)
    private List<Attribute> attributes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Note note = (Note) o;
        return getId() != null && Objects.equals(getId(), note.getId())
               && Objects.equals(getName(), note.getName())
               && Objects.equals(getContext(), note.getContext());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getName(), getContext());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
               "id = " + getId() + ", " +
               "name = " + getName() + ", " +
               "context = " + getContext() + ", " +
               "description = " + getDescription() + ", " +
               "createdDate = " + getCreatedDate() + ", " +
               "updatedDate = " + getUpdatedDate() + ")";
    }
}

