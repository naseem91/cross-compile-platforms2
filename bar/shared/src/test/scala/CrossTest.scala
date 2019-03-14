import org.scalatest.{FlatSpec, Matchers}
import com.SharedMain

class CrossTest extends FlatSpec with Matchers{

  it should "be an intger" in {SharedMain.a should be (2)}

}
