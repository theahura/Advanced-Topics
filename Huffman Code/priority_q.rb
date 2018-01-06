#creates Q with smallest treenodes on top and largest treenodes at bottom

require_relative 'tree_node.rb'
require_relative 'huffman_tree.rb'

class PriorityQ

  attr_accessor :list
  
  #initializes, takes a new list and puts it in q in order, from greatest at index [0] to smallest at index [length]
  def initialize(inputlist)
    @list = Array.new
    list1 = inputlist
    while list1.length > 0
      a = list1[0]
      list1.each {|treenode| a = a.compareto(treenode)}
      @list.push(a)
      list1.delete(a)
    end
  end
  
  #adds a node to a list in the right spot
  def add_to_list(a)
    i = 0
    while i < @list.length
      if a == a.compareto(list[i])
        @list.insert(i, a)
        #puts "inserted"
        return list
      end
      i = i+1
    end
    @list.push(a) 
    #puts "at end"
  end   
   
end
