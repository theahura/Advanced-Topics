
import random

#filename = input("Please input filename.") 

file = open("crime.txt", 'r')

filestring = file.read()

n = input("Please input seedlength");

start = random.randint(0, len(filestring)/2) #Finds a random spot to start...

cutstring = filestring[start:] #and cuts out everything before the random starting spot

story = ""

seedstring = cutstring #string that is cut to create the seed

for x in range(0, len(cutstring)-n): #loops through each seed from 0 to the length of the string (-the start seed)

    loopedstring = seedstring #string to find options following the seed
    
    List = []  #stores any options

    seed = seedstring[:n]

   # print 'NEXT'

    while (loopedstring.find(seed, 0, len(loopedstring)) > -1): #loops to find each spot/possibility
        index = loopedstring.find(seed, 0, len(loopedstring))
        #print loopedstring[index]
        #print index
        List.append(loopedstring[index])
        loopedstring = loopedstring[index + 1:]
        #print len(loopedstring)
        #print seed

    randomnum = random.randint(0, len(List)-1)

    story = story + List[randomnum]
    
    print story
    
    seedstring = seedstring[1:]

story = story[story.find('.', 0, len(story)) : story.rfind('.', 0, len(story))]

print story

