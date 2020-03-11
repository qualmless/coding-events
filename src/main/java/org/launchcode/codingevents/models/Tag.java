package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Tag extends AbstractEntity {

    @NotBlank(message = "Tag name is required")
    @Size(max = 50, message = "Tag can be no more than 50 characters")
    private String name;

    public Tag(@NotBlank(message = "Tag name is required") @Size(max = 50, message = "Tag can be no more than 50 characters") String name) {
        this.name = name;
    }

    public Tag(){}

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return "#" + name + " ";
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
