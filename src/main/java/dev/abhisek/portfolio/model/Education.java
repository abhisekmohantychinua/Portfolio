package dev.abhisek.portfolio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "educations")
public class Education {
    @Id
    private String id;
    private String start;
    private String end;
    private String institution;
    private String location;
    private String degree;
    private String fieldOfStudy;
    private String description;
}
