package i_introduction._7_Nullable_Types

import util.TODO
import util.doc7

fun test() {
    val s: String = "this variable cannot store null references"
    val q: String? = null

    if (q != null) q.length      // you have to check to dereference
    val i: Int? = q?.length      // null
    val j: Int = q?.length ?: 0  // 0
}

fun todoTask7(client: Client?, message: String?, mailer: Mailer): Nothing = TODO(
    """
        Task 7.
        Rewrite JavaCode7.sendMessageToClient in Kotlin, using only one 'if' expression.
        Declarations of Client, PersonalInfo and Mailer are given below.
    """,
    documentation = doc7(),
    references = { JavaCode7().sendMessageToClient(client, message, mailer) }
)

//the ? indicates that the client and message are nullable, mailer is not
fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
    val personalInfo: PersonalInfo? = client?.personalInfo//note if client is null, then this whole thing evals to null without an NPE
    val email: String? = client?.personalInfo?.email
  //my solution was very close.  I pulled out the vars above, and the answer, they pull out just the email and use the following if
    //if (email != null && message != null) {
    //since the ? will prevent an NPE, it makes the result null thats why the above line works
    if (client == null || message == null || personalInfo == null || email == null) {
        return
    }
    mailer.sendMessage(email, message)
}

//interesting these are used in the JavaCOde
class Client (val personalInfo: PersonalInfo?)
class PersonalInfo (val email: String?)

interface Mailer {
    fun sendMessage(email: String, message: String)
}
