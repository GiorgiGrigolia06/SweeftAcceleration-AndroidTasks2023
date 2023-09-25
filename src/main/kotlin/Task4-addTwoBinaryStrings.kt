/**
 * This function adds two binary strings and returns the result.
 * To achieve this, it first initializes two variables, "var i" and "var j" to track the rightmost digit of each string.
 * Inside a while loop, it iterates through both strings from right to left, or until there's a carry.
 * Additionally, it adds the current binary digits of 'a' and 'b' to the "sum," converting them from ASCII to integer.
 * Then, it appends the least significant digit of the sum to the result and calculates the carry for the next iteration.
 * Lastly, it moves to the next digits of both 'a' and 'b' from right to left.
 */

fun addTwoBinaryStrings(a: String, b: String): String {
    var result = ""
    var sum = 0
    var i = a.length - 1
    var j = b.length - 1

    while (i >= 0 || j >= 0 || sum == 1) {
        sum +=
            if (i >= 0)
                a[i].code - '0'.code
            else 0

        sum +=
            if (j >= 0)
                b[j].code - '0'.code
            else 0

        result = (sum % 2 + '0'.code).toChar() + result

        sum /= 2

        i--
        j--
    }

    return result
}

fun main() {
    val a = "1010"
    val b = "1011"
    val sum = addTwoBinaryStrings(a, b)
    println("The sum of $a and $b in binary equals to $sum.")
}