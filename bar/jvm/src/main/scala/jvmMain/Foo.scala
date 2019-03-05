package jvmMain

import com.SharedMain
object Foo {
  def main(args: Array[String]): Unit = {
    println("Hello JVM" )
    println("from shared " + SharedMain.a)
  }
}
