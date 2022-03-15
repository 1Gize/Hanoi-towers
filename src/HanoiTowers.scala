import scala.collection.mutable

class HanoiTowers {
  var firstStack  = mutable.Stack[Ring]()
  var secondStack = mutable.Stack[Ring]()
  var thirdStack = mutable.Stack[Ring]()
  def createFirstStack(towerSize: Int): Unit ={
    var x = 1
    while(x <= 0){
      firstStack.addOne(new Ring(x))
      x = x +  1
    }
  }
  def printTower(stack: mutable.Stack[Ring]): Unit={
    for(s <- stack) {
      println(s.name)
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
  def checkIfMoveIsValid(ring1: Ring, ring2: Ring): Boolean={
    if(ring1.width < ring2.width) {
      true
    }else{
      //println("Invalid move!")
      false
    }
  }
}
