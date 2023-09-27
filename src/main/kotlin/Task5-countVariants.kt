/**
 * The function below calculates the number of possible variants to climb a staircase with a given number of "numberOfStairs".
 *
 * Step 1: Check if there are 0, 1, or 2 stairs.
 * If there are 0 stairs, there's no way to climb, so the answer is 0 variant.
 * If there's only 1 stair, there's only one way to climb it, which is by taking one step, so the answer is 1 variant.
 * If there are 2 stairs, there are 2 possible ways: either take two steps at once or take one step, then another step.
 * In this case, the answer is 2 variants.
 *
 * Step 2: For cases with more than 2 stairs, function uses dynamic programming to calculate the number of variants.
 * It initializes two variables, "previous" and "current", to represent the number of variants for 1 and 2 stairs, respectively.
 * Then a loop is used to iteratively calculate the number of variants for each number of stairs from 3 up to "numberOfStairs".
 * At each step, the next value is calculated by adding "previous" and "current", representing the total number of variants
 * to reach the current step by either taking one step or two steps.
 * Function updates "previous" and "current" for the next iteration.
 *
 * Step 3: The final value of "current" represents the total number of variants to climb "numberOfStairs" stairs efficiently.
 *
 * Note: The use of BigInteger in this implementation allows for the calculation of variants for extremely large values
 * of "numberOfStairs" without encountering overflow. It may consume a large amount of memory on huge values, though.
 *
 * Fun fact: This function can even calculate the possible variants to fully cover the Niesen Mountain Staircase,
 * which is the largest in the world with 11,674 stairs.
 */

import java.math.BigInteger

fun countVariants(numberOfStairs: BigInteger): BigInteger {
    if (numberOfStairs <= BigInteger.TWO)
        return numberOfStairs

    var previous = BigInteger.ONE
    var current = BigInteger.TWO

    var i = BigInteger.valueOf(3)

    while (i <= numberOfStairs) {
        val next = previous + current
        previous = current
        current = next
        i = i.add(BigInteger.ONE)
    }

    return current
}

fun main() {
    val numberOfStairs = BigInteger.valueOf(12)
    val variants = countVariants(numberOfStairs)
    if (variants in BigInteger.ZERO..BigInteger.ONE) println("There is $variants possible variant to climb $numberOfStairs stair.")
    else println("There are $variants possible variants to climb $numberOfStairs stairs.")
}


/**
 * At first, I decided to use recursion, but due to the inefficiency of
 * the recursive approach for large values, I opted to use dynamic programming.
 * The recursive function below works properly, but it fails on large inputs.
 *
 * RECURSIVE VERSION:
    fun countVariants(numberOfStairs: Int): Int {
        if (numberOfStairs <= 2)
            return numberOfStairs

        return countVariants(numberOfStairs - 1) + countVariants(numberOfStairs - 2)
    }
*/