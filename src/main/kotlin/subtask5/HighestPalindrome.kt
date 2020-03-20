package subtask5

class HighestPalindrome {

    // TODO: Complete the following function
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        val str = digitString.toCharArray()
        if (n % 2 == 1) return "-1"
        val numberOfUnpaired = getNumberOfUnpaired(str)
        if (numberOfUnpaired > (k - 1) && k != 1) return "-1"
        val numberOfReplace = k - numberOfUnpaired
        for (i in 0 until numberOfReplace) {
            val minIndex = getMinimal(str)
            str.setPairValue(minIndex, '9')
        }
        for (i in 0 until k - numberOfReplace * 2) {
            val max = getMax(str)
            val maxValue = str[max]
            str.setPairValue(max, maxValue)
        }
        return str.joinToString("")
    }

    private fun getMinimal(digitString: CharArray): Int {
        var min = Int.MAX_VALUE
        for (i in digitString.indices) {
            if (digitString.isMirrorSame(i)) continue
            else {
                if (digitString[i].toInt() < min)
                    min = i
                if (digitString.getMirror(i).toInt() < min)
                    min = digitString.getMirrorIndex(i)
            }
        }
        return min
    }

    private fun getMax(digitString: CharArray): Int {
        var max = Int.MIN_VALUE
        for (i in digitString.indices) {
            if (digitString.isMirrorSame(i)) continue
            else {
                if (digitString[i].toInt() > max)
                    max = i
                if (digitString.getMirror(i).toInt() > max)
                    max = digitString.getMirrorIndex(i)
            }
        }
        return max
    }

    private fun CharArray.setPairValue(index: Int, value: Char) {
        val middleElem = this.size / 2
        val pairIndex = if (index >= middleElem) index - (middleElem - 1) else ((this.size) - 1) - index
        this[pairIndex] = value
        this[index] = value
    }

    private fun getNumberOfUnpaired(digitString: CharArray): Int {
        var pairCount = 0
        for (i in 0 until digitString.size / 2) {
            if (!digitString.isMirrorSame(i)) pairCount++
        }
        return pairCount
    }

    private fun CharArray.getMirror(index: Int): Char {
        return this[this.lastIndex - index]
    }

    private fun CharArray.getMirrorIndex(index: Int): Int {
        return this.lastIndex - index
    }

    private fun CharArray.isMirrorSame(index: Int): Boolean {
        return this[index] == this.getMirror(index)
    }
}

