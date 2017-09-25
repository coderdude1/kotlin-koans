package i_introduction._10_Object_Expressions

import util.TODO
import util.doc10
import java.util.*
import kotlin.Comparator

fun todoTask10(): Nothing = TODO(
    """
        Task 10.
        Read about object expressions that play the same role in Kotlin as anonymous classes in Java.

        Add an object expression that provides a comparator to sort a list in a descending order using 'java.util.Collections' class.
        In Kotlin you use Kotlin library extensions instead of java.util.Collections,
        but this example is still a good demonstration of mixing Kotlin and Java code.

        https://kotlinlang.org/docs/reference/object-declarations.html

    """,
    documentation = doc10()
)

fun task10(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList, object : Comparator<Int> {  //I had to peek, this is really the same as passing in an anonymous class
        override fun compare(x: Int, y: Int) = y - x
    })
    return arrayList
}

/*
solution in answer branch.  when using intellij it made stuff nullable, I removed that
    Collections.sort(arrayList, object : Comparator<Int> {  //I had to peek, this is really the same as passing in an anonymous class
        override fun compare(x: Int, y: Int) = y - x
    })

    intellij suggested using lambda instead of object : Comparator<Int>
    recomended this instead (note it is not an object expression):
        Collections.sort(arrayList) { x, y ->
        y - x
    }
 */