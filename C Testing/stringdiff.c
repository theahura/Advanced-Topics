/*
 * stringdiff.c
 *
 *  Created on: May 22, 2013
 *      Author: Amol
 */

#include <C:\Users\Amol\Dropbox\Kapoor, Amol\Advanced Topics\C Testing\PingryInput.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
	string string1;
	string string2;
	int x;
	int returnedval;
	string *shortest;

	string1 = GetString();
	string2 = GetString();

	if (strlen(string2) > strlen(string1))
	{
		shortest = string1;
		returnedval = strlen(string2) - strlen(string1);
	}
	else
	{
		shortest = string2;
		returnedval = strlen(string1) - strlen(string2);
	}

	for (x = 0; x < strlen(shortest); x++)
	{
		if (string1[x] != string2[x])
		{
			returnedval++;
		}
	}

	printf("%d\n", returnedval);

	free(string1);
	free(string2);
	free(shortest);
	free(returnedval);

	return 0;
}
