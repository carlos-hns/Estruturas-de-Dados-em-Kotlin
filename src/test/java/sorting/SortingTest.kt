package sorting

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SortingTest {
    @Test
    fun `Should return the same list if the list is already sorted`(){
        val orderedList = mutableListOf(1.0, 2.0, 3.0, 4.0, 5.0)
        val listCopy = orderedList.toMutableList()
        InsertionSort.sortInAscendingOrder(listCopy)
        assertEquals(orderedList, listCopy)
    }

    @Test
    fun `Should return a ascending ordered list if the list is unordered`(){
        val unorderedList = mutableListOf(5.0, 1.0, 3.0, 2.0, 4.0)
        val orderedList = mutableListOf(1.0, 2.0, 3.0, 4.0, 5.0)
        InsertionSort.sortInAscendingOrder(unorderedList)
        assertEquals(orderedList, unorderedList)
    }

    @Test
    fun `Should return a ascending ordered list if the list is unordered 2`(){
        val unorderedList = mutableListOf(1.0, 1.0, 3.0, 2.0, 5.0)
        val orderedList = mutableListOf(1.0, 1.0, 2.0, 3.0, 5.0)
        InsertionSort.sortInAscendingOrder(unorderedList)
        assertEquals(orderedList, unorderedList)
    }

}