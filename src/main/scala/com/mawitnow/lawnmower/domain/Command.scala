package com.mawitnow.lawnmower.domain

private[domain] sealed case class Command(label: String)

private[domain] object Command {

  def create(commands: String): List[Command] = {
    commands.map {
      case 'A' => A
      case 'D' => D
      case 'G' => G
    }.toList
  }

  object A extends Command("Forward")

  object D extends Command("Right")

  object G extends Command("Left")
}

