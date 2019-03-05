import scala.scalajs.js.annotation.JSExportTopLevel
import scala.scalajs.js
import org.querki.jquery._
import com.SharedMain

object Foo extends js.JSApp {


  def main(): Unit = {

  }

  @JSExportTopLevel("append")
  def append(){
    val name = $("#name").value()
    $("#v").html("Hi "+name)
  }

}
