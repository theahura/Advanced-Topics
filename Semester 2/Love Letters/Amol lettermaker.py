# Author: Amol
# Version: 1

import random

Nouns = open('Noun.txt', 'r')
nounlist = Nouns.readlines()
nounlist = map(lambda s : s[:len(s) - 1], nounlist)


Verbs = open('Verb.txt', 'r')
verblist = Verbs.readlines()
verblist = map(lambda s : s[:len(s) - 1], verblist)


Advs = open('Adv.txt', 'r')
advlist = Advs.readlines()
advlist = map(lambda s : s[:len(s) - 1], advlist)

Adjs = open('Adj.txt', 'r')
adjlist = Adjs.readlines()
adjlist = map(lambda s : s[:len(s) - 1], adjlist)

Open1 = open('Opening1.txt', 'r')
open1list = Open1.readlines()
open1list = map(lambda s : s[:len(s) - 1], open1list)

Open2 = open('Opening2.txt', 'r')
open2list = Open2.readlines()
open2list = map(lambda s : s[:len(s) - 1], open2list)


#------------------------------------

def getLoveLetter():
    
    printstring = open1list[random.randint(0, len(open1list)-1)] + open2list[random.randint(0, len(open2list)-1)] + ","

    for x in range(0, 5) :
        if x%3 == random.randint(0,2): 
            finalword = nounlist[random.randint(0, len(nounlist)-1)]
            printstring = printstring + "\n " + "MY " + adjlist[random.randint(0, len(adjlist)-1)] + nounlist[random.randint(0, len(nounlist)-1)] + advlist[random.randint(0, len(advlist)-1)] + verblist[random.randint(0, len(verblist)-1)] + "YOUR " + adjlist[random.randint(0, len(adjlist)-1)] + finalword[:len(finalword)-1] + "."
        elif x%3 == random.randint(0,2):
            finalword = nounlist[random.randint(0, len(nounlist)-1)]
            printstring = printstring + "\n " + "YOUR " + adjlist[random.randint(0, len(adjlist)-1)] + nounlist[random.randint(0, len(nounlist)-1)] + verblist[random.randint(0, len(verblist)-1)] + "MY " + adjlist[random.randint(0, len(adjlist)-1)] + finalword[:len(finalword)-1] + "."
        else :
            finalword = nounlist[random.randint(0, len(nounlist)-1)]
            printstring = printstring + "\n " + "OUR " + nounlist[random.randint(0, len(nounlist)-1)] + advlist[random.randint(0, len(advlist)-1)] + verblist[random.randint(0, len(verblist)-1)] + "THE " + adjlist[random.randint(0, len(adjlist)-1)] + finalword[:len(finalword)-1] + "."


    finalword = nounlist[random.randint(0, len(nounlist)-1)]

    printstring = printstring + "\n " + "YOUR " + adjlist[random.randint(0, len(adjlist)-1)] + finalword[:len(finalword)-1] + ","
    printstring = printstring + "\n " + "MR. BURKHART"

    return printstring

print getLoveLetter()
