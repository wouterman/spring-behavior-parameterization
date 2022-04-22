package com.github.wouterman.springbootbehaviorparameterization;


import static java.util.stream.Collectors.toList;

import com.github.wouterman.springbootbehaviorparameterization.domain.Chocolate;
import com.github.wouterman.springbootbehaviorparameterization.domain.DarkChocolateFilter;
import java.util.List;
import java.util.function.Predicate;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChocolateService {

  public static List<Chocolate> filterBitterChocolates(List<Chocolate> chocolates) {
    return chocolates.stream().filter(chocolate -> chocolate.getType().equals("bitter")).toList();
  }

  public static List<Chocolate> filterChocolatesByType(List<Chocolate> chocolates, String type) {
    return chocolates.stream().filter(chocolate -> chocolate.getType().equals(type)).toList();
  }

  public static List<Chocolate> filterChocolatesByWeight(List<Chocolate> chocolates, Integer weight) {
    return chocolates.stream().filter(chocolate -> chocolate.getWeight() > weight).toList();
  }

  public static List<Chocolate> filterChocolatesByAnyAttribute(List<Chocolate> chocolates, String type, Integer weight, boolean flag) {
    if (flag) return chocolates.stream().filter(chocolate -> chocolate.getWeight() > weight).toList();
    return chocolates.stream().filter(chocolate -> chocolate.getType().equals(type)).toList();
  }

  public static List<Chocolate> filterChocolatesWithAbstraction(List<Chocolate> chocolates, DarkChocolateFilter predicate) {
    return chocolates.stream().filter(predicate).toList();
  }

  public static List<Chocolate> filterChocolatesWithFunctionalInterfaces(List<Chocolate> chocolates, Predicate<Chocolate> predicate) {
    return chocolates.stream().filter(predicate).toList();
  }

  public static List<Chocolate> filterChocolatesWithLambdas(List<Chocolate> chocolates, Predicate<Chocolate> predicate) {
    return chocolates.stream().filter(predicate).toList();
  }

}