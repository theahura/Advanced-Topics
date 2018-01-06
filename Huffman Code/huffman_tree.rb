#This class should contain a root pointer and a constructor that takes in the
#string value used to generate the tree.
#HuffmanTree should also contain whatever variables and methods are necessary to actually
#build the tree. Think carefully about your design and break the process into methods
#whenever possible.
#You will also need a method to print the tree in some logical way

require_relative 'huffman_tree.rb'

class HuffmanTree

  attr_accessor :root
  
  #Takes top two off priority q and makes a new node
  def new_node_in_tree(a, b)
    c = TreeNode.new(a.integer + b.integer, a.character + b.character)
    c.right = a
    c.left = b
    a.parent = c
    b.parent = c
    c
  end
  
  #print tree method
  
end
