/**
 * This is a data structure where elements can be of any type [T] and are stored in a [mutableMapOf<T, Node<T>>()].
 *
 * In this data structure, the delete function is done in O(1) time because a mutable map is used
 * to store the elements and their corresponding nodes, which allows to access and remove any element in constant time.
 * Additionally, a doubly linked list is used to store the nodes, which allows to update the previous and next pointers
 * of the surrounding nodes in constant time.
 *
 * [add] adds elements to the data structure.
 * [delete] deletes elements from the data structure.
 * [getAllItems] returns all items in the set as a list.
 * [contains] checks if a specific element is present.
 */

class MyDataStructure<T> {
    inner class Node<T>(val value: T) {
        var next: Node<T>? = null
        var previous: Node<T>? = null
    }

    private val data = mutableMapOf<T, Node<T>>()
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun add(element: T) {
        if (data.containsKey(element)) return

        val newNode = Node(element)
        data[element] = newNode

        /*
         * If the list is initially empty,
         * the new node becomes both the head and tail.
         */
        if (head == null) {
            head = newNode
            tail = newNode
        } else { // If the list is not empty, the new node is added after the current tail, and the tail pointer is updated.
            tail?.next = newNode
            newNode.previous = tail
            tail = newNode
        }
    }

    fun delete(element: T) {
        val nodeToRemove = data[element]
        if (nodeToRemove != null) {
            // If the Node exists, it updates the head and tail pointers.
            if (nodeToRemove == head) head = nodeToRemove.next
            if (nodeToRemove == tail) tail = nodeToRemove.previous

            // Updates the previous and next pointers of the surrounding nodes.
            nodeToRemove.previous?.next = nodeToRemove.next
            nodeToRemove.next?.previous = nodeToRemove.previous

            data.remove(element)
        }
    }

    fun getAllItems(): List<T> {
        val result = mutableListOf<T>()
        var current = head

        while (current != null) {
            result.add(current.value)
            current = current.next
        }

        return result
    }

    fun contains(element: T): Boolean {
        return data.containsKey(element)
    }
}

fun main() {
    val myDataStructure = MyDataStructure<String>()

    // Add items.
    myDataStructure.add("banana")
    myDataStructure.add("pineapple")
    myDataStructure.add("watermelon")

    // See all items.
    println(myDataStructure.getAllItems())

    // Delete an item.
    myDataStructure.delete("watermelon")

    // Check if deleted item (watermelon) is still present.
    println(myDataStructure.contains("watermelon"))
}