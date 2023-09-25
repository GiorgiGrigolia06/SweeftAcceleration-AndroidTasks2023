/**
 * This function finds the unique number in an integer array.
 * It uses two loops to check if each number is present elsewhere in the array.
 * If a number is found elsewhere, it's marked, and the function continues.
 * If number is not found elsewhere, it's considered unique and will be returned.
 * If a unique number is not found, [NoSuchElementException] is thrown.
 */

fun singleNumber(numArray: IntArray): Int {
    for (i in numArray.indices) {
        var check = false
        for (j in numArray.indices) {
            if (i != j && numArray[i] == numArray[j]) {
                check = true
                break
            }
        }

        if (!check)
            return numArray[i]
    }

    throw NoSuchElementException("Non-repeating number not found!")
}

fun main() {
    val numArray = intArrayOf(3, 3, 3, 3, 7, 7, 3, 6, 7, 3, 7, 3, 7, 7, 7, 3, 3, 7, 7, 3, 3, 7, 7, 7, 3, 3)
    val uniqueNumber = singleNumber(numArray)
    println("The unique number is $uniqueNumber.")
}