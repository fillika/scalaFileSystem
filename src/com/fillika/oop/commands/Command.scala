package com.fillika.oop.commands

import com.fillika.oop.filesystem.State

trait Command {
  //  Transform our state
  def apply(state: State): State
}

object Command {
  def from(input: String): Command = new UnknownCommand
}
