package guru.springframework.netfluxexample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/*
 * Created by NR on 30 Jun 2019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieEvent {
    public String movieId;
    public Date date;
}
