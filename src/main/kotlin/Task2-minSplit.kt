/**
 * This function calculates the minimum number of coins required to represent a given amount.
 * It defines a list of coins in descending order.
 * Then, the variables are implemented to keep track of remaining amount and the coin count.
 * Next step is to iterate through each coin using for loop.
 * Inside a for loop, a while loop checks if the remaining amount is greater than or equal to the current coin value.
 * If true, it will subtract the coin value from the remaining amount and increment the coin count.
 */

fun minSplit(amount: Int): Int {
    val listOfCoins = listOf(50, 20, 10, 5, 1)

    var remainingAmount = amount
    var coinCount = 0

    listOfCoins.forEach { coinValue ->
        while (remainingAmount >= coinValue) {
            remainingAmount -= coinValue
            coinCount ++
        }
    }

    return coinCount
}

fun main() {
    val amount = 500
    val minimumCoinsNeeded = minSplit(amount)
    println("Minimum amount of coins needed: $minimumCoinsNeeded.")
}