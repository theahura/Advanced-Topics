
#indexes every word in a certain section of the internet and adds that word to
#a dictionary

import re
import operator

keyworddict = {}
linklist = []

def get_page(url): #return page
	try:
		import urllib
		return urllib.urlopen(url).read()
	except:
		return ""    

def get_next_target(s, constraints): #Returns next link on a page
         index = s.find("http")
         p = s[index+1:]
         index2 = p.find('"')
         if s[index:index2 + 2].find("https") == -1: 
                 if len(constraints) > 0:
                         for x in constraints:
                                 if s[index:index2 + 2].find(x) != -1:
                                         return s[index:index2 + 2]
                 else:
                        return s[index:index2 + 2]

                
def get_all_links(page, constraints): #Returns a list of all links on a given page
        linklist2 = []
        indexlist = [m.start() for m in re.finditer('href', page)]
        for x in indexlist:
                if not get_next_target(page[x+5:], constraints) == None:
                        if not get_next_target(page[x+5:], constraints) == '':
                                linklist2.append(get_next_target(page[x+5:], constraints))
        return linklist2

def union(list1, list2): #Adds to list1 any items in list2 that are not already in list1
        for x in list2:
                if x not in list1:
                        list1.append(x)

def add_page_to_index(url): #Indexes an entire page
        page = get_page(url)
        pagelist = page.split()
        x = 0
        while x < len(pagelist):
                if not pagelist[x].isalnum():
                        del pagelist[x] 
                else:
                        x = x+1
        for word in pagelist:
                if word not in keyworddict:
                        keyworddict[word] = {url : 1} #if the index doesn't exist, add a new list with #times and url
                else:
                        if url not in keyworddict[word]:
                                keyworddict[word][url] = 1
                        else:
                                keyworddict[word][url] = keyworddict[word][url] + 1    #if it does exist, add to value

                                


#def add_to_index(index, keyword, url): #Indexes an individual keyword

def crawl_web(seed, depth, constraints): #Begins the web crawl. The depth and constraints parameters could be optional; constraints = list of words
        linklist.append(seed)
        x = 0
        y = 0
        while x < depth:
                templist = []
                length = len(linklist)
                while y < length:
                        templist = get_all_links(get_page(linklist[y]), constraints)
                        y = y + 1
                        union(linklist, templist)
                x = x + 1
         #       print linklist
       # print len(linklist)
        z = 0
        for i in linklist:
               # print z
                z = z+1
                add_page_to_index(i)


def lookup(keyword, url, depth, constraints): #Do a lookup of a keyword.
        crawl_web(url, depth, constraints)
        for x in keyworddict:
                if x == keyword:
                        finallist = [(v, k) for k, v in keyworddict[x].iteritems()]
                        return sorted(finallist, reverse=True), 
print lookup("Pingry", "http://www.pingry.org/", 3, "")
