import com.SharedMain

object Foo {
  def main(args: Array[String]): Unit = {
    println("Hello Native")
    println("from shared " + SharedMain.a)
  }
}