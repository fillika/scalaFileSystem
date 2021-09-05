package com.fillika.oop.filesystem

import com.fillika.oop.files.Directory

class State(val root: Directory, val wd: Directory, val output: String) {
  def show: Unit = {
    println(output)
    print(State.SHELL_TOKEN)
  }

  def setMessage(message: String): State = State(root, wd, message)
}

object State {
  val SHELL_TOKEN = "$ "

  // Это типо фабрики
  def apply(root: Directory, wd: Directory, output: String = "") = {
    new State(root, wd, output)
  }
}