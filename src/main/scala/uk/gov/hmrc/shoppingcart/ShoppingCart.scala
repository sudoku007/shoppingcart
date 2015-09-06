package uk.gov.hmrc.shoppingcart


trait Item

case object Apple extends Item

case object Orange extends Item

class ShoppingCart {

  val itemsPrice: Map[Item, BigDecimal] = Map(Apple -> 0.60, Orange -> 0.25)

  def checkoutCost(items: List[Item]): BigDecimal = items.map(itemsPrice).sum

}