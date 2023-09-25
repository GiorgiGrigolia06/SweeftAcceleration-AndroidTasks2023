/**
 * This function finds the smallest positive whole number that is not present in the given array of integers.
 * Firstly, it sorts the array in ascending order.
 * Then, it initializes the smallest possible missing number to 1.
 * After that comes a for loop to iterate through the sorted array to find the missing number.
 * Inside a for loop, if statement checks whether the current number is positive and less than or equal to smallestMissingNumber.
 * If true, it updates the smallestMissingNumber to be num + 1
 */

fun notContains(array: IntArray): Int {

    array.sort()
    var smallestMissingNumber = 1

    for (num in array) {
        if (num in 1..smallestMissingNumber)
            smallestMissingNumber = num + 1
    }

    return smallestMissingNumber
}

fun main() {
    val array = intArrayOf(-23, -9, 0, 1, 2, 3, 6, 187, 444, 47, 222, 1111)
    val result = notContains(array)
    println("The smallest missing number is $result.")
}