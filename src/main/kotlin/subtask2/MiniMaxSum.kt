package subtask2

class MiniMaxSum {

    // TODO: Complete the following function
    fun getResult(input: IntArray): IntArray {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        for (i in input.indices){
            val resultSum = input.filterIndexed { index, _ -> index != i }.sum()
            if(min > resultSum) min = resultSum
            if(max < resultSum) max = resultSum
        }
        return IntArray(2) {if(it == 0) min else max}
    }
}
