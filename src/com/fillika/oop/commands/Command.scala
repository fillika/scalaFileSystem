package com.fillika.oop.commands

import com.fillika.oop.filesystem.State

trait Command {
  //  Transform our state
  def apply(state: State): State
}

object Command {
  val MKDIR = "mkdir";

  def from(input: String): Command = {
    val tokens: Array[String] = input.split(" ")

    if (input.isEmpty || tokens.isEmpty) emptyCommand;
    else if (MKDIR.equals(tokens(0))) {
      if (tokens.length < 2) incompleteCommand(MKDIR)
      else new Mkdir(tokens(1))
    }
    else new UnknownCommand
  }

  def emptyCommand: Command = (state: State) => state
  def incompleteCommand(name: String): Command =
    (state: State) => state.setMessage(s"\"$name\" is incomplete command");
}
