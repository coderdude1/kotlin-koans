package iii_conventions

import util.TODO


class Invokable(var invocations: Int = 0) {
    /*
    The invoke() operator allows instance of your classes to be called as functions.  Note lambdas use this! so we do
            val square = { value: Int -> value * value }

            println(square(5)) // prints 25

        intesd of
            println(square.invoke(5)) // also prints 25

            https://proandroiddev.com/til-about-operator-overloading-in-kotlin-and-the-invoke-operator-da3686ef4694

    operator is required since we are overloading the default invoke fun
     */
    operator fun invoke(): Invokable {
        invocations++
        return this
    }

    fun getNumberOfInvocations() = invocations
}

fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change the class 'Invokable' to count the number of invocations:
        for 'invokable()()()()' it should be 4.
    """,
    references = { invokable: Invokable -> })

fun task31(invokable: Invokable): Int {
//    todoTask31()
    return invokable()()()().getNumberOfInvocations()
}
