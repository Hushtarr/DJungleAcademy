package com.djungleacademy.mapper;


import com.djungleacademy.dto.LessonDTO;
import com.djungleacademy.entity.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface LessonMapper {

//    @Mapping(target = "course", ignore = true) // if you want dto have no access to full obj->will be null
//    @Mapping(target = "instructor", ignore = true) // if you want dto have no access to full obj->will be null
    @Mapping(source = "instructor.firstName", target = "instructorName")
    @Mapping(source = "course.name", target = "courseName")
    LessonDTO toDTO(Lesson lesson);


// No need to map instructorName and courseName, as the entity does not have these properties;
// they are only for DTO to display
//    @Mapping(source = "courseName", target = "course.name") //no need to
//    @Mapping(source = "instructorName", target = "instructor.firstName")
    Lesson toEntity(LessonDTO lessonDTO);
}

