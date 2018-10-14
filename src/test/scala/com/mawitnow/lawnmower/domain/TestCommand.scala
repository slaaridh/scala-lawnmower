package com.mawitnow.lawnmower.domain

import org.scalatest.FunSuite

class TestCommand extends FunSuite {

  test("should correctly create a list of commands") {
    val str = "AADDGA"
    val expected = Seq(Command.A, Command.A, Command.D, Command.D, Command.G, Command.A)
    val commands = Command.create(str)
    assert(expected == commands)
  }

  test("should throw en exception if not valid command") {
    assertThrows[MatchError] {
      val str = "ABGG"
      Command.create(str)
    }
  }

}
