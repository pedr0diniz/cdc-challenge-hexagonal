package br.com.zinid.returnal.adapter.category.output;

import br.com.zinid.returnal.application.domain.category.Category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "category")
public class CategoryEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Deprecated
    public CategoryEntity() {
    }

    // For the BookEntity to use while retrieving the id.
    public CategoryEntity(Long id) {
        this.id = id;
    }

    public CategoryEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Category toDomain() {
        return new Category(name);
    }

    public static CategoryEntity convertFromDomain(Category category) {
        return new CategoryEntity(category.getName());
    }
}
