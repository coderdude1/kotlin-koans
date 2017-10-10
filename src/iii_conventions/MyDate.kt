package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        //very java way, this works gonna try to kotlinfy it before checking the actual answer
        var diff = 0
        if (year != other.year ) //not sure about a when block since the test is cascading on a different property for each block
            diff = year - other.year
        else if(month != other.month)
            diff = month - other.month;
        else
            diff = dayOfMonth - other.dayOfMonth
        return diff
    }
}

//Functions that overload operators need to be marked with the operator modifier.
operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate)
