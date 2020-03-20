package subtask3

class BillCounter {

    // TODO: Complete the following function
    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val annaBill = bill.filterIndexed { index, _ -> index != k }.sum() / 2
        val needToPay = b - annaBill
        return if (needToPay != 0) needToPay.toString() else "Bon Appetit"
    }
}
