/**
 * This function finds the smallest positive whole number that is not present in the given array of integers.
 * It uses a boolean array to track the presence of positive whole numbers in the input array,
 * and it returns the smallest missing positive whole number.
 */

fun notContains(numArray: IntArray): Int {
    val n = numArray.size
    val containsArray = BooleanArray(n + 1)

    for (num in numArray)
        if (num in 1..n)
            containsArray[num] = true

    for (i in 1..n)
        if (!containsArray[i])
            return i

    /*
     * Returns the smallest missing positive whole
     * number beyond the range of numbers in the array.
     */
    return n + 1
}

fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5, 6, 7, 187, 444, 47, 222, 1111)
    val result = notContains(array)
    println("The smallest missing number is $result.")
}