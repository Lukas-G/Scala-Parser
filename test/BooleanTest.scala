package test

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

import ftanml.FtanParsers
import ftanml.objects.FtanBoolean

class BooleanTest extends ParserTest with FlatSpec {

  "Booleans" should "be compared correctly (equals, hashCode)" in {
    FtanBoolean(true) should_equal FtanBoolean(true)
    FtanBoolean(false) should_equal FtanBoolean(false)
    FtanBoolean(true) should_not_equal FtanBoolean(false)
  }

  they should "be parsed correctly" in {
    "true" <--> FtanBoolean(true)
    "false" <--> FtanBoolean(false)
  }

  they should "have a default value when used directly" in {
    FtanBoolean should_equal FtanBoolean(false)
  }

  they should "be rejected, if wrong" in {
    "False" invalid;
    "True" invalid;
    "FALSE" invalid;
    "TRUE" invalid;
    "truefoo" invalid;
    "falsefoo" invalid;
    "ttrue" invalid;
    "ffalse" invalid;
  }

}