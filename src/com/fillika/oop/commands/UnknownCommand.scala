package com.fillika.oop.commands

import com.fillika.oop.filesystem.State

class UnknownCommand extends Command {
  override def apply(state: State): State = state.setMessage("Command not found")
}
