package uk.gov.hmrc.shoppingcart

import scala.math.BigDecimal


trait Item

case object Apple extends Item

case object Orange extends Item

trait Offer {
  def applyOffer(items: List[Item]): Int
}

object AppleBogofOffer extends Offer {
  def applyOffer(items: List[Item]): Int = items.size / 2 + items.size % 2
}

object Orange3For2Offer extends Offer {
  def applyOffer(items: List[Item]): Int = (2 * (items.size / 3)) + items.size % 3
}

object NoOffer extends Offer {
  def applyOffer(items: List[Item]): Int = items.size
}

class ShoppingCart {

  private val itemsPrice: Map[Item, BigDecimal] = Map(Apple -> 0.60, Orange -> 0.25)
  private val itemsOffer: Map[Item, Offer] = Map(Apple -> AppleBogofOffer, Orange -> Orange3For2Offer)
  itemsOffer.withDefaultValue(NoOffer)

  def checkoutCost(items: List[Item]): BigDecimal = {
    items.groupBy(identity)
      .map({ case (item, listOfItems) => itemsPrice(item) * itemsOffer(item).applyOffer(listOfItems) })
      .sum
  }

}