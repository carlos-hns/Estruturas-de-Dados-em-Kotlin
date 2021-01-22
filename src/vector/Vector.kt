package vector

import kotlin.jvm.Throws

class Vector(private val capacity: Int) {

    private var size: Int = 0
    private val elements: Array<String?> = Array(capacity) { null }

    @Throws(FullVectorException::class)
    fun addOrThrows(element: String) {
        if (this.size < this.elements.size){
            this.elements[this.size] = element
            this.size++;
        } else {
            throw FullVectorException("Vector is full, don't is possible add more elements.")
        }
    }

    fun add(element: String): Boolean {
        return if (this.size < this.elements.size){
            this.elements[this.size] = element
            this.size++;
            true
        } else {
            false
        }
    }

}