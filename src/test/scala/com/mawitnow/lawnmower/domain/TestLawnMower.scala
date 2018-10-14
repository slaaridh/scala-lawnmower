package com.mawitnow.lawnmower.domain

import org.scalatest.FunSuite

/**
  * Coming from xUnit
  */
class TestLawnMower extends FunSuite {

  test("Commands GAGAGAGAA should produce a position 1 3 N") {
    val lawnMower = new LawnMower(1, 2, 'N', 5, 5)
    // Execute work
    assert(lawnMower.execute("GAGAGAGAA") == "1 3 N")
  }

  test("Commands AADAADADDA should produce a position 5 1 E") {
    val lawnMower = new LawnMower(3, 3, 'E', 5, 5)
    assert(lawnMower.execute("AADAADADDA") == "5 1 E")
  }

}
