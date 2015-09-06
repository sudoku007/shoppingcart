package uk.gov.hmrc.shoppingcart

import org.scalatest.{FlatSpec, Matchers}

class ShoppingCartTest extends FlatSpec with Matchers {
  private val shoppingCart: ShoppingCart = new ShoppingCart

  "An empty shopping cart " should "have a checkout cost of £0.00" in {
    assert(shoppingCart.checkoutCost(List()) == 0.00)
  }

  "A shopping cart with 1 Apple " should "have a checkout cost of £0.60" in {
    assert(shoppingCart.checkoutCost(List(Apple)) == 0.60)
  }

  "A shopping cart with 2 Apples " should "have a checkout cost of £1.20" in {
    assert(shoppingCart.checkoutCost(List(Apple, Apple)) == 1.20)
  }

  "A shopping cart with 3 Apples " should "have a checkout cost of £1.80" in {
    assert(shoppingCart.checkoutCost(List(Apple, Apple, Apple)) == 1.80)
  }

  "A shopping cart with 1 Orange " should "have a checkout cost of £0.25" in {
    assert(shoppingCart.checkoutCost(List(Orange)) == 0.25)
  }

  "A shopping cart with 2 Oranges " should "have a checkout cost of £0.50" in {
    assert(shoppingCart.checkoutCost(List(Orange, Orange)) == 0.50)
  }

  "A shopping cart with 3 Oranges " should "have a checkout cost of £0.75" in {
    assert(shoppingCart.checkoutCost(List(Orange, Orange, Orange)) == 0.75)
  }

  "A shopping cart with 1 Apple, 1 Orange " should "have a checkout cost of £0.85" in {
    assert(shoppingCart.checkoutCost(List(Apple, Orange)) == 0.85)
  }

  "A shopping cart with 2 Apples, 1 Orange " should "have a checkout cost of £1.45" in {
    assert(shoppingCart.checkoutCost(List(Apple, Orange, Apple)) == 1.45)
  }

  "A shopping cart with 2 Apples, 2 Oranges " should "have a checkout cost of £1.70" in {
    assert(shoppingCart.checkoutCost(List(Apple, Orange, Apple, Orange)) == 1.70)
  }

  "A shopping cart with 3 Apples, 1 Orange " should "have a checkout cost of £2.05" in {
    assert(shoppingCart.checkoutCost(List(Apple, Apple, Orange, Apple)) == 2.05)
  }

  "A shopping cart with 3 Apples, 2 Oranges " should "have a checkout cost of £2.30" in {
    assert(shoppingCart.checkoutCost(List(Apple, Orange, Apple, Orange, Apple)) == 2.30)
  }

  "A shopping cart with 3 Apples, 3 Oranges " should "have a checkout cost of £2.55" in {
    assert(shoppingCart.checkoutCost(List(Apple, Orange, Apple, Orange, Apple, Orange)) == 2.55)
  }

}