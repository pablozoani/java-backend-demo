package com.pablozoani.webapp.layers.business.datatransferobject;

import com.pablozoani.webapp.layers.model.Academy;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class AcademyDTO {

    private Long id;

    private String name;

    private Set<CourseDTO> courses = new HashSet<>();

    public AcademyDTO(String name) {
        this.name = name;
    }

    public static synchronized Academy toEntity(AcademyDTO dto) {

        if (dto == null) return null;

        final Academy entity = new Academy(dto.getName());

        entity.setId(dto.getId());

        dto.getCourses()
           .forEach(courseDTO -> entity.addCourse(CourseDTO.toEntity(courseDTO)));

        return entity;
    }

    public static synchronized AcademyDTO toDTO(Academy entity) {

        if (entity == null) return null;

        final AcademyDTO dto = new AcademyDTO(entity.getName());

        entity.getCourses()
              .forEach(course -> dto.getCourses().add(CourseDTO.toDTO(course)));

        return dto;
    }
}
