#This TreeNode should behave like a normal TreeNode, except that instead of
#containing an Object, it will contain both a Character (named value) and an int (named count).
#Each should have an accessor and a modifier. Since you will be placing these TreeNodes into
#a PriorityQueue, they will also have to be Comparable. This comparison should be based on
#the value of the int. If the value is the same, the comparison should be based on the
#alphabetical order of the character.

class TreeNode
  
  #modifier and accessor
  attr_accessor :character, :integer, :left, :right, :parent, :numval
  
  #initializes
  def initialize(integer, character)
    @character = character
    @integer = integer
  end
  
  #comparison; returns greatest
  def compareto(b)
    a = self
    if a.integer > b.integer
      return a
    elsif b.integer > a.integer
      return b
    #ints are the same, go to chars
    elsif (a.character <=> b.character) == 1
     return a
    else 
      b
    end
  end
 
end
