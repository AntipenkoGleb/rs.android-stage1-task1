package subtask4

private  val BRACKETS_TYPES = arrayOf(Pair('<', '>'), Pair('(', ')'), Pair('[', ']'))

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        return parseString(inputString)
    }

    private fun parseString(string: String): Array<String> {
        val result = ArrayList<String>()
        for ((index, char) in string.withIndex()) {
            if (isOpenBracket(char)) {
                result.add(readTextInBrackets(string.substring(index + 1), char))
            }
        }
        return result.toTypedArray()
    }

    private fun readTextInBrackets(text: String, bracket: Char): String {
        val strBuilder = StringBuilder()
        var offset = 0
        for (char in text) {
            if (char == bracket){
                offset++
                strBuilder.append(char)
                continue
            }
            if (isClosedBracket(bracket, char)) {
                if (offset-- == 0) {
                    return strBuilder.toString()
                }
            }
            strBuilder.append(char)
        }
        return ""
    }

    private fun isOpenBracket(char: Char): Boolean {
        BRACKETS_TYPES.forEach { if (it.first == char) return@isOpenBracket true }
        return false
    }

    private fun isClosedBracket(open: Char?, close: Char): Boolean {
        if (open == null) return false
        BRACKETS_TYPES.forEach { if (it.first == open && it.second == close) return@isClosedBracket true }
        return false
    }
}
