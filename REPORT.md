# The Extended Habitable Zone
## By Xenia Beltei
### Section 3: Introduction to Computer Programming in Engineering and Science
#### May 2019

## Introduction
For my CE, I decided to explore the idea of the habitable zone even further. 
For the term project, Susan and I wrote a program that would show the stability of the planet’s orbit around a binary star system. 
In the report we discussed how the stability has a big impact on the habitability of the planet. 
However, there are many other factors that can influence this. One of them is the amount of starlight that a 
planet receives from its star. If the planet is located too close, the star will make the water evaporate, 
which is not unsuitable the habitability of a planet, as it relies among other factors on liquid water. If a planet will be too far, the water is going to be frozen, which is also bad. It's even more complicated
when you think about a binary star system because we have to take into account the radiation from both stars which will be located at different
positions every single instance of time, so the total amount of the radiation received on the planet will vary.
In my CE I will write a program that will take values(stars' radii, the distance from the planet to the stars) as input and 
will predict the extended habitable zone for a particular system. I will explore both types of systems, the ones that have one star at the center and the binary star systems.

I will validate my code by running it with the values of planets within the habitable zone that we already know 
(for example planets like TRAPPIST-1d, Kepler-186f, Kepler-442b). 

## The Model and the Code
The goal of my program is to print values for the inner and the outer adge of the extended habitable zone. The extended habitable zone is larger than the conservative habitable zone (it includes distances with less favourable conditions basically).
In my model, I assume circular orbits.
The first equation that we need is the absolute luminosity equation:
