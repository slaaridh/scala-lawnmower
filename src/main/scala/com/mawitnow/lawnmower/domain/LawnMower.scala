package com.mawitnow.lawnmower.domain

import com.mawitnow.lawnmower.domain.Command._
import com.mawitnow.lawnmower.domain.Direction._

class LawnMower(x: Int, y: Int, direction: Char, maxX: Int, maxY: Int) {


  require(x <= maxX)
  require(y <= maxY)
  private val initPosition = Position(x, y, Direction.from(direction))


  /**
    * Execute commands
    *
    * @return
    */

  def execute(commands: String): String = {
    var currPosition = initPosition
    for (c <- Command.create(commands))
      currPosition = move(c, currPosition)
    currPosition.get()
  }

  private def move(command: Command, currentPosition: Position): Position = command match {
    case D => currentPosition.copy(direction = currentPosition.direction.right())
    case G => currentPosition.copy(direction = currentPosition.direction.left())
    case A => forward(command, currentPosition)
  }

  private def forward(command: Command, currentPosition: Position): Position = {
    var newPosition = currentPosition
    newPosition.direction match {
      case N if y < maxY => newPosition = newPosition.copy(y = newPosition.y + 1)
      case E if x < maxX => newPosition = newPosition.copy(x = newPosition.x + 1)
      case S if y > 0 => newPosition = newPosition.copy(y = newPosition.y - 1)
      case W if x > 0 => newPosition = newPosition.copy(x = newPosition.x - 1)
    }
    newPosition
  }

  private final case class Position(x: Int, y: Int, direction: Direction) {
    def get(): String = x + " " + y + " " + direction
  }

}






