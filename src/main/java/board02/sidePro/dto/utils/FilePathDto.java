package board02.sidePro.dto.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@Getter @Setter
public class FilePathDto {
    String prefix;
    String suffix;

    Map<String, FilePathDto> view;
}
