import java.util.Arrays
// indices是一个扩展属性，意味着循环变量i会依次取值为0、1、2...直到s.size - 1，通过索引访问集合s中的每个元素。

//胃口小的吃小块

fun findContentChildren(g: IntArray, s: IntArray): Int {
    Arrays.sort(g)
    Arrays.sort(s)
    var count = 0
    for (i in s.indices) {
        if (count < g.size && g[count] <= s[i]) {
            count++
        }
    }
    return count
}

//胃口大的吃大块 
import java.util.Arrays

fun findContentChildren2(g: IntArray, s: IntArray): Int {
    Arrays.sort(g)
    Arrays.sort(s)
    var count = 0
    var i = s.lastIndex
    var j = g.lastIndex
    while (j >= 0 && i >= 0) {
        if (g[j] <= s[i]) {
            count++
            i--
        }
        j--
    }
    return count
}

