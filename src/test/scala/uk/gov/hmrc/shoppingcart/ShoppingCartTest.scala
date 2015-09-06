package uk.gov.hmrc.shoppingcart

import org.scalatest.{FlatSpec, Matchers}

class ShoppingCartTest extends FlatSpec with Matchers {
  private val shoppingCart: ShoppingCart = new ShoppingCart

  "An empty shopping cart " should "have a checkout cost of £0.00 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List()) == 0.00)
  }

  "A shopping cart with 1 Apple " should "have a checkout cost of £0.60 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(Apple)) == 0.60)
  }

  "A shopping cart with 2 Apples " should "have a checkout cost of £0.60 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(Apple, Apple)) == 0.60)
  }

  "A shopping cart with 3 Apples " should "have a checkout cost of £1.20 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(Apple, Apple, Apple)) == 1.20)
  }

  "A shopping cart with 4 Apples " should "have a checkout cost of £1.20 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(Apple, Apple, Apple, Apple)) == 1.20)
  }

  "A shopping cart with 1 Orange " should "have a checkout cost of £0.25 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(Orange)) == 0.25)
  }

  "A shopping cart with 2 Oranges " should "have a checkout cost of £0.50 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(Orange, Orange)) == 0.50)
  }

  "A shopping cart with 3 Oranges " should "have a checkout cost of £0.50 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(Orange, Orange, Orange)) == 0.50)
  }

  "A shopping cart with 4 Oranges " should "have a checkout cost of £0.75 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(Orange, Orange, Orange, Orange)) == 0.75)
  }

  "A shopping cart with 1 Apple, 1 Orange " should "have a checkout cost of £0.85 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(Apple, Orange)) == 0.85)
  }

  "A shopping cart with 2 Apples, 1 Orange " should "have a checkout cost of £0.85 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(Apple, Orange, Apple)) == 0.85)
  }

  "A shopping cart with 2 Apples, 2 Oranges " should "have a checkout cost of £1.10 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(Apple, Orange, Apple, Orange)) == 1.10)
  }

  "A shopping cart with 3 Apples, 1 Orange " should "have a checkout cost of £1.45 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(Apple, Apple, Orange, Apple)) == 1.45)
  }

  "A shopping cart with 3 Apples, 2 Oranges " should "have a checkout cost of £1.70 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(Apple, Orange, Apple, Orange, Apple)) == 1.70)
  }

  "A shopping cart with 3 Apples, 3 Oranges " should "have a checkout cost of £1.70 after offers are applied" in {
    assert(shoppingCart.checkoutCost(List(Apple, Orange, Apple, Orange, Apple, Orange)) == 1.70)
  }

}