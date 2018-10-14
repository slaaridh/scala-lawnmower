package com.mawitnow.lawnmower.domain

private[domain] sealed abstract class Direction(label: String) {
  def left(): Direction

  def right(): Direction
}

private[domain] object Direction {

  def from(direction: Char): Direction = {
    direction match {
      case 'N' => N
      case 'E' => E
      case 'S' => S
      case 'W' => W
    }
  }

  case object N extends Direction("North") {
    override def left(): Direction = W

    override def right(): Direction = E
  }

  case object E extends Direction("Est") {
    override def left(): Direction = N

    override def right(): Direction = S
  }

  case object S extends Direction("South") {
    override def left(): Direction = E

    override def right(): Direction = W
  }

  case object W extends Direction("West") {
    override def left(): Direction = S

    override def right(): Direction = N
  }


}

