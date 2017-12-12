package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate) = when {  //I cheated looked at answer.  this is MUCH better!  Uses lambda with when block
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}

//Functions that overload (extend?) operators need to be marked with the operator modifier.
operator fun MyDate.rangeTo(other: MyDate): DateRange {
    return DateRange(this, other)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

//This works too for the .. n26InRange
//class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>
//Note the solution used a seperate class for DateIterator vs me using the anonomous/Object expression style
class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterator<MyDate> { //Itereator object Expression
    var currentDate: MyDate = start

    override fun hasNext(): Boolean = currentDate <= endInclusive  //expressionSyntax

    override fun next(): MyDate {
        val retval = currentDate  //need to return the intial value on first request
        currentDate = currentDate.addTimeIntervals(TimeInterval.DAY, 1)
        return retval
    }

    //Intellij offers to turn this into a rangeCheck myDate in start..endInclusive
    operator fun contains(myDate: MyDate) : Boolean = start <= myDate && myDate <= endInclusive
}

//n29 add class with props
class RepeatedTimeInterval(val ti: TimeInterval, val n: Int)

//now extension functions per request
fun TimeInterval.times(numOfTimes: Int) = RepeatedTimeInterval(this, numOfTimes) //add .times to Timeinterval that returns a RequetedTimeInteval using referenced TimeInterval

fun MyDate.plus(timeInterval: TimeInterval) = addTimeIntervals(timeInterval, 1)