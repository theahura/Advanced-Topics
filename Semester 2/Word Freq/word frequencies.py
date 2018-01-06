#"""
#WordFrequency.py
 
#This program should read a text file and populate a dictionary where each key represents 
#a word in the text file and is associated with the number of times that word occurs. Output the dictionary.
#Is there a way to output only the top 10 most commonly occurring words? How about only amongst those that have a
#length of 4 or greater? Could you use command line arguments to do this? Consider:
 
#python WordFrequency.py "warandpeace.txt" 10 4
 
#and 
 
#http://www.tutorialspoint.com/python/python_command_line_arguments.htm
 
#and
 
#http://www.tutorialspoint.com/python/python_dictionary.htm
 
#This assignment will be worth 5 golden stars, to be awarded at the beginning of class on Friday.
#"""

import sys

dict = {}

file = open('warandpeace.txt', 'r')

filestring = file.read()

wordlist = filestring.split()

for x in wordlist:
    if dict.has_key(x):
        dict[x] = dict[x] + 1
    else:
        dict[x] = 1

sort = sorted(dict, key=dict.get, reverse = True)
        
print "Top ten words are: "

y = 0

while y < 10:
    print sort[y]," ", dict[sort [y] ]
    y += 1
print "Words that are four or more letters are: "

for x in sort:
    if len(x) > 3:
         print x," ", dict[x]
