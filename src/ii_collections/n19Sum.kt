package ii_collections

fun example6() {
    listOf(1, 3).sum() == 4
    listOf("a", "b", "cc").sumBy { it.length } == 4
}

fun Customer.getTotalOrderPrice(): Double {
    // Return the sum of prices of all products that a customer has ordered.
    // Note: a customer may order the same product for several times.
//    return orders.sumByDouble { it.products.sumByDouble { it.price } } //ugly but works
    return orders.flatMap { it.products }.sumByDouble { it.price } //the '}' after products makes this work.  note intellij autocompletion looks like this
//    return orders.flatMap{ it.products.sumByDouble { it.price }} //this doesn't work
}
