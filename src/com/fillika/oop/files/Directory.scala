package com.fillika.oop.files

class Directory(override val parentPath: String, override val name: String, val contents: List[DirEntry])
  extends DirEntry(parentPath, name) {

}

object Directory {
  val SEPARATOR = "/"
  var ROOT_PATH = "/"

  def ROOT: Directory = Directory.empty("", "")

  // Это типо фабрики
  def empty(parentPath: String, name: String): Directory = {
    new Directory(parentPath, name, List())
  }
}