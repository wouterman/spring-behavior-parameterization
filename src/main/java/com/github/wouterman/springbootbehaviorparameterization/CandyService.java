package com.github.wouterman.springbootbehaviorparameterization;

import java.util.List;
import java.util.function.Predicate;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CandyService {

  public static <T> List<T> filter(List<T> candies, Predicate<T> predicate) {
    return candies.stream().filter(predicate).toList();
  }

}
