package subtask2

class MiniMaxSum {

    // TODO: Complete the following function
    fun getResult(input: IntArray): IntArray {
        val min = input.min()!!
        val max = input.max()!!
        val sum = input.sum()
        return arrayOf(sum - max, sum - min).toIntArray()
    }
}
