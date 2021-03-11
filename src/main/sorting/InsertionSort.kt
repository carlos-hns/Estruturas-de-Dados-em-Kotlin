package sorting

class InsertionSort {
    companion object {
        fun sortInAscendingOrder(vector: MutableList<Double>) {
            // Element 0 is ordered without any change
            for(unsortedElementIndex in 1 until vector.size) {
                val unsortedElement = vector[unsortedElementIndex]
                var currentSortedElementIndex  = unsortedElementIndex - 1
                while (currentSortedElementIndex >= 0 && unsortedElement < vector[currentSortedElementIndex]) {
                    vector[currentSortedElementIndex + 1] = vector[currentSortedElementIndex]
                    currentSortedElementIndex--
                }
                vector[currentSortedElementIndex + 1] = unsortedElement
            }
        }
    }
}