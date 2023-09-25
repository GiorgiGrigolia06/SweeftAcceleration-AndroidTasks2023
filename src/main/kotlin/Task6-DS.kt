/**
 * A data structure that allows adding, deleting, and checking the presence of the elements.
 * Elements can be of any type [T] and are stored in a [HashSet].
 *
 * [add] adds elements to the data structure.
 * [delete] deletes elements from the data structure.
 * [getAllItems] returns all items in the set as a list.
 * [contains] checks if a specific element is present.
 *
 * Note: Adding duplicate elements to this data structure won't be possible because it's a [HashSet].
 */

class DeletionDataStructure<T> {
    private val elements = HashSet<T>()

    fun add(element: T) {
        elements.add(element)
    }

    fun delete(element: T) {
        elements.remove(element)
    }

    fun getAllItems(): List<T> {
        return elements.toList()
    }

    fun contains(element: T): Boolean {
        return elements.contains(element)
    }
}

fun main() {
    val myDataStructure = DeletionDataStructure<String>()

    // Add items.
    myDataStructure.add("banana")
    myDataStructure.add("pineapple")
    myDataStructure.add("watermelon")

    // See all items.
    println(myDataStructure.getAllItems())

    // Delete an item.
    myDataStructure.delete("watermelon")

    // Check if deleted item ("watermelon") is still present.
    println(myDataStructure.contains("watermelon"))
}