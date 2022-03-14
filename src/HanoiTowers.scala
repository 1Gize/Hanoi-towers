import scala.collection.mutable

class HanoiTowers {
  var firstStack  = mutable.Stack[Ring]()
  var secondStack = mutable.Stack[Ring]()
  var thirdStack = mutable.Stack[Ring]()
  def createFirstStack(towerSize: Int): Unit ={
    var x = towerSize
    while(x > 0){
      firstStack.addOne(new Ring(x))
      x = x - 1
    }
  }
  def printTower(stack: mutable.Stack[Ring]): Unit={
    for(s <- stack) {
      println(stack.top.name)
      stack.pop()
    }
  }
}
