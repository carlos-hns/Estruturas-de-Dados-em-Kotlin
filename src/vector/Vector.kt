package vector

import kotlin.jvm.Throws

class Vector(private var capacity: Int) {

    private var size: Int = 0
    private var elements: Array<String?> = Array(capacity) { null }

    @Throws(FullVectorException::class)
    fun addOrThrows(element: String) {

        increaseSize()
        if (this.size < this.capacity){
            this.elements[this.size] = element
            this.size++;
        } else {
            throw FullVectorException("Vector is full, don't is possible add more elements.")
        }
    }

    fun add(element: String): Boolean {
        increaseSize()
        return if (this.size < this.capacity){
            this.elements[this.size] = element
            this.size++;
            true
        } else {
            false
        }
    }

    @Throws(FullVectorException::class, IllegalArgumentException::class)
    fun addOrThrows(element: String, position: Int) {
        increaseSize()
        when {
            position !in 0 until this.capacity -> {
                throw IllegalArgumentException("Invalid position, don't is possible find the element because position is not in correct interval.")
            }
            this.size == this.capacity -> {
                throw FullVectorException("Vector is full, don't is possible add more elements.")
            }
            this.elements[position] == null -> {
                this.addOrThrows(element)
            }
            else -> {
                for (currentPosition in this.size-1 downTo position){
                    this.elements[currentPosition + 1] = this.elements[currentPosition]
                }
                this.elements[position] = element
                this.size++
            }
        }
    }

    fun add(element: String, position: Int): Boolean {
        increaseSize()
        return when {
            position !in 0 until this.capacity -> {
                false
            }
            this.size == this.capacity -> {
                false
            }
            this.elements[position] == null -> {
                if(this.add(element)) true
                false
            }
            else -> {
                for (currentPosition in this.size-1 downTo position){
                    this.elements[currentPosition + 1] = this.elements[currentPosition]
                }
                this.elements[position] = element
                this.size++
                true
            }
        }
    }

    private fun updateCapacity(){
        this.capacity = this.elements.size
    }

    private fun increaseSize(){
        updateCapacity()
        if(this.size == this.capacity){
            val newElements: Array<String?> = Array(this.capacity * 2) { null }
            for (i in 0..size){
                newElements[i] = this.elements[i]
            }
            this.elements = newElements
        }
    }

    @Throws(IllegalArgumentException::class)
    fun findOrThrows(position: Int): String? {
        if ((position !in 0 until this.size)){
            throw IllegalArgumentException("Invalid position, don't is possible find the element because position is not in correct interval.")
        }
        return this.elements[position]
    }

    fun findPosition(element: String): Int {
        for(i in 0 until this.size){
            if(this.elements[i].equals(element)){
                return i
            }
        }
        return -1
    }

    fun has(element: String): Boolean {
        for (i in 0 until this.size){
            if(this.elements[i].equals(element)){
                return true
            }
        }
        return false
    }

    fun size(): Int {
        return this.size
    }

    override fun toString(): String {
        val mString = StringBuilder()
        mString.append("[")

        for (i in 0 until this.size - 1){
            mString.append(this.elements[i])
            mString.append(", ")
        }

        // If size is 1, it go 0 to 1 (exclude 1).
        // For make more beautiful the string we don't iterate
        // in the last element in the loop above
        // rather them we add on the if instruction below.
        // This make the char ',' don't be add after the last element.

        if (this.size > 0){
            mString.append(this.elements[this.size-1])
        }

        mString.append("]")
        return mString.toString()
    }

}