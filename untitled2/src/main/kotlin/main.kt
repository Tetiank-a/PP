const val N = 4

fun getCofactor(
        mat: Array<IntArray>, temp: Array<IntArray>,
        p: Int, q: Int, n: Int
) {
    var i = 0
    var j = 0

    for (row in 0 until n) {
        for (col in 0 until n) {
            if (row != p && col != q) {
                temp[i][j++] = mat[row][col]
                if (j == n - 1) {
                    j = 0
                    i++
                }
            }
        }
    }
}

fun getDeterminant(mat: Array<IntArray>, n: Int): Int {
    var D = 0 // Initialize result
    if (n == 1) return mat[0][0]
    val temp = Array(N) { IntArray(N) }
    var sign = 1
    for (f in 0 until n) {
        getCofactor(mat, temp, 0, f, n)
        D += (sign * mat[0][f]
                * getDeterminant(temp, n - 1))
        sign = -sign
    }
    return D
}

fun main(args: Array<String>) {
    val mat =
        arrayOf(intArrayOf(1, 0, 2, -1), intArrayOf(3, 0, 0, 5),
            intArrayOf(2, 1, 4, -3), intArrayOf(1, 0, 5, 0))
    print("Determinant of the matrix is : " + getDeterminant(mat, N))
}