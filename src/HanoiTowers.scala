import scala.collection.mutable
import scala.io.StdIn.readLine

class HanoiTowers {
  var firstStack  = mutable.Stack[Ring]()
  var secondStack = mutable.Stack[Ring]()
  var thirdStack = mutable.Stack[Ring]()
  val stackArray = Array(firstStack,secondStack,thirdStack)
  def createFirstStack(towerSize: Int): Unit ={
    var x = towerSize
    while(x > 0){
      firstStack.push(new Ring(x))
      x = x - 1
    }
  }
  def printTower(stack: mutable.Stack[Ring]): Unit={
    if(stack.isEmpty) {
      println("Stack is empty")
    }else {
    for(s <- stack) {
      println(s.name)
      }
    }
  }
  def moveRing(stack1: mutable.Stack[Ring], stack2: mutable.Stack[Ring]): Unit={
    val ring1 = stack1.top
    if(stack2.isEmpty){
      stack2.push(ring1)
      stack1.pop()
    }else if(checkIfMoveIsValid(ring1,stack2.top)){
      stack2.push(ring1)
      stack1.pop()
    }else{
      println("Please chose different move, this one is invalid")
    }
  }
  def checkIfMoveIsValid(ring1: Ring, ring2: Ring): Boolean= {
    ring1.width < ring2.width
  }

  def checkWin(towerSize: Int): Boolean ={
    thirdStack.size != towerSize
  }
  def printGameState() ={
    var x  = 0
    for(s <- stackArray){
      println(s"Stack number : $x")
      printTower(s)
      x = x + 1
    }
  }
  def play() ={
    var x = ""
    while(x != "q"){
      val towerSize = readLine("Enter tower size: ").toInt
      createFirstStack(towerSize)
      while(checkWin(towerSize)){
        printGameState()
        val numberOfFirstStack = readLine("Enter number of first stack: ").toInt
        val numberOfSecondStack = readLine("Enter number of second stack: ").toInt
        moveRing(stackArray(numberOfFirstStack),stackArray(numberOfSecondStack))
      }
      x = readLine("If u want to exit press q: ")
    }
  }
}
