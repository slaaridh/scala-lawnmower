package com.mawitnow.lawnmower.service

import com.mawitnow.lawnmower.domain.LawnMower

//noinspection ScalaDocMissingParameterDescription
object LawnMowersService {
  private val SEP = ' '

  def execute(input: List[String]): List[String] = {
    for (lawnMowerConfig <- createLawnMowers(input)) yield lawnMowerConfig.lawnmower.execute(lawnMowerConfig.commands)
  }

  /**
    * Return the list of lawnmowers positions.
    * if the input is not valid a runtime exception will be thrown and no lawnmower will be created.
    *
    * @param input
    * @return a list of String
    */
  private def createLawnMowers(input: List[String]): List[LawnMowerConfig] = {
    val head = input.head.split(SEP)
    val maxX = head(0).toInt
    val maxY = head(1).toInt
    val tail = input.tail

    tail.grouped(2).map(list => (list.head, list(1))).map { case (position, commands) =>
      val pos = position.split(SEP)
      val x = pos(0).toInt
      val y = pos(1).toInt
      val orientation = pos(2).charAt(0)
      LawnMowerConfig(new LawnMower(x, y, orientation, maxX, maxY), commands)
    }.toList
  }

  private final case class LawnMowerConfig(lawnmower: LawnMower, commands: String)

}

