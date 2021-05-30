import scala.annotation.tailrec

object HelloWorld {
  val weekdays = Array("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")
  val products = Map("mleko"->4d, "jajka"->3d, "woda"-> 1.5d, "chleb"-> 3.59d)

  def task1a(): String = {
    var result = ""

    for ((weekday, idx) <- weekdays.zipWithIndex) {
      if (idx != 0)
        result += ',' + weekday
      else
        result += weekday
    }
    result
  }

  def task1b(): String = {
    var result = ""

    for ((weekday, idx) <- weekdays.zipWithIndex if weekday.startsWith("P")) {
      if (idx != 0)
        result += ',' + weekday
      else
        result += weekday
    }
    result
  }

  def task1c(): String = {
    var result = ""
    val size = weekdays.length
    var i = 0
    while (i < size) {
      if (i != 0)
        result += ',' + weekdays(i)
      else
        result += weekdays(i)
      i += 1
    }
    result
  }

  def task2a(weekdays: Array[String]=weekdays): String = {
    if (weekdays.length == 1)
      weekdays(0)
    else
      task2a(weekdays.take(weekdays.length-1)) + ',' + weekdays.last
  }

  def task2b(weekdays: Array[String] = weekdays): String = {
    if (weekdays.length == 1)
      weekdays(0)
    else
      weekdays.last + ',' + task2b(weekdays.take(weekdays.length-1))
  }

  @tailrec
  def task3(weekdays: Array[String]=weekdays, res: String = ""): String = {
    if (weekdays.length == 1)  res + weekdays(0)
    else task3(weekdays.slice(1, weekdays.length), res  + weekdays(0)+ ",")
  }

  def task4a(): String = {
    return weekdays.foldLeft("")((a:String,b:String) =>
      if (a == "") b
      else a + "," + b
    )
  }

  def task4b(): String = {
    return weekdays.foldRight("")((a:String,b:String) =>
      if (b == "") a
      else a + ',' + b
    )
  }

  def task4c(): String = {
    return weekdays.foldLeft("")((a:String,b:String) =>
      if (a == "") b
      else if(b.startsWith("P")) a + "," + b
      else a
    )
  }

  def task5(): Map[String, Double] = {
    return  products map {case (k,v) =>(k, 0.9 * v)}
  }

  def task6(args:(Int, Double, Float)= (1, 2d, 3f)) = {
    var (first, second, third) = args
    println(first)
    println(second)
    println(third)
  }

  def safeMap(key: Option[Int]) = key match
  {
    case Some(k) => (k)
    case None => (404)
  }

  def task7()= {
    val exampleMap :Map[String, Int] = Map("x"-> 5, "y"-> 4 )

    println(safeMap(exampleMap.get("x")) )
    println(safeMap(exampleMap.get("y")))
    println(safeMap(exampleMap.get("z")))
  }

  def task8(l: List[Int]): List[Int]= {
      if (l.length == 1)
        if (l.head != 0) l
        else List()
      else task8(l.slice(0, l.length/2)) ::: task8(l.slice(l.length/2, l.length))
  }

  def task9(x: List[Int]):List[Int]= {
    x.map(a=> a + 1)
  }

  def task10(x: List[Double]):List[Double] = {
    x.filter{el => el >= -5d && 12d >= el}
  }


  def main(args: Array[String]): Unit = {
    println(task1a())
    println(task1b())
    println(task1c())
    println(task2a())
    println(task2b())
    println(task3())
    println(task4a())
    println(task4b())
    println(task4c())
    println(task5())
    task6()
    task7()
    println(task8(List(0,1,2,3,0,1,2,0,1,0,0)))
    println(task9(List(1,2,3,4,5)))
    println(task10(List(-100d, 100d, 0, 3, -2)))
  }
}



