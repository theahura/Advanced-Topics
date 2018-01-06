#This class will contain a main method that tests your Huffman Code
#implementation. Could have an option for file input where a text file gets passed to the
#HuffmanTree
#
#
#General Algorithm:
#1. Create and fill the Map (Treemap or HashMap) that will keep track of the number of
#occurrences of each letter.
#2. Create a TreeNode for each letter and place in the PriorityQueue
#3. Take first two elements off of the PriorityQueue
#4. Make a new TreeNode with those elements as its children, whose count is the sum of the
#children's counts.
#5. Add that TreeNode to the PriorityQueue.
#6. As long as there is more than 1 TreeNode left in the PriorityQueue, go back to step 3.
#7. Print HuffmanTree (this should be called from your runner).

require_relative 'tree_node.rb'
require_relative 'priority_q.rb'
require_relative 'huffman_tree.rb'
 
  
  def main()
    
    @encodedlist = Array.new
    
    #sets up huffman with input from file named "input"
    inputfile = File.new("input.txt", "r")
    input = inputfile.read
    wordfreqs = get_frequencies(input)
    wordlist = Array.new
    
    #puts wordfreqs
    count = 1
    
    wordfreqs.each do |a, b| 
    #  puts a
    #  puts b
      temp = TreeNode.new(b, a)
      wordlist.push(temp) #creates tree nodes
    end
    
    #creates a priority q with the treenodes just created
    #puts wordlist[0].character
    q = PriorityQ.new(wordlist)

    #initializes the tree and begins add loop
    tree = HuffmanTree.new
    count = 0
    while q.list.length > 1
      #puts "count: "
      #puts count
      count = count + 1
      #puts "length: " 
      #puts q.list.length
      #pops 2, makes a new node, and adds it to the right spot in the list
      new_node = tree.new_node_in_tree(q.list.pop, q.list.pop)
      #puts "success"
      q.add_to_list(new_node)
    end 
     
    #sets root to last node made
    tree.root = new_node
    tree.root.numval = ""
      
    encode(tree.root)
    
    charlist = input.split(//)
    finalstring = ""
   
   #iterates each char in the string
    i = 0
    while i < charlist.length
      a = 0
      #finds the matching treenode
      while a < @encodedlist.length
        if @encodedlist[a].character == charlist[i]
          #adds the treenode encoded value to the finalstring
          finalstring = finalstring + @encodedlist[a].numval
          break
        end
        a = a + 1
      end        
      i = i + 1
    end
    puts finalstring
    puts printtree(tree.root)
  end
  
  #encodes each node in tree with 0/1 by taking previous as a string and adding a 0 or 1
  def encode(root)
    if root.left == nil && root.right == nil
      @encodedlist.push(root)
      return 
    else
      if root.left != nil
        root.left.numval = root.numval + "0"
        encode(root.left)
      end
      
      if root.right != nil
        root.right.numval = root.numval + "1"
        encode(root.right)
      end
    end
  end
  
  def get_frequencies(input)
    charlist = input.split(//)
    freqs = Hash.new(0)
    charlist.each {|char| freqs[char] += 1}
    freqs #returns the frequencies 
  end

  #prints out the tree
  def printtree(root)
    #current layer
    layer1 = Array.new
    #current layers children
    layer2 = Array.new
    
    layer1.push(root)
    
    while true
      i = 0 
      while i < layer1.length
        print layer1[i].character
        print " " 
        print layer1[i].integer
        print " || "
        
        #populates the second layer with the current layers children
        if layer1[i].right != nil
          layer2.push(layer1[i].right)
        end 
        if layer1[i].left != nil
          layer2.push(layer1[i].left)
        end
        i = i + 1
      end 
      
      #base case
      if layer2.length == 0
        return
      end
      
      #switches the two layers, making layer 1 = layer 2 and clearing layer 2
      layer1 = layer2
      layer2 = Array.new
      puts ""
    end    
  end

main()


