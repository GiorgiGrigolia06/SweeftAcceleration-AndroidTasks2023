/**
 * This function finds a unique number in an array of numbers.
 * It uses XOR to do this efficiently.
 * It starts with a result of 0 and XORs it with each number in the list.
 * When you XOR the same number twice, it cancels out and leaves you with the unique one.
 * Finally, it returns the unique number.
 */

fun singleNumber(numArray: IntArray): Int {
    var uniqueNumber = 0
    for (num in numArray) uniqueNumber = uniqueNumber xor num
    return uniqueNumber
}

fun main() {
    val numArray = intArrayOf(1, 1, 3, 3, 222, 5, 5, 6, 6)
    val uniqueNumber = singleNumber(numArray)
    if (uniqueNumber == 0) println("The array does not contain a unique number.")
    else println("The unique number is $uniqueNumber.")
}


/**
 * Below you can find the function that does the same thing as the one above,
 * but it can also find the unique number if other numbers are present more than twice.
 * It uses two sets, "firstSet" and "secondSet," to keep track of seen numbers.
 * Function iterates through the array, moving numbers from "firstSet" to "secondSet" when seen again.
 * Finally, it returns the first and only number remaining in "firstSet," which is the unique integer.
 *
    fun singleNumber(numArray: IntArray): Int {
        val firstSet = HashSet<Int>()
        val secondSet = HashSet<Int>()

        for (num in numArray) {
            if (!firstSet.contains(num) && !secondSet.contains(num))
                firstSet.add(num)
            else if (firstSet.contains(num)) {
                firstSet.remove(num)
                secondSet.add(num)
            }
        }

      return firstSet.first()
    }
 */