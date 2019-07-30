package team2.spring.library.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team2.spring.library.entities.Story;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReaderStatisticDto {
    private String reader;
    private String select;
    private List<Story> stories;
}
