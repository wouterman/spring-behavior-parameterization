package com.github.wouterman.springbootbehaviorparameterization;

import static org.junit.jupiter.api.Assertions.*;

import com.github.wouterman.springbootbehaviorparameterization.domain.Chocolate;
import com.github.wouterman.springbootbehaviorparameterization.domain.DarkChocolateFilter;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

class ChocolateServiceTest {

  private final Chocolate chocoOne = new Chocolate("dark", 100);
  private final Chocolate chocoTwo = new Chocolate("white", 200);
  private final Chocolate chocoThree = new Chocolate("bitter", 300);
  private final Chocolate chocoFour = new Chocolate("bitter", 400);
  private final Chocolate chocoFive = new Chocolate("milk", 600);
  private final List<Chocolate> chocos = List.of(chocoOne, chocoTwo, chocoThree, chocoFour, chocoFive);

  private final DarkChocolateFilter predicate = new DarkChocolateFilter();

  @Test
  void filterBitterChocolates() {
    Integer expectedAmountOfChocos = 2;

    List<Chocolate> result = ChocolateService.filterBitterChocolates(chocos);
    Integer actualAmountOfChocos = result.size();

    assertEquals(expectedAmountOfChocos, actualAmountOfChocos);
  }

  @Test
  void filterChocolatesByType() {
    Integer expectedAmountOfChocos = 1;

    List<Chocolate> result = ChocolateService.filterChocolatesByType(chocos, "dark");
    Integer actualAmountOfChocos = result.size();

    assertEquals(expectedAmountOfChocos, actualAmountOfChocos);
  }

  @Test
  void filterChocolatesByWeight() {
    Integer expectedAmountOfChocos = 3;

    List<Chocolate> result = ChocolateService.filterChocolatesByWeight(chocos, 200);
    Integer actualAmountOfChocos = result.size();

    assertEquals(expectedAmountOfChocos, actualAmountOfChocos);
  }

  @Test
  void filterChocolatesByAnyAttribute_Type() {
    Integer expectedAmountOfChocos = 1;

    List<Chocolate> result = ChocolateService.filterChocolatesByAnyAttribute(chocos, "white", 0, false);
    Integer actualAmountOfChocos = result.size();

    assertEquals(expectedAmountOfChocos, actualAmountOfChocos);
  }

  @Test
  void filterChocolatesByAnyAttribute_Weight() {
    Integer expectedAmountOfChocos = 4;

    List<Chocolate> result = ChocolateService.filterChocolatesByAnyAttribute(chocos, "", 100, true);
    Integer actualAmountOfChocos = result.size();

    assertEquals(expectedAmountOfChocos, actualAmountOfChocos);
  }

  @Test
  void filterChocolatesWithAbstraction_DarkType() {
    Integer expectedAmountOfChocos = 1;

    List<Chocolate> result = ChocolateService.filterChocolatesWithAbstraction(chocos, predicate);
    Integer actualAmountOfChocos = result.size();

    assertEquals(expectedAmountOfChocos, actualAmountOfChocos);
  }

  @Test
  void filterChocolatesWithAbstraction_DarkTypeAnonymousClass() {
    Integer expectedAmountOfChocos = 1;

    List<Chocolate> result = ChocolateService.filterChocolatesWithAbstraction(chocos,
        new DarkChocolateFilter() {
          public boolean test(Chocolate chocolate) {
            return chocolate.getType().equals("dark");
          }
        });
    Integer actualAmountOfChocos = result.size();

    assertEquals(expectedAmountOfChocos, actualAmountOfChocos);
  }

  @Test
  void filterChocolatesWithFunctionalInterfaces_TypeAndWeight() {
    Integer expectedAmountOfChocos = 1;
    Predicate<Chocolate> predicate = (chocolate) -> chocolate.getWeight() >= 100 && chocolate.getType().equals("dark");

    List<Chocolate> result = ChocolateService.filterChocolatesWithFunctionalInterfaces(chocos, predicate);
    Integer actualAmountOfChocos = result.size();

    assertEquals(expectedAmountOfChocos, actualAmountOfChocos);
  }

  @Test
  void filterChocolatesWithLambdas_Type() {
    Integer expectedAmountOfChocos = 1;

    List<Chocolate> result = ChocolateService.filterChocolatesWithLambdas(chocos, (chocolate) -> chocolate.getType().equals("dark"));
    Integer actualAmountOfChocos = result.size();

    assertEquals(expectedAmountOfChocos, actualAmountOfChocos);
  }
}