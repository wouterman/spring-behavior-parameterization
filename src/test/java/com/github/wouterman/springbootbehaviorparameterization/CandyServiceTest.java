package com.github.wouterman.springbootbehaviorparameterization;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.wouterman.springbootbehaviorparameterization.domain.Cake;
import com.github.wouterman.springbootbehaviorparameterization.domain.Chocolate;
import java.util.List;
import org.junit.jupiter.api.Test;

class CandyServiceTest {

  private final Chocolate chocoOne = new Chocolate("dark", 100);
  private final Chocolate chocoTwo = new Chocolate("white", 200);
  private final Chocolate chocoThree = new Chocolate("bitter", 300);
  private final Chocolate chocoFour = new Chocolate("bitter", 400);
  private final Chocolate chocoFive = new Chocolate("milk", 600);
  private final Cake cakeOne = new Cake("chocolate", 100);
  private final Cake cakeTwo = new Cake("blueberry", 200);
  private final Cake cakeThree = new Cake("vanilla", 300);
  private final Cake cakeFour = new Cake("redvelvet", 400);
  private final Cake cakeFive = new Cake("icecream", 600);
  private final List<Chocolate> mockedChocos = List.of(chocoOne, chocoTwo, chocoThree, chocoFour,
      chocoFive);
  private final List<Cake> mockedCakes = List.of(cakeOne, cakeTwo, cakeThree, cakeFour, cakeFive);

  @Test
  void filter_CakeWeight() {
    Integer expectedAmountOfCandies = 4;

    List<Cake> candies = CandyService.filter(mockedCakes, (cake) -> cake.getWeight() > 100);
    Integer actualAmountOfCandies = candies.size();

    assertEquals(expectedAmountOfCandies, actualAmountOfCandies);
  }

  @Test
  void filter_CakeFlavor() {
    Integer expectedAmountOfCandies = 1;

    List<Cake> candies = CandyService.filter(mockedCakes,
        (cake) -> cake.getFlavor().equals("chocolate"));
    Integer actualAmountOfCandies = candies.size();

    assertEquals(expectedAmountOfCandies, actualAmountOfCandies);
  }

  @Test
  void filter_ChocolateWeight() {
    Integer expectedAmountOfCandies = 4;

    List<Chocolate> candies = CandyService.filter(mockedChocos,
        (chocolate) -> chocolate.getWeight() > 100);
    Integer actualAmountOfCandies = candies.size();

    assertEquals(expectedAmountOfCandies, actualAmountOfCandies);
  }

  @Test
  void filter_ChocolateType() {
    Integer expectedAmountOfCandies = 2;

    List<Chocolate> candies = CandyService.filter(mockedChocos,
        (chocolate) -> chocolate.getType().equals("bitter"));
    Integer actualAmountOfCandies = candies.size();

    assertEquals(expectedAmountOfCandies, actualAmountOfCandies);
  }
}