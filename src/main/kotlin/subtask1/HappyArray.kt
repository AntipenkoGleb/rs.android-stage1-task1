package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        val happyArray = sadArray.toMutableList()
        var step = 0
        while (step != happyArray.size) {
            if (!lessThenNearest(happyArray, step)) {
                happyArray.removeAt(step)
                step--
            } else step++
        }
        return happyArray.toIntArray()
    }

    private fun lessThenNearest(sadArray: MutableList<Int>, index: Int): Boolean {
        if (index == 0 || index == sadArray.lastIndex) return true
        return sadArray[index] < (sadArray[index - 1] + sadArray[index + 1])
    }
}
