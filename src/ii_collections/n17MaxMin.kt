package ii_collections

fun example4() {
    val max = listOf(1, 42, 4).max()
    val longestString = listOf("a", "bc").maxBy { it.length }
}

fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? {
    // Return a customer whose order count is the highest among all customers
//    return customers.maxWith(Comparator { o1, o2 -> o1.orders.size - o2.orders.size })
    return customers.maxBy { it.orders.size } //from answer

}

fun Customer.getMostExpensiveOrderedProduct(): Product? {
    // Return the most expensive product which has been ordered
    return orderedProducts.maxBy { it.price }
}
