package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        return makeHappy(sadArray)
    }

    private fun makeHappy(sadArray: IntArray): IntArray {
        val resultArray = sadArray.filterIndexed { index, _ -> lessThenNearest(sadArray, index)  }.toIntArray()
        return if(resultArray.size < sadArray.size ) makeHappy(resultArray) else resultArray
    }

    private fun lessThenNearest(sadArray: IntArray, index: Int): Boolean {
        if (index == 0 || index == sadArray.lastIndex) return true
        return sadArray[index] < (sadArray[index - 1] + sadArray[index + 1])
    }
}
