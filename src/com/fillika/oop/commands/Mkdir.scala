package com.fillika.oop.commands
import com.fillika.oop.filesystem.State

class Mkdir(dirname: String) extends Command {
  override def apply(state: State): State = {
    val workingDir = state.wd
    if (workingDir.hasEntry(dirname)) {
      state.setMessage("Entry " + " already exist!")
    }
    state
  }
}
