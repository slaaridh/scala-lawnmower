package com.mawitnow.lawnmower.service

import org.scalatest.FunSuite

import scala.io.Source

class TestLawnMowersService extends FunSuite {


  test("Test input file") {

    val resourcesPath = getClass.getResource("/entries.txt")
    val positions = LawnMowersService.execute(Source.fromFile(resourcesPath.getPath).getLines().toList)
    positions.foreach(println)

    assert(positions.head == "1 3 N")
    assert(positions(1) == "5 1 E")
  }


}
