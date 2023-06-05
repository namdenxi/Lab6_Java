package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name")
        @NotEmpty(message = "Name not empty")
        private String name;

        @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
        @ToString.Exclude
        private List<Book> books = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
                        return false;
                Category category = (Category) o;
                return getId() != null && Objects.equals(getId(),
                        category.getId());
        }
        @Override
        public int hashCode() {
                return getClass().hashCode();
        }
}
