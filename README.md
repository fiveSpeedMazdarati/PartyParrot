# PartyParrot

The preeminent party parrot API on the ENTIRE internets!

## Problem Statement

While important to society, we feel that the [Party Parrot website](https://cultofthepartyparrot.com/) is sadly featureless.  You have to control-f to get the parrot you desire -- and there are a LOT!  With no categories!  We want to help.

## Project Objectives

We want developers to be able to get a party parrot by name or get a list of them by category. We would also like to return a list of all the available party parrots as of the creation of this service.

URI:

GET
return a single parrot by name
JSON
/parrots/{name}

GET
return all parrots by category
JSON
/parrots/category/{categoryName}

GET
return all categories
JSON
/parrots/categories/

POST
add a new parrot to the collection of parrots
parrots/{name}/{link}/{hd}/{category}
* should this be set up as a form parameter to help out the user?

GET
return all of the parrots
JSON
parrots/

anonymous service


