package com.pablozoani.webapp.layers.business.datatransferobject;

import com.pablozoani.webapp.layers.model.Academy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class AcademyDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String name;

    public AcademyDTO(String name) { this.name = name; }

    public static synchronized Academy toEntity(AcademyDTO dto) {

        if (dto == null) return null;

        final Academy entity = new Academy(dto.getName());

        entity.setId(dto.getId());

        return entity;
    }

    public static synchronized AcademyDTO toDTO(Academy entity) {

        if (entity == null) return null;

        final AcademyDTO dto = new AcademyDTO(entity.getName());

        dto.setId(entity.getId());

        return dto;
    }

    @Override
    public String toString() {
        return "AcademyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
