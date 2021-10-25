package InTechs.InTechs.calendar.payload.response;

import InTechs.InTechs.issue.value.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CalendarResponse {

    private final String id;
    private final String name;
    private final int progress;
    private final State state;
    private final String date;
    private final String content;

}