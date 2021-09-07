package com.fillika.oop.filesystem

import com.fillika.oop.commands.Command
import com.fillika.oop.files.Directory

import java.util.Scanner

object Filesystem extends App {
  val root = Directory.ROOT
  val scanner = new Scanner(System.in);

  var state = State(root, root)

  // Бесконечный цикл позволяет программе работать не выключаясь
  while (true) {
    state.show // <- Запуск цикла вызывает сначала этот метод
    val input = scanner.nextLine() // TODO разобраться с методом nextLine

    /**
     * Как работает Command.from
     * У нас есть объект Command. Метод from создает новый инстанс класса UnknownCommand
     * Этот инстанс имеет метод apply. Принимая state он возвращает обратно state, вызывая метод setMessage
     * Метод setMessage создает новый инстанс класса State с полученными данными.
     * Этим новым экземпляром мы заменяем текущий state и запускаем цикл заново.
     */
    state = Command.from(input).apply(state);
  }
}
