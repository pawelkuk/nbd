case class Osobaa(imie: String, nazwisko: String)

class KontoBankowe() {
  private var _stanKonta: Double = 0
  def this(stanKonta: Double) = {
    this()
    this.stanKonta = stanKonta
  }
  def stanKonta: Double = _stanKonta
  private def stanKonta_= (value: Double):Unit  = {_stanKonta = value}
  def wpłać(wartość: Double):Unit= {
    if (wartość > 0) stanKonta += wartość
  }
  def wypłać(wartość: Double): Unit={
    if (wartość > 0 && stanKonta > wartość) stanKonta -= wartość
  }

}

object NBD2 {
  def task4(): Unit = {
    println("\nTask 4")

    def transformFunction(x: Int): Int = {
      return x + 1
    }
    def higherOrderFunction(valueToActUpon: Int, transformFunction: Int => Int): Int = {
      println("Task 4| Value to act upon: " + valueToActUpon)
      val applyThreeTimes = Function.chain(List.fill(3)(transformFunction))
      return applyThreeTimes(valueToActUpon)
    }

    val result = higherOrderFunction(3, transformFunction)
    println("Task 4| Result: 3+1+1+1 = " + result)
  }
  def task5():Unit = {
    println("\nTask 5")
    val student = new Osoba() with Student;
    println("Student, podatek: " + student.podatek)
    val pracownik = new Osoba() with Pracownik;
    pracownik.pensja = 3000d;
    println("Pracownik, podatek: " + pracownik.podatek + " przy pensji: " + pracownik.pensja)
    val nauczyciel = new Osoba() with Nauczyciel;
    nauczyciel.pensja = 3000d;
    println("Nauczyciel, podatek: " + nauczyciel.podatek + " przy pensji: " + nauczyciel.pensja)
    // To nie działa - konfliktujące dziedzicenia - kompilator nie moze tego zlinearyzować
//    val pracownikOrazStudent = new Osoba() with Pracownik with Student
//    println("pracownik i Student podatek: " + pracownikOrazStudent.podatek + " przy pensji: " + pracownikOrazStudent.pensja)


  }
  def task3(): Unit = {
    println("\nTask 3")

    def matcher(osoba: Osobaa): String = {
      osoba match {
        case Osobaa("Alicja", "Abacka") => "Hej, jesteś lubianą członkinią naszej społeczności"
        case Osobaa("Bob", "Babacki") => "Hej, jesteś lubianym członkiem naszej społeczności"
        case Osobaa("Ewa", "Cabacka") => "Hej, nie ufamy Ci, bo chcesz wykraść nasze klucze prywatne"
        case _ => "Hej, nieznajoma/y"
      }
    }
    val alicja = Osobaa("Alicja", "Abacka")
    val bob = Osobaa("Bob", "Babacki")
    val ewa = Osobaa("Ewa", "Cabacka")
    println("Alicja |" + matcher(alicja))
    println("Bob    |" + matcher(bob))
    println("Ewa    |" + matcher(ewa))
  }

  def task2(): Unit = {
    println("\nTask 2")

    var konto: KontoBankowe = new KontoBankowe()
    konto.wpłać(10)
    konto.wpłać(20)
    konto.wpłać(-10)
    konto.wypłać(60)
    println("Stan konta po operacjach: +10, +20, -10(niedozwolone), -60(niedozwolone) równa się: " + konto.stanKonta)
  }

  def task1(): Unit = {
    println("\nTask 1")

    def matcher(n: String): String = {
      return  n match {
        case "Poniedziałek" => "Praca"
        case "Wtorek" => "Praca"
        case "Środa" => "Praca"
        case "Czwartek" => "Praca"
        case "Piątek" => "Praca"
        case "Sobota" => "Weekend"
        case "Niedziela" => "Weekend"
        case _ => "Nie ma takiego dnia"
      }

    }
    println("Poniedziałek" + " matches to " + matcher("Poniedziałek"))
    println("Wtorek" + " matches to " + matcher("Wtorek"))
    println("Sobota" + " matches to " + matcher("Sobota"))
    println("Invalid input" + " matches to " + matcher("Invalid input"))


  }

  def main(args: Array[String]) = {
    task1()
    task2()
    task3()
    task4()
    task5()
  }
}

class Osoba {
  private var _imie: String = "Alicja"
  private var _nazwisko: String = "Abacka"
  private var _podatek: Double = 0d

  def imie: String = _imie
  def nazwisko: String = _nazwisko
  def podatek: Double = _podatek

}

trait Student extends Osoba {
  override def podatek: Double = 0d
}

trait Nauczyciel extends Pracownik {
  override def podatek: Double = 0.1 * pensja
}

trait Pracownik extends Osoba{
  private var _pensja = 0d
  def pensja: Double = _pensja
  def pensja_=(nowaPensja:Double): Unit = _pensja = nowaPensja
  override def podatek: Double = 0.2 * pensja

}
